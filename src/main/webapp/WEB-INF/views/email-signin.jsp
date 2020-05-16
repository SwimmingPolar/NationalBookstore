<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>이메일 로그인 - National Bookstore</title>
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
  <link rel="stylesheet" href="../../resources/styles/email-signin.css" />

  <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
</head>
<body>
  <header class="topbar">
    <nav>
      <div class="container">
        <a href="javascript: history.back();"><i class="far fa-arrow-left"></i></a>
        <h2>이메일 로그인</h2>
      </div>
    </nav>
  </header>
  <div class="body-wrapper">
    <div class="selection-container">
      <div>
        <h3>이메일 로그인</h3>
        <form id="login-form" action="/member/signin" method="post">
          <div class="form-container">
            <label>이메일</label>
            <input type="text" placeholder="nationalbookstore@gmail.com" spellcheck="false" autocomplete="off" name="memberEmail"/>
            <label>비밀번호</label>
            <input type="password" placeholder="영어, 숫자 포함 4자리 이상 입력해주세요." name="memberPw"/>
            <div class="find-my-account">
              <a href="#">아이디 찾기</a>
              <a href="#">비밀번호 찾기</a>
            </div>
            <button type="submit" disabled="disabled">로그인</button>
            <a href="/member/signup">회원가입</a>
          </div>
        </form>
      </div>
    </div>
  </div>
</body>
<!-- enable login button on valid input -->
<script>
  $(document).ready(function () {
    function areValid(email, passwd) {
      const emailPattern = /^[\d\w]+@(=?.*?[\w]+)[\d\w]*\.[\w]+(\.[\w]+){0,1}$/;
      const passwdPattern = /^(?=.*?[^\s])[\w\d]{4,}$/;
      return emailPattern.test(email) && passwdPattern.test(passwd);
    }
    const email = document.querySelector('.form-container > input[type="text"]');
    const passwd = document.querySelector('.form-container > input[type="password"]');
    const loginButton = document.querySelector('.form-container > button[type="submit"]');
    [email, passwd].forEach(input => {
      input.addEventListener('input', () => {
        const areValidated = areValid(email.value, passwd.value);
        if (areValidated)
          loginButton.removeAttribute('disabled');
        else
          loginButton.setAttribute('disabled', 'disabled');
      });
    });
  });
</script>

</html>