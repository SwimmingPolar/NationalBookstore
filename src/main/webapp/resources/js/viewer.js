$(document).ready(function() {
	var timerId;
	$(".header-caller").on("mouseover", function() {
		$(".header").addClass("popup")
	});
	
	$(".header, .modal").on("mouseover", function() {
		clearTimeout(timerId);
	});
	
	$(".header").on("mouseout", function() {
		timerId = setTimeout(() => $(".header").removeClass("popup"), 3500);
	});
	
	$(".page").on("click", function() {
		$(".header").toggleClass("popup");
	})
	
	$("#flip-type + label").on("click", function() {
		$(this).children(".toggle-switch").toggleClass("fa-arrows-v").toggleClass("fa-arrows-h");
	});
	$("#page-type + label").on("click", function() {
		$(this).children(".toggle-switch").toggleClass("fas").toggleClass("fad");
	});
	
	$(".btn-func").on("click", function(e) {
		$(".modal").removeClass("pop");
		$(".modal."+e.target.classList[0]).addClass("pop");
	});
	
	//기능 단축키
	$(document).on("keydown", function(e) {
		switch(e.originalEvent.keyCode) {
		case 73: //i=목차
			$(".modal").removeClass("pop");
			$(".modal.index").addClass("pop");
			break;
		case 70: //f=본문검색
			$(".modal").removeClass("pop");
			$(".modal.search").addClass("pop");
			break;
		case 83: //s=보기설정
			$(".modal").removeClass("pop");
			$(".modal.setting").addClass("pop");
			break;
		case 76: //ㅣ=책갈피리스트
			$(".modal").removeClass("pop");
			$(".modal.bookmark").addClass("pop");
			break;
		case 66: //b=책갈피 추가
			/*$(".modal").removeClass("pop");*/
			$(".bookmark-alarm").addClass("pop");
			$(".bookmark-div .bookmark").trigger("click");
			var timer= setTimeout(() => $(".bookmark-alarm").removeClass("pop"), 300);
			break;
		case 27: //esc=모달 닫기
			$(".modal").removeClass("pop");
			break;
		}
	});
	
	$(".btn-modal-close, .modal-layer").on("click", function() {
		$(".modal").removeClass("pop");
	});
	//보기설정 > 글자,배경색
	$(".page-color").on("click", function(e) {
		var color = e.target.classList[1];
		if(color == "white")
			$(".content .page").css("background","#FFFFFF").css("color", "#000000");
		else if(color == "green")
			$(".content .page").css("background","#2b9900").css("color", "#FFFFFF");
		else if(color == "gray")
			$(".content .page").css("background","#6a6a6a").css("color", "#FFFFFF");
		else
			$(".content .page").css("background","#000000").css("color", "#FFFFFF");
	});
	
});
