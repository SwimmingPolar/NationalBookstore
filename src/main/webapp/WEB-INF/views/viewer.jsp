<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.0.js" integrity="sha256-r/AaFHrszJtwpe+tHyNi/XCfMxYpbsRg2Uqn0x3s2zc=" crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap" rel="stylesheet">
<script src="viewer.js" ></script>
<link rel="stylesheet" type="text/css" href="reset.css" />
<link rel="stylesheet" type="text/css" href="viewer.css" />
<title>Insert title here</title>
</head>
<body>
	<div class="header" >
		<div class="left-div" >
			<button class="far fa-chevron-left"></button>
		</div>
		<div class="mid-div" >
			<h3>책 제목</h3>
		</div>
		<div class="right-div" >
			<button class="index btn-func far fa-list-ol">목차</button>
			<button class="search btn-func far fa-search">본문검색</button>
			<button class="setting btn-func fal fa-cog">설정</button>
			<div class="toggle-div" >
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
			</div>
			<button class="bookmark btn-func far fa-bookmark" >책갈피</button>
		</div>
	</div>
	<div class="content" >
		<div class="header-caller" ></div>
		<div class="page left" >
			<h1>왼쪽 페이지</h1>
			<c:forEach begin="0" end="35" >
				<span>동해물과 백두산이 마르고 닳도록</span><br />
			</c:forEach>
			<h3>챕터</h3>
		</div>
		<hr />
		<div class="page right" >
			<h1>오른쪽 페이지</h1>
			<c:forEach begin="0" end="35" >
				<span>하느님이 보우하사 우리나라 만세</span><br />
			</c:forEach>
			<h3>페이지</h3>
		</div>
		<div class="modal index" >
			<div class="modal-content" >
				<h1>목차입니다.</h1>
				<button class="btn-modal-close" >닫기</button>
			</div>
			<div class="modal-layer" ></div>
		</div>
		<div class="modal search" >
			<div class="modal-content" >
				<h1>본문검색입니다.</h1>
				<input type="text" /><button>검색</button>
				<button class="btn-modal-close" >닫기</button>
			</div>
			<div class="modal-layer" ></div>
		</div>
		<div class="modal setting" >
			<div class="modal-content" >
				<h1>설정</h1>
				<div class="select-background" >
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
				<input type="range" step="5" />
				줄 간격
				<input type="range" />
				좌우 여백
				<input type="range" />
				<button class="btn-modal-close" >닫기</button>
			</div>
			<div class="modal-layer" ></div>
		</div>
		<div class="modal bookmark" >
			<div class="modal-content" >
				<h1>책갈피입니다.</h1>
				<button class="btn-modal-close" >닫기</button>
			</div>
			<div class="modal-layer" ></div>
		</div>
	</div>
	<div class="bookmark-div" >
		<button class="bookmark far fa-bookmark" ></button>
	</div>
</body>
</html>