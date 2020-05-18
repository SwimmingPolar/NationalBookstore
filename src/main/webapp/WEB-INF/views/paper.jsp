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
  <link rel="stylesheet" href="../../resources/styles/common.css" />
	<link rel="stylesheet" href="../../resources/styles/paper.css" />

  <!-- jQuery CDN -->
  <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
  <!-- slidify sliders and fadeInUp reveal -->
  <script src="../../resources/js/common.js"></script>
<%
	String type = request.getParameter("type");
	String keyword = request.getParameter("keyword");
	String genre = request.getParameter("genre");
	String pageNum = request.getParameter("page");
	
	if(type == null)
		type = "title";
	if(keyword == null)
		keyword = "";
	if(genre == null || genre == "")
		genre = "0";
	if(pageNum == null)
		pageNum = "1";
%>
<script type="text/javascript" >
	$(document).ready(function() {
		var type = "<%=type %>";
		var keyword = "<%=keyword %>";
		var genre = "<%=genre %>";
		var layout = "${cookie.layout.value}";
		var pageNum = "<%=pageNum %>";
		if(layout == "") {
			layout = "list";
		}
		//검색기준 and 검색어 유지
		$(".type").val(type);
		$(".keyword").val(keyword);
		$(".category[type='hidden']").val(genre);
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
		$(".btn-category[value='"+genre+"']").toggleClass("selected");
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
		$(".to-cart").click(function(e) {
			e.preventDefault();
		});
		$(".btn-cart-outer").click(function() {
			var cartList = [];
			$(".checkbox-cart").each(function() {
				if($(this).prop("checked") == true)
					cartList.push({ bookNum : $(this).val(), bookCount : "1" });
			})
			var cartArray = JSON.stringify(cartList);
			if(cartList.length == 0)
				alert("추가할 도서를 선택해주세요.");
			else {
				$.ajax({
					url : "/search/cart",
					dataType : "json",
					contentType : "application/json",
					data : {
						"cartList" : cartArray,
					},
					type : "POST"
				})
				.done(function(response) {
					console.dir(response.doneM);
					/* var moveToCart = confirm("장바구니로 이동 하시겠습니까?");
					if(moveToCart == true)
						location.href="/cartPage"; */
				})
				.fail(function(response) {
					alert("장바구니 담기에 실패했습니다. 다시 시도해주세요.")
				})
			}
		})
		//페이징
		var currentpage = "${param.page }"; //현재 페이지
		var startpage = 0; //시작 페이지 초기화
		//현재 페이지가 널이아니고 비어있으면 1.
		if(currentpage=="") 
			currentpage = 1;
		//시작 페이지 지정.
		if(currentpage%10 != 0) {
			startpage = parseInt(currentpage/10)+1;
		} else if(currentpage%10 == 0) {
			startpage = currentpage/10;
		}
		startpage = startpage*10-9; //ex)11페이지로 가면 스타트페이지는 11페이지부터
		//페이지 버튼들에 순차적으로 번호 부여.
		var setpages = startpage;
		$(".page.num").each(function() {
			$(this).addClass(""+setpages).attr("value", setpages).text(setpages);
			setpages++;
		});
		//현재 페이지 점등
		if(currentpage=="") {
			$(".page.1").css("color", "red");
		} else {
			$(".page."+currentpage).css("color", "red");
		}
		if("${param.genre}" != ""){
			$("li > button").css("color", "black");
		}
		//검색결과 길이
		var paperlength = ${paperCount };
		var length = paperlength;
		//결과 있는 페이지까지만 enable
		$(".page.num").attr("disabled", true);
		var endpage = Math.ceil(length/12);
		for(var index=0;index<=endpage;index++) {
			$(".page."+index).attr("disabled", false);
		}
		//이전, 다음 페이지 버튼
		var firsto = $(".page.num").first().val();
		var lasto = $(".page.num").last().val();
		if(startpage == 1)
			$(".page.before").attr("disabled", true);
		else
			$(".page.before").attr("value", (firsto-10));
		
		if(endpage <= lasto)
			$(".page.after").attr("disabled", true);
		else
			$(".page.after").attr("value", parseInt(lasto)+1);
		$("button[value=all]").click(function(e) {
			e.preventDefault();
			$("form.search-form").submit();
		});
		//topbar
		$(".topbar h2").click(function() {
			location.href="/paper";
		});
		$(".topbar h2").append("::${param.keyword }");
		//책정보 보기
		$(".book .title, .book .cover").click(function() {
			var bookNum = $(this).parents(".search")[0].classList[1];
			location.href = "/book/bookdetail?booknumber="+bookNum;
		});
		//해당 기준으로 다시 검색
		$(".book .author, .book .publisher").click(function(e) {
			var type = e.target.className;
			var keywordo = e.target.innerHTML;
			location.href = "?type="+type+"&keyword="+keywordo;
		});
		//바로보기
		$(".btn-read").click(function() {
			var bookNum = $(this).parents(".search")[0].classList[1];
			location.href = "viewer?booknumber="+bookNum;
		});
		//바로구매
		$(".btn-purchase").click(function(e) {
			var bookNum = $(this).parents(".search")[0].classList[1];
			location.href = "purchase?booknumber="+bookNum;
		});
	});
