<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>베스트셀러</title>
<!-- Google Fonts -->
<link
href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Nanum+Gothic|Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap"
rel="stylesheet" />
<!-- Fontawesome API-->
<script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
<!-- css reset -->
<link rel="stylesheet" href="../../resources/styles/reset.css" />
<!-- individual page stylesheet -->
<link rel="stylesheet" href="../../resources/styles/best.css" />
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
                <a href="/"><i class="far fa-arrow-left"></i></a>
                <h2>베스트셀러</h2>
            </div>
        </nav>
    </header>
    <%-- 내용 --%>
    <div class="main-container" >
    	<div class="select-container" >
    		<script type="text/javascript" >
	    		$(document).ready(function() {
	    			$(".time-container > .btn, .genre-container > .btn").click(function(e) {
	    				$(this).siblings().removeClass("selected");
	    				$(this).addClass("selected");
	    				var time = $(".time-container .selected").text();
	    				var genre = $(".genre-container .selected").text();
	    				console.dir(time+";"+genre);
	    				$.ajax({
	    					url : "/best",
	    					data : {
	    						"time" : time
	    						//,"genre" : genre
	    					},
	    					method : "GET"
	    				})
	    				.done(function(e) {
	    					var tag = "<c:forEach var='book' items='${result }' >"
				    			   		+"<div class='book ${book.bookNum }' >"
				    			   		+"<img src='${book.bookThumbnail }' />"
				    			   		+"<div class='info' >"
				    			   		+"<div class='title' title='${book.bookTitle }'>${book.bookTitle }</div>"
				    			   		+"<div class='author' >${book.bookWriter }</div>"
				    			   		+"</div>"
				    			   		+"</div>"
				    			   		+"</c:forEach>"
	   						console.dir("통신 성공");
	    					$("div.book-list").empty().append(tag);
	    				})
	    				.fail(function(e) {
	    					console.dir("통신 실패");
	    				});
	    			});
	    		});
	    	</script>
	    	<div class="time-container" >
	    		<button class="btn selected" ><span class="far fa-check"></span>일간</button>
	    		<button class="btn" ><span class="far fa-check"></span>주간</button>
	    		<button class="btn" ><span class="far fa-check"></span>월간</button>
	    		<button class="btn" ><span class="far fa-check"></span>연간</button>
	    	</div>
	    	<div class="genre-container" >
	    		<button class="btn selected" >전체</button>
	    		<button class="btn" >소설</button>
	    		<button class="btn" >시/에세이</button>
	    		<button class="btn" >인문</button>
	    		<button class="btn" >역사</button>
	    		<button class="btn" >예술</button>
	    		<button class="btn" >종교</button>
	    		<button class="btn" >사회</button>
	    		<button class="btn" >과학</button>
	    		<button class="btn" >경제/경영</button>
	    		<button class="btn" >자기계발</button>
	   		</div>
	   		<script type="text/javascript" >
	   			$(document).ready(function() {
	   				$(".btn.expand").on("click", function() {
	   					$(this).toggleClass("fa-chevron-up").toggleClass("fa-chevron-down");
	   					$("div.genre-container").toggleClass("expand");
	   				})
	   			});
	   		</script>
	   		<button class="btn expand far fa-chevron-down"></button>
	   		<!-- <button class="btn aa shrink far fa-chevron-up"></button> -->
    	</div>
    	<script type="text/javascript" >
    		$(document).ready(function() {
    			$(".book").on("click", function(e) {
    				var bookNum = $(this).parents("book").prevObject[0].classList[1];
    				location.href="/book/bookdetail?booknumber="+bookNum;
    			});
    		});
    	</script>
    	<div class="book-container book-list1 fadeInUp" >
		   	<c:forEach var="book" items="${result }" varStatus="status">
		   		<div class="book ${book.bookNum }" >
		   			<img src="${book.bookThumbnail }" />
		   			<div class="info" >
		   				<div>${status.index + 1}</div>
		   				<div class="title" title="${book.bookTitle }">${book.bookTitle }</div>
		   				<div class="author" >${book.bookWriter }</div>
		   			</div>
		   		</div>
		   	</c:forEach>
    	</div>
    	<%-- <div class="book-container book-list fadeInUp" >
		   	<c:forEach var="book" items="${result }" >
		   		<div class="book ${book.bookNum }" >
		   			<img src="${book.bookThumbnail }" />
		   			<div class="info" >
		   				<div class="title" title="${book.bookTitle }">${book.bookTitle }</div>
		   				<div class="author" >${book.bookWriter }</div>
		   			</div>
		   		</div>
		   	</c:forEach>
    	</div> --%>
    </div>
    <%-- 내용 끝 --%>
	<%@ include file="template/footer.jsp" %>
</body>
</html>