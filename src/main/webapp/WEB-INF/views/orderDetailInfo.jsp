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

</head>
<body>

<jsp:include page="sideMenu.jsp"/>

 <div class="mainBody">

        <div class="mainTitle">
            <h3> 주문 상세현황 </h3>
        </div>

        <div class="orderDetail">

            <table>
                <tr>
                    <th colspan="2">주문번호 (9987454321) / <a> 주문 날짜: 2020-04-30</a></th>
                </tr>
                <tr>
                    <th> 회원아이디 </th>
                    <td>  abc1234 </td>
                </tr>
                <tr> 
                    <th> 주문 상세기록 </th>
                    <td> 
                        <div class="orderInfo">
                            <table class="secondTable">
                                <tr>
                                    
                                </tr>
                                <tr>
                                    <td> 도서명 </td>
                                    <td> 달빛 마신 소녀 </td>
                                </tr>
                            </table>

                        </div> 
                    </td>    
                </tr>
                <tr> 
                    <th> 배송지 (상세주소) </th>
                    <td> 
                   <ul>
                       <li> 우편번호 </li>
                       <li> 주소 </li>
                       <li> 상세주소 </li>
                   </ul>

                   <ul>
                       <li> 45778 </li>
                       <li> 경기도 시흥시 은행동 </li>
                       <li> 273-71 태청빌라 301호 </li>
                   </ul>
                    </td>    
                </tr>
                <tr> 
                    <th> 결제수단 </th>
                    <td>  </td>    
                </tr>
                <tr> 
                    <th> 결제금액 </th>
                    <td>  </td>    
                </tr>
            </table>

        </div>

    </div>


</body>
</html>