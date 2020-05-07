<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../resources/styles/sideMenu.css">
    <link rel="stylesheet" href="../../resources/styles/putNewBook.css">
    <script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>


</head>
<body>

<jsp:include page = "sideMenu.jsp"/>


<div class="wrapper">
    <div class="putItemTitle">
        <h3> 상품 등록 </h3>
    </div>
    
 <div class="storyBox">
    <ul>
        <li> 
            <p>- 가격과 상품이미지 설정하여 상품등록합니다.</p>
        </li>
        <li>
            <p>- <a>*</a> 로 설정된 부분은 필수 입력하셔야 합니다. </p>
        </li>
        <li>
            <p>- 시중가를 적으면 세일이 적용됩니다. (필요할 경우에만 입력하세요.) </p>
        </li>
        <li>
            <p> <a> * 주의: 종이책이 존재하지 않는 e-book은 배송비를 '없음'으로 설정하셔야 합니다.</a></p>
        </li>
     
    </ul>

</div>

 <div class ="main">
   
  
        <div class="insertNewBook">
    
            <table>
                <tr>
                    <th>
                        카테고리
                    </th>
                    <td>
                        <select name="firstDiv" id="">
                            <option value="bigMenu_one">철학</option>
                            <option value="bigMenu_two">종교</option>
                            <option value="bigMenu_three">문학</option>
                            <option value="bigMenu_four">역사</option>
                        </select>
                        <select name="secondDiv" id="">
                            <option value="sMenu_one">서양철학</option>
                            <option value="sMenu_two">불교</option>
                            <option value="sMenu_three">영미문학</option>
                            <option value="sMenu_four">유럽</option>
                        </select>
                    </td>
                </tr>
<tr>
  <th>도서 코드</th>
  <td><input type="text" name="bookCode" id=""></td>
</tr>
<tr>
    <th> 도서 이미지 </th>
    <td> <input type="file" name="bookfile" id="">
        <div class="bookImg">
            
        </div>
    </td>
</tr>
<tr>
    <th><a>*</a> 도서명</th>
    <td><input type="text" name="bookName" id=""></td>
</tr>
<tr>
    <th><a>*</a> 저자</th>
    <td><input type="text" name="author" id=""></td>
</tr>
<tr>
    <th><a>*</a> 출판사</th>
    <td style="padding-left:0px;"><table><tr><td><input type="text" name="" id=""></td><th>출판날짜</th><td><input type="text" name="editDate" id="" ></td></tr></table></div></td>
</tr>
<tr>
<th>간략한설명</th>
<td><input type="text" name="smallTalk" id=""></td>
</tr>

    <tr>
        <th colspan="2" style="text-align: center;"> 상세페이지에 나오는 내용을 직접 입력</th>
        
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

    <div class="moneyBox">
        <table>
            <tr>
                <th>
                    <a>*</a> 가격입력
                </th>
                <td style="border-top:none;">
                    판매가: <input type="text" name="inputPrice" id=""> 원 공급가: <input type="text" name="supplyMoney" id=""> 원
                        <a style="display: block; font-size:10px; margin-top:5px;"> ※ 본사카테고리 수수료기준</a>
                </td>
            </tr>
            <tr>
                <th><a>*</a> 적립금</th>
                <td><input type="text" name="saveMiles" id="">원
                    <a style="display: block; font-size:10px; margin-top:5px;"> [회원별 적립금]</a></td>
            </tr>
            <tr>
                <th>시중가격</th>
                <td><input type="text" name="price" id="">원 (필요할시에만 기입하세요.)</td>
            </tr>
        </table>

    </div>
    <!-- moneyBox -->

    <div class="shippingFare">
        ♣ 배송비옵션 (선택하지 않을시 기본설정에 따릅니다.)
    </div>

    <div class="shipChoice">
      <div>
        <label for="freeShip"><input type="radio" name="shipping" id="freeShip">무료배송  </label>
        <a>해당 상품을 무료배송합니다.</a>
    </div>
      <div>
        <label for="afterShip"><input type="radio" name="shipping" id="afterShip">착불</label>
        <input type="text" name="whatPrice1" id=""> ( <input type="text" name="fixPrice" id="">원 이상 주문시 무료)
    </div>
      <div>
        <label for="beforeShip"><input type="radio" name="shipping" id="beforeShip">선불</label>
        <input type="text" name="whatPrice2" id=""> ( <input type="text" name="fixPrice" id="">원 이상 주문시 무료)
    </div>
    
        <p> ※ 착불, 선불 배송비 -
            무료배송 기준금액을 '공백' 또는 '0'으로 입력할 경우 주문금액과 관계없이 무조건 배송비를 
            부과합니다.
        </p>

    </div>

    <div class="settingChoice">
        <table>
<tr>
    <th style="border-top:none;">품절표시설정</th>
    <td style="border-top:none;">
        <label for="soldoutYes"><input type="radio" name="soldout" id="soldoutYes" >품절표시</label>
        <label for="soldoutNo"><input type="radio" name="soldout" id="soldoutNo">품절표시안하기</label>
    </td>
</tr>
<tr>
    <th>상품지연설정</th>
    <td><label for="delayYes"><input type="radio" name="delay" id="delayYes">지연하기</label>
        <label for="delayNo"><input type="radio" name="delay" id="delayNo">지연안하기</label></td>
</tr>

        </table>


    </div>

</div>


    </div>
    <!-- blue end -->
<div class="finishBtn">
    <button type="button" class="saveNewProduct">도서 등록</button>
    <input type="reset" value="취소" class="resetInfo">
</div>

</div>    
<!-- wrapper end -->

</body>
</html>