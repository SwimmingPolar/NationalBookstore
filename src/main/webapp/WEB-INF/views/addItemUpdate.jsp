<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="../../resources/styles/sideMenu.css">
    <link rel="stylesheet" href="../../resources/styles/addItemUpdate.css">
    <script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>


</head>
<body>
<jsp:include page = "sideMenu.jsp"/>

<div class="wrapper">
    <div class="putItemTitle">
        <h3> 상품 수정 </h3>
    </div>
    
  <div class ="main">
   
  
        <div class="insertNewBook">
    
            <table>
                <tr>
                    <th>
                        카테고리
                    </th>
                    <td>
                        <label for="bigCategory" >영미문학</label>
                        <b>></b>
                        <label for="smallCategory" style="color:rgb(122, 122, 122);">소설</label>
                    </td>
                </tr>
<tr>
  <th>도서 코드</th>
  <td>
      <label for="bookCode"> 78945461324 </label>
  </td>
</tr>
<!-- <tr>
    <th> 도서 이미지 </th>
    <td> <input type="file" name="bookfile" id="">
        <div class="bookImg">
            
        </div>
    </td>
</tr> -->
<tr>
    <th>도서명</th>
    <td><label for="bookName">달빛 마신 마녀</label></td>
</tr>
<tr>
    <th>저자</th>
    <td> <input type="text" name="bookAuthor" id="bookAuthor" placeholder="Kelly Barnhill"></td>
</tr>
<tr>
    <th> 출판사</th>
    <td><input type="text" name="editCompany" id="editCompany" placeholder="양철북" ></td>
</tr>
<tr>
    <th>출판날짜</th>
    <td><input type="text" name="editDate" id="editDate" placeholder="2018/05/09"></td>
</tr>
<tr>
<th> 책소개 </th>
<td> <input type="file" name="bookStory" id=""></td>
</tr>
<tr>
<th> 목차 </th>
<td> <input type="file" name="bookIndex" id=""> </td>
</tr>
<tr>
<th> 리뷰</th>
<td><input type="file" name="bookReview" id=""></td>
</tr>
 </table>

        </div> 
        <!-- insertBook end -->
    
<div class="rightBox">
    <div class="settingChoice">
        <table>
<tr>
    <th style="border-top:none;">품절표시설정</th>
    <td style="border-top:none;">
        <label for="soldoutYes"><input type="radio" name="soldout" id="soldoutYes" checked>품절표시</label>
        <label for="soldoutNo"><input type="radio" name="soldout" id="soldoutNo">품절표시안하기</label>
    </td>
</tr>
<tr>
    <th>상품지연설정</th>
    <td><label for="delayYes"><input type="radio" name="delay" id="delayYes" checked>지연하기</label>
        <label for="delayNo"><input type="radio" name="delay" id="delayNo">지연안하기</label></td>
</tr>

        </table>


    </div>
    <div class="moneyBox">
        <table>
            <tr>
                <th>
                   가격입력
                </th>
                <td style="border-top:none;">
                  <input type="text" name="inputPrice" id=""> 원
                </td>
            </tr>
            <tr>
                <th>적립금</th>
                <td><input type="text" name="saveMiles" id=""> 원</td>
            </tr>
           
        </table>

    </div>
    <!-- moneyBox -->
<!-- 
    <div class="shippingFare">
        ♣ 배송비옵션 (선택하지 않을시 기본설정에 따릅니다.)
    </div> -->

    <div class="shipChoice">
      <div>
        <label for="freeShip"><input type="radio" name="shipping" id="freeShip">무료배송  </label>
        <a>해당 상품을 무료배송합니다.</a>
    </div>
      <div>
        <label for="afterShip"><input type="radio" name="shipping" id="afterShip">착불</label>
        <input type="text" name="whatPrice1" id=""> ( <input type="text" name="fixPrice" id=""> 원 이상 주문시 무료)
    </div>
      <div>
        <label for="beforeShip"><input type="radio" name="shipping" id="beforeShip">선불</label>
        <input type="text" name="whatPrice2" id=""> ( <input type="text" name="fixPrice" id=""> 원 이상 주문시 무료)
    </div>
    
        <p> ※ 착불, 선불 배송비 -
            무료배송 기준금액을 '공백' 또는 '0'으로 입력할 경우 주문금액과 관계없이 무조건 배송비를 
            부과합니다.
        </p>

    </div>


</div>


    </div>
    <!-- blue end -->
<div class="finishBtn">
    <button type="button" class="saveNewProduct">수정 완료</button>
    <input type="reset" value="취소" class="resetInfo">
</div>

</div>    
<!-- wrapper end -->



</body>
</html>