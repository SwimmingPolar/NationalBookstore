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
    <link rel="stylesheet" href="../../resources/styles/reset.css">
    <link rel="stylesheet" href="../../resources/styles/common.css">
    <script src="../../resources/js/common.js"></script>

</head>
<body>

<div class="wrapper">
<div class="firstColumn">
<!-- 배경화면 넣는곳 -->
<div class="follow">
    <button type="button" id="followBtn"> <i class="fas fa-plus-circle"></i> 팔로우 </button>
  </div>
<div class="bigbox">

<div class="myImage"> 
    <a href="#modalGo" id="modalOpen"><img id="myFaceImage" src="${pageContext.request.contextPath }/resources/images/myLibrary/picture1.png" ></a>   
</div>

<div class="myNickname">
        <a> ${ryanMember.memberNickName } </a> 님의 서재 
      <%--   <a> ${ryanMember.memberEmail } </a> --%>
</div>
</div>


<div class = "manyBtn">
    <ul>
        <li><a href="#"> 읽은 책 <b>( ${readbookcount } )</b> </a></li>
        <li><a href="#"> 좋아요 <b>( ${likeBookcount } )</b> </a></li>
        <li><a href="#"> 팔로우 <b>( ${myFollower} )</b> </a></li>
    </ul>


</div>

<div class="goSubscribe">
<a href="goSubscribe.jsp"> 
  <b> 정기구독 시작 </b><br>
  <em> 바로가기 </em> 
  <i class="fas fa-arrow-circle-right"></i>
</a>

    
</div>

</div>
<!-- firstColumn end -->

<div class="secondColumn">
    <input type="radio" name="myPage" id="mybook" checked><label for="mybook"> 내 책</label>
    <input type="radio" name="myPage" id="mybookcart"><label for="mybookcart">책장</label>
    <input type="radio" name="myPage" id="mypost"><label for="mypost">포스트</label>
    
    <div class="content one">
        <div class="mybookTitle">
            <a> ${readbookcount} </a> 권의 도서
        </div>
         <c:choose>
          <c:when test="${readbooklist.size() >0 }">
        <div class="myBookbook">
          <ul>
            <c:forEach var="readbook" items="${readbooklist}">
            	<li>
              	<a href="#">
              	<div class="books"> 
             
              	<div class="mybookimage">
                   <a href="/book/bookdetail?booknumber=${readbook.bookNum }"> 
                   	<img src="${pageContext.request.contextPath }${readbook.bookThumbnail }" alt="없음">	
                   </a>
              	</div>
              	<div class="names">
                <strong>${readbook.bookTitle}</strong> <br>
                <span>${readbook.bookWriter}</span> 
              	</div>
              	</div> <!-- books end -->
           		 </a>
            	</li>
          	</c:forEach>
          </ul>
   		 </div> <!-- myBookbook end -->  
   		 </c:when>     
           	<c:otherwise>
           		 <div class="mybook_Content">
        	   <span> <i class="fas fa-books"></i></span>
        	    	서재에 등록된 도서가 없습니다
      		     </div>
           	</c:otherwise>
          </c:choose>
            	
        </div>
           <div class="content two">
        <div class="mybookTitle">
            <a>${libcount}</a> 개의 책장
        </div>
    
        <div class="ebooks">
            <div class="listTitle">
              <strong> 찜 목록 </strong> 
            </div>
            <div class="totalBtn">
              <label for="allChk">
              <input type="checkbox" name="allChk" id="allChk"> 전체선택
              </label>    
              <button type="button" id="allDelete" onclick="allDelete();"> 전체삭제 </button>      
            </div>
            <div class="ebookList"> 
                 <c:choose>
                     <c:when test="${libbooklist.size() >0 }">
                  <table>
                         <c:forEach var="book" items="${libbooklist}">
                          
                          <tr>
                  <td><input type="checkbox" name="chkbox" id="chkbox"></td>
                  <td>
                     <a href="/book/bookdetail?booknumber=${book.bookNum }"> 
                  		<img src="${pageContext.request.contextPath }${book.bookThumbnail }" alt="없음">
                  	</a>
                  </td>
                  <td>
                    <ul>
                      <li> <strong>${book.bookTitle}</strong> </li>
                      <li> <a>${book.bookWriter} 지음</a>  </li>
                      <li> <span>${book.bookPublisher}</span></li>
                    </ul>
                  </td>
                  <td><button type="button" id="goRead">바로보기</button>
                  <a href="/booklist/deleteLibList?booknum=${book.bookNum }" id=eachDelete>삭제</a></td>
                </tr>
                       </c:forEach>   	
                       </table>		
                     </c:when>        
                     <c:otherwise>
                         <span> <i class="fas fa-books"></i></span>
                              찜한 도서가 없습니다. 
                       <!-- <button type="button" id=makeBookCart> <i class="fas fa-plus"></i> 새 책장 만들기 </button> -->
                     </c:otherwise>
             </c:choose>             
          </div>
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
                    <td> ${reviewRegdate} </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <input type="text" name="postTitleChk" id="postTitleChk" 
                        value="${reviewTitle}" readonly>     
                        <textarea name="postText" id="postText" readonly>  
                            ${reviewContent}
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
                <span><i class="fas fa-star"></i></span>
                <span><i class="fas fa-star"></i></span>
                <span><i class="fas fa-star"></i></span>
                <span><i class="fas fa-star"></i></span>
                <span><i class="fas fa-star"></i></span>
                <span id=starScore> 0 </span> 점
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
</div>
<!-- 
<script> 

    $('.bookStarScore span').click(function(){
        $(this).parent().children('span').removeClass('on');
        $(this).addClass('on').prevAll('span').addClass('on');
        $('.starJum01').click(function(){
            $('#starTxt').val($(this).length);       
        })
    }); 
    </script> -->
    <!-- 별점 구현 -->
    <script>
