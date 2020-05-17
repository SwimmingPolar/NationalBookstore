<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
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
    <form id="signup-form" action="#" method="post">
      <div class="form-container">
        <div class="email-container">
          <label for="email">
            <input id="email" name="email" type="text" required spellcheck="false" autocomplete="off">
            <span class="placeholder">이메일</span>
          </label>
          <button type="button" class="auth-btn" disabled>인증</button>
          <label for="email-auth">
            <input id="email-auth" name="email-auth" type="text" required spellcheck="false" autocomplete="off" placeholder="인증 코드를 입력해주세요.">
            <span class="timer"></span>
          </label>
          <span class="warning-msg"><span class="far fa-exclamation-circle"></span></span>
        </div>
        <div class="passwd-container">
          <label for="passwd">
            <input id="passwd" name="passwd" type="password" required onblur="validatePasswd()">
            <span class="placeholder">비밀번호</span>
          </label>
          <label for="passwdConfirm">
            <input id="passwdConfirm" name="passwdConfirm" type="password" required onblur="validatePasswd()">
            <span class="placeholder">비밀번호 확인</span>
          </label>
          <span class="warning-msg"><span class="far fa-exclamation-circle"></span></span>
        </div>
        <div class="nickname-container">
          <label for="nickname">
            <input id="nickname" name="nickname" type="text" required spellcheck="false" autocomplete="off">
            <span class="placeholder">닉네임</span>
          </label>
          <span class="warning-msg"><span class="far fa-exclamation-circle"></span></span>
        </div>
        <div class="address-container">
          <label for="zipcode" onclick="openAddressAPI()">
            <input id="zipcode" name="zipcode" type="text" required spellcheck="false" autocomplete="off" tabindex="-1"
              disabled="disabled">
            <span class="placeholder">우편번호</span>
          </label>
          <button type="button" onclick="openAddressAPI()">우편번호 찾기</button>
          <label for="roadAddress" onclick="openAddressAPI()">
            <input id="roadAddress" name="roadAddress" type="text" required spellcheck="false" autocomplete="off"
              tabindex="-1" disabled="disabled">
            <span class="placeholder">주소</span>
          </label>
          <label for="detailAddress">
            <input id="detailAddress" name="detailAddress" type="text" required spellcheck="false" autocomplete="off">
            <span class="placeholder">상세 주소</span>
          </label>
          <span class="warning-msg"><span class="far fa-exclamation-circle"></span></span>
        </div>
        <div class="tel-container">
          <label for="tel">
            <input id="tel" name="tel" type="text" required spellcheck="false" autocomplete="off"
              onblur="validateTel()">
            <span class="placeholder">휴대폰 번호</span>
          </label>
          <span class="warning-msg"><span class="far fa-exclamation-circle"></span></span>
        </div>
        <button class="submit" type="button" disabled>회원 가입 완료</button>
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
            zipcodePlaceholder.style.transform = 'scale(0.8) translateX(-10%) translateY(-70%)';
            roadAddressPlaceholder.style.transform = 'scale(0.8) translateX(-10%) translateY(-70%)';
            zipcode.value = data.zonecode;
            roadAddress.value = data.address;
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
      timer.style.color = 'var(--violet-color)';

      // get time from timer element's data attribute
      let countdown = 60;
      // clear previous timer if any
      const previousCountdown = timer.getAttribute('data-countdown-timer-id');
      if (previousCountdown) clearInterval(previousCountdown);

      // update timer element every second
      const intervalId = setInterval(() => {
        let minutes = String(Math.floor(countdown/60));
        minutes = (minutes.length === 1 ? '0' : '') + minutes;

        let seconds = String(Math.floor(countdown%60));
        seconds = (seconds.length === 1 ? '0' : '') + seconds;

        timer.innerHTML = minutes + ':' + seconds;

        // decrease timer
        countdown -= 1;
        // update timer data and save on timer element
        timer.setAttribute('data-countdown', countdown);

        // if countdown is less then 10 seconds change font color to red on next coundown repaint
        if (countdown <= 10) timer.style.color = 'var(--red-color)';

        // stop timer on 0 second
        if (countdown < 0) clearInterval(intervalId);
      }, 1000);
      // set setInterval id to timer element
      timer.setAttribute('data-countdown-timer-id', intervalId);
    }
    function requestVerificationCodeConfirmation() {
      const countdownTime = Number(document.querySelector('.email-container span.timer').value.trim());
      if (countdownTime < 0) {
        alert('인증 코드가 만료되었습니다.')
        return;
      }
      const emailInput = document.getElementById('email');
      const email = emailInput.value.trim();
      const code = document.getElementById('email-auth').value.trim();

      const xhr = new XMLHttpRequest();
      xhr.open('POST', '/emailAuthenticationCheck');
      xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
      xhr.onreadystatechange = function() {
        if (!(xhr.readyState === 4 && xhr.status === 200)) return;
          const isValid = JSON.parse(xhr.response).result;
          console.log('verification completed: ' + isValid);
          if (isValid) {
            // lock email input
            emailInput.setAttribute('data-locked', true); 
            // hide authentication code input
            emailWrapper.classList.remove('getAuth');
            // mark checked
            const emailLabel = document.querySelector('.email-container label[for="email"]');
            markChecked(emailLabel);

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

      // enable authentication code input label
      if (!emailWrapper.classList.contains('getAuth'))
        emailWrapper.classList.add('getAuth');
      // change button text
      emailAuthButton.textContent = '확인';

      // add code confirm request handler
      emailAuthButton.addEventListener('click', () => {
        const email = document.getElementById('email').value.trim();
        
        const xhr = new XMLHttpRequest();
        xhr.open('POST', '/emailAuthentication');

        xhr.onerror = () => 
        xhr.onreadystatechange = function() {
          if (!(xhr.readyState === 4 && xhr.status === 200)) return;

          const isValid = JSON.parse(xhr.response).result;
          console.log('request verification code: ' + isValid);
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
      });
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

          // start timer when email confirmation code is successfully sent
          const timer = emailWrapper.querySelector('span.timer');
          startTimer(timer);

          // hold off alert message
          setTimeout(() => alert('이메일을 확인해주세요!', 0));
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
      const emailAuthButton = document.querySelector('.email-container > button');
      const warningMsg = document.querySelector('label[for="email"] ~ .warning-msg');

      let validationTimer = null;
      emailInput.addEventListener('input', function () {
        const email = emailInput.value.trim();
        // remove check mark on input
        const check = document.querySelector('.email-container .validated');
        if (check) check.parentElement.removeChild(check);

        // remove email validation processed marking
        emailInput.removeAttribute('data-is-validated');
        // disable email authentication button
        emailAuthButton.setAttribute('disabled', 'disabled');
        // change button content
        emailAuthButton.textContent = '인증';

        // if email is not valid format then return
        if (!isValidEmailFormat(email)) return;

        // clear validation schedule
        clearTimeout(validationTimer)
        validationTimer = setTimeout(function () {
          if (email.length <= 0) return;
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
        // if email is valid format, show email authentication process message
        else if (isValidEmailFormat(email))
          warningMsg.innerHTML = '<span class="far fa-check-circle info-msg"> 이메일 인증을 진행해주세요.</span>';
        // if not, show warning message 
        else
          warningMsg.innerHTML = '<span class="far fa-exclamation-circle"> 이메일 양식을 확인해주세요.</span>';

        warningMsg.style.display = 'block';
        emailWrapper.style.marginBottom = '0';
      });
      emailInput.addEventListener('focus', () => {
        const isLocked = emailInput.getAttribute('data-locked');
        if (!isLocked) return;

        const onUserConsent = confirm('이메일을 바꾸시겠습니까?');
        if (onUserConsent)
          emailInput.removeAttribute('data-locked');
      });
    });
  </script>
  <!-- 비밀번호 유효성 검사 -->
  <script>
    function validatePasswd() {
      const passwd = document.getElementById('passwd').value.trim();
      const passwdConfirm = document.getElementById('passwdConfirm').value.trim();
      const passwdPattern = /^(?=.*?[^\s])[\w\d]{4,}$/;
      const warningMsg = document.querySelector('label[for="passwd"] ~ .warning-msg');
      const passwdWrapper = warningMsg.parentElement;

      // 패스워드칸을 지울 경우 경고 메세지도 가림
      if (passwd.length <= 0) {
        warningMsg.style.display = 'none';
        passwdWrapper.style.marginBottom = '25px';
      }
      // 유효하지 않은 비밀번호 일 경유
      else if (!(passwdPattern.test(passwd))) {
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
    function validateTel() {
      const telWrapper = document.querySelector('label[for="tel"]').parentElement;
      const telLabel = document.querySelector('.tel-container label');
      const telPattern = /\d{11}/;
      const tel = document.getElementById('tel').value.trim().replace(/-/g, '').replace(/[\s]/g, '');
      const warningMsg = telWrapper.querySelector('.warning-msg');

      if (tel.length <= 0) {
        warningMsg.style.display = 'none';
        telWrapper.style.marginBottom = '25px';
      } else if (!(telPattern.test(tel)) || tel.length > 11) {
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
        if (!(xhr.readyState === 4 && ready.status === 200)) return;
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
</body>

</html>