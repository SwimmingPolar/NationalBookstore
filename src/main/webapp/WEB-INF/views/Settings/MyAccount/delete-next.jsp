<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="../../../../resources/styles/deleteNext.css">
    <link href="https://fonts.googleapis.com/css?family=Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap" rel="stylesheet">
    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
    <script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../../../../resources/styles/reset.css">
    <link rel="stylesheet" href="../../../../resources/styles/common.css">
    <script src="../../../../resources/js/common.js"></script>
</head>
<body>
<header class="topbar">
	<nav>
		<div class="container">
		    <a href="javascript: history.back();"><i class="far fa-arrow-left"></i></a>
		    <h2>회원 탈퇴</h2>
		</div>
    </nav>
</header>
    <div class="wrapper">
        <div class="inputPw">
            <h2> 비밀번호 확인 </h2> 
            <hr class="line">
            <div class="infoRechk"> 
                <p>회원님의 정보를 보호하기 위해 비밀번호를 다시 입력해주세요.</p>
                <input type="password" name="inputPW" id="inputPW" placeholder="비밀번호">
            </div>
            <div class="finishChkBtn">
                <button type="button" id="preBtn" onclick="location.href='deleteMyInfo.jsp'">이전</button>
                <button type="button" id="okBtn" onclick="pwRechk()">확인</button>
            </div>
        </div>
</div>

<script>
function pwRechk() {
var pwChk = $('#inputPW').val();
$.ajax({
    type: "post",
    data: {
        "inputPW":pwChk
    },
    url : "passwordRecheck.do",
    dataType: "text",
    success : function(result) {
        if(result) {
            alert("비밀번호가 틀렸습니다. 다시 입력해주세요.");
        }else if(result) {
        	if(confirm("정말로 회원탈퇴를 진행 하시겠습니까?")) {
        		
        	}
        }
    }

});

}

</script>



<script>
    $(document).ready(() => {
      const li = document.querySelector('footer.fixed a[href="/myaccount"]').parentElement;
      const ul = li.parentElement;
      [ul, li].forEach(element => element.classList.add('active'));
    });
  </script>
<%@ include file="../../template/footer.jsp" %>
</body>
</html>