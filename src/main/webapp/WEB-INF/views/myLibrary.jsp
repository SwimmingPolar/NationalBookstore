<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

	<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="member"/>
</sec:authorize>
     <header class="topbar">
        <nav>
          <div class="container">
            <a href="javascript: history.back();"><i class="far fa-arrow-left"></i></a>
            <c:choose>
            	<c:when test="${checkId}">  <h2>${followId.memberNickName } 님의 서재</h2></c:when>
            	<c:otherwise> <h2>내 서재</h2></c:otherwise>
            </c:choose>
          </div>
        </nav>
      </header> 
<div class="wrapper">
<div class="firstColumn">
<!-- 배경화면 넣는곳 -->
<div class="follow">

   	<c:if test="${checkId}">
   		<c:if test="${followCheck eq false }">
   			<button type="button" id="followBtn"> <i class="fas fa-plus-circle"></i> 팔로우 </button>
     	</c:if>
     </c:if>    
    <button type="button" id="categoryAdd" onclick="location.href='interestedBook.jsp'"> <i class="fas fa-plus"></i> 관심 카테고리 </button>
     
  </div>
<div class="bigbox">
<div class="myImage"> 
    <a href="#"><img id="myFaceImage" src="${pageContext.request.contextPath }/resources/images/myLibrary/picture1.png" ></a>   
</div>
<div class="myNickname">
		<c:choose>
			<c:when test="${checkId}"> <a> ${followId.memberNickName }<%-- ${ryanMember.memberNickName } --%> </a> 님의 서재  </c:when>
			<c:otherwise><a>  ${member.member.memberNickName }  </a> 님의 서재 </c:otherwise>
		</c:choose>
</div>
</div>
<div class = "manyBtn">
    <ul>
        <li><a href="#"> 읽은 책 <b>( ${readbookcount } )</b> </a></li>
        <li><a href="#"> 좋아요 <b>( ${likeBookcount } )</b> </a></li>
   	    <li><a href="#" id="modalOpen"> 팔로우 <b>( ${myFollower} )</b> </a></li>
    </ul>
</div>
<div class="goSubscribe">
<c:if test="${checkId eq false}">
<a href="goSubscribe.jsp"> 
  <b> 정기구독 시작 </b><br>
  <em> 바로가기 </em> 
  <i class="fas fa-arrow-circle-right"></i>
</a>
</c:if>
    
</div>

</div>
<!-- firstColumn end -->

<div class="secondColumn">
    <input type="radio" name="myPage" id="mybook" checked><label for="mybook"> 내 책</label>
    <input type="radio" name="myPage" id="mybookcart"><label for="mybookcart">책장</label>
   <c:if test="${checkId eq false}"><input type="radio" name="myPage" id="mypost"><label for="mypost">포스트</label></c:if>
    
     <div class="content one">
        <div class="mybookTitle">
            <a> ${readbookcount} </a> 권의 도서
        </div>
         <c:choose>
          <c:when test="${readbooklist.size() >0 }">
        <div class="myBookbook">
          <ul>
            <c:forEach var="readbook" items="${readbooklist}">
						<li><a href="/book/bookdetail?booknumber=${readbook.bookNum }">
							<div class="books">
								<div class="mybookimage">
										<img src="${pageContext.request.contextPath }${readbook.bookThumbnail }" alt="없음">
								</div>
								<div class="names">
									<strong>${readbook.bookTitle}</strong> <br> <span>${readbook.bookWriter}</span>
								</div>
							</div> <!-- books end -->
						</a></li>
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
           	  <c:if test="${checkId eq false}">
              <label for="allChk">
              <input type="checkbox" name="allChk" id="allChk"> 전체선택
              </label>    
              <button type="button" id="allDelete"> 선택삭제 </button>   
              </c:if>   
            </div>
            <div class="ebookList" id="ebooklist" > 
                 <c:choose>
                     <c:when test="${libbooklist.size() >0 }">
                  <table>
                     <c:forEach var="book" items="${libbooklist}">
                          <tr>
                  <td><input type="checkbox" name="chkbox" id="chkbox" value="${book.bookNum }"></td>
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
                <c:if test="${checkId eq false}">
                  <td><button type="button" id="goRead">바로보기</button>
                  <a href="/booklist/deleteLibList?booknum=${book.bookNum }" id=eachDelete>삭제</a></td>
                  </c:if>
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
    <c:if test="${checkId eq false}">
     <div class="content four">

        <div class="mybookTitle">
        	   나의 포스트 <a>0</a> 개
        </div>
        <div class ="postInputBtn">
        <button type= "button" id = postInput onclick="openNewPost()"> <i class="fas fa-pencil-alt"></i> 포스트 작성</button>
        </div>
            
        <div class="myPostCheck" id="myPostCheck">
         <c:choose>
          <c:when test="${myreviewlist.size() >0 }">
          <table>
          <c:forEach var="review" items="${myreviewlist}">
                <tr>
                    <th> 도서명 </th>	
                    <th> 내용 </th>
                    <th> 등록날짜 </th>
                </tr>
                <tr>
                	<td>${review.reviewTitle}<td>
                    <td>
                    	<textarea name="postText" id="postText" readonly>  
                            ${review.reviewContent}
                        </textarea>
                    </td>
                    <td>${review.reviewRegdate}<td>
                </tr>
             		  </c:forEach>
           	 		</table>
           	 	</c:when>
	     	 </c:choose> 
        </div>

        <form id="postRegister" action="/review/write" method="get">  
        <div class="postInsert" id="postInsert">
            <select name="bookSelect" id="bookSelect">
              <c:forEach var="list" items ="${libbooklist}">
                <option value="bookChoice"> ${list.bookTitle} </option>
              </c:forEach>
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

            <input type="text" name="reviewTitle" id="postTitle" placeholder="제목을 입력하세요">
            <textarea name="reviewContent" id="post_Content" placeholder="솔직한 생각을 입력해주세요."></textarea>

            <div class="postEndBtn">
                <button type="button" id="postSave"> 저장 </button>
                <button type="button" id="postCancel"> 취소 </button>
            </div>
             </div> 
          </form>
     </div>
     </c:if>
