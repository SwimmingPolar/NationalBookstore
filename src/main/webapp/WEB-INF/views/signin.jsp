<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>로그인 - National Bookstore</title>
    <!-- Google Fonts -->
    <link
      href="https://fonts.googleapis.com/css?family=Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap"
      rel="stylesheet"
    />
    <!-- Fontawesome -->
    <script
      src="https://kit.fontawesome.com/201657538f.js"
      crossorigin="anonymous"
    ></script>
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
    <link rel="stylesheet" href="../../resources/styles/signin.css" />
  </head>
  <body>
    <div class="title-bar">
      <a href="/"><h2>National Bookstore</h2></a>
    </div>
    <div class="container">
      <div class="selection-container">
        <div class="email">
          <h3>이메일 로그인</h3>
          <div class="selection">
            <a href="/member/email-signin"><span class="fas fa-envelope-square"></span>이메일</a>
          </div>
        </div>
        <div class="social">
          <h3>SNS 로그인</h3>
          <div class="selection">
            <a href="#"><span class="fab fa-google"></span>구글</a>
            <a href="#"><span class="fab fa-facebook-square"></span>페이스북</a>
            <a href="#"><span class="fab fa-twitter-square"></span>트위터</a>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
