<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">    
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.5, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>${book.bookTitle }</title>
 <!-- Google Fonts -->
<link
href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Nanum+Gothic|Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap"
rel="stylesheet" />
<!-- Fontawesome API-->
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
font-family: '맑은 고딕', sans-serif;
font-family: 'Noto Sans KR', sans-serif;
font-family: 'Black Han Sans', sans-serif;
font-family: 'Nanum Gothic', sans-serif;
-->
<!-- css reset -->
<link rel="stylesheet" href="../../resources/styles/reset.css" />
<!-- individual page stylesheet -->
<link rel="stylesheet" href="../../resources/styles/viewer2.css" />
<!-- <link rel="stylesheet" href="../../resources/styles/common.css" /> -->
<!-- jQuery CDN -->
<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
<!-- slidify sliders and fadeInUp reveal -->
<!-- <script src="../../resources/js/common.js"></script> -->
<!-- <script src="../../resources/js/viewer2.js"></script> -->
<script type="text/javascript" >
	<%-- 로그인 검증 --%> 
	<%-- var memberEmail = "${ryanMember.memberEmail }";
	function chkEmail() {
		if(memberEmail == null || memberEmail == "") {
			alert("로그인이 필요합니다.");
			location.href = "/member/signin";
		}
	};
	chkEmail(); --%>
	$(document).ready(function() {
		var width = window.innerWidth, height = window.innerHeight;
		//console.dir(width+","+height);
		var jumpLeft = width / 8;
		var jumpRight = width- (width/8);
		$("div.main-container").css("width", width).css("height", height);
		$("div.page").css("width", width/2).css("height", height);
		$("div.result").css("height", (height - 100));
		//기본 line-height: 3.0
		var lineHeight = width/768;
		//기본 font-size: 1.35em;
		var fontSize = width/88.88888;
		//기본 padding: 70px 110px;
		var paddingV = width/27.42857;
		var paddingH = width/17.45454; 
		//console.dir(fontSize);
		$("div.page").css("font-size", fontSize).css("line-height", lineHeight);
		//내 화면 크기는 1920,969
	 	//화면 사이즈가 변할때마다 main-container의 크기 변환
		$(window).resize(function() {
			width = window.innerWidth;
			height = window.innerHeight;
			//console.dir(width/640+"//"+width/1422.22222);
			fontSize = width/88.88888;
			lineHeight = width/768;
			paddingV = width/27.42857;
			paddingH = width/17.45454; 
			$("div.page").css("font-size", fontSize).css("line-height", lineHeight);
			$("div.page").css("padding", paddingV+"px "+paddingH+"px");
			//console.dir(width*lineHeight+","+width*fontSize);
			jumpLeft = width / 8;
			jumpRight = width - (width/8);
			$("div.main-container").css("width", width).css("height", height);
			$("div.page").css("width", width/2).css("height", height);
			$("div.result").css("height", (height - 100));
		});
	 	//책 데이터 파싱
		var pages = [];
	 	var index = [];
	 	var bookmarks = [];
	 	var indexMap = new Map();
	 	var temp = 0; //목차 할당 용도.
		//List로 불러온 목차를 javascript Array로 저장
		<c:forEach var="i" items="${index }" >
			index.push("${i }");
		</c:forEach>
		//페이지 나누는 동시에 목차 할당
		var indexFinder = -1; //페이지마다 목차 이름을 Map으로 할당. 검색결과 위해
		<c:forEach var="c" items="${chapter.get(0) }" varStatus="status">
			pages.push("${c }");
			if("${c }".indexOf("<h3>") >= 0) {
				$(".modal.index").append("<button class='btn goindex ${status.index}' >"+(temp+1)+"."+ index[temp]+"</button>");
				temp++;
				indexFinder++;
			}
			indexMap.set("${status.index }", index[indexFinder]);
		</c:forEach>
		//북마크 불러옴
		$("div.modal.bookmarks > div.result").empty();
		<c:forEach var="bm" items="${bookmark }" >
			bookmarks.push("${bm.pageNum }");
			$("div.modal.bookmarks > div.result").append(
					"<button class='btn goindex ${bm.pageNum }' >${bm.pageNum + 1 }페이지</button>");
		</c:forEach>
		//페이지 new
		//로드시 첫 두 페이지 초기화
		var startPage = 0; <%--나중에는 ${마지막읽던곳 }으로--%>
		var currentPage = startPage;
		//console.dir("currentPage는"+currentPage+"로 세팅됐습니다.")
		var prevPage = (currentPage-2), nextPage = (currentPage+2);
		//console.dir("prevPage는"+prevPage+",nextPage는"+nextPage+"로 세팅됐습니다.")
		jumpTo(startPage);
		/* $(".page").each(function() {
			$(this).empty().append(pages[startPage]);
			$(this).attr("value", startPage);
			startPage++;
		}); */
		startPage = 0; <%--나중에는 ${마지막읽던곳 }으로--%>
		//$(".page.left").empty().append(pages[startPage]);
		//$(".page.right").empty().append(pages[(startPage+1)]);
		function jumpTo(e) { //페이지 이동 함수 e = 페이지번호. 두 페이지용
			currentPage = e;
			if(currentPage == -2)
				currentPage = 0;
			console.dir("currentPage:"+currentPage);
			console.dir("pagelength:"+pages.length);
			if( (e>=0) && (e<=pages.length) ) {
				if(e%2 == 1 && (e-1>=0)) {
					console.dir("index가 짝수입니다! -1 합니다.")
					currentPage--;
					e--;
				}
				$(".page").each(function() {
					$(this).empty().append(pages[e]);
					$(this).attr("value", e);
					e++;
				});
				var tempCurrent = currentPage;
				//console.clear();
				$(".btn.bookmark").each(function() {
					//console.dir("#"+tempCurrent+"번째 북마크버튼 체크!")
					<%-- 색칠된 북마크 fas fa-bookmark --%>
					<%-- 안된거 fal fa-bookmark --%>
					$(this).removeClass("fas added").addClass("fal");
					for(var a in bookmarks) {
						//console.dir(tempCurrent+"북마크 버튼과"+bookmarks[a]+" 비교함");
						if(tempCurrent == bookmarks[a]) {
							//console.dir("리스트 안에 북마크 있음!");
							//console.dir($(this));
							$(this).addClass("fas added").removeClass("fal");
						} 
					}
					$(this).attr("value", tempCurrent);
					tempCurrent++;
				});
				var tempCurrent2 = parseInt(currentPage);
				$(".pageNum").each(function() {
					$(this).empty().append(tempCurrent2+1);
					tempCurrent2++;
				});
				
				prevPage = (currentPage-2);
				nextPage = (currentPage+2);
			}
			if(currentPage == 0)
				prevPage = 0;
			console.dir("prevPage:"+prevPage+",nextPage:"+nextPage);
		}
		
		
		function jumpToSingle(e) { //페이지 이동 함수 e = 페이지번호. 단일 페이지용
			currentPage = e;
			//console.dir("currentPage:"+currentPage);
			if( (e>=0) && (e<pages.length) ) {
				$(".page").each(function() {
					$(this).empty().append(pages[e]);
					$(this).attr("value", e);
					e++;
				});
				var tempCurrent = currentPage;
				$(".btn.bookmark").each(function() {
					$(this).attr("value", tempCurrent);
					tempCurrent++;
				});
				var tempCurrent2 = parseInt(currentPage);
				$(".pageNum").each(function() {
					$(this).empty().append(tempCurrent2+1);
					tempCurrent2++;
				});
				
				prevPage = (currentPage-1);
				nextPage = (currentPage+1);
			}
			if(currentPage == 0)
				prevPage = 0;
		}
		$(".modal.index .btn.goindex").click(function(e) { //목차로 이동
			var goTo = parseInt(e.target.classList[2]);
			jumpTo(goTo);
		});
		function keyJump(e) { //키입력
			var keyCode = e.keyCode;
			//console.dir(keyCode);
			// 107 Num Key  +
		    // 109 Num Key  -
		    // 173 Min Key  hyphen/underscor Hey
		    // 61 Plus key  +/= key
		    // 37 left
		    // 38 up
		    // 39 right
		    // 40 down
			if (e.ctrlKey==true&&(e.which == '61' || e.which == '107' || e.which == '173' || e.which == '109'  || e.which == '187'  || e.which == '189' )) {
				e.preventDefault(); //브라우저 줌인 줌아웃 불가
			} else if(keyCode == 39 || keyCode == 40) { //다음
				e.preventDefault();
				jumpTo(nextPage);
			} else if(keyCode == 37 || keyCode == 38) { //이전
				e.preventDefault();
				jumpTo(prevPage);
			} else if(keyCode == 27) { //esc
				e.preventDefault();
			}
		}
		document.addEventListener("keydown", keyJump, {passive:false});
		function scrollJump(e) { //스크롤
			$(".btn.bookmark").css("display", "none");
			$(".result").unbind();
			//console.dir(e.path[0].classList[0]);
			var d = e.wheelDelta;
			var currentOn = e.path[0].classList[0];
			if(currentOn == "page") {
				e.preventDefault();
				if(d < 0) { //다음
					jumpTo(nextPage);
				}
				else if(d > 0) { //이전
					jumpTo(prevPage);
				}
			}
		}
		document.addEventListener("wheel", scrollJump, {passive:false});
		//var a = document.querySelectorAll(".page");
		//a.forEach.call(a ,function(a){ a.addEventListener("wheel", keyJump, {passive:false} ); });
		
		//마우스 이벤트
		var mouseX, mouseY, mousedX, mousedY;
		//var docWidth = window.innerWidth, docHeight = window.innerHeight;
		//var jumpLeft = docWidth / 8;
		//var jumpRight = docWidth - (docWidth/8);
		$(".page").on("mousedown", function(e) {
			mouseX = e.pageX;
			mouseY = e.pageY;
		});
		$(".page").on("mouseup", function(e) {
			mousedX = e.pageX;
			mousedY = e.pageY;
			if(mouseX == mousedX && mouseY == mousedY) { //시작,끝 위치 같을떄
				if(mouseX < jumpLeft) { //페이지 넘기기 부분 클릭. 왼쪽. 이전페이지
					//console.dir("페이지를 넘기려고 하시는군요")
					jumpTo(prevPage);
				} else if(mouseX > jumpRight) { //페이지 넘기기 부분 클릭. 오른쪽. 다음페이지
					//console.dir("페이지를 넘기려고 하시는군요")
					jumpTo(nextPage);
				} else { //페이지 넘기기 부분 클릭 X
					if($(".modal-container").hasClass("modal-pop")) { //옵션창이 떠있을떄
						$(".modal-container").removeClass("modal-pop");
					} else {
						$(".header-container").toggleClass("header-pop");
					}
				}
			} else { //시작, 끝 위치 다를때
				//console.dir("드래그 감지");
			}
		});
		
		//본문검색
		var keyword;
		$(".modal.search input.keyword").on("keydown", function(e) {
			//console.dir(e.keyCode);
			if(e.keyCode == 13) {
				$(".modal.search div.result").empty();
				var counter = 0;
				keyword = $(".modal.search input.keyword").val().toLowerCase();
				var keywordo = ""; //검색 결과에 노출될 검색어
				var keywordLength = keyword.length;
				if(keyword != "") {
					for(var index in pages) {
						var contento = pages[index].toLowerCase(); //검색중인 페이지의 내용
						//var contentForLighting = contento.replace("<h3>", "").replace("</h3>", "");
						var finder = contento.indexOf(keyword);
						//var finderForLighting = contentForLighting.indexOf(keyword);
						keywordo = pages[index].substring(finder, (finder+keywordLength));
						while(finder >= 0) {
							//console.dir(index+"번째 index(페이지),"+finder+"번째 글자에서 키워드를 발견!");
							//console.dir("finderForLighting:"+finderForLighting);
							//112자 출력할 예정
							var contentPrev = "";//pages[index].substring(0, finder);
							var contentNext = "";//pages[index].substring((finder+keywordLength), pages[index].length);
							if(finder < 32) {
								contentPrev = pages[index].substring(0, finder);
							} else {
								contentPrev = pages[index].substring((finder-32), finder);
							}
							if(finder + 32 > 600) {
								contentNext = pages[index].substring((finder+keywordLength), pages[index].length);
							} else {
								contentNext = pages[index].substring((finder+keywordLength), (finder+32));
							}
							contentPrev = contentPrev.replace("<h3>", "").replace("</h3>","");
							contentNext = contentNext.replace("<h3>", "").replace("</h3>","");
							/////////////////////////////////////////
							var inPage = parseInt(index) + 1;
							$(".modal.search div.result").append("<div class='goindex "+index+"'>"
									+"<div class='title' >"
									+"<span class='chapter' >"+indexMap.get(index+"")+"</span>"
									+"<span class='index'>"+inPage+"페이지</span>"
									+"</div>"
									+"<div class='content' >"
									+contentPrev
									+"<span class='result-keyword' >"+keywordo+"</span>"
									+contentNext
									//+"최동열 : 난 오랫동안 자네를 지켜봐온 사람일세, 자네는 자네답게 살았어,"
									//+"조선의 주먹 황제답게 말이야... 늘 야인이었지만, 용감하고 멋있게 살았어."
									//+"얘기야... 뭐랄까... 야인시대 라고나 할까...?"
									+"</div>"
									+"</div>");
							finder = contento.indexOf(keyword, (finder+1));
							//finderForLighting = contentForLighting.indexOf(keyword, (finderForLighting+1));
						}
					}
				}
			}
		});
		//검색결과로 이동
		$(document).on("click", "div.goindex", function(e) {
			var goTo = parseInt($(this).parents("div.goindex").prevObject[0].classList[1]);
			jumpTo(goTo);
			//console.dir(goTo);
			//console.dir($("div.page[value="+goTo+"]").text().toLowerCase());
		});
		//책갈피
		$(document).on("mouseover", "div.page", function(e) {
			var side = e.target.classList[1];
			var pageNum = $(this).attr("value");
			//console.dir(pageNum);
			if(pageNum >= 0 && pageNum < pages.length){
				if(side == "left") {
					$(".btn.bookmark").css("display", "none");
					$(".btn.bookmark."+side).css("display", "inline");
				} else if(side == "right") {
					$(".btn.bookmark").css("display", "none");
					$(".btn.bookmark."+side).css("display", "inline");
				}
			}
		});
		var memberEmail = "abc1234@naver.com";
		$(document).on("click", ".btn.bookmark.fal", function(e) {
			var thisPage = e.target.value;
			<%-- 색칠된 북마크 fas fa-bookmark --%>
			<%-- 안된거 fal fa-bookmark --%>
			$(this).addClass("fas added").removeClass("fal");
			console.dir("북마크 추가!");
			$.ajax ({
				url : "/addBookmark",
				data : {
					"bookNum" : ${book.bookNum},
					"pageNum" : thisPage,
					"memberEmail" : memberEmail
				}
			})
			.done(function(data) {
				//console.dir("북마크 추가 성공")
				console.dir(data);
				//북마크 다시 불러옴
				bookmarks = [];
				$("div.modal.bookmarks > div.result").empty();
				for(var a in data) {
					bookmarks.push(data[a].pageNum);
					$("div.modal.bookmarks > div.result").append(
							"<button class='btn goindex "+parseInt(data[a].pageNum)+"' >"+(parseInt(data[a].pageNum)+1)+"페이지</button>");
				}
				/*<c:forEach var="bm" items="${bookmark }" >
					bookmarks.push("${bm.pageNum }");
				</c:forEach> */
				
			})
			.fail(function(data) {
				//console.dir("북마크 추가 실패")
			});
		});
		<%-- 색칠된 북마크 fas fa-bookmark --%>
		<%-- 안된거 fal fa-bookmark --%>
		$(document).on("click", ".btn.bookmark.fas", function(e) {
			var thisPage = e.target.value;
			<%-- 색칠된 북마크 fas fa-bookmark --%>
			<%-- 안된거 fal fa-bookmark --%>
			$(this).removeClass("fas added").addClass("fal");
			console.dir("북마크 추가!");
			$.ajax ({
				url : "/addBookmark",
				data : {
					"bookNum" : ${book.bookNum},
					"pageNum" : thisPage,
					"memberEmail" : memberEmail
				}
			})
			.done(function(data) {
				bookmarks = [];
				$("div.modal.bookmarks > div.result").empty();
				for(var a in data) {
					bookmarks.push(data[a].pageNum);
					$("div.modal.bookmarks > div.result").append(
							"<button class='btn goindex "+parseInt(data[a].pageNum)+"' >"+(parseInt(data[a].pageNum)+1)+"페이지</button>");
				}
			})
			.fail(function(data) {
				//console.dir("북마크 추가 실패")
			});
		});
		//책갈피로 이동
		$(document).on("click", ".modal.bookmarks .btn.goindex", function(e) {
			var goTo = parseInt(e.target.classList[2]);
			console.dir(goTo);
			jumpTo(goTo);
		});
	});
