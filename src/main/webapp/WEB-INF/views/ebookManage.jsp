<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="../../resources/styles/sideMenu.css">
    <link rel="stylesheet" href="../../resources/styles/ebookManage.css">
    <script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>

</head>
<body>

<jsp:include page="sideMenu.jsp"/>

<div class="newItemInsert">
        <div class="choiceOrders">
            <h3> 주문 관리 </h3>

        </div>
        <ul class="tabs">
            <form action="" onclick="chngStyle()">
                <li class="active" rel="tabFirstContent"> 주문 기록 </li>
                <li rel="tabSecondContent"> 환불/교환</li>
            </form>
        </ul>

        <div class="tabWrapper">
            <div id="tabFirstContent" class="tabContent ">

                <div class="orderTable">
                    <span class="statusChk">
                        <a href="#">All</a>
                         <a href="#">입금대기 (0) </a>
                        <i class="fas fa-grip-lines-vertical"></i>
                        <a href="#">결제완료 (1) </a>
                        <i class="fas fa-grip-lines-vertical"></i>
                        <a href="#">배송준비 (0) </a>
                        <i class="fas fa-grip-lines-vertical"></i>
                        <a href="#">배송중 (1) </a>
                        <i class="fas fa-grip-lines-vertical"></i>
                        <a href="#">배송완료 (0) </a>
                        <i class="fas fa-grip-lines-vertical"></i>

                    </span>

                    <!-- <div class="dateBtn">

                        <input type="date" name="daySearch" id=""> - <input type="date" name="daySearch2" id="">
                        <input type="button" value="검색">
                    </div> -->

                    <span class="tableTitle">
                        <select name="choice" id="">
                            <option value="choicehidden" hidden> 선택 </option>
                            <option value="productName">상품명</option>
                            <option value="orderStatus"> 주문 상태 </option>
                            <option value="orderPrice"> 금액 </option>
                            <option value="orderClient"> 주문자 </option>
                            <option value="shipNumber"> 송장번호 </option>
                        </select>
                        <input type="text" name="searchTxt" id="">
                        <input type="button" value="검색">
                    </span>
                    <table>
                        <tr>
                            <th> <input type="checkbox" name="chkboxTitle"
                                    id="chkboxTitle"></th>
                            <th> 주문 현황 </th>
                            <th> 주문 상태 </th>
                            <th> 금액 </th>
                            <th> 결제수단 </th>
                            <th> 주문자 </th>
                            <th> 송장번호 </th>
                        </tr>
                        <tr>
                            <td style="text-align: center;"><input type="checkbox" name="chkboxContent"
                                    id="chkboxContent"> </td>
                            <td>
                                <span class="adjustHere">
                                    <a href="orderDetailInfo.html">
                                        <span> 주문번호 : 2020050311447-4879546 </span>
                                        <span> 달빛 마신 마녀 </span>
                                        <span> 2020-05-03 11:33 </span>
                                        
                                    </a>
                                </span>
                            </td>
                            <td> 결제완료 </td>
                            <td> 24,000 </td>
                            <td> 카드 </td>
                            <td> abc1234 </td>
                            <td> 998745612 </td>
                        </tr>
                    </table>
                </div>
                <!-- table 끝 -->

                <div class="endbtnOrders">
                    <div class="choiceStatus">
                        <select name="statusPut" id="">
                            <option value="payEnd">결제완료</option>
                            <option value="shipEnd">배송완료</option>
                            <option value="shipping">배송중</option>
                            <option value="standby">결제대기</option>
                        </select>
                        <input type="button" value="적용">
                    </div>

                </div>
            </div>
            <!-- red end -->

            <div id="tabSecondContent" class="tabContent">

            </div>
            <!--  -->

        </div>
        <!-- blue end -->
    </div>
    <!-- tabWrapper end -->

    <script>

        var $chkboxTitle = $('#chkboxTitle');
        $chkboxTitle.change(function () {
            var $this = $(this);
            var checked = $this.prop('checked');
            $('input[name="chkboxContent"]').prop('checked', checked);

        });

    </script>

    <script>
        $('document').ready(function () {

            $('.tabContent').hide();
            $('.tabContent').eq(0).show();

            $('ul.tabs li').click(function () {
                $('ul.tabs li').removeClass('active');
                $(this).addClass('active');
                $('.tabContent').hide();
                var openTab = $(this).attr('rel');
                $('#' + openTab).fadeIn();
              

    })

        })

    </script>




</body>
</html>