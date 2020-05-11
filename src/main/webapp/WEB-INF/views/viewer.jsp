<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.0.js" integrity="sha256-r/AaFHrszJtwpe+tHyNi/XCfMxYpbsRg2Uqn0x3s2zc=" crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css?family=Nanum_Gothic|Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap" rel="stylesheet">
<script src="../resources/js/viewer.js" ></script>
<link rel="stylesheet" type="text/css" href="../resources/styles/reset.css" />
<link rel="stylesheet" type="text/css" href="../resources/styles/viewer.css" />
<title>Insert title here</title>
<script type="text/javascript" >
	$(document).ready(function() {
		var page = [];
		var index = [];
		var tempIndex = [];
		var current = 0;
		var temp;
		$(".page.left>div").append("${chapter.get(0).get(0)}");
		$(".page.right>div").append("${chapter.get(0).get(1)}");
		$(".left span").empty().append(current+1);
		$(".right span").empty().append(current+2);
		//List로 불러온 책내용을 javascript Array로 저장
		<c:forEach var="c" items="${chapter.get(0) }" varStatus="status">
			page.push("${c }");
			temp = "${c }";
			if(temp.indexOf("<h3>") >= 0) {
				index.push("${status.index + 1}");
			}
		</c:forEach>
		//List로 불러온 목차를 javascript Array로 저장
		<c:forEach var="i" items="${index }" >
			tempIndex.push("${i }");
		</c:forEach>
		var temp = null;
		//페이지 넘기기. 방향키
		$(document).on("keydown", function(e) {
			if(e.originalEvent.keyCode==37 || e.originalEvent.keyCode==38) {
				if(current > 0) {
					current -= 2;
					$(".page.left>div").empty().append(page[current]);
					$(".page.right>div").empty().append(page[(current+1)]);
				}
			} else if(e.originalEvent.keyCode==39 || e.originalEvent.keyCode==40) {
				current += 2;
				if(current > page.length) {
					current -= 2;
				} else {
					$(".page.left>div").empty().append(page[current]);
					$(".page.right>div").empty().append(page[(current+1)]);
				}
			}
			$(".left span").empty().append(current+1);
			$(".right span").empty().append(current+2);
		});
		
		$(document).on("mousewheel DOMMouseScroll", ".page", function(e) {
			if (e.originalEvent.wheelDelta == 120) {
				if(current > 0) {
					current -= 2;
					$(".page.left>div").empty().append(page[current]);
					$(".page.right>div").empty().append(page[(current+1)]);
				}
			} else if(e.originalEvent.wheelDelta == -120) {
				current += 2;
				if(current > page.length) {
					current -= 2;
				} else {
					$(".page.left>div").empty().append(page[current]);
					$(".page.right>div").empty().append(page[(current+1)]);
				}
			}
			$(".left span").empty().append(current+1);
			$(".right span").empty().append(current+2);
		});
		$(".jump").on("click", function(e) {
			var to = e.target.classList[1];
			if(to == "left") {
				if(current > 0) {
					current -= 2;
					$(".page.left>div").empty().append(page[current]);
					$(".page.right>div").empty().append(page[(current+1)]);
				}
			} else if(to == "right") {
				current += 2;
				if(current > page.length) {
					current -= 2;
				} else {
					$(".page.left>div").empty().append(page[current]);
					$(".page.right>div").empty().append(page[(current+1)]);
				}
			}
			$(".left span").empty().append(current+1);
			$(".right span").empty().append(current+2);
		});
		//목차
		for(var a in index) {
			var aa = parseInt(a)+1;
			$(".modal.index ul").append("<li value='"+index[a]+"'>"+tempIndex[a]+". ("+index[a]+"p)</li>");
		}
		$(".modal.index li").on("click", function(e) {
			var value = (e.target.value-1);
			current = value;
			if(value%2==1) {
				current--;
			}
			$(".page.left>div").empty().append(page[current]);
			$(".page.right>div").empty().append(page[(current+1)]);
			$(".left span").empty().append(current+1);
			$(".right span").empty().append(current+2);
		});
		//본문검색
		$(".btn-search").on("click", function() {
			$(".modal.search .search-result").empty();
			var counter = 0;
			var keyword = $(".keyword").val();
			var keywordLength = keyword.length;
			console.dir(keywordLength);
			if(keyword != "") {
				for(var index in page) {
					var asdasd = page[index].indexOf(keyword);
					while(asdasd >= 0) {
						console.dir("본문에 있음");
						var inpage = parseInt(index)+1;
						$(".modal.search .search-result").append("<li class='"+asdasd+" "+(asdasd+keywordLength)+"' value="+index+">"+keyword+","+inpage+"page</li>");
						asdasd = page[index].indexOf(keyword, (asdasd+1));
					}
				}
			}
		});
		//본문검색 후 해당 페이지로 이동
		$(document).on("click", ".modal.search li", function(e) {
			var value = (e.target.value);
			current = value;
			if(value%2==1) {
				current--;
			}
			$(".page.left>div").empty().append(page[current]);
			$(".page.right>div").empty().append(page[(current+1)]);
			$(".left span").empty().append(current+1);
			$(".right span").empty().append(current+2);
		})
		//책갈피
		$(document).on("click", ".bookmark-div .bookmar", function() {
			$.ajax({
				data : {
				}
			})
			.done(function(data) {
				
			})
			.fail(function(data) {
				
			})
		})
		//테스트
		$(".bookmark-div .bookmark").on("click", function() {
			console.dir("현재페이지:"+(current));
		});
	});
