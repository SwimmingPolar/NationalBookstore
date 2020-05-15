<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="../../resources/styles/myManage.css">
    <link href="https://fonts.googleapis.com/css?family=Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap" rel="stylesheet">
    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
    <script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../../resources/styles/reset.css">
    <link rel="stylesheet" href="../../resources/styles/common.css">
    <script src="../../resources/js/common.js"></script>

</head>
<body>
<header class="topbar">
        <nav>
          <div class="container">
            <a href="javascript: history.back();"><i class="far fa-arrow-left"></i></a>
            <h2>내 정보 관리</h2>
          </div>
        </nav>
      </header>
<div class="wrapper">
    <div class="title">
        <h2> <i class="fas fa-bell-on"></i>  <p> ${ryanMember.memberNickName }</p></h2>

    </div>
    
            
    <div class="summary">
        <div class="goSub">
            
            <button type="button" id="gogoSub" onclick="location.href='goSubscribe.html'">
                <p>
                    정기구독 신청하기
                </p>
                <p>
                    독서 습관을 길러서 지식인이 되어보아요.
                </p>
                <p>
                    정기구독 신청하고 첫 달 무료 혜택받기!!

                </p>
                <div class="image">
                    <img src="../../resources/images/myLibrary/photoImg.png" >
                </div>
            </button>
           

        </div>

    </div>

    <div class="listChoice">
        <p> 정보 관리 </p>
        <ul>
            <li><a href="myInfoUpdate.jsp">회원정보수정 <i class="far fa-chevron-right"></i></a></li>
            <li><a href="deleteMyInfo.jsp">회원탈퇴<i class="far fa-chevron-right"></i></a> </li>
        </ul>
    </div>

    <div class="listChoice">
        <p> 서비스 관리 </p>
        <ul>
            <li><a href="buyPaperBook.jsp">종이책 구매 관리<i class="far fa-chevron-right"></i></a></li>
            <li><a href="#">구독 내역<i class="far fa-chevron-right"></i></a></li>
            <li><a href="#">결제수단 관리<i class="far fa-chevron-right"></i></a></li>
        </ul>
    </div>

    <div class="listChoice">
        <p> 서비스 안내 </p>
        <ul>
            <li><a href="#">공지사항<i class="far fa-chevron-right"></i></a></li>
            <li><a href="#">고객센터<i class="far fa-chevron-right"></i></a></li>
        </ul>
    </div>


    <div class="lastColumn">


    </div>

</div>
</body>
</html>