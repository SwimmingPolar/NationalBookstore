<%@page import="org.springframework.ui.Model"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색</title>
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap" rel="stylesheet">
<!-- Fontawesome -->
<script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
<!-- css reset -->
<link rel="stylesheet" type="text/css" href="../resources/styles/reset.css" />
<link rel="stylesheet" type="text/css" href="../resources/styles/search.css" />
<script src="https://code.jquery.com/jquery-3.5.0.js" integrity="sha256-r/AaFHrszJtwpe+tHyNi/XCfMxYpbsRg2Uqn0x3s2zc=" crossorigin="anonymous"></script>
<%
	String type = request.getParameter("type");
	String keyword = request.getParameter("keyword");
	String category = request.getParameter("category");
	String pageNum = request.getParameter("page");
	
	if(type == null)
		type = "BOOK_TITLE";
	if(keyword == null)
		keyword = "";
	if(category == null)
		category = "all";
	if(pageNum == null)
		pageNum = "1";
%>
<script type="text/javascript" >
	$(document).ready(function() {
		var type = "<%=type %>";
		var keyword = "<%=keyword %>";
		var category = "<%=category %>";
		var layout = "${cookie.layout.value}";
		var pageNum = "<%=pageNum %>";
		if(layout == "") {
			layout = "list";
		}
		//검색기준 and 검색어 유지
		$(".type").val(type);
		$(".keyword").val(keyword);
		$(".category[type='hidden']").val(category);
		$(".btn-layout."+layout).css("color", "#000000");
		$(".btn-page."+pageNum).css("color", "var(--red-color)");
		//레이아웃 유지
		if(layout == "list") {
			$(".search-result").removeClass("grid-layout");
		} else {
			$(".search-result").addClass("grid-layout");
		}
		//카테고리 선택 및 점등
		$(".btn-category").each(function() {
			$(this).removeClass("selected");
		})
		$(".btn-category[value='"+category+"']").toggleClass("selected");
		//검색버튼 or 카테고리 버튼 누를 시
		$(".btn-search, .category").click(function() {
			var name = $(".type option:selected").val();
			var value = $(".keyword").val();
		});
		//검색결과 레이아웃 변경
		$(".btn-layout").click(function() {
			$(".checkbox-cart").each(function() {
				$(this).prop("checked", true);
				$(this).prop("checked", false);
			});
			$(".btn-layout").css("color", "var(--gray-color)");
			$(this).css("color", "#000000");
			if($(this).hasClass("list")) {
				$(".search-result").removeClass("grid-layout");
				document.cookie = "layout=list";
			}
			else {
				$(".search-result").addClass("grid-layout");
				document.cookie = "layout=grid";
			}
		})
		//장바구니 추가
		$(".btn-cart-outer").click(function() {
			var cartList = [];
			$(".checkbox-cart").each(function() {
				if($(this).prop("checked") == true)
					cartList.push($(this).val());
			})
			console.dir(cartList);
		})
		
		$(".btn-page").click(function(data) {
			console.dir(data.target.value);
		})
	});
