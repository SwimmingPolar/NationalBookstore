<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=0.5" charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.0.js" integrity="sha256-r/AaFHrszJtwpe+tHyNi/XCfMxYpbsRg2Uqn0x3s2zc=" crossorigin="anonymous"></script>
<script src="resources/script/common.js" ></script>
<script src="resources/script/booklist.js" ></script>
<script type="text/javascript">
	$(document).ready(function() {
		var currentpage = "${param.page }";
		if(currentpage=="")
			currentpage = 1;
		var startpage = 0;
		//페이징 이전, 다음버튼
		if(currentpage%10 != 0) {
			startpage = parseInt(currentpage/10)+1;
		} else if(currentpage%10 == 0) {
			startpage = currentpage/10;
		}
		startpage = startpage*10-9;
		console.dir("startpage:"+startpage);
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
		//전체 점등 or not
		if(("${param.genre }" == "") && ("${param.sub_genre }" == "")) {
			$("li > button[name='genre'][value=0]").css("color", "var(--main-color)");
		}
		//선택된 장르 점등
		$("li > button[name='genre'][value='${param.genre}']").css("color", "var(--main-color)");
		$("li > button[name='sub_genre'][value='${param.sub_genre}']").css("color", "var(--main-color)");
		//결과 있는 페이지까지만 enable
		$(".page.num").attr("disabled", true);
		var resultlength = "${length }";
		//var endpage = parseInt(resultlength/3)+1;
		var endpage = Math.ceil(resultlength/12);
		console.dir("endpage:"+endpage);
		for(var index=0;index<=endpage;index++) {
			$(".page."+index).attr("disabled", false);
		}
		//이전, 다음 페이지 버튼
		var firsto = $(".page.num").first().val();
		var lasto = $(".page.num").last().val();
		console.dir("lasto:"+lasto);
		if(startpage == 1)
			$(".page.before").attr("disabled", true);
		else
			$(".page.before").attr("value", (firsto-10));
		
		if(endpage <= lasto)
			$(".page.after").attr("disabled", true);
		else
			$(".page.after").attr("value", parseInt(lasto)+1);
		//sort
		if("${param.sort}" != "")
			$(".btn.sort.${param.sort }").css("color", "var(--main-color)");
		else
			$(".btn.sort.title").css("color", "var(--main-color)");
		//상세 페이지로 이동
		$(document).on("click", ".book > .cover, .book > .title", function(e) {
			console.dir(e.target);
		})
	});
</script>
<link rel="stylesheet" type="text/css" href="../../resources/styles/reset.css" />
<link rel="stylesheet" type="text/css" href="../../resources/styles/booklist.css" />
<title>Insert title here</title>
</head>
<body>
	<div class="header" >
		<div class="title" >
			<h3><a href="booklist">전체 책</a></h3>
			<a href="/" ><button class="btn history" ><</button></a>
		</div>
	</div>
    <div class="sort" >
    	<form action="booklist" method="GET" >
		   	<span>정렬 방식 : </span>
		   	<button name="sort" value="title" class="btn sort title" >제목</button> |
		   	<button name="sort" value="author" class="btn sort author" >저자</button> |
		   	<button name="sort" value="publisher" class="btn sort publisher" >출판사</button>
		   	<input type="hidden" name="genre" value="${param.genre }" />
			<input type="hidden" name="sub_genre" value="${param.sub_genre }" />
	   	</form>
    </div>
	<div class="nav" >
		<form action="booklist" method="get">
			<input type="hidden" name="sort" value="${param.sort }" />
			<span>장르</span>
			<ul class="genre">
				<li ><button name="genre" value="0" >전체</button></li>
				<li><button name="genre" value="2" >소설 ></button>
					<ul>
						<li><button name="sub_genre" value="1" >판타지</button>
						<li><button name="sub_genre" value="2" >한국소설</button>
						<li><button name="sub_genre" value="3" >영미소설</button>
					</ul>
				</li>
				<li><button name="genre" value="3" >시/에세이</button></li>
				<li><button name="genre" value="4" >인문 ></button>
					<ul>
						<li><button name="sub_genre" value="4" >기호학/언어학</button></li>
						<li><button name="sub_genre" value="5" >심리</button></li>
					</ul>
				</li>
				<li><button name="genre" value="5" >역사</button></li>
				<li><button name="genre" value="6" >예술</button></li>
				<li><button name="genre" value="7" >종교</button></li>
				<li><button name="genre" value="8" >사회</button></li>
				<li><button name="genre" value="9" >과학</button></li>
				<li><button name="genre" value="10" >경제/경영</button></li>
				<li><button name="genre" value="11" >자기계발</button></li>
			</ul>
		</form>
	</div>
	<div class="container" >
		<div class="content">
			<div class="books" >
				<c:choose>
					<c:when test="${empty result }" >
						<h3>결과가 없습니다.</h3>
					</c:when>
					<c:otherwise>
						<form action="book/bookdetail" method="GET" >
							<c:forEach var="book" items="${result }" >
								<div class="book" >
									<div class="cover" style="background: url('${book.bookThumbnail }') no-repeat; background-size: 100%" >
										<button name="booknumber" value="${book.bookNum }" class="btn detail">보기</button>
									</div>
									<div class="title" >
										<button name="booknumber" value="${book.bookNum }" title="${book.bookTitle }">${book.bookTitle }</button>
									</div>
								</div>
							</c:forEach>
						</form>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="page" >
			<form action="booklist" method="GET">
				<input type="hidden" name="genre" value="${param.genre }" />
				<input type="hidden" name="sub_genre" value="${param.sub_genre }" />
				<input type="hidden" name="sort" value="${param.sort }" />
				<button class="btn page before" name="page" ><</button>
				<c:forEach var="i" begin="0" end="9" >
					<button class="btn page num" name="page" ></button>
				</c:forEach>
				<button class="btn page after" name="page" >></button>
			</form>
		</div>
	</div>
</body>
</html>