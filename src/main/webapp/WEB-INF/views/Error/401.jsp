<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <title>Unauthorized :: 401</title>
  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Nanum+Gothic|Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap"rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Pangolin&family=Indie+Flower&family=Special+Elite&family=Monoton&family=Titillium+Web:wght@400;600;700&display=swap" rel="stylesheet">
  <!-- 
    font-family: 'Pangolin'
    font-family: 'Indie Flower';
    font-family: 'Special Elite';
    font-family: 'Monoton';
    font-family: 'Titillium Web';
  -->

  <!-- Fontawesome API-->
  <script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>

  <!-- css reset -->
  <link rel="stylesheet" href="../../../resources/styles/reset.css">
  <!-- individual page stylesheet -->
  <link rel="stylesheet" href="../../../resources/styles/error.css">

  <style>
    .icon {
      opacity: 0.9;
    }
  </style>
</head>
<body>
  <div class="container">
    <div class="error fadeInUp">
      <p class="message">Error: 401 Unauthorized</p>
      <h1 class="code">4<span class="icon fad fa-fingerprint"></span>1</h1>
      <h4 class="description">
        보안 토큰 혹은 인증 정보가 잘못 되었습니다.<br />
      </h4>
    </div>
  </div>
  <div class="svg-wrapper">
    <svg viewBox="0 0 1440 320"><path fill="#007bff" fill-opacity="1" d="M0,64L1440,224L1440,0L0,0Z"></path></svg>
    <div class="button-wrapper fadeInUp">
      <a href="/">홈으로</a>
      <a href="javascript: history.back();">뒤로가기</a>
    </div>
  </div>
  <!-- slidify sliders and fadeInUp reveal -->
  <script src="../../../resources/js/common.js"></script>
  <link rel="stylesheet" href="../../../resources/styles/common.css">
</body>
</html>