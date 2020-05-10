<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="../../resources/styles/deleteNext.css">
    <link href="https://fonts.googleapis.com/css?family=Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap" rel="stylesheet">
    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
    <script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>

</head>
<body>

    <div class="title">
        <h3> 회원 탈퇴 </h3>
    </div>
    
    <div class="wrapper">
        <div class="inputPw">

            <h2> 비밀번호 확인 </h2> 
            <hr class="line">
            <div class="infoRechk"> 
                <p>회원님의 정보를 보호하기 위해 비밀번호를 다시 입력해주세요.</p>
                <input type="text" name="inputPW" id="inputPW" placeholder="비밀번호">
            </div>
            <div class="finishChkBtn">
                <button type="button" id="preBtn">이전</button>
                <button type="button" id="okBtn">확인</button>
            </div>
        </div>
        

    </div>

</body>
</html>