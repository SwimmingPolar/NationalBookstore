<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.0.js" integrity="sha256-r/AaFHrszJtwpe+tHyNi/XCfMxYpbsRg2Uqn0x3s2zc=" crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../../resources/styles/reset.css" />
<link rel="stylesheet" type="text/css" href="../../resources/styles/all.css" />
<%
	String type = request.getParameter("type");
	String keyword = request.getParameter("keyword");
	String category = request.getParameter("category");
	if(type == null)
		type = "BOOK_TITLE";
	if(keyword == null)
		keyword = "";
	if(category == null)
		category = "all";
%>
<script type="text/javascript" >
	$(document).ready(function() {
		var type = "<%=type %>";
		var keyword = "<%=keyword %>";
		var layout = "${cookie.layout.value}";
		if(layout == "") {
			layout = "list";
		}
		console.dir("현재 레이아웃:${cookie.layout.value}");
		//검색기준 and 검색어 유지
		$(".type").val(type);
		$(".keyword").val(keyword);
		<c:forEach var="category" items="${selected }" >
			var category = "${category }";
			$(".category").each(function() {
				if($(this).val() == category)
					$(this).attr("checked", true);
			})
		</c:forEach>
		$(".btn-layout."+layout).css("color", "#000000");
		//레이아웃 유지
		if(layout == "list") {
			$(".book-list").removeClass("grid-layout");
		} else {
			$(".book-list").addClass("grid-layout");
		}
		//검색결과 레이아웃 변경
		$(".btn-layout").click(function() {
			$(".btn-layout").css("color", "var(--gray-color)");
			$(this).css("color", "#000000");
			if($(this).hasClass("list")) {
				$(".book-list").removeClass("grid-layout");
				document.cookie = "layout=list";
			}
			else {
				$(".book-list").addClass("grid-layout");
				document.cookie = "layout=grid";
			}
		})
		//정렬
		$(".btn-sort").click(function() {
			var sort = $(this).val();
			console.dir(sort);
			$.ajax({
				url : "sort.do",
				type : "POST",
				data : { "sort" : sort },
				dataType : "json"
			})
			.done(function() {
				console.dir("통신 성공");
			})
			.fail(function() {
				console.dir("통신 실패");
			})
			.always(function() {
				console.dir("통신 요청");
			});
		})
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<%-- 타이틀 --%>
	<div class="div-title" >
		<h3>National Bookstore</h3>
	</div>
	<div ></div>
	${sorto }
	<a href="http://localhost:8081/test/books.jsp"><</a>
	<a href="http://localhost:8081/test/category.do?CATEGORY_NUM=1" >HOME</a>
	<div >
	</div>
	<%-- 검색 박스 --%>
	<form action="category-search.do" method="GET" >
		<div class="search-box" >
			<%-- 검색바 --%>
			<div class="search-bar" >
				<select class="type" name="type" >
					<option value="BOOK_TITLE" >제목</option>
					<option value="BOOK_WRITER" >저자</option>
					<option value="BOOK_PUBLISHER" >출판사</option>
				</select>
				<input class="keyword" type="text" name="keyword" placeholder="검색어를 입력해주세요" />
				<button class="btn-search fas fa-search" ></button>
				</div>
			<%-- 장르 선택 --%>
			<div class="search-selection" >
				<c:forEach var="category" items="${book_category }" >
					<label class="selection" for="${category.CATEGORY_NUM }" ><input type="checkbox" class="category" id="${category.CATEGORY_NUM }" name="category" value="${category.CATEGORY_NUM }"/>${category.BOOK_CATEGORY }</label>
				</c:forEach>
			</div>
		</div>
	</form>
	<!-- 검색 결과 요약 -->
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
	</div>
	<%-- 정렬 기준 --%>
	<div class="sort" >
		<div class="layout" >
			<button class="btn-layout list fas fa-list" ></button>
			<button class="btn-layout grid fas fa-th-large" ></button>
		</div>
		<div class="sort-type" >
			<span>정렬 기준 : </span>
			<button name="sort" value="BOOK_TITLE" class="btn-sort" >제목</button>
			<button name="sort" value="BOOK_WRITER" class="btn-sort" >저자</button>
			<button name="sort" value="BOOK_PUBLISHER" class="btn-sort" >출판사</button>
		</div>
	</div>
	<div class="book-list" >
		<c:forEach var="book" items="${book_list }" >
			<div class="search" >
				<div class="book" >
					<!-- 책 커버 -->
					<img class="cover" />
					<!-- 책 정보 -->
					<div class="info" >
						<div class="title" >${book.BOOK_TITLE }</div>
						<div>
							<span class="author" >${book.BOOK_WRITER }</span>
							<span class="publisher" >${book.BOOK_PUBLISHER }</span>
						</div>
					</div>
				</div>
				<div class="interact" >
					<c:choose>
						<c:when test="${list.getKey() eq 'ebook' }" >
							<button class="btn-read" >바로보기</button>
						</c:when>
					</c:choose>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>