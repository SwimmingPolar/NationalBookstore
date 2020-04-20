<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:if test="${ryanMember != null }">
		<h1>자동 로그인 완료!</h1>
	</c:if>
	
	<a href="/member/login">로그인 페이지 이동</a>
	
</body>
</html>