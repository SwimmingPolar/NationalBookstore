<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <title>Bad Request :: 400</title>
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
    #loader {
      position: fixed;
      right: 16px;
      bottom: 16px;
      transition: 2s ease;
      opacity: 0;
      font-family: '맑은 고딕', 'Roboto', sans-serif;
      font-size: 14px;
      display: flex;
      align-items: center;
      font-weight: bold;
    }
  </style>
</head>
<body>
  <div class="container">
    <div class="error fadeInUp">
      <p class="message">Error: 400 Bad Request</p>
      <h1 class="code">4<span class="icon fa fa-frown"></span>0</h1>
      <h4 class="description">
        잘못 된 요청입니다.<br />
        허튼수작 하지마세요!!!<br />
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
  <div id="loader">
    <span>아이큐 추적 중 입니다...&nbsp;&nbsp;</span>
    <img width="18px" src="../../../resources/images/ajax-loading.svg" alt="">
  </div>
  <script>
    window.onload = function() {
      const loader = document.getElementById('loader');
      setTimeout(() => loader.style.opacity = '0.3', 1000);
    }
  </script>
  <!-- slidify sliders and fadeInUp reveal -->
  <link rel="stylesheet" href="../../../resources/styles/common.css">
  <script src="../../../resources/js/common.js"></script>
</body>
</html>