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
	
	<form action="/admin/revenue/subscription" method="post">
		<select name="choiceDate">
			<option value="">선택</option>
			<c:forEach var="choice" items="${choiceList}">
				<option value="${choice}">${choice}</option>
			</c:forEach>
		</select>
		
		<input type="date" name="startDate"> 
		<input type="date" name="endDate">
		<input type="submit" value="rr">
	</form>
	
	<c:if test="${regularList != null }">
		<c:forEach var="r" items="${regularList }">
			돈 : ${r.count } 날짜: ${r.paymentDate }
		</c:forEach>
	</c:if>
	
</body>
</html>