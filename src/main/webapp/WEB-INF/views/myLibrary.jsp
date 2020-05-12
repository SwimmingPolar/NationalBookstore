<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>    
    <script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap" rel="stylesheet">
<link rel="stylesheet" href="../../resources/styles/myLibrary.css">
</head>
<body>

<div class="wrapper">
<div class="firstColumn">
<!-- 배경화면 넣는곳 -->

<div class="myImage"> 
    <a href="#"> <i class="fas fa-user-circle"></i> </a>    
</div>

<div class="myNickname">
        <a> 지혜로운 셀럽 </a> 님의 서재 
        <a> 아이디  abc1234 </a>
</div>

<div class="infoSetting">
   <a href="#"><i class="fas fa-users-cog"></i></a> 

</div>

<div class = "manyBtn">
    <ul>
        <li><a href="#"> 읽은 책 <b>( ${readbookcount } )</b> </a></li>
        <li><a href="#"> 좋아요 <b>( 1 )</b> </a></li>
        <li><a href="#"> 팔로우 <b>( ${myFollower} )</b> </a></li>
    </ul>


</div>

<div class="goSubscribe">
<a href="#"> 
  <b>지금 바로 <em>정기구독</em> 을 시작하세요.</b><br>
    목표와 함께라면 독서가 일상이 됩니다.
</a>

    
</div>

</div>
<!-- firstColumn end -->

<div class="secondColumn">
    <input type="radio" name="myPage" id="mybook" checked><label for="mybook"> 내 책</label>
    <input type="radio" name="myPage" id="mybookcart"><label for="mybookcart">책장</label>
    <input type="radio" name="myPage" id="paperbook"><label for="paperbook">종이책 주문</label>
    <input type="radio" name="myPage" id="mypost"><label for="mypost">포스트</label>
    
    <div class="content one">
        <div class="mybookTitle">
            <a>${readbookcount }</a> 권의 도서
        </div>
        <div class="mybook_Content">
           <span> <i class="fas fa-books"></i></span>
            	<c:forEach var="book" items="${libbooklist}">
            		${book.bookTitle }
            	 </c:forEach>
            	서재에 등록된 도서가 없습니다
        </div>
        
    </div>
    <div class="content two">
        <div class="mybookTitle">
            <a>${libcount}</a> 개의 책장
        </div>
    
        <div class="makeNewBook">
            <div class="mybook_Content">
            <span> <i class="fas fa-books"></i></span>
                		나만의 책장을 만들어보세요
             <button type="button" id=makeBookCart> <i class="fas fa-plus"></i> 새 책장 만들기 </button>
             <c:forEach var="readbook" items="${readbooklist}"> 
             		${readbook.bookTitle}             
             </c:forEach>
         </div>
        </div>
    </div>
    <div class="content three">
        <div class="mybookTitle">
            <a>0</a> 권의 종이책 주문
        </div>
        <div class="mybook_Content">
            <span> <i class="fas fa-book"></i></span>
        	     종이책 주문 정보가 존재하지 않습니다
         </div>

    </div>
    <div class="content four">
        <div class="mybookTitle">
        	   나의 포스트 <a>0</a> 개
        </div>
        <div class ="postInputBtn">
        <button type= "button" id = postInput onclick="openNewPost()"> <i class="fas fa-pencil-alt"></i> 포스트 작성</button>
        </div>
            
        <div class="myPostCheck" id="myPostCheck">
            <table>
                <tr>
                    <th> 도서명 </th>
                    <th> 별점 </th>
                    <th> 등록날짜 </th>
                </tr>
                <tr>
                    <td> 달빛 마신 마녀 </td>
                    <td> ★★★★☆ </td>
                    <td> 2019-04-30 </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <input type="text" name="postTitleChk" id="postTitleChk" 
                        value="인생 책입니다." readonly>
                        
                        <textarea name="postText" id="postText" readonly>
                            좋아요. 재밌고 흥미로워요~~!! 좋아요. 재밌고 흥미로워요~~!! 좋아요. 재밌고 흥미로워요~~!!
                            좋아요. 재밌고 흥미로워요~~!! 좋아요. 재밌고 흥미로워요~~!! 좋아요. 재밌고 흥미로워요~~!!
                            좋아요. 재밌고 흥미로워요~~!! 좋아요. 재밌고 흥미로워요~~!! 좋아요. 재밌고 흥미로워요~~!!
                           

                        </textarea>
                       
                    </td>

                </tr>
            </table>

        </div>


        <div class="postInsert" id="postInsert">
            <select name="bookSelect" id="bookSelect">
                <option value="bookChoice"> ===== 책선택 ===== </option>
                <option value="bookChoice"> book1 </option>
                <option value="bookChoice"> book2 </option>
            </select>
            <div class ="bookStarScore">
                <b>별점 등록</b>     
                <span><i class="fas fa-star starJum01"></i></span>
                <span><i class="fas fa-star starJum02"></i></span>
                <span><i class="fas fa-star starJum03"></i></span>
                <span><i class="fas fa-star starJum04"></i></span>
                <span><i class="fas fa-star starJum05"></i></span>
                <b> 점</b>
            </div>
            <div class="postImgFile">  
                <input type="file" name="postImageFile" id="postImageFile" onchange="uploadImg(this);">
                    <div class="postImage" id="postImage">
                        <img id ="imgimg" width=200>
                    </div>
                    
            </div>

            <input type="text" name="postTitle" id="postTitle" placeholder="제목을 입력하세요">
            <textarea name="post_Content" id="post_Content" placeholder="솔직한 생각을 입력해주세요."></textarea>
            
            <div class="postEndBtn">
                <button type="button" id="postSave"> 저장 </button>
                <button type="button" id="postCancel"> 취소 </button>
            </div>
       
        </div>
        

    </div>
    </div>

</div>

<script> 

    $('.bookStarScore span').click(function(){
        
        $(this).parent().children('span').removeClass('on');
        $(this).addClass('on').prevAll('span').addClass('on');
        $('.starJum01').click(function(){
            $('#starTxt').val($(this).length);
            
        })
    
    });
    
    
    </script>

    <script>
        
        function openNewPost() {
            
            var openP = document.getElementById('postInsert');
            var postChk = document.getElementById('myPostCheck');

            if (openP.style.display == 'none') {
                openP.style.display ='block';
                postChk.style.display = 'none';
            }else {
            
                openP.style.display ='none';
                postChk.style.display = 'block';
                
            }
        }


    </script>

    <script>

        // 파일 업로드  미리보기

        function uploadImg(here) {
            if(here.files && here.files[0]) {
                var reader = new FileReader();
                reader.onload = function(e) {
                    $('#imgimg').attr('src', e.target.result);
                }
                reader.readAsDataURL(here.files[0]);
            }

        }

        // 파일 업로드하기 

    </script>


<!--     <script>
    var cnt=0;
    var array =['.starJum01'];
        $(function(){
            cnt++;
            $('.starJum01').click(function(){
                $('#starJum').val(cnt);

            })
        })

    </script> -->



</body>
</html>