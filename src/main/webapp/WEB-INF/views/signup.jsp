<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>회원가입 - National Bookstore</title>
  <!-- Google Fonts -->
  <link
    href="https://fonts.googleapis.com/css?family=Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto+Mono|Roboto&display=swap"
    rel="stylesheet" />
  <!-- Fontawesome -->
  <script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
  <!--
    Main Font:
    font-family: 'Kaushan Script', cursive;

    Article Choices:
    font-family: 'Roboto', sans-serif;
    font-family: 'Open Sans', sans-serif;
    font-family: 'Montserrat', sans-serif;

    Korean Font:
    font-family: 'Noto Sans KR', sans-serif;
    -->

  <!-- css reset -->
  <link rel="stylesheet" href="../../resources/styles/reset.css">

  <!-- individual page stylesheet -->
  <link rel="stylesheet" href="../../resources/styles/signup.css">

  <!-- jQuery CDN -->
  <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
</head>
<body>
  <header class="topbar">
    <nav>
      <div class="container">
        <a href="javascript: history.back();"><i class="far fa-arrow-left"></i></a>
        <h2>회원가입</h2>
      </div>
    </nav>
  </header>
  <div class="body-wrapper">
    <form id="signup-form" action="/member/signUp" method="POST">
      <div class="form-container">
        <div class="email-container">
          <label for="email">
            <input id="email" name="memberEmail" type="text" required spellcheck="false" autocomplete="off">
            <span class="placeholder">이메일</span>
          </label>
          <button type="button" class="auth-btn" disabled tabindex="-1">인증</button>
          <label for="email-auth">
            <input id="email-auth" name="email-auth" type="text" required spellcheck="false" autocomplete="off" placeholder="인증 코드를 입력해주세요." tabindex="-1">
            <span class="timer"></span>
          </label>
          <span class="warning-msg"><span class="far fa-exclamation-circle"></span></span>
        </div>
        <div class="passwd-container">
          <label for="passwd">
            <input id="passwd" name="memberPw" type="password" required onblur="validatePasswd()">
            <span class="placeholder">비밀번호</span>
          </label>
          <label for="passwdConfirm">
            <input id="passwdConfirm" name="memberPwChk" type="password" required onblur="validatePasswd()">
            <span class="placeholder">비밀번호 확인</span>
          </label>
          <span class="warning-msg"><span class="far fa-exclamation-circle"></span></span>
        </div>
        <div class="nickname-container">
          <label for="nickname">
            <input id="nickname" name="memberNickName" type="text" required spellcheck="false" autocomplete="off">
            <span class="placeholder">닉네임</span>
          </label>
          <span class="warning-msg"><span class="far fa-exclamation-circle"></span></span>
        </div>
        <div class="address-container">
          <label for="zipcode" onclick="openAddressAPI()">
            <input id="zipcode" type="text" required spellcheck="false" autocomplete="off" tabindex="-1"
              disabled="disabled">
            <input id="zipcodeHidden" type="hidden" name="memberZipcode">
            <span class="placeholder">우편번호</span>
          </label>
          <button type="button" onclick="openAddressAPI()">우편번호 찾기</button>
          <label for="roadAddress" onclick="openAddressAPI()">
            <input id="roadAddress" name="memberAddress" type="text" required spellcheck="false" autocomplete="off"
              tabindex="-1" disabled="disabled">
            <input id="roadAddressHidden" type="hidden" name="memberAddress">
            <span class="placeholder">주소</span>
          </label>
          <label for="detailAddress">
            <input id="detailAddress" name="memberDaddress" type="text" required spellcheck="false" autocomplete="off">
            <span class="placeholder">상세 주소</span>
          </label>
          <span class="warning-msg"><span class="far fa-exclamation-circle"></span></span>
        </div>
        <div class="tel-container">
          <label for="tel">
            <input id="tel" name="memberTel" type="text" required spellcheck="false" autocomplete="off"
              onblur="validateTel()">
            <span class="placeholder">휴대폰 번호</span>
          </label>
          <span class="warning-msg"><span class="far fa-exclamation-circle"></span></span>
        </div>
        <input type="hidden" name="memberAdmin" value="1" tabindex="-1">
        <button id="submitBtn" type="button" disabled>회원 가입</button>
        <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
      </div>
    </form>
  </div>
  <!-- change z-index of overlapping input elements on focus -->
  <script>
    $(document).ready(function () {
      const email = document.getElementById('email');
      const emailAuth = document.getElementById('email-auth');
      const passwdInput = document.getElementById('passwd');
      const passwdConfirmInput = document.getElementById('passwdConfirm');
      const inputs = [email, emailAuth, passwdInput, passwdConfirmInput];
      inputs.forEach(input => {
        input.addEventListener('focus', () => {
          inputs.forEach(input => input.parentElement.style.zIndex = 1);
          input.parentElement.style.zIndex = 2;
        });
      });
    });
  </script>
  <script>
    $(document).ready(function () {
      const addressLabels = [...(document.querySelectorAll('.address-container > label'))];
      const inputs = addressLabels.map(label => label.querySelector('input'));
      addressLabels.forEach((label, index) => {
        inputs[index].addEventListener('focus', () => {
          addressLabels.forEach(otherLabel => otherLabel.style.zIndex = 1);
          addressLabels[index].style.zIndex = 2;
        });
      });
    });
  </script>
  <!-- 도로명주소 API 연결 -->
  <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script>
    let isAddressWindowOpened = false;
    function openAddressAPI() {
      if (!isAddressWindowOpened) {
        isAddressWindowOpened = true;
        const addressWindow = new daum.Postcode({
          oncomplete: function (data) {
            isAddressWindowOpened = false;
            const zipcodePlaceholder = document.querySelector('label[for="zipcode"] .placeholder');
            const roadAddressPlaceholder = document.querySelector('label[for="roadAddress"] .placeholder');
            const zipcode = document.getElementById('zipcode');
            const roadAddress = document.getElementById('roadAddress');
            const zipcodeHidden = document.getElementById('zipcodeHidden');
            const roadAddressHidden = document.getElementById('roadAddressHidden');

            zipcodePlaceholder.style.transform = 'scale(0.8) translateX(-10%) translateY(-70%)';
            roadAddressPlaceholder.style.transform = 'scale(0.8) translateX(-10%) translateY(-70%)';
            zipcode.value = data.zonecode;
            roadAddress.value = data.address;
            zipcodeHidden.value = data.zonecode;
            roadAddressHidden.value = data.address;

            const event = new Event('input');
            zipcode.dispatchEvent(event);
            roadAddress.dispatchEvent(event);
          },
          onclose: function () {
            isAddressWindowOpened = false;
          }
        });
        addressWindow.open();
      }
    }
  </script>
  <script>
    function markChecked(label) {
      if (!label) return;

      const check = document.createElement('span');
      check.className = 'fal fa-check validated';
      label.appendChild(check);
    }
  </script>
  <!-- 이메일 인증 버튼 활성화 -->
  <script>
    function startTimer(timer) {
      // clear previous timer if any
      const previousCountdown = timer.getAttribute('data-countdown-timer-id');
      if (previousCountdown) clearInterval(previousCountdown);

      timer.style.color = 'var(--violet-color)';

      // get time from timer element's data attribute
      let countdown = 179;
      timer.innerHTML = '03:00';

      // update timer element every second
      const intervalId = setInterval(() => {
        // update timer data and save on timer element
        timer.setAttribute('data-countdown', countdown);

        let minutes = String(Math.floor(countdown/60));
        minutes = (minutes.length === 1 ? '0' : '') + minutes;

        let seconds = String(Math.floor(countdown%60));
        seconds = (seconds.length === 1 ? '0' : '') + seconds;

        timer.innerHTML = minutes + ':' + seconds;

        // decrease timer
        countdown -= 1;

        // if countdown is less then 10 seconds change font color to red on next coundown repaint
        if (countdown <= 10) timer.style.color = 'var(--red-color)';

        // stop timer on 0 second
        if (countdown < 0) clearInterval(intervalId);
      }, 1000);
      // set setInterval id to timer element
      timer.setAttribute('data-countdown-timer-id', intervalId);
    }
    function requestVerificationCodeConfirmation() {
      const countdownTime = Number(document.querySelector('.email-container span.timer').getAttribute('data-countdown'));
      if (countdownTime <= 0) {
        alert('인증 코드가 만료되었습니다.\n이메일을 새로 입력해주세요')
        return;
      }

      const emailWrapper = document.querySelector('.email-container');
      const emailInput = document.getElementById('email');
      const email = emailInput.value.trim();
      const emailAuth = document.getElementById('email-auth');
      const code = emailAuth.value.trim();
      const warningMsg = document.querySelector('label[for="email"] ~ .warning-msg');

      // if code is not input then return
      if (code.length <= 0) return;

      const xhr = new XMLHttpRequest();
      xhr.open('POST', '/member/authenticationCheck');
      xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
      xhr.onreadystatechange = function() {
        if (!(xhr.readyState === 4 && xhr.status === 200)) return;
          const isValid = JSON.parse(xhr.response).result;

          if (isValid) {
            // lock email input on successful email verification
            emailInput.setAttribute('data-locked', true);

            emailWrapper.classList.remove('getAuth');

            // hide authentication code input
            const emailAuthLabel = document.querySelector('.email-container label[for="email-auth"]');
            emailAuthLabel.style.transition = '0.125s ease-out';
            emailAuthLabel.addEventListener('transitionend', function showEmailAuthLabel() {
              emailAuthLabel.style.transition = '';
              emailAuthLabel.removeEventListener('transitionend', showEmailAuthLabel);
            });

            const emailAuthButton = document.querySelector('.email-container > button');
            emailAuthButton.textContent = '인증 완료';
            emailAuthButton.setAttribute('disabled', 'disabled');
            emailAuthButton.removeAttribute('tabindex');
            // remove all event handler
            emailAuthButton.parentElement.replaceChild(emailAuthButton.cloneNode(true), emailAuthButton);

            const emailAuthInput = document.getElementById('email-auth');
            emailAuthInput.removeAttribute('tabindex');

            // mark checked
            const emailLabel = document.querySelector('.email-container label[for="email"]');
            markChecked(emailLabel);
            // reset emailAuth input
            emailAuth.value = '';

            // stop timer
            const timerId = document.querySelector('.email-container span.timer').getAttribute('data-countdown-timer-id');
            if (timerId) clearInterval(timerId);

            warningMsg.style.display = 'none';
            emailWrapper.style.marginBottom = '25px';
          } else {
            alert('일치하지 않는 인증 코드 입니다.');
          }
      }
      xhr.send('memberEmail=' + email + '&emailCode=' + code);
    }
    // 이메일 인증 코드 전송 요청
    function requestEmailVerificationCode() {
      const emailWrapper = document.querySelector('.email-container');
      const emailAuthButton = document.querySelector('.email-container > button');
      const warningMsg = document.querySelector('label[for="email"] ~ .warning-msg');
      const emailInput = document.getElementById('email');
      const email = emailInput.value.trim();

      // start timer
      const timer = emailWrapper.querySelector('span.timer');
      startTimer(timer);

      // enable authentication code input label
      if (!emailWrapper.classList.contains('getAuth')) {
        const emailAuthLabel = document.querySelector('.email-container label[for="email-auth"]');
        emailAuthLabel.style.transition = '0.125s ease-out';
        emailAuthLabel.addEventListener('transitionend', function showEmailAuthLabel() {
          emailAuthLabel.style.transition = '';
          emailAuthLabel.removeEventListener('transitionend', showEmailAuthLabel);
        });
        const emailAuthInput = document.getElementById('email-auth');
        emailAuthInput.removeAttribute('tabindex');
        emailAuthButton.removeAttribute('tabindex');
        emailWrapper.classList.add('getAuth');
      }
      // change button text
      emailAuthButton.textContent = '확인';

      const xhr = new XMLHttpRequest();
      xhr.open('POST', '/member/emailAuthentication');

      xhr.onreadystatechange = function() {
        if (!(xhr.readyState === 4 && xhr.status === 200)) return;

        const isValid = JSON.parse(xhr.response).result;

        if (!isValid) {
          alert('이메일 인증 오류: 관리자에게 문의해주세요.');
          return;
        }

        const newEmailAuthButton = emailAuthButton.cloneNode(true);
        // add authentication code request handler
        newEmailAuthButton.addEventListener('click', requestVerificationCodeConfirmation);
        // remove all previous event handler
        emailAuthButton.parentElement.replaceChild(newEmailAuthButton, emailAuthButton);
      };

      xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
      xhr.send('memberEmail=' + email);
    }
    function validateEmail() {
      const emailAuthButton = document.querySelector('.email-container > button');
      const emailInput = document.getElementById('email');
      const email = emailInput.value.trim();

      // append spinner to label
      const emailLabel = document.querySelector('.email-container label');
      const spinner = document.createElement('img');
      spinner.setAttribute('src', '../../resources/images/ajax-loading.svg');
      emailLabel.appendChild(spinner);

      const xhr = new XMLHttpRequest();
      xhr.open('POST', '/member/signUpCheck');

      // unload spinenr on 'loadend'
      xhr.addEventListener('loadend', () => emailLabel.removeChild(spinner));

      // activate email authentication button on available email account
      xhr.onreadystatechange = function () {
        if (!(xhr.readyState === 4 && xhr.status === 200)) return;

        const emailWrapper = document.querySelector('.email-container');
        const emailInput = document.getElementById('email');
        const warningMsg = document.querySelector('label[for="email"] ~ .warning-msg');

        // mark email input as validated (whether valid or not, available or not)
        emailInput.setAttribute('data-is-validated', true);

        const isValid = JSON.parse(xhr.response).result;

        // remove all previous event handler
        const newEmailAuthButton = emailAuthButton.cloneNode(true);

        // if email is valid & available
        if (isValid) {
          // change warning message
          warningMsg.innerHTML = '<span class="far fa-check-circle info-msg"> 이메일 인증을 진행해주세요.</span>';

          // enable authentication button
          newEmailAuthButton.removeAttribute('disabled');
          
          // add authentication code request handler
          newEmailAuthButton.addEventListener('click', requestEmailVerificationCode);

          emailAuthButton.parentElement.replaceChild(newEmailAuthButton, emailAuthButton);
        }
        // if email in in use
        else {
          warningMsg.innerHTML = '<span class="far fa-exclamation-circle"> 이메일이 이미 사용되고 있습니다.</span>';
        }
        warningMsg.style.display = 'block';
        emailWrapper.style.marginBottom = '0';
      };

      xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
      xhr.send('memberEmail=' + email);
    }
    function isValidEmailFormat(email) {
      const emailPattern = /^[\d\w]+@(=?.*?[\w]+)[\d\w]*\.[\w]+(\.[\w]+){0,1}$/;
      return emailPattern.test(email);
    }
    $(document).ready(function () {
      const emailWrapper = document.querySelector('.email-container');
      const emailInput = document.getElementById('email');
      const warningMsg = document.querySelector('label[for="email"] ~ .warning-msg');

      let validationTimer = null;
      emailInput.addEventListener('input', function () {
        const emailAuthButton = document.querySelector('.email-container > button');
        // remove check mark on input
        const check = document.querySelector('.email-container .validated');
        if (check) check.parentElement.removeChild(check);

        // remove email validation processed marking
        emailInput.removeAttribute('data-is-validated');
        // disable email authentication button
        emailAuthButton.setAttribute('disabled', 'disabled');
        // change button content
        emailAuthButton.textContent = '인증';

        // clear validation schedule
        clearTimeout(validationTimer)
        validationTimer = setTimeout(function () {
          const email = emailInput.value.trim();

          // if email is not valid format then return
          if (!isValidEmailFormat(email)) return;

          validateEmail(email, emailAuthButton);
        }, 850);
      });
      emailInput.addEventListener('blur', () => {
        const email = emailInput.value.trim();
        const isValidated = emailInput.getAttribute('data-is-validated');

        // if email when through validation process then return
        if (isValidated) return;

        // if email is not provided then remove warning message
        if (email.length <= 0) {
          warningMsg.style.display = 'none';
          emailWrapper.style.marginBottom = '25px';
          return;
        }
        // if email is not valid format
        else if (!isValidEmailFormat(email)) {
          warningMsg.innerHTML = '<span class="far fa-exclamation-circle"> 이메일 양식을 확인해주세요.</span>';
          warningMsg.style.display = 'block';
          emailWrapper.style.marginBottom = '0';
        }

      });
      emailInput.addEventListener('focus', () => {
        const isLocked = emailInput.getAttribute('data-locked');
        if (!isLocked) return;

        const userDidConsent = confirm('이메일을 변경하시겠습니까?');
        if (!userDidConsent) {
          emailInput.blur();
          return;
        }

        emailInput.removeAttribute('data-locked');
      });
    }); 
  </script>
  <!-- 비밀번호 유효성 검사 -->
  <script>
    function isValidPasswdFormat(passwd) {
      const passwdPattern = /^(?=.*?[^\s])[\w\d]{4,}$/;
      return passwdPattern.test(passwd);
    }
    function validatePasswd() {
      const passwd = document.getElementById('passwd').value.trim();
      const passwdConfirm = document.getElementById('passwdConfirm').value.trim();
      const warningMsg = document.querySelector('label[for="passwd"] ~ .warning-msg');
      const passwdWrapper = warningMsg.parentElement;

      // 패스워드칸을 지울 경우 경고 메세지도 가림
      if (passwd.length <= 0) {
        warningMsg.style.display = 'none';
        passwdWrapper.style.marginBottom = '25px';
      }
      // 유효하지 않은 비밀번호 일 경유
      else if (!isValidPasswdFormat(passwd)) {
        warningMsg.innerHTML = '<span class="far fa-exclamation-circle">유효한 비밀번호를 입력해주세요.</span>'
        warningMsg.style.display = 'block';
        passwdWrapper.style.marginBottom = '0';
      } 
      // 비밀번호 확인칸에 입력이 있지만 일치하지 않을 경우
      else if (passwdConfirm.length > 0 && passwdConfirm !== passwd) {
        warningMsg.innerHTML = '<span class="far fa-exclamation-circle">비밀번호가 일치하지 않습니다.</span>'
        warningMsg.style.display = 'block';
        passwdWrapper.style.marginBottom = '0';
      }
      // 유효한 비밀번호 일 경우 true를 반환
      else if (passwd === passwdConfirm) {
        warningMsg.style.display = 'none';
        passwdWrapper.style.marginBottom = '25px';
        [...(document.querySelectorAll('.passwd-container label'))].forEach(label => markChecked(label));
        return true;
      }
      return false;
    }
    $(document).ready(function() {
      const passwdInput = document.getElementById('passwd');
      const passwdConfirmInput = document.getElementById('passwdConfirm');
      [passwdInput, passwdConfirmInput].forEach((input, index, arr) => {
        input.addEventListener('input', () => {
          // remove check mark on both passwd, passwdConfirm input element on 'input' event
          [...(document.querySelectorAll('.passwd-container label .validated'))].forEach(checkMark => {
            if (checkMark) checkMark.parentElement.removeChild(checkMark);
          });
        });
      });
    });
  </script>
  <!-- 핸드폰번호 유효성 검사 -->
  <script>
    function isValidTelFormat(tel) {
      tel = tel.trim().replace(/-/g, '').replace(/[\s]/g, '');
      const telPattern = /\d{11}/;
      return telPattern.test(tel);
    }
    function validateTel() {
      const telWrapper = document.querySelector('label[for="tel"]').parentElement;
      const telLabel = document.querySelector('.tel-container label');
      const tel = document.getElementById('tel').value.trim().replace(/-/g, '').replace(/[\s]/g, '');
      const warningMsg = telWrapper.querySelector('.warning-msg');

      if (tel.length <= 0) {
        warningMsg.style.display = 'none';
        telWrapper.style.marginBottom = '25px';
      } else if (!isValidTelFormat(tel) || tel.length > 11) {
        telWrapper.style.marginBottom = '0';
        warningMsg.style.display = 'block';
        warningMsg.innerHTML = '<span class="far fa-exclamation-circle">유효한 휴대폰 번호를 입력해주세요.</span>';
      } else {
        // 핸드폰 입력 양식이 맞을 경우
        warningMsg.style.display = 'none';
        telWrapper.style.marginBottom = '25px';
        markChecked(telLabel);
        return true;
      }
      return false;
    }
    $(document).ready(function() {
      const telInput = document.querySelector('.tel-container input');

      telInput.addEventListener('input', () => {
        const checkMark = document.querySelector('.tel-container label .validated');
        if (checkMark) checkMark.parentElement.removeChild(checkMark);
      });
    });
  </script>
  <!-- 닉네임 유효성 검사 -->
  <script>
    function validateNickName(nickname) {
      const nicknameWrapper = document.querySelector('label[for="nickname"]').parentElement;
      const nicknameLabel = document.querySelector('.nickname-container label');
      const nicknameInput = document.getElementById('nickname');
      const warningMsg = nicknameWrapper.querySelector('.warning-msg');

      // attach spinner on ajax try
      const spinner = document.createElement('img');
      spinner.setAttribute('src', '../../resources/images/ajax-loading.svg');
      nicknameLabel.appendChild(spinner);

      const xhr = new XMLHttpRequest();
      xhr.open('POST', '/member/signUpCheck');

      xhr.addEventListener('loadend', () => nicknameLabel.removeChild(spinner));

      xhr.onreadystatechange = function () {
        if (!(xhr.readyState === 4 && xhr.status === 200)) return;
        const isValid = JSON.parse(xhr.response).result;

        nicknameInput.setAttribute('data-is-validated', true);
        
        if (isValid) {
          warningMsg.style.display = 'none';
          nicknameWrapper.style.marginBottom = '25px';
          markChecked(nicknameLabel);
        }
        else {
          warningMsg.innerHTML = '<span class="far fa-exclamation-circle">닉네임이 이미 사용되고 있습니다.</span>';
          warningMsg.style.display = 'block';
          nicknameWrapper.style.marginBottom = '0';
        }
      }

      xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
      xhr.send('memberNickName=' + nickname);
    }
    function isValidNickNameFormat(nickname) {
      const nicknamePattern = /^[a-zA-Z][\d\w]{3,11}/;
      return nicknamePattern.test(nickname);
    }
    $(document).ready(function () {
      const nicknameWrapper = document.querySelector('label[for="nickname"]').parentElement;
      const nicknameInput = document.getElementById('nickname');
      const warningMsg = nicknameWrapper.querySelector('.warning-msg');
      let validationTimer = null;

      nicknameInput.addEventListener('input', () => {
        const nickname = nicknameInput.value.trim();
        const check = document.querySelector('.nickname-container .validated');
        if (check) check.parentElement.removeChild(check);

        nicknameInput.removeAttribute('data-is-validated');

        clearTimeout(validationTimer);
        if (isValidNickNameFormat(nickname)) {
          validationTimer = setTimeout(function () {
            if (nickname.length <= 0) return;
            validateNickName(nickname);
          }, 850);
        }
      });
      nicknameInput.addEventListener('blur', () => {
        const nickname = nicknameInput.value.trim();
        const isValidated = nicknameInput.getAttribute('data-is-validated');

        if (isValidated) return;

        if (nickname.length <= 0) {
          warningMsg.style.display = 'none';
          nicknameWrapper.style.marginBottom = '25px';
        }
        // if nickname is not valid
        else if (!isValidNickNameFormat(nickname)) {
          warningMsg.style.display = 'block';
          nicknameWrapper.style.marginBottom = '0';
          warningMsg.innerHTML = '<span class="far fa-exclamation-circle">유효하지 않은 닉네임 입니다.</span>';
        }
        else {
          warningMsg.style.display = 'none';
          nicknameWrapper.style.marginBottom = '25px';
          return true;
        }
        return false;
      });
    });
  </script>
  <!-- 주소 유효성 검사 -->
  <script>
    $(document).ready(function() {
      const addressWrapper = document.querySelector('.address-container');
      const addressInputs = [...(addressWrapper.querySelectorAll('input'))];
      const warningMsg = addressWrapper.querySelector('.warning-msg');

      addressInputs.forEach(input => {
        input.addEventListener('blur', () => {
          const addr = input.value.trim();          

          if (addr.length > 0) return;

          warningMsg.style.display = 'none';
          addressWrapper.style.marginBottom = '25px';
        });
      });
    });
  </script>
  <!-- 양식 유효성 검사 -->
  <script>
  // enable warning message
  function showWarningMsg(container, message) {
    const wrapper = document.querySelector('.form-container .' + container + '-container');
    const warningMsg = wrapper.querySelector('.warning-msg');
    
    wrapper.style.marginBottom = '0';
    warningMsg.style.display = 'block';
    warningMsg.innerHTML = '<span class="far fa-exclamation-circle">' + message + '</span>';
  }
  // requires ajax request for validation
  function promiseEmailVerification(inputKeyword) {
    return new Promise((resolve, reject) => {
      const email = document.getElementById('email').value.trim();
    
      const xhr = new XMLHttpRequest();
      xhr.open('POST', '/member/authenticationCompleteCheck');
      xhr.onreadystatechange = () => {
        if (!(xhr.readyState === 4 && xhr.status === 200)) return;
      
        const isValid = JSON.parse(xhr.response).result;

        resolve({ 'input': 'email', 'isValid': isValid, 'inputKeyword': inputKeyword });
      };
      xhr.onerror = () => reject('이메일 유효성 검사를 할 수 없습니다.');

      xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
      xhr.send('memberEmail=' + email);
    });
  }

  function promiseNickNameVerification(inputKeyword) {
    return new Promise((resolve, reject) => {
      const nickname = document.getElementById('nickname').value.trim();
      
      const xhr = new XMLHttpRequest();
      xhr.open('POST', '/member/signUpCheck');
      xhr.onreadystatechange = () => {
        if (!(xhr.readyState === 4 && xhr.status === 200)) return; 
        
        const isValid = JSON.parse(xhr.response).result;
        
        resolve({ 'input': 'nickname', 'isValid': isValid, 'inputKeyword': inputKeyword });
      };
      xhr.onerror = () => reject('닉네임 유효성 검사를 할 수 없습니다.');

      xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
      xhr.send('memberNickName=' + nickname);
    });
  }
  function promisePasswdDoesMatch(inputKeyword) {
    return new Promise((resolve, reject) => {
      const passwd = document.getElementById('passwd').value.trim();
      const passwdConfirm = document.getElementById('passwdConfirm').value.trim();

      const isValid = passwd === passwdConfirm;

      resolve({ 'input': 'passwd', 'isValid': isValid, 'inputKeyword': inputKeyword });
    });
  }
  async function validateForms(submitStatus) {
    // if form is already submitted then return
    if (submitStatus.isSubmitted) return;
    // set submitted status to true
    submitStatus.isSubmitted = true;

    const submitBtn = document.getElementById('submitBtn');
    submitBtn.innerHTML = '<img width="7%" height="100%" src="../../resources/images/ajax-loading.svg" alt="">';

    const inputKeywords = {
      // inputID inputWrapperPrefix : messagePrefix
      'email email': '이메일을',
      'passwdConfirm passwd': '비밀번호 확인을',
      'passwd passwd': '비밀번호를',
      'nickname nickname': '닉네임을',
      'detailAddress address': '상세 주소를',
      'roadAddress address': '주소를',
      'zipcode address': '우편번호를',
      'tel tel': '휴대폰 번호를'
    };
    // form validation process
    // 1. check for empty form
    // 2. check if input value is legit (regular expression compatible)
    // 3. ping server for validity

    // 1. check for EMPTY form
    Object.keys(inputKeywords).forEach(key => {
      const input = document.querySelector('#signup-form #' + key.split(' ')[0]);
      const inputValue = input.value.trim();

      // if input is not empty then return
      if (inputValue.length > 0) return;

      showWarningMsg(key.split(' ')[1], inputKeywords[key] + ' 입력해주세요.');
      // remove failed form from the collection
      inputKeywords[key] = undefined;
      delete inputKeywords[key];
    });

    // 2. check if input value is NOT regular expression compatible
    Object.keys(inputKeywords).forEach(key => {
      const input = document.querySelector('#signup-form #' + key.split(' ')[0]);
      const inputValue = input.value.trim();
      // get pattern matching function base on input name
      const isValidFormat = (function(inputName) {
        switch (inputName) {
          case 'email':
            return isValidEmailFormat;
          case 'passwd':
          case 'passwdConfirm':
            return isValidPasswdFormat;
          case 'nickname':
            return isValidNickNameFormat;
          case 'tel':
            return isValidTelFormat;
        }
        return undefined
      }(key.split(' ')[0]));

      // if inputValue is valid format then return
      if (!isValidFormat || isValidFormat(inputValue)) return;

      showWarningMsg(key.split(' ')[1], '유효한 ' + inputKeywords[key] + '  입력해주세요.');
      // remove failed form from the collection
      inputKeywords[key] = undefined;
      delete inputKeywords[key];
    });

    // 3. ping server for email, nickname validity and
    //    check if passwd and passwdConfirm matches
    const promises = Object.keys(inputKeywords).map(inputKeyword => {
      const inputName = inputKeyword.split(' ')[0];
      switch (inputName) {
        case 'email':
          return promiseEmailVerification(inputKeyword);
        case 'nickname':
          return promiseNickNameVerification(inputKeyword);
        case 'passwd':
          return promisePasswdDoesMatch(inputKeyword);
      }
    }).filter(promise => promise !== undefined);

    await Promise.all([...promises])
           .then(results => results.forEach(result => {
              // if input is validated then do not remove from the collection
              if (result.isValid) return;
              switch(result.input) {
                case 'email':
                  showWarningMsg('email', '이메일 인증을 완료해주세요.');
                  break;
                case 'nickname':
                  showWarningMsg('nickname', '사용할 수 없는 닉네임 입니다.');
                  break;
                case 'passwd':
                  showWarningMsg('passwd', '비밀번호가 일치하지 않습니다.');
                  break;
              }
              inputKeywords[result.inputKeyword] = undefined;
              delete inputKeywords[result.inputKeyword];
           }))
           .catch(exception => {
             console.error(exception);
           });
    const validInputs = Object.keys(inputKeywords).map(inputKeyword => inputKeyword.split(' ')[0]);

    // if all 8 inputs are not valid then return
    if (validInputs.length !== 8) {
      // remove loader svg
      submitBtn.innerHTML = '회원 가입';
      // reset submitted status to false
      submitStatus.isSubmitted = false;
      return;
    }
    
    const form = document.getElementById('signup-form');
    form.submit();
  }
  </script>

  <!-- enable submit button on at least a single input to each form -->
  <script>
    $(document).ready(function() {
      const inputs = [...(document.querySelectorAll('label input:not(#email-auth)'))];
      // prevent multiple submit request
      const submitStatus = {
        isSubmitted: false
      };

      inputs.forEach(input => {
        input.addEventListener('input', () => {
          // if form is already submitted then return;
          if (submitStatus.isSubmitted) return;

          const submitBtn = document.getElementById('submitBtn');
          const isValid = inputs.every(otherInput => otherInput.value.trim().length > 0);

          if (isValid) {
            submitBtn.removeAttribute('disabled');
            submitBtn.addEventListener('click', validateForms.bind(this, submitStatus));
          }
          else {
            if (!submitBtn.hasAttribute('disabled')) {
              submitBtn.setAttribute('disabled', 'disabled');
              submitBtn.parentElement.replaceChild(submitBtn.cloneNode(true), submitBtn);
            }
          }
        });
      });
    });
  </script>
</body>

</html>