</script>
</head>
<c:set var="ebook" value="${result.ebook }" />
<c:set var="paper" value="${result.paper }" />
<c:set var="ebookCount" value="${fn:length(ebook) }" />
<c:set var="paperCount" value="${fn:length(paper) }" />
<c:set var="resultCount" value="${ebookCount + paperCount }" />
<body>
	<div class="div-title" >
		<h3>National Bookstore</h3>
	</div>
	<div ></div>
	<!-- 검색바 -->
	<form action="/controller/search/search" method="GET" >
		<div class="search-bar" >
			<select class="type" name="type" >
				<option value="BOOK_TITLE" >제목</option>
				<option value="BOOK_WRITER" >저자</option>
				<option value="BOOK_PUBLISHER" >출판사</option>
			</select>
			<input class="keyword" type="text" name="keyword" placeholder="검색어를 입력해주세요" autocomplete="off" spellcheck="false"/>
			<button class="btn-search fas fa-search" name="category" value="all" ></button>
		</div>
	</form>
	<!-- 검색 결과 요약 -->
	<c:if test="${not empty param.keyword }" >
		<!-- 카테고리 선택 -->
		<form action="/controller/search/search" method="GET" >
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
		<c:choose>
			<%-- 통합검색일때 --%>
			<c:when test="${param.category eq 'all' }" >
				<c:forEach var="list" items="${result }" >
					<div class="search-list">
						<%-- 카테고리 벨트 --%>
						<div class="category-belt" >
							<form action="/controller/search/search" method="GET" >
								<input class="type" type="hidden" name="type" />
								<input class="keyword" type="hidden" name="keyword" />
								<button name="category" value="${list.getKey() }" class="btn-category-belt" >
									<c:choose>
										<c:when test="${list.getKey() eq 'ebook' }" >
											<span class="category-title" >EBOOK</span>
											<span class="category-count" >${ebookCount }</span>
										</c:when>
										<c:when test="${list.getKey() eq 'paper' }" >
											<span class="category-title" >종이책</span>
											<span class="category-count" >${paperCount }</span>
										</c:when>
									</c:choose>
									<span class="fas fa-chevron-right"></span>
								</button>
							</form>
						</div>
						<%-- 카테고리 벨트 끝 --%>
						<%-- 책리스트 --%>
						<div class="search-result" >
							<c:set var="loop_flag" value="true" />
							<c:forEach var="book" items="${list.getValue() }" begin="0" end="3" varStatus="status" >
								<c:if test="${loop_flag }" >
									<div class="search" >
										<div class="book" >
											<!-- 책 커버 -->
											<img class="cover" />
											<!-- 책 정보 -->
											<div class="info" >
												<div class="title" >${book.bookTitle }</div>
												<div>
													<span class="author" >${book.bookWriter }</span>
													<span class="publisher" >${book.bookPublisher }</span>
												</div>
											</div>
										</div>
										<div class="interact" >
											<c:choose>
												<c:when test="${list.getKey() eq 'ebook' }" >
													<button class="btn-read" >바로보기</button>
												</c:when>
												<c:when test="${list.getKey() eq 'paper' }" >
													<button class="btn-purchase" >구매</button>
												</c:when>
											</c:choose>
										</div>
									</div>
								</c:if>
							</c:forEach>
						</div>
						<%-- 책리스트 끝 --%>
					</div>
				</c:forEach>
			</c:when>
			<%-- 통합검색일때 끝 --%>
			<%-- 단일 카테고리일때 --%>
			<c:otherwise>
				<div class="search-list" >
				<%-- 카테고리 벨트 --%>
					<div class="category-belt" >
						<input class="type" type="hidden" name="type" />
						<input class="keyword" type="hidden" name="keyword" />
						<button class="btn-category-belt" style="cursor:default;" >
							<c:choose>
								<c:when test="${param.category eq 'ebook' }" >
									<span class="category-title" >EBOOK</span>
									<span class="category-count" >${ebookCount }</span>
								</c:when>
								<c:when test="${param.category eq 'paper' }" >
									<span class="category-title" >종이책</span>
									<span class="category-count" >${paperCount }</span>
								</c:when>
							</c:choose>
							<%-- 종이책일때는 장바구니 추가 버튼 생성 --%>
							<c:if test="${param.category eq 'paper' }">
								<span class="to-cart" ><span class="btn-cart-outer far fa-check-square" ><span class="btn-cart" >&nbsp;장바구니 추가</span></span></span>
							</c:if>
							<span class="fas fa-chevron-right" style="display:none;"></span>
						</button>
					</div>
					<%-- 카테고리 벨트 끝 --%>
					<%-- 책리스트 --%>
					<div class="search-result" >
						<c:forEach var="book" items="${result.get(param.category) }" >
							<div class="search" >
								<div class="book" >
									<!-- 책 커버 -->
									<img class="cover" />
									<c:if test="${param.category eq 'paper' }" >
										<input class="checkbox-cart btn-grid-cart" type="checkbox" name="cart" value="${book.bookNum }"/>
									</c:if>
									<!-- 책 정보 -->
									<div class="info" >
										<div class="title" >${book.bookTitle }</div>
										<div>
											<span class="author" >${book.bookWriter }</span>
											<span class="publisher" >${book.bookPublisher }</span>
										</div>
									</div>
								</div>
								<div class="interact" >
									<c:choose>
										<c:when test="${param.category eq 'ebook' }" >
											<button class="btn-read" >바로보기</button>
										</c:when>
										<c:when test="${param.category eq 'paper' }" >
											<button class="btn-purchase" >구매</button>
											<input class="checkbox-cart btn-list-cart" type="checkbox" name="cart" value="${book.bookNum }" />
										</c:when>
									</c:choose>
								</div>
							</div>
						</c:forEach>
					</div>
					<%-- 책리스트 끝 --%>
				</div>
				<form action="/controller/search/search" >
				<div class="div-page" >
					<button class="btn-page before" name="pageNumber" value="before"><</button>
					<c:forEach var="i" begin="0" end="9" >
						<button class="btn-page ${i+1 }" name="pageNumber" value="${i+1 }" >${i+1 }</button>
					</c:forEach>
					<button class="btn-page next" name="pageNumber" value="after">></button>
				</div>
				</form>
			</c:otherwise>
			<%-- 단일 카테고리일때 끝 --%>
		</c:choose>
	</c:if>
</body>
</html>