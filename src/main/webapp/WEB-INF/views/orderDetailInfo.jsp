<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="../../resources/styles/sideMenu.css">
    <link rel="stylesheet" href="../../resources/styles/orderDetailInfo.css">
    <script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
    <link rel="stylesheet" href="../../resources/styles/reset.css">
    <link rel="stylesheet" href="../../resources/styles/common.css">
    <script src="../../resources/js/common.js"></script>
</head>
<body>

<jsp:include page="sideMenu.jsp"/>

 <div class="mainBody">

        <div class="mainTitle">
            <h3> 주문 상세현황 </h3>
        </div>

        <div class="orderDetail">
            <div class="orderInformation">
                주문번호 (9987454321) / <a> 주문 날짜: 2020-04-30</a></th>
             </div>

            <div class="orderInfo">
                <table class="secondTable">
                <tr>
                    <th> 도서이미지 </th>
                    <th> 도서명 </th>
                    <th> 수량 </th>
                    <th> 가격 </th>
                    
                </tr>
                    <tr>
                        <td> <img src="../../resources/image/book02.jpg" alt="오류" width=100> </td>
                        <td> 달빛 마신 소녀 </td>
                        <td> <input type="text" id="howMany" value="2"> </td>
                        <td> KRW <span class="bookPrice">16,000</span> 원  </td>
                    </tr>
                    <tr>
                        <td colspan="3"> 총 개수 <a> 2 </a> 개 </td>
                        <td> 총 금액  <a> 32,000 </a> 원</td>
                    </tr>
                </table>
            </div> 
         
            <div class="clientInfo">
                <table>
                    <tr>
                        <th>주문자 이름</th>
                        <td colspan="3">홍길동</td>
                    </tr>
                    <tr>
                        <th>핸드폰 번호</th>
                        <td>010-4444-8888</td>
                        <th>이메일</th>
                        <td>abc1234@gmail.com</td>
                    </tr>

                </table>

            </div>


            <div class="delivery"> 
                <table class="deliveryInfo">
                    <tr>
                        <th> 우편번호 </th>
                        <td> 32140 </td>
                    </tr>
                    <tr>
                        <th> 주소 </th>
                        <td> 경기도 시흥시 매화동 </td>
                    </tr>
                    <tr>
                        <th> 상세주소 </th>
                        <td> 273-6 태청빌라 301호 </td>
                    </tr>
                    <tr>
                        <th> 배송 요청사항 </th>
                        <td> 문앞에 놔주세요. </td>
                    </tr>
                </table>
            </div>

                <div class="payMethod">
                        <table class="payMethod">
                            <tr>
                                <th colspan="2"> 주문 금액 </th>
                                <th colspan="2"> 할인 금액 </th>
                                <th colspan="2"> 결제 금액 </th>
                                <th colspan="2"> 적립 포인트 </th>
                            </tr>
                            <tr>
                                <td> <b>상품금액</b> </td>
                                <td> 27,000 원 </td>
                                <td> <b>할인</b> </td>
                                <td> 2,700 원 </td>
                                <td> <b>신용카드</b> </td>
                                <td> 24,300 원 </td>
                                <td> <b>기본적립 </b> </td>
                                <td> 1,350 원 </td>

                            </tr>
                        
                        </table> 
                
                </div>
                <!-- payMethod end -->
        </div>

    </div>

</body>
</html>