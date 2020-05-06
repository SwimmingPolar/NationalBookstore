$(document).ready(function() {
	var timerId;
	/*$(document).on("mousemove", function(e) {
		if(e.clientY <= 10)
			$(".header").addClass("popup");
		
		if(e.clientY >= 86) {
			setTimeout(() => $(".header").removeClass("popup"), 3500);
		}
	});*/
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
		$(".modal").css("display", "none");
		$(".modal."+e.target.classList[0]).css("display", "block");
	});
	
	$(".btn-modal-close, .modal-layer").on("click", function() {
		$(".modal").css("display", "none");
	});
});