</div>

<!-- 팔로우 모달창 -->
<div id ="modalGo" class="modal">
    
  <div class="modal_content">
    <span id="modalCloseBtn">
      <button type="button" > <i class="fas fa-times-circle"></i> </button>
  </span>

  <span class="followNum">
    <i class="fas fa-user-plus"></i> 팔로우한 사람들
  </span>

  <div class = "likeList"> 
  <ul>
    <c:choose>
    <c:when test="${followerList.size() > 0 }">
	<c:forEach var="foll" items="${followerList }">
          <li><img id="myFace" src="${pageContext.request.contextPath }/resources/images/myLibrary/picture1.png" ></li>
          <li><a href="/booklist/myLibList?clickId=${foll.fkMemberFollow2 }"> ${foll.memberNickName} </a>님</li>
     </c:forEach>
     </c:when>
     <c:otherwise>
     	<li><img id="myFace" src="${pageContext.request.contextPath }/resources/images/myLibrary/picture1.png" ></li>
     	<li>친애하는 셀럽님이 없습니다</li>
     </c:otherwise>
</c:choose>
          </ul>
    </div>
  </div>
</div>
</div>

<!-- 별점 등록 -->

<script>
$(document).ready(function(){
	$("#followBtn").on('click',function(){
		var followId = "${followId.memberEmail}";
		$.ajax({
			url:"/follow/requestFollow",
			type:"get",
			data:{
				following:followId
			},
			success:function(data){
				if(data){
					alert("팔로우 되었습니다.");
					//$("#followBtn").css("display","none");
					$("#followBtn").text("팔로우취소");
				}else{
					alert("오류가 발생하였습니다. 고객센터로 문의해주세요");
				}
			},
			error:function(){
				alert("오류가 발생하였습니다. 고객센터로 문의해주세요");
			}
		})
	});
});
</script>

<script>
$(document).ready(function(){
	
	$("#allDelete").on('click',function(){
		var count=0;
		var array = [];
		var memberEmail = "${member.member.memberEmail}";
		$("input[name=chkbox]:checked").each(function(){
			array.push($(this).val());
		});
		$.ajax({
			url:"/booklist/deleteLibList",
			type:"post",
			traditional:true,
			data:{
				booknum:array,
				memberEmail : memberEmail
			},
			success:function(data){
				if(data ==null || data == ""){
					console.log("data 받음"); //다 삭제했을때 
					// 데이터가 없을 시 .. 찜 목록이 없습니다. 표tl
					$('#ebooklist tbody').html('');
					$('#ebooklist').append(" <span> <i class='fas fa-books'></i></span>찜 목록이 없습니다");
				}else if(data.length > 0){
					//있으면 데이터 보여주기
					$('#ebooklist tbody').html('');
					for(var index=0;index<data.length;index++) {
		 				$('#ebooklist tbody').append("<tr>"
		               +"<td>"
		 						+"<input type='checkbox' name='chkbox' id='chkbox' value="+data[index].bookNum +"'></td>"
		               +"<td>  <a href='/book/bookdetail?booknumber="+data[index].bookNum+"'>" 
		               +"<img src='"+${pageContext.request.contextPath }data[index].bookThumbnail +"'alt='없음'>"
		               +"</a> </td><td> <ul><li> <strong>"+data[index].bookTitle+"</strong> </li>"
		               +"<li> <a>"+data[index].bookWriter+"지음</a>  </li>"
		               +"<li> <span>"+data[index].bookPublisher+"</span></li>"
		               +"</ul>"
		               +"</td>"
		               +"<td><button type='button' id='goRead'>바로보기</button>"
		               +"<a href='/booklist/deleteLibList?booknum="+data[index].bookNum +"' id=eachDelete>삭제</a></td>"
		            	+"</tr>");
		 			}
			                     
				}
			},
			error:function(){
				alert("에러");
			}
		});
	});	
});


</script>

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

<!-- 별점 보여주기 -->
<script>
 
  $(function() {
     var rating = $('.myreviewScore');
 
     rating.each(function(){
         var score = $(this).attr('data-rate');
         console.log(score);
         $(this).find('span:nth-child(-n+'+score+')').css({color:'#f1c40f'});
        //  $('#starScore').html(targetScore);
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
  var closeBtn = document.getElementsByClassName('modalCloseBtn'); 
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

 <script>

    $(document).ready(() => {
      const li = document.querySelector('footer.fixed a[href="/booklist/myLibList"]').parentElement;
      const ul = li.parentElement;
      [ul, li].forEach(element => element.classList.add('active'));
    });
  </script>

  <script>
  
  function allDelte(){
	  location.href = "/booklist/allDelte";
  }
    
  </script>
  <script>
    /* var cnt=0; */
function followClick(){
  /* cnt++; */
  var btn = document.getElementById('followBtn');
  
    btn.innerHTML="팔로잉";
    btn.style.backgroundColor="transparent";
    
 /*  }else {
    btn.innerHTML="<i class='fas fa-plus-circle'></i> 팔로우";
    btn.style.backgroundColor="#17769c";
    
  } */

}
  </script>
<%@ include file="template/footer.jsp" %>
</body>
</html>