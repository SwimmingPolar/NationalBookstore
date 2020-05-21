<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="../../../../resources/styles/myInfoUpdate.css">
    <link href="https://fonts.googleapis.com/css?family=Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap" rel="stylesheet">
    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
    <script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
    <script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
    <link rel="stylesheet" href="../../../../resources/styles/reset.css" />
    <link rel="stylesheet" href="../../../../resources/styles/common.css" />
    <!-- jQuery CDN -->
    <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
    <!-- slidify sliders and fadeInUp reveal -->
    <script src="../../../../resources/js/common.js"></script>

<body>
<sec:authentication property="principal" var="member"/>
    <header class="topbar">
        <nav>
          <div class="container">
            <a href="javascript: history.back();"><i class="far fa-arrow-left"></i></a>
            <h2> 개인정보수정 </h2>
          </div>
        </nav>
      </header>
    <div class="newMyInfo">
        <div class="imageBox">
            <img id="myFaceImage" src="${pageContext.request.contextPath}${member.member.memberProfile}" >
            <!-- 사진 넣을거임 -->
            <label for="camera">
                <i class="fas fa-camera-retro"></i>
                <input type="file" name="memberProfile" id="camera" onchange="uploadMyImg(this);">
            </label>
                   <button type="button" id="deleteBtn" onclick="deletePhoto();"><i class="fas fa-times"></i></button> 
        </div>
        <!-- imageBox end -->
        <div class="wrapperOne">
        <p>필명</p>
        <div class="updateLists">
            <script type="text/javascript" >
            	document.addEventListener("DOMContentLoaded", function() {
            		$("#nickNameChk").on("click", function() {
            			chkNickName();
            		});
            		$("input[name=nickName]").on("focus blur keyup", function() {
            			chkNickName();
            		});
            		
            		function chkNickName() {
            			var memberVO = [];
	            		var currentNickname = $("input[name=nickName]").val().toLowerCase();
            			memberVO.push({memberNickName : currentNickname});
	            		$.ajax({
	            			url : "/member/signUpCheck",
	            			type : "POST",
	            			data : { memberNickName : currentNickname }
	            		})
	            		.done(function(data) {
	            			//true면 없는거, false면 있는거
	            			var result = data.result;
	            			$("button[class=chkBtn]").attr("disabled", false);
	            			if(result == true) {
	            				$("div.nickNameAlert").css("display",  "none");
	            				$("button[class=chkBtn]").attr("disabled", false);
	            			} else {
	            				$("div.nickNameAlert").css("display",  "block");
	            				$("button[class=chkBtn]").attr("disabled", true);
	            			}
	            		})
	            		.fail(function() {
	            			console.dir("중복체크 실패!");
	            		});
            		};
            	});
            </script>
            <input type="text" name="nickName" id="nickName ">
           	<%-- <button type="button" id="nickNameChk">중복확인</button> --%>
        </div>
        <div class="nickNameAlert" ><i class='fas fa-exclamation-circle'></i>중복된 닉네임입니다.</div>
        <span style ="color:rgb(194, 16, 16)">  <i class='fas fa-exclamation-circle'></i> 욕설, 비속어 사용 시 서비스 이용이 제한될 수 있습니다. </span>
        </div>
<!-- wrapperOne end -->
        <div class="wrapperOne_half">
            <p>비밀번호 </p>
            <input type="password" name="memberPw" id="inputPw" maxlength="16" onKeyup="inputText(this);" placeholder="비밀번호 입력">
            <!-- <span id="hereChk">영문, 숫자를 포함한 8 ~ 16자 조합으로 입력해 주세요. </span> -->
            <span id="hereText">8자 이상, 16자 이하로 입력해주세요.</span>
            <input type="password" name="memberPw" id="inputPwAgain" placeholder="비밀번호 재입력" onkeyup="pwRechk();">
            <span id="rechkPW"></span>
        </div>
        <hr class="firstLine">
        <!-- updateLists end -->
        <div class="wrapperTwo">
            <p>핸드폰 번호</p>
            <div class="phoneUpdate">
            <input type="text" name="memberTel" id="phoneNum">
            <span> ※ ' - ' 없이 숫자로만 입력해주세요. </span>
            </div>
    
            <!-- <div class="updateMail">    
            <div class="input">
                <input type="text" name="mailAdrsB" id="mailAdrsA" placeholder="이메일 입력">
            </div> 
            <span> @ </span>    
            <div class="dis">
                <input type="text" name="mailAdrsA" id="mailAdrsB" placeholder="직접 입력" disabled>
            </div>       
            </div>
            <div class="mailChoice">
                <select name="mchoice" id="mchoice" onchange="clickHere();">
                    <option value="hotmail.com">hotmail.com</option>
                    <option value="naver.com">naver.com</option>
                    <option value="gmail.com">gmail.com</option>
                    <option value="hanmail.com">hanmail.net</option>
                    <option value="nate.com">nate.com</option>
                    <option value="selfInput" id="selfInput" selected>직접입력</option>
                </select>
             </div>     -->
             
            <!-- mailChoice end -->
            <hr class="secondLine">        
           </div>
    <!-- wrapperTwo end -->
       <div class="wrapperFour">
        <p> 주소 </p>
     <div class="address1">
        <button type="button" id="zipCodeSearch" onclick="zipCodeClick()">검색</button>
        <input type="text" name="memberZipcode" id="homeZipcode" >
        <input type="text" name="memberaddress" id="homeAdrs">
     </div>
     <div class="address2">       
        <input type="text" name="memberDaddress" id="homeDetail" placeholder="상세 주소를 입력해주세요.">
        </div>
     </div>
       <div class="wrapperThree">   
        <div class="infoAgree"> 
            <label for="infoChk"><input type="checkbox" name="infoChk" id="infoChk"> <span>개인정보 수집 및 이용 동의</span> </label>
        </div>  
        <div class="infoChkList">
            <ul>
                <li>개인정보 수집 목적: 원활한 서비스 이용을 위해 정보를 수집합니다.</li>
                <li>개인정보 수집항목: 프로필 이미지, 필명, 아이디, 비밀번호, 이메일, 주소 </li>
                <li>개인정보 이용기간: 회원 탈퇴 시 또는 개인정보처리방침에 따라 보유 및 파기 됩니다.</li>            </ul>
        </div>
    <div class="finishBtn">
        <div class="btn1">
        <button type="button" class="resetBtn" onclick="history.back()">취소</button>
    </div>
    <div class="btn2">
        <button type="button" class="chkBtn" onclick="updateFinish();">확인</button>
    </div>
    </div>
       </div>
        </div>
    <!-- 제일 큰 박스 end -->

 <!--이메일 주소 자동입력 &직접입력  -->
    <script>
        function clickHere() {
            var selectHere = document.getElementById('mchoice').value;
                // document.getElementById('mailAdrsB').value=selectHere;
            if(selectHere=='selfInput'){
                var x = document.getElementById('mailAdrsB');
                x.disabled = false;
                x.style.backgroundColor='white';
                // x.style.color='#e8e8e8';
                x.value="";

            }else {
               var y= document.getElementById('mailAdrsB');
                y.disabled = true;
                y.value=selectHere;
                y.style.backgroundColor='#f5f5f5';
                // alert(y);
            }
        }
    </script>