</script>
</head>
<body>
  <header class="topbar">
    <nav>
      <div class="container">
        <a href="/"><i class="far fa-arrow-left"></i></a>
        <h2>도서 구매</h2>
      </div>
    </nav>
  </header>
<div class="main-container" >
	<!-- 검색바 -->
	<form class="search-form" action="/paper/search" method="GET" >
		<div class="search-bar" >
			<select class="type" name="type" >
				<option value="title" >제목</option>
				<option value="author" >저자</option>
				<option value="publisher" >출판사</option>
			</select>
			<input class="keyword" type="text" name="keyword" placeholder="검색어를 입력해주세요" autocomplete="off" spellcheck="false"/>
			<button class="btn-search fas fa-search" name="genre" value="0" ></button>
			<input type="hidden" name="page" value="1" />
		</div>
	</form>
	<%-- 빈 화면에 내보낼 것들 --%>
	<c:if test="${empty param.keyword }" >
		<div class="empty-spot" >
			<h3>호호아아!</h3>
		</div>
	</c:if>
	<!-- 검색 결과 요약 -->
	<%-- <c:forEach var="a" items="${counto }">
		<h3>장르 정보</h3>
		<h4>장르이름:${a.CATEGORY_NAME } 장르번호:${a.CAT_NUM } 갯수:${a.COUNT }</h4>
	</c:forEach> --%>
	<c:set var="allCount" value="0" />
	<c:forEach var="temp" items="${counto }" >
		<c:set var="allCount" value="${allCount+temp.COUNT }" />
	</c:forEach>
	<c:if test="${not empty param.keyword }" >
		<!-- 카테고리 선택 -->
		<form action="/paper/search" method="GET" >
			<div class="category-list" >
				<input class="type" type="hidden" name="type" />
				<input class="keyword" type="hidden" name="keyword" />
				<input type="hidden" name="page" value="1" />
				<button name="genre" value="0" class="btn-category selected">전체<span>${allCount }</span></button>
				<c:forEach var="genre" items="${counto }">
					<button name="genre" value="${genre.CAT_NUM }" class="btn-category selected">${genre.CATEGORY_NAME }<span>${genre.COUNT }</span></button>
				</c:forEach>
			</div>
		</form>
		<div class="search-summary" >
			<div>
				'<span class="skeyword" ><%=keyword %></span><span>'에 대한</span>
			</div>
			<span class="scount" >총<span class="result-count" >
						${paperCount}
			</span>개의 검색결과</span>
			<div class="layout" >
					<button class="btn-layout btn-list list fas fa-list"></button>
					<button class="btn-layout btn-grid fas grid fa-th-large"></button>
			</div>
		</div>
	</c:if>
	<%-- 검색결과 --%>
	<!-- paper -->
	<c:if test="${param.genre ne 'ebook' }" >
		<c:if test="${param.keyword ne null and param.keyword ne ''}" >
			<div class="search-list fadeInUp">
				<%-- 카테고리 벨트 --%>
				<div class="category-belt" >
					<span class="btn-cart-outer far fa-check-square" ><span class="btn-cart" >&nbsp;장바구니 추가</span></span>
				</div>
				<%-- 카테고리 벨트 끝 --%>
				<%-- 책리스트 --%>
				<c:choose>
					<c:when test="${paperCount eq 0 }" >
						<h3>결과가 없습니다.</h3>
					</c:when>
					<c:otherwise>
						<div class="search-result" >
							<c:forEach var="book" items="${paper }">
								<div class="search ${book.bookNum }" >
									<div class="book" >
										<!-- 책 커버 -->
										<img class="cover"  src="${book.bookThumbnail }"/>
										<!-- 책 정보 -->
										<div class="info" >
											<div class="title" >${book.bookTitle }</div>
											<div>
												<span class="author" >${book.bookWriter }</span>
												<span class="publisher" >${book.bookPublisher }</span>
											</div>
											<span class="price" >${book.bookPrice }원</span>
										</div>
									</div>
									<div class="interact" >
										<button class="btn-purchase" >구매</button>
										<input class="checkbox-cart btn-list-cart" type="checkbox" name="cart" value="${book.bookNum }" />
									</div>
								</div>
							</c:forEach>
						</div>
					</c:otherwise>
				</c:choose>
				<%-- 책리스트 끝 --%>
			</div>
		</c:if>
	</c:if>
	<%--검색결과 끝 --%>
	<%-- 페이징 --%>
	<div class="page" >
		<form action="/paper/search" method="GET">
			<input type="hidden" name="type" value="${param.type }" />
			<input type="hidden" name="keyword" value="${param.keyword }" />
			<input type="hidden" name="genre" value="${param.genre }" />
			<button class="btn page before" name="page" ><</button>
			<c:forEach var="i" begin="0" end="9" >
				<button class="btn page num" name="page" ></button>
			</c:forEach>
			<button class="btn page after" name="page" >></button>
		</form>
	</div>
</div>
	<%@ include file="template/footer.jsp" %>
</body>
</html>