</script>
</head>
<body>
	<div class="header" >
		<div class="left-div" >
			<button class="far fa-chevron-left"></button>
		</div>
		<div class="mid-div" >
			<h3>${book.BOOK_TITLE }</h3>
		</div>
		<div class="right-div" >
			<button class="index btn-func far fa-list-ol">목차</button>
			<button class="search btn-func far fa-search">본문검색</button>
			<button class="setting btn-func fal fa-cog">설정</button>
			<%--<div class="toggle-div" >
				<input type="checkbox" id="flip-type" />
				<label for="flip-type" >
					<span class="toggle-switch fal fa-arrows-h" ></span>
				</label>
			</div>
			<div class="toggle-div" >
				<input type="checkbox" id="page-type" />
				<label for="page-type" >
					<span class="toggle-switch fas fa-book-open" ></span>
				</label>
			</div> --%>
			<button class="bookmark btn-func far fa-bookmark" >책갈피</button>
		</div>
	</div>
	<div class="content" >
		<div class="header-caller" ></div>
		<div class="jump left" ></div>
		<div class="jump right" ></div>
		<div class="page left" >
			<div class="inner">
			</div>
			<span></span>
		</div>
		<hr />
		<div class="page right" >
			<div class="inner">
			</div>
			<span></span>
		</div>
		<div class="modal index" >
			<div class="modal-content" >
				<h1>목차</h1>
				<ul>
				</ul>
				<button class="btn-modal-close" >닫기</button>
			</div>
			<div class="modal-layer" ></div>
		</div>
		<div class="modal search" >
			<div class="modal-content" >
				<h1>본문검색</h1>
				<input class="keyword" type="text" /><button class="btn-search">검색</button>
				<ul class="search-result" ></ul>
				<button class="btn-modal-close" >닫기</button>
			</div>
			<div class="modal-layer" ></div>
		</div>
		<div class="modal setting" >
			<div class="modal-content" >
				<h1>설정</h1>
				<div class="setting-background" >
					<button class="page-color white"></button>
					<button class="page-color green"></button>
					<button class="page-color gray"></button>
					<button class="page-color black"></button>
				</div>
				글꼴
				<select>
					<option>휴먼굴림체</option>
					<option>나눔고딕</option>
				</select>
				글자 크기
				<div class="setting-fontsize" >
					<input type="radio" id="font-large" name="fontsize" ><label for="font-large" >크게</label>
					<input type="radio" id="font-normal" name="fontsize" ><label for="font-normal" >보통</label>
				</div>
				줄 간격
				<input type="range" />
				<button class="btn-modal-close" >닫기</button>
			</div>
			<div class="modal-layer" ></div>
		</div>
		<div class="modal bookmark" >
			<div class="modal-content" >
				<h1>책갈피</h1>
				<button class="btn-modal-close" >닫기</button>
			</div>
			<div class="modal-layer" ></div>
		</div>
	</div>
	<div class="bookmark-div" >
		<button class="bookmark far fa-bookmark" ></button>
	</div>
	<div class="bookmark-alarm" >
		<span>북마크 추가됨</span>
	</div>
</body>
</html>