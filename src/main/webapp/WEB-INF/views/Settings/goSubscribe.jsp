<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="../../../resources/styles/goSubscribe.css">
    <link href="https://fonts.googleapis.com/css?family=Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap" rel="stylesheet">
    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
    <script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>

</head>
<body>
<div class="wrapper">
    <div class="backBtn">
    <button type="button" id="backbtn" onclick="location.href='myLibrary.jsp'"><i class="fas fa-chevron-left"></i></button>

    </div>

    <div class="freeStory">
    <strong> 정기구독 결제 후 <br> 첫 달 무료 </strong>
    <img src="../../../resources/images/myLibrary/kids.png" alt="경로잘못됨">
    <span> 결제일자 전까지 언제든 해지할 수 있어요. </span>
    </div>

    <div class="bigBox">
        <div class="firstBox">
            <strong>e-book 정기구독</strong>
            <p> 1만 권의 책을 언제 어디서나 만나보세요 </p>
            <div class="inner">
                <button type="button" id="innerOne">
                    <span> 1개월 </span>
                    <span> <span> 9,900원 </span>첫 달 무료 <i class="fal fa-chevron-right"></i> </span>
                </button>
                
               
                <button type="button" id="innerTwo">
                    <span> 3개월 </span>
                    <span> <span> 29,900원 </span>첫 달 무료 <i class="fal fa-chevron-right"></i></span>
                </button>
            </div>
            
        </div>

        <div class="secondBox">
            <strong>종이책 정기구독</strong>
            <p> 전자책 무제한에 종이책도 격월로 받아보세요 </p>
            <div class="inner">
                <div class="one">
                <p> 전자책 정기구독에 6,000원만 추가 </p>
                <button type="button" id="innerOne">
                    <!-- <p> 전자책 정기구독에 6,000원만 추가 </p> -->
                    <span> 1개월 </span>
                    <span> <span>15,900원 </span>첫 달 무료 <i class="fal fa-chevron-right"></i> </span>
                </button>
            </div>
            <div class="two">
                <p> 3개월 e-book 정기구독에 종이책 2권까지 </p>
                <button type="button" id="innerTwo">
                    <!-- <p> 전자책 정기구독에 6,000원만 추가 </p> -->
                    <span> 3개월 </span>
                    <span> <span> 59,900원 </span>첫 달 무료 <i class="fal fa-chevron-right"></i></span>
                </button>
            </div>
            </div>
        </div>
    </div>
    <div class="howToUse">
        <p>이용 안내</p>
        <ul>
            <li> 첫 달 무료 체험 후, 위약금이나 약정없이 언제든지 쉽게 해지할 수 있습니다. </li>
            <li> 모든 정기구독은 결제 후 7일간 미사용 시 취소할 수 있습니다. </li>
            <li> 정기구독 중 전자책 연 정기구독 또는 종이책 월/연 정기구독으로 전환 가입 시, 남은 이용기간은 연장해 드립니다. </li>
            <li> 종이책은 상품이 손상되지 않은 경우, 교환/반품할 수 있습니다. (왕복 배송비 별도) </li>
            <li> 종이책은 국내 배송만 가능합니다.  </li>
        </ul>

    </div>

</div>
<!-- wrapper end -->

</body>
</html>