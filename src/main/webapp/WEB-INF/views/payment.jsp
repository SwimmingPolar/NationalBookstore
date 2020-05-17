<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.0.js" integrity="sha256-r/AaFHrszJtwpe+tHyNi/XCfMxYpbsRg2Uqn0x3s2zc=" crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../../resources/styles/reset.css" />
<link rel="stylesheet" type="text/css" href="../../resources/styles/payment.css" />
<script type="text/javascript" >
	$(document).ready(function() {
		//결제 방식 선택
		$(".payment > label").click(function(data) {
			var className = "."+data.target.className;
			//결제 방식 상세 초기화
			$(".manual-name").val("");
			$(".credit-card input[type=checkbox]").prop("checked", true)
			$(".credit-card input[type=checkbox]").prop("checked", false);
			//해당 결제 위한 div 띄움
			$(".payment-detail > div").css("display", "none");
			$(".payment-detail > "+className).css("display", "flex");
		});
		//신용카드 종류 선택
		$(".credit-card input[type=checkbox]").click(function(data) {
			$(".credit-card input[type=checkbox]").prop("checked", true)
			$(".credit-card input[type=checkbox]").prop("checked", false);
			$(this).prop("checked", true);
		});
		$(".btn-payment").click(function(e) {
			e.preventDefault();
			var confirmPayment = confirm("결제 하시겠습니까?");
			
			if(confirmPayment && $(".agree1[type=checkbox]").prop("checked")) {
				alert("다음 페이지로 리다이렉트");
				$(".form1").submit();
			}
			else {
				console.dir("취소함")
			}
		})
	});
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" >
		<form class="form1" action="#" method="GET" >
			<div class="product-info" >
				<div class="book" >
					<img src="http://placehold.it/120X140.jpg" />
				</div>
				<ul class="product-info-detail" >
					<li class="product-name" >
						<span>책 제목</span>
						<div class="product-name-content" >
							룬의 아이들 1
						</div>
					</li>
					<li class="product-price" >
						<span>가격</span>
						<div class="product-price-content" >
							16,000원
						</div>
					</li>
					<li class="product-amount" >
						<span>수량</span>
						<input type="number" step="1" min="1" max="999" value="1" name="amount" autocomplete="off" spellcheck="false" />
					</li>
				</ul>
			</div>
			<div class="order-info" >
				<div class="order-info-title" >
					배송지 정보
				</div>
				<div class="order-info-address" >
					<span>받는분</span>
					<input type="text" placeholder="이름" name="name" autocomplete="off" spellcheck="false"/>
					<input type="text" placeholder="전화번호" name="tel" autocomplete="off" spellcheck="false" />
					<input type="text" placeholder="주소" name="address" autocomplete="off" spellcheck="false" />
					<input type="text" placeholder="상세주소" name="address" autocomplete="off" spellcheck="false" />
					<textarea placeholder="배송 요청 메세지를 남겨주세요." name="inquiry" autocomplete="off" spellcheck="false" ></textarea>
				</div>
			</div>
			<div class="payment-info" >
				<ul class="payment-info-detail" >
					<li class="payment-price" >
						<span>상품금액</span>
						16,000원
					</li>
					<li class="payment-shipment" >
						<span>배송비</span>
						<div class="product-shipment-content" >
							2,500원
						</div>
					</li>
					<li class="payment-final-price" >
						<span>최종 금액</span>
						<div class="product-final-price-content" >
							18,500원
						</div>
					</li>
				</ul>
			</div>
			<div class="payment" >
				<input id="manual" type="radio" name="payment-method" value="manual" /><label for="manual" class="manual" >무통장 입금</label>
				<input id="credit-card" type="radio" name="payment-method" value="credit-card" /><label for="credit-card" class="credit-card" >신용카드</label>
				<input id="kakao-pay" type="radio" name="payment-method" value="kakao-pay" /><label for="kakao-pay" class="kakao-pay" >카카오페이</label>
			</div>
			<div class="payment-detail" >
				<div class="manual" >
					<div>
						<label for="bank-name" >은행</label>
						<select id="bank-name" class="bank-name" name="bank-name" >
							<option value="sinhan" >신한은행 : 110-111-1111111</option>
							<option value="kb" >국민은행 : 02-312-12211</option>
							<option value="ibk" >기업은행 : 034-1214-111231</option>
							<option value="kakaobank">카카오뱅크 : 3343-12-11212</option>
						</select>
						<label for="transferer-name" >입금자명</label><input class="manual-name" type="text" name="manual-name" autocomplete="off" spellcheck="false" />
					</div>
				</div>
				<div class="credit-card" >
					<div>
						<input id="card1" type="checkbox" name="card" value="card1" ><label for="card1" >신한</label> 
						<input id="card2" type="checkbox" name="card" value="card2" ><label for="card2" >국민</label>
						<input id="card3" type="checkbox" name="card" value="card3" ><label for="card3" >BC</label>
						<input id="card4" type="checkbox" name="card" value="card4" ><label for="card4" >농협</label>
						<input id="card5" type="checkbox" name="card" value="card5" ><label for="card5" >우리</label>
						<input id="card6" type="checkbox" name="card" value="card6" ><label for="card6" >기업</label>
						<input id="card7" type="checkbox" name="card" value="card7" ><label for="card7" >카카오뱅크</label>
					</div>
				</div>
				<div class="kakao-pay" >
					<div>
						카카오페이
					</div>
				</div>
			</div>
			<div class="agreement" >
				<input type="checkbox" id="agree1" class="agree1" name="agreement" /><label for="agree1">상기 결제 내용과 정보 수집에 동의합니다.</label>
			</div>
			<input type="hidden" name="book_num" />
			<input type="hidden" name="user_email" />
			<button class="btn-payment" >결제하기</button>
		</form>
	</div>
</body>
</html>