<!-- 프로필 사진 미리보기 -->
<script>
        
    function uploadMyImg(here) {
           if(here.files[0]) {
               var reader = new FileReader();
               reader.onload = function(e) {
                   $('#myFaceImage').attr('src', e.target.result);
               }
               reader.readAsDataURL(here.files[0]);
           }
       }

</script>

<!-- 프로필사진 x 버튼 누를시 삭제기능 -->
    <script>   
    function deletePhoto() {
        // var aa = document.getElementById('');
        
        if(confirm('기본이미지로 변경하시겠습니까?')==true) {
        document.getElementById('myFaceImage').src="../../resources/images/myLibrary/picture1.png";
        }else {
            return false;
        }
    }
    </script>

<!-- 비밀번호 유효성 검사 -->
    <script>
        function pwRechk(){
            var pw = document.getElementById('inputPw').value;
            var pwChk = document.getElementById('inputPwAgain').value;
            var chk = document.getElementById("rechkPW");

            if(pw==""||pwChk=="") {
                chk.innerHTML="비밀번호를 입력해주세요.";
                chk.style.color="#999";
            }else if(pw!=pwChk) {
                chk.innerHTML="<i class='fas fa-exclamation-circle'></i>"+" 비밀번호가 맞지 않습니다. 다시 입력해주세요.";
                chk.style.color="red";
            }else if(pw.length<=7){
                chk.innerHTML="<i class='fas fa-exclamation-circle'></i>"+" 8자이상 16자 이하로 입력해주세요.";
                chk.style.color="red";
            }else {
                chk.innerHTML="<i class='far fa-check-circle'></i>"+" 비밀번호가 일치합니다.";
                chk.style.color ="#0099FF";
            }
        }
    </script>

     <script>
        function inputText(here) {
            var pw = here.value;
            var msg = ""; 

            if(pw.length) {
                if(pw.length==""||pw.length<=4) {
                    msg = "8자 이상, 16자 이하로 입력해주세요.";
                }else if(pw.length <9) {
                    msg= " 보안이 취약한 비밀번호입니다.";
                }else {
                    msg = " 보안이 강력한 비밀번호입니다.";
                } 
            }
            document.getElementById("hereText").innerHTML = msg;         
        }
    </script>
<!-- 주소 검색 -->
    <script>
       function zipCodeClick() {
        new daum.Postcode({
            oncomplete: function(data) {
                $('[name=memberZipcode]').val(data.zonecode);
                $('[name=memberaddress]').val(data.address);
                $('[name=memberDaddress]').val(data.buildingName);
            }
        }).open();
     }
    </script>

    <!-- 마지막 확인버튼 누를시  -->
    <script>
        function updateFinish(){
            var infoChk =document.getElementById('infoChk');
            var inputChk = document.getElementsByTagName("input");
            var inputTag="";
            var cnt=0;
            // for(var i=0; i< inputChk.length; i++) {
            //     var inputTag =inputChk[i];
            //     if(inputTag.value==""){
            //         cnt++;
            //        alert(cnt);
            //     }
            // }
            if(infoChk.checked==false){
                    alert("개인정보 수집 및 이용에 동의해주세요.");
            }
        }
    </script>
  <script>
    $(document).ready(() => {
      const li = document.querySelector('footer.fixed a[href="/myaccount"]').parentElement;
      const ul = li.parentElement;
      [ul, li].forEach(element => element.classList.add('active'));
    });
  </script>
  <%@ include file="../../template/footer.jsp" %>
</body>
</html>