</script>
<body>
	<%-- 상단바 나오게 함 --%>
	<script type="text/javascript" >
		$(document).ready(function() {
			var headerTimerId;
			var modalTimerId;
			$(".header-caller").on("mouseover", function() {
				$(".header-container").addClass("header-pop");
			});
			
			$(".header-container").on("mouseout", function() {
				headerTimerId = setTimeout(()=>$(".header-container").removeClass("header-pop"), 1000);
			});
			
			$(".header-container").on("mouseover", function() {
				clearTimeout(headerTimerId);
			});
			//모달
			$(".modal-container").on("mouseover", function() {
				clearTimeout(headerTimerId);
			});
			$(".modal-caller").on("mouseover", function() {
				$(".modal-container").addClass("modal-pop");
			});
		});
	</script>
	<div class="header-caller"></div>
	<div class="modal-caller"></div>
	<%-- 상단바 --%>
	<div class="header-container" >
		<div class="header" >
			<button class="btn tomain far fa-arrow-left" ></button>
			<span class="title">${book.bookTitle }</span>
			<script type="text/javascript" >
				$(document).ready(function() {
					$(".configuration > .btn").on("click", function(e) {
						var modalName = e.target.classList[1];
						//console.dir(modalName);
						$(".modal").css("display", "none");
						$(".modal."+modalName).css("display", "flex");
						$(".modal-container").addClass("modal-pop");
					});
				});
			</script>
			<div class="configuration" >
				<button class="btn index fal fa-list"> 목차</button>
				<button class="btn search fal fa-search"> 본문검색</button>
				<button class="btn note fal fa-sticky-note"> 독서노트</button>
				<button class="btn setting fal fa-sliders-h"> 보기설정</button>
				<button class="btn bookmarks fal fa-bookmark"> 책갈피</button>
			</div>
		</div>
	</div> <%-- header-container 끝 --%>
	<div class="main-container" >
		<%-- 책 내용 보여줌 --%>
		<div class="page left" >
		</div>
		<div class="page right" >
		</div>
		<div class="pageNum left" ></div>
		<div class="pageNum right" ></div>
	</div> <%-- main-container 끝 --%>
	<script type="text/javascript">
		$(document).ready(function() {
			$(".btn.bookmark").on("click", function() {
				//console.dir("북마크 추가");
			});
		});
	</script>
	<div class="bookmark-container left" >
		<%-- 북마크 추가 버튼 --%>
		<button class="btn bookmark left fal fa-bookmark"></button>
		<%-- 색칠된 북마크 fas fa-bookmark --%>
		<%-- 안된거 fal fa-bookmark --%>
	</div>
	<div class="bookmark-container right" >
		<%-- 북마크 추가 버튼 --%>
		<button class="btn bookmark right fal fa-bookmark"></button>
		<%-- 색칠된 북마크 fas fa-bookmark --%>
		<%-- 안된거 fal fa-bookmark --%>
	</div> <%-- bookmark-container 끝 --%>
	<div class="modal-container" >
		<div class="modal index" >
			<span class="title">목차</span>
			<div class="book" >
				<!-- <img src="http://placehold.it/120X140" /> -->
				<img src="${book.bookThumbnail }" />
				<span class="title" >${book.bookTitle }</span>
				<span class="author" >${book.bookWriter }</span>
			</div>
			<%-- <button class="btn goindex ${페이지번호 }" >${인덱스 } ${목차 이름 }</button> 형식으로 나옴 --%>
		</div>
		<div class="modal search" >
			<span class="title">본문검색</span>
			<input class="keyword" type="text" placeholder="단어.." />
			<div class="result" >
			</div>
		</div>
		<div class="modal note" >
			<span class="title">독서노트
			</span>
		</div>
		<div class="modal setting" >
			<span class="title">보기설정</span>
			<span class="title sub" >페이지 색상</span>
			<script type="text/javascript">
				document.addEventListener("DOMContentLoaded", function() {
					$(".btn.color").on("click", function(e) {
						var color = e.target.classList[2];
						if(color == "black") {
							//console.dir("black!!");
							$("div.page.left").css("box-shadow", "3px 0 15px -3px rgba(255, 255, 255, 0.5)");
							$("div.page.right").css("box-shadow", "-3px 0 15px -3px rgba(255, 255, 255, 0.5)");
						} else {
							$("div.page.left").css("box-shadow", "3px 0 15px -3px rgba(0, 0, 0, 0.5)");
							$("div.page.right").css("box-shadow", "-3px 0 15px -3px rgba(0, 0, 0, 0.5)");
						}
						var background = $(".btn.color."+color).css("background-color");
						var fontColor = $(".btn.color."+color).css("color");
						//console.dir(fontColor);
						$(".main-container").css("background", background);
						$(".page").css("color", fontColor);
					});
				});
			</script>
			<div class="page-color" >
				<button class="btn color white" >흰</button>
				<button class="btn color black" >검</button>
				<button class="btn color green" >초</button>
				<button class="btn color gray" >회</button>
			</div>
		</div>
		<div class="modal bookmarks" >
			<span class="title">책갈피</span>
			<div class="result" >
				<!-- <button class="btn goindex 1" >1. 중요부분 3p</button>
				<button class="btn goindex 2" >2. 다시 봐야할 부분 28p</button>
				<button class="btn goindex 3" >3. 이해안됨 55p</button>
				<button class="btn goindex 4" >4. 시험에 나오는 부분 150p</button>
				<button class="btn goindex 5" >5. 시험범위 끝 250p</button>
				<button class="btn goindex 6" >6. 책갈피1 252p</button>
				<button class="btn goindex 7" >7. 책갈피2 255p</button> -->
			</div>
		</div>
	</div> <%-- modal-container 끝 --%>
</body>
</html>