<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 도서</title>
<script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.0.js" integrity="sha256-r/AaFHrszJtwpe+tHyNi/XCfMxYpbsRg2Uqn0x3s2zc=" crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../../resources/styles/reset.css" />
<link rel="stylesheet" type="text/css" href="../../resources/styles/books.css" />
<script type="text/javascript" >
</script>
</head>
<body>
	<div id="div-title" class="div-title" >
		<h3>National Bookstore</h3>
	</div>
	<div ></div>
	<form action="books/all" method="GET">
		<div class="genre-list" >
			<button class="genre 2" name="genre" value="2" >소설/시</button>
			<button class="genre 3" name="genre" value="3" >에세이</button>
			<button class="genre 4" name="genre" value="4" >인문</button>
			<button class="genre 5" name="genre" value="5" >역사</button>
			<button class="genre 6" name="genre" value="6" >예술</button>
			<button class="genre 7" name="genre" value="7" >종교</button>
			<button class="genre 8" name="genre" value="8" >사회</button>
			<button class="genre 9" name="genre" value="9" >과학</button>
			<button class="genre 10" name="genre" value="10" >경제/경영</button>
			<button class="genre 11" name="genre" value="11" >자기계발</button>
		</div>
	</form>
</body>
</html>