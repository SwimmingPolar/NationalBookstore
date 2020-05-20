<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap" rel="stylesheet">
    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
    <script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../../resources/styles/reset.css">
    <link rel="stylesheet" href="../../resources/styles/common.css">
    <script src="../../resources/js/common.js"></script>
    <link rel="stylesheet" href="../../resources/styles/interestedBook.css">
</head>
<body>
    <div class="interestTitle">
        <i class="fas fa-tasks"></i> 관심 카테고리
    
    </div> 
    
    <div class="bigBox2">
            <div class="title2">
                <div class="titleDetail">
    
                </div>
            </div>
            <div class="bookListBox">
                <ul>
                	<!-- label 이름 똑같이 쓰기-->
                    <!-- foreach 시작 -->
                    <li>
                        <div class="booklist">
                            
                            <form action="" method="post" name ="addLabelChk"></form>
                            <label for="chk1">
                            <div class="banner">
                                <img src="NationalBookstore/src/main/webapp/resources/images/myLibrary/example.jpg">  
                                <span class="text"> 판타지 </span>
                            </div>
                             </label>
                            <div class="addLabel">
                               <input type="checkbox" name="addLabelchk" id="chk1"> 
                               <label for="chk1"> 추가완료 </label>
                           </div>
                             
                             </form>
                             
                        </div>
                    </li>            
                 <!-- foreach 끝 -->
    
                </ul>
            </div>
    </div>
    <script>
         
         function addCategory(){
             var memeberId = $("#memberId").val();
    
             var chkchk = [];
            $("input[name='addLabel']:checked").each(function(i){
                chkchk.push($(this).val());
    
            });
    
    
            var allData ={"memberId":memberId, "chkchk":chkchk};
            $.ajax({
                url:" ",
                type:'post',
                data: allData,
                success : function(data) {
                    alert("추가가 완료되었습니다.");
                    window.opener.location.reload();
                    self.close();
    
                },
                error:function(jqXHR, textStatus, errorThrown) {
                    alert("에러가 발생했습니다.");
                    self.close();
                }
            });
    
         }
    
    
    </script>
</body>
</html>