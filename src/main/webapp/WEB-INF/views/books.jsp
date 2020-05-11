<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<title>전체 도서</title>
  <!-- Google Fonts -->
  <link
    href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Nanum+Gothic|Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap"
    rel="stylesheet" />
  <!-- Fontawesome API -->
  <script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
  <!--
    Available Fonts
    Main Font:
    font-family: 'Kaushan Script', cursive;

    Article Choices:
    font-family: 'Roboto', sans-serif;
    font-family: 'Open Sans', sans-serif;
    font-family: 'Montserrat', sans-serif;

    Korean Font:
    font-family: 'Noto Sans KR', sans-serif;
    font-family: 'Black Han Sans', sans-serif;
    font-family: 'Nanum Gothic', sans-serif;
    -->
  <!-- css reset -->
  <link rel="stylesheet" href="../../resources/styles/reset.css" />
  <!-- individual page stylesheet -->
	<link rel="stylesheet" href="../../resources/styles/books.css" />
  <link rel="stylesheet" href="../../resources/styles/common.css" />

  <!-- jQuery CDN -->
  <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
  <!-- slidify sliders and fadeInUp reveal -->
  <script src="../../resources/js/common.js"></script>
</head>
<body>
  <header class="topbar">
    <nav>
      <div class="container">
        <a href="javascript: history.back();"><i class="far fa-arrow-left"></i></a>
        <h2>전체 도서</h2>
      </div>
    </nav>
  </header>
	<form action="books/all" method="GET">
		<div class="genre-list fadeInUp" >
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
	<%@ include file="template/footer.jsp" %>
</body>
</html>