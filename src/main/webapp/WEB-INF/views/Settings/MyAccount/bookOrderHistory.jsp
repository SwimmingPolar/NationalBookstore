<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>    
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="../../../../resources/styles/buyPaperBook.css">
<link rel="stylesheet" href="../../../../resources/styles/buyPaperBook.css">
<link rel="stylesheet" href="../../../../resources/styles/reset.css">
<link rel="stylesheet" href="../../../../resources/styles/common.css">
<script src="../../../../resources/js/common.js"></script>

</head>
<header class="topbar">
    <nav>
      <div class="container">
        <a href="javascript: history.back();"><i class="far fa-arrow-left"></i></a>
        <h2> 종이책 주문 내역 </h2>
      </div>
    </nav>
  </header>

  <div class="tabWrapper">
        <div class="bigPaperbox">
            <p> <i class="fas fa-theater-masks"></i> 지혜로운 셀럽님 </p>
            <ul>
                <li> 주문접수에서 업체에 주문내역을 통보한 단계까지는 바로 주문내역 변경이 가능하나, 결제수단 변경은 주문접수 상태에서만 가능합니다. </li>
                <li> 업체발송준비중 단계에서 주문내역 변경을 하시기 위해서는 별도로 업체에 연락을 하셔야 합니다. </li>
                <li> 결제수단변경은 온라인 입금에서 <a>카드결제로 변경만 가능</a>하며, 카드결제 후 다른 카드로 변경 결제하시려면 주문 취소 후 <a>재결제</a>하시기 바랍니다. </li>
            </ul>
        </div>
        <div class="boxDesign">
            <div>
                <ul>
                    <li>01. 주문접수</li>
                    <li>입금전 상태입니다. (7일내 미입금시 자동취소)</li>
                </ul>
            </div>
            <div>
                <ul>
                    <li>02. 결제완료</li>
                    <li>고객님의 결제가 확인완료되었습니다.</li>
                </ul>
            </div>
            <div>
                <ul>
                    <li>03. 발송 준비중</li>
                    <li>센터에서 주문을 접수하여, 상품을 포장중입니다.</li>
                </ul>
            </div>
            <div>
                <ul>
                    <li>04. 출고 완료</li>
                    <li>택배사로 상품을 넘겼습니다.</li>
                </ul>
            </div>
            <div>
                <ul>
                    <li>05. 배송중</li>
                    <li>고객님의 집까지 배송 중입니다.</li>
                </ul>
            </div>

        </div>
        <div class="tableWrapper">
            <c:choose>
                <c:when test="">    
        <div class="orderTable">
            <table>
                <tr>
                    <th> <input type="checkbox" name="chkboxTitle" id="chkboxTitle"></th>
                    <th> 주문 번호</th>
                    <th> 주문 현황 </th>
                    <th> 내역 </th>
                    <th> 주문 상태 </th>
                    <th> 구분 </th>
                </tr>
                <c:forEach var="" items="">
                <tr>
                    <td style="text-align: center;"><input type="checkbox" name="chkboxContent"
                            id="chkboxContent"> </td>
                    <td> 202005031 </td>
                            <td>
                        <span class="adjustHere">
                            <a href="#" onclick="window.open('orderDetailInfo.html', 'detail', 'top=100px, left=100px, height=730px, width=1000px')">
                                <img src="../../resources/images/myLibrary/book02.jpg" alt="">
                            </a>
                        </span>
                    </td>
                    <td>
                    <ul>
                        <li><strong> 도서명 </strong> <span>달빛마신 소녀</span></li>
                        <li><strong> 가격  </strong> <span> 24,000 원</span></li>
                        <li><strong> 주문일 </strong> <span>2020/05/05</span></li>
                    </ul>  
                    </td>
                    <td> 결제완료 </td>
                    <td style="text-align:center;"> 
                        <button type="button" id="exchange">교환</button>
                        <button type="button" id="refund">환불</button>
                    </td>
                </tr>
            </c:forEach>
            </table>
        </div>
        <div class="finishBtn">
            <button type="button" id="deleteBtn">선택 삭제</button>
            <button type="button" id="chkBtn" onclick="location.href='myAccount.jsp'">확인</button>
        </div>
         </div>
        </c:when> 

        <!-- orderTable end -->
        <c:otherwise>
          <div class="noHave">
            <i class="fas fa-book-reader"></i>
                <p> 종이책 주문 정보가 존재하지 않습니다. </p>
         </div>
       </c:otherwise>
    </c:choose>
        
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
    <%@ include file="../../template/footer.jsp" %>
</body>
</html>