$(function() {

$('.bookStarScore span').click(function() {
  var starNum = $(this).index() +1;
  $('.bookStarScore span').css({color:'#979797'});
  $('.bookStarScore span:nth-child(-n+'+starNum+')').css({color:'#f1c40f'});
  $('#starScore').html(starNum-1);
});

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
        function uploadImg(here) {
            if(here.files && here.files[0]) {
                var reader = new FileReader();
                reader.onload = function(e) {
                    $('#imgimg').attr('src', e.target.result);
                }
                reader.readAsDataURL(here.files[0]);
            }
        }
    </script>
    <script>
    var cnt=0;
    var array =['.starJum01'];
        $(function(){
            cnt++;
            $('.starJum01').click(function(){
                $('#starJum').val(cnt);
            })
        })
    </script>
 <script>
  var $allChk = $('#allChk');
  $allChk.change(function () {
      var $this = $(this);
      var checked = $this.prop('checked');
      $('input[name="chkbox"]').prop('checked', checked);
  });
</script> 

<script>
  var modal = document.getElementById('modalGo');
  var openBtn = document.getElementById('modalOpen');
  var closeBtn = document.getElementsByClassName('close')[0]; 
  openBtn.onclick = function() {
     modal.style.display = "block";
  }
  closeBtn.onclick = function() {
    modal.style.display = "none";
  }
 window.onclick = function(event){
     if(event.target==modal) {
         modal.style.display = "none";
 
     }
 }
 </script>
 <script language=JavaScript>
 function allDelete(){
	 var array = new Array();
	 <c:forEach var="book" items="${libbooklist}">
	 	array.push(${book.bookNum});
	 </c:forEach>
	 alert(array);
	 if(array != null){
		 $.ajax({
			 url: "/booklist/deleteLibList",
			 type: "post",
			 dataType:"json",
	         data: {
	        	 "booknum" : array
	         },
	         success: function (response) {
	        	 alert(response);
	         },
	         error: function(request,status, error) {
	        	 alert("error"+request.status+"message : "+request.message);
	         }
		 });
	 }            
 }
 </script>
 <script>
    $(document).ready(() => {
      const li = document.querySelector('footer.fixed a[href="myLibrary.jsp"]').parentElement;
      const ul = li.parentElement;
      [ul, li].forEach(element => element.classList.add('active'));
    });
  </script>
<%@ include file="template/footer.jsp" %>
</body>
</html>