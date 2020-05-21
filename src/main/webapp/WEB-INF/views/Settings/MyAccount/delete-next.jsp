<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
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
<sec:authentication property="principal" var="member"/>
<header class="topbar">
	<nav>
		<div class="container">
		    <a href="javascript: history.back();"><i class="far fa-arrow-left"></i></a>
		    <h2>회원 탈퇴</h2>
		</div>
    </nav>
</header>
<form action="/member/delete" method="post" id="deleteForm">
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
<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
</form>
<script>
function pwRechk() {

	var pwChk = $('#inputPW').val();
	if(pwChk.length == 0) {
		alert("비밀번호를 입력해주세요!")
		return
	}
	
	var member = [];
	member.push({memberEmail : "${member.member.memberEmail}" , memberPw : pwChk});
	$.ajax({
    	type: "POST",
    	dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(member),
    	url : "/member/deletePasswordCheck",
    	traditional:true,
	})
	.done(function(response) {
		if(response) {
			if(confirm("정말로 회원탈퇴를 진행하시겠습니까?")) {
				document.getElementById('deleteForm').submit();
			} else {
				alert("회원탈퇴 진행을 취소 하셨습니다.")
				location.href="/";
			}
		} else {
			alert("비밀번호가 일치 하지 않습니다.");
		}
	})
	.fail(function(response) {
	})

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