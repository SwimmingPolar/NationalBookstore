<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="../../resources/styles/sideMenu.css">
    <link rel="stylesheet" href="../../resources/styles/bookInfoManage.css">
    <script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
</head>
<body>

<jsp:include page = "sideMenu.jsp"/>

<div class="main">

    <div class= "titleBookManage">
        <h3> 도서 정보 관리</h3>
    </div>

    <div class="bookInfo">

        <table>
            <tr>
                <th style="width:40px;"><input type="checkbox" name="allChkbox" id="allChkbox"></th>
                <th>도서코드</th>
                <th>도서이미지</th>
                <th>도서</th>
                <!-- <th>도서 상세사항</th> -->
                <th>금액</th>
                <th>등록날짜</th>
                <th>수정/삭제</th>
            </tr>
            <tr>
                <td><input type="checkbox" name="updateChkbox" id="updateChkbox"></td>
                <td><a href="#">567888974321</a> </td>
                <td><img src="../../resources/image/book02.jpg" alt="오류">
                </td>
                <td >
                    <table class="bookData">
                        <tr>
                            <th>도서명</th>
                            <td>달빛마신 마녀</td>
                        </tr>
                        <tr>
                            <th style="border-bottom: none;">저자</th>
                            <td style="border-bottom: none;">Kelly Barnhill</td>
                        </tr>
                        <!-- <tr>
                            <th>출판사</th>
                            <td>민음사</td>
                        </tr>
                           <tr>
                            <th style="border-bottom: none;">출판날짜</th>
                            <td style="border-bottom: none;">2017-05-14</td>
                           </tr> -->

                    </table>
                </td>
                <!-- <td> 
                    <ul>
                        <li><input type="button" value="책소개"></li>
                        <li><input type="button" value="목차"></li>
                        <li><input type="button" value="리뷰"></li>
                    </ul>
                </td> -->
                <td>KRW 24,000 원 </td>
                <td>2020-05-04</td>
                <td><input type="button" value="수정" onclick="location.href='addItemUpdate.html'">
                <input type="button" value="삭제" id="deleteBtn"></td>
            </tr>
        </table>

    </div>


 </div>

<script>

var $allChkbox = $('#allChkbox');
    $allChkbox.change(function() {
        var $this = $(this);
        var checked = $this.prop('checked');
        $('input[name="updateChkbox"]').prop('checked',checked);

    });


</script>

<script>


    $('#deleteBtn').click(function(){
        var chkPopup = confirm("정말로 삭제하시겠습니까? ");
        if(chkPopup==true) {
            alert("삭제되었습니다.");
        }else {
            alert("취소되었습니다.");
        }

    })


</script>



</body>
</html>