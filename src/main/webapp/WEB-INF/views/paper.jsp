<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<title>도서 구매</title>
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
	<link rel="stylesheet" href="../../resources/styles/paper.css" />
  <link rel="stylesheet" href="../../resources/styles/common.css" />

  <!-- jQuery CDN -->
  <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
  <!-- slidify sliders and fadeInUp reveal -->
  <script src="../../resources/js/common.js"></script>
	<%
		//이전 검색어 유지를 위함
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String criteria = request.getParameter("criteria");
		String keyword = request.getParameter("keyword");
		String category = request.getParameter("category");
		String layout = request.getParameter("layout");
		if(criteria==null) {
			criteria = "제목";
		}
		if(keyword==null) {
			keyword = "";
		}
		if(category==null) {
			category = "all";
		}
		if(layout==null) {
			layout = "list";
		}
	%>
	<script type="text/javascript" >
		//체크된 책들 장바구니에 추가
		$(document).on("click", ".btn-cart", function() {
			console.clear();
			$("input[type='checkbox']:checked").each(function(){
				console.dir($(this).parents(".search").find(".title").text());
			});
		});
		//구매 버튼. 구매 페이지로 이동
		$(document).on("click", ".btn-purchase", function() {
			console.clear();
			console.dir($(this).parents(".search").find(".title").text()+" 구매 시도");
		})
	</script>
</head>
<body>
  <header class="topbar">
    <nav>
      <div class="container">
        <a href="javascript: history.back();"><i class="far fa-arrow-left"></i></a>
        <h2>도서 구매</h2>
      </div>
    </nav>
  </header>
	<!-- 검색바 -->
	<form action="search.do" method="GET" >
		<div class="search-bar" >
			<select class="type" name="type" >
				<option value="BOOK_TITLE" >제목</option>
				<option value="BOOK_WRITER" >저자</option>
				<option value="BOOK_PUBLISHER" >출판사</option>
			</select>
			<input class="keyword" type="text" name="keyword" placeholder="검색어를 입력해주세요"/>
			<button class="btn-search fas fa-search" name="category" value="all" ></button>
		</div>
	</form>
	<!-- 검색 결과 요약 -->
	<!-- 카테고리 선택 -->
	<form action="search.do" method="GET" >
		<div class="category-list" >
			<input class="type" type="hidden" name="type" />
			<input class="keyword" type="hidden" name="keyword" />
			<button name="category" value="all" class="btn-category selected">통합검색</button>
			<button name="category" value="ebook" class="btn-category">ebook</button>
			<button name="category" value="paper" class="btn-category">종이책</button>
		</div>
	</form>
	<div class="search-summary" >
		<div>
			'<span class="skeyword" ><%=keyword %></span><span>'에 대한</span>
		</div>
		<span class="scount" >총<span class="result-count" >
			<c:choose >
				<c:when test="${param.category eq 'all' }" >
					${resultCount }
				</c:when>
				<c:when test="${param.category eq 'ebook' }" >
					${ebookCount }
				</c:when>
				<c:when test="${param.category eq 'paper' }" >
					${paperCount}
				</c:when>
			</c:choose>
		</span>개의 검색결과</span>
		<div class="layout" >
				<button class="btn-layout btn-list list fas fa-list"></button>
				<button class="btn-layout btn-grid fas grid fa-th-large"></button>
		</div>
	</div>
	<div class="cart-belt" >
		<button class="btn-cart" ><i class="far fa-check-square"></i>장바구니 추가</button>
	</div>
	<div class="search-list" >
		<form action="#" method="POST" >
				<button class="category-title" name="category" value="all" >
					전체
					<span class="category-bracket fas fa-chevron-right" ></span>
				</button>
		</form>
		<div class="search-result" >
			<%for(int index=0;index<3;index++) {%>
				<div class="search" >
					<div class="book" >
						<!-- 책 커버 -->
						<img class="cover" src="http://placehold.it/95X120.jpg" />
						<!-- 책 정보 -->
						<div class="info" >
							<div class="title" >책 제목<%=index+1 %> 전체</div>
							<div>
								<span class="author" >저자</span>
								<span class="publisher" >출판사</span>
							</div>
						</div>
					</div>
					<div class="interact" >
						<button class="btn-purchase" >구매</button>
						<input type="checkbox" name="title" value="book-title" />
					</div>
				</div>
			<%} %>
		</div>
	</div>
	<div class="search-list" >
		<form action="#" method="POST" >
			<button class="category-title" name="category" value="all" >장르1</button>
		</form>
		<%for(int index=0;index<3;index++) {%>
			<div class="search" >
				<div class="book" >
					<!-- 책 커버 -->
					<img class="cover" src="http://placehold.it/95X120.jpg" />
					<!-- 책 정보 -->
					<div class="info" >
						<div class="title" >책 제목<%=index+1 %> 장르1</div>
						<div>
							<span class="author" >저자</span>
							<span class="publisher" >출판사</span>
						</div>
					</div>
				</div>
				<div class="interact" >
					<button class="btn-purchase" >구매</button>
					<input type="checkbox" name="title" value="book-title" />
				</div>
			</div>
		<%} %>
	</div>
	<div class="search-list" >
		<form action="#" method="POST" >
			<button class="category-title" name="category" value="all" >장르2</button>
		</form>
		<%for(int index=0;index<3;index++) {%>
			<div class="search" >
				<div class="book" >
					<!-- 책 커버 -->
					<img class="cover" src="http://placehold.it/95X120.jpg" />
					<!-- 책 정보 -->
					<div class="info" >
						<div class="title" >책 제목<%=index+1 %> 장르2</div>
						<div>
							<span class="author" >저자</span>
							<span class="publisher" >출판사</span>
						</div>
					</div>
				</div>
				<div class="interact" >
					<button class="btn-purchase" >구매</button>
					<input type="checkbox" name="title" value="book-title" />
				</div>
			</div>
		<%} %>
	</div>
	<%@ include file="template/footer.jsp" %>
</body>
</html>