<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="../../resources/styles/myInfoUpdate.css">
    <link href="https://fonts.googleapis.com/css?family=Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap" rel="stylesheet">
    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
    <script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>



<body>
<div class="title">
        <h3> 개인정보수정 </h3>
    </div>

    <div class="newMyInfo">
        <div class="myInfoDeleteBtn">
            <button type="button" id="delete" onclick="location.href='deleteMyInfo.jsp'">회원탈퇴</button>
        </div>

        <div class="imageBox">
            <img id="myFaceImage" src="../../resources/image/picture1.png" >
            <!-- 사진 넣을거임 -->
            <label for="camera">
                <i class="fas fa-camera-retro"></i>
                <input type="file" name="camera" id="camera" onchange="uploadMyImg(this);">
            </label>
                   <button type="button" id="deleteBtn"><i class="fas fa-times"></i></button> 
        </div>
        <!-- imageBox end -->
        <div class="wrapperOne">
        <p>필명</p>
        <div class="updateLists">
            <input type="text" name="nickName" id="nickName ">
            <button type="button" id="nickNameChk">중복확인</button>
        
        </div>
        <span> 욕설, 비속어 사용 시 서비스 이용이 제한될 수 있습니다. </span>
        </div>
<!-- wrapperOne end -->

        <div class="wrapperOne_half">
            <p>비밀번호 </p>
            <input type="password" id="inputPw" placeholder="비밀번호 입력" onclick="inputText();">
            <span>영문, 숫자를 포함한 8~16자 조합으로 입력해 주세요. </span>
            <input type="password" name="inputPwAgain" id="inputPwAgain" placeholder="비밀번호 재입력" disabled>
            <span>비밀번호 확인을 위해 비밀번호를 다시 한 번 입력해 주세요.</span>
        </div>


        <hr class="firstLine">
        <!-- updateLists end -->
       <div class="wrapperTwo">
        <p>이메일</p>
        <div class="updateMail">
        
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
                <option value="selfInput" id="selfInput">직접입력</option>
            </select>
         </div>    
        <!-- mailChoice end -->

        <hr class="secondLine">  
         
       </div>
    <!-- wrapperTwo end -->

       <div class="wrapperFour">
        <p> 주소 </p>
     <div class="address1">
        <button type="button" id="zipCodeSearch" onclick="zipCodeClick();">검색</button>
        <input type="text" name="homeZipcode" id="homeZipcode" >
        <input type="text" name="homeAdrs" id="homeAdrs">
     </div>
     <div class="address2">    
        
        <input type="text" name="homeDetail" id="homeDetail">
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
                <li>개인정보 이용기간: 회원 탈퇴 시 또는 개인정보처리방침에 따라 보유 및 파기 됩니다.</li>

            </ul>

           

        </div>

        <button type="button" class="chkBtn">확인</button>

       </div>



        </div>
    <!-- 제일 큰 박스 end -->

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


    <script>

        /* function zipCodeClick() {
            new daum.PostCode({
               oncomplete: function(data) {
                   var roadAdrs = data.roadAddress;
                   var roadAdrs2 = '';

               if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                   roadAdrs2 += data.bname;
               } 
               if(data.buildingName !== '' && data.apartment == 'Y') {
                   roadAdrs2 += (roadAdrs2 !== ''?', ' + data.buildingName: data.build)
               }
               if(roadAdrs2!=='') {
                   roadAdrs2 = '( ' + roadAdrs2 + ')';
               }    
               if(roadAdrs !=='') {
                   roadAdrs += roadAdrs2;
               }

               document.getElementById('homeZipcode').value = data.zonecode;
               document.getElementById('homeAdrs').value = roadAdrs;
               document.getElementById('homeDetail').focus();

               }

            }).open();
            
        }
 */

    </script>

    <script>
/* 
        function inputText() {
            var pw = document.getElementById('inputPw');
            
            if(!pw.value=='') {
                alert(pw);
            alert(pw.value);
            alert(pw.length);
            alert(pw.value.length);
                var pw2 =document.getElementById('inputPwAgain');
                pw2.disabled=false;
                pw2.style.backgroundColor='white';

            }else {
                
            }

        }
 */

    </script>



</body>
</html>