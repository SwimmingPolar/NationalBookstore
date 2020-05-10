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
    href="https://fonts.googleapis.com/css?family=Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap"
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
  <link rel="stylesheet" href="../../resources/styles/reset.css" />

  <!-- individual page stylesheet -->
  <link rel="stylesheet" href="../../resources/styles/signup.css" />

  <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
</head>

<body>
  <div class="title-bar">
    <a href="/">
      <h2>National Bookstore</h2>
    </a>
  </div>
  <div class="container">
    <form id="signup-form" action="/member/signup" method="post">
      <div class="form-container">
        <div class="email-container">
          <label for="email">
            <input id="email" name="email" type="text" required spellcheck="false" autocomplete="off">
            <span class="placeholder">이메일</span>
          </label>
          <button type="button" disabled>인증</button>
          <span class="warning-msg"><span class="far fa-exclamation-circle"></span></span>
        </div>
        <div>
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
        <div>
          <label for="nickname">
            <input id="nickname" name="nickname" type="text" required spellcheck="false" autocomplete="off">
            <span class="placeholder">닉네임</span>
          </label>
          <span class="warning-msg"><span class="far fa-exclamation-circle"></span></span>
        </div>
        <div class="address-container">
          <label for="zipcode" onclick="openAddressAPI()">
            <input id="zipcode" name="zipcode" type="text" required spellcheck="false" autocomplete="off" tabindex="-1" disabled="disabled">
            <span class="placeholder">우편번호</span>
          </label>
          <button type="button" onclick="openAddressAPI()">우편번호 찾기</button>
          <label for="roadAddress" onclick="openAddressAPI()">
            <input id="roadAddress" name="roadAddress" type="text" required spellcheck="false" autocomplete="off" tabindex="-1" disabled="disabled">
            <span class="placeholder">주소</span>
          </label>
          <label for="detailAddress">
            <input id="detailAddress" name="detailAddress" type="text" required spellcheck="false" autocomplete="off">
            <span class="placeholder">상세 주소</span>
          </label>
          <span class="warning-msg"><span class="far fa-exclamation-circle"></span></span>
        </div>
        <div>
          <label for="tel">
            <input id="tel" name="tel" type="text" required spellcheck="false" autocomplete="off" onblur="validateTel()">
            <span class="placeholder">휴대폰 번호</span>
          </label>
          <span class="warning-msg"><span class="far fa-exclamation-circle"></span></span>
        </div>
        <button type="submit" disabled>회원 가입 완료</button>
      </div>
    </form>
  </div>
  <!-- change z-index of overlapping input elements on focus -->
  <script>
    $(document).ready(function () {
      const passwdInput = document.getElementById('passwd');
      const passwdConfirmInput = document.getElementById('passwdConfirm');
      const inputs = [passwdInput, passwdConfirmInput];
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
          oncomplete: function(data) {
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
          onclose: function() {
            isAddressWindowOpened = false;
          }
        });
        addressWindow.open();
      }
    }
  </script>
  <!-- 이메일 인증 버튼 활성화 -->
  <script>
    $(document).ready(function() {
      function isValidFormat(email) {
        const emailPattern = /^[\d\w]+@(=?.*?[\w]+)[\d\w]*\.[\w]+(\.[\w]+){0,1}$/;
        return emailPattern.test(email);
      }
      function validateEmail(email, emailAuthButton) {
        // append spinner to label
        const emailLabel = document.querySelector('.email-container > label[for="email"]');
        const spinner = document.createElement('img');
        spinner.setAttribute('src', '../../resources/images/ajax-loading.svg');
        emailLabel.appendChild(spinner);

        const xhr = new XMLHttpRequest();
        xhr.open('POST', '/member/signUpCheck');

        // unload spinenr on 'loadend'
        xhr.addEventListener('loadend', () => {
          emailLabel.removeChild(spinner);
          const check = document.createElement('span');
          check.className = 'fal fa-check validated';
          emailLabel.appendChild(check);
        });

        xhr.onreadystatechange = function() {
          if (xhr.readyState === 4 && xhr.status === 200) {
            emailAuthButton.removeAttribute('disabled');
            console.dir(xhr.responseText);
          }
        };

        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.send('memberEmail=' + email);
      }
      const emailInput = document.getElementById('email');
      const emailAuthButton = document.querySelector('.email-container > button')
      let validationTimer = null;
      emailInput.addEventListener('input', function() {
        // remove check mark on input
        const check = document.querySelector('.email-container .validated');
        if (check) check.parentElement.removeChild(check);

        if (isValidFormat(emailInput.value.trim()))
          validationTimer = clearTimeout(validationTimer) || setTimeout(function() {
            validateEmail(emailInput.value.trim(), emailAuthButton)
          }, 750);
        else
          emailAuthButton.setAttribute('disabled', 'disabled');
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
      const wrapperDiv =  warningMsg.parentElement;

      if (!(passwdPattern.test(passwd))) {
        wrapperDiv.style.marginBottom = '0';
        warningMsg.style.display = 'block';
        warningMsg.innerHTML = '<span class="far fa-exclamation-circle">유효한 비밀번호를 입력해주세요.</span>'
      } else if (passwd !== passwdConfirm) {
        wrapperDiv.style.marginBottom = '0';
        warningMsg.style.display = 'block';
        warningMsg.innerHTML = '<span class="far fa-exclamation-circle">비밀번호가 일치하지 않습니다.</span>'
      } else {
        wrapperDiv.style.marginBottom = '25px';
        warningMsg.style.display = 'none';
      }
    }
  </script>
  <!-- 핸드폰번호 유효성 검사 -->
  <script>
    function validateTel() {
      const tel = document.getElementById('tel').value.trim().replace(/-/g, '').replace(/[\s]/g, '');
      const telPattern = /[\D]/gi;
      const telWrapper = document.querySelector('label[for="tel"]').parentElement;
      const warningMsg = telWrapper.querySelector('.warning-msg');

      if (telPattern.test(tel) || tel.length !== 11) {
        telWrapper.style.marginBottom = '0';
        warningMsg.style.display = 'block';
        warningMsg.innerHTML = '<span class="far fa-exclamation-circle">유효한 휴대폰 번호를 입력해주세요.</span>'
      } else {
        telWrapper.style.marginBottom = '25px';
        warningMsg.style.display = 'none';
      }
    }
  </script>
  <!-- 닉네임 유효성 검사 -->
  <script>
    $(document).ready(function() {
      const nicknameInput = document.getElementById('nickname');
      const nicknamePattern = /^[a-zA-Z][\d\w]{3,11}/;
      const nicknameWrapper = document.querySelector('label[for="nickname"]').parentElement;
      const warningMsg = nicknameWrapper.querySelector('.warning-msg');
      let validationTimer = null;

      nicknameInput.addEventListener('input', function() {
        const nickname = document.getElementById('nickname').value.trim();
        if (nicknamePattern.test(nickname)) {
          validationTimer = clearTimeout(validationTimer) || setTimeout(function() {
            
          }, 750);
        }
      }); 
    });
  </script>
</body>

</html>