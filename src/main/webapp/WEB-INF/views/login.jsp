<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/member/login" method="post">
		<input type="text" name="memberEmail"><br>
		<input type="text" name="memberPw"><br>
		<input type="checkbox" name="autoLogin" value="auto">
		<input type="submit" value="ㅇㅇ">
	</form>
	<a href="/member/logout">dfs</a>
</body>
</html>