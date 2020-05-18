<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>    
    <link href="https://fonts.googleapis.com/css?family=Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../../resources/styles/serviceCenter.css">
    <script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../../resources/styles/reset.css">
    <link rel="stylesheet" href="../../resources/styles/common.css">
    <script src="../../resources/js/common.js"></script>
</head>
<body>
    <header class="topbar">
        <nav>
          <div class="container">
            <a href="javascript: history.back();"><i class="far fa-arrow-left"></i></a>
            <h2>고객 센터</h2>
          </div>
        </nav>
      </header>
<div class="bigBox">
      <div class="tabBox">
          <ul class="tabs">
                <li>
                  <a href="#" id= "here" rel="one">
                      문의하기
                    </a>
                </li>
                <li>
                    <a href="#"id="here" rel="two">
                      문의내역
                   </a>
                </li>
          </ul>
      </div>

         <div class="contentBox one" id="one">
            <div class="goQuestion">
              <div id="selectTopic">
                <button type="button" id="topic"> 
                    <strong>회원 정보 문의</strong><span><i class="fas fa-chevron-down"></i></span>
                </button>
                <ul>
                    <li> <a href="#">회원 정보 문의</a> </li>
                    <li> <a href="#">결제/취소/환불 문의</a> </li>
                    <li> <a href="#">구독/서비스이용 문의</a> </li>
                    <li> <a href="#">배송 문의</a> </li>
                    <li> <a href="#">도서관련 문의</a> </li>
                    <li> <a href="#">기타 문의</a> </li>
                </ul>
              </div>
              <!-- selectTopic end -->
              <div class="title">
                  <input type="text" id="titleName" placeholder="제목을 입력하세요.">
                <textarea id="matter">어떤 문제가 있으신가요? 아래 내용을 자세히 적어주시면 문제를 더욱 빨리 처리할 수 있습니다.

(*문제가 발생하는 화면 또는 영상을 첨부해주시면 문제 해결에 큰 도움이 됩니다.)

                </textarea>
               </div>
            </div>
            <div class="addNotice">
                <ul>
                    <li>문의 [제목]과 [내용]란에는 절대 개인정보를 입력하지 마세요.</li>
                    <li>문의에 개인정보가 포함되어 있거나, 중복 문의인 경우에는 삭제될 수 있습니다.</li>
                    <li>문의에 욕설, 인격침해, 성희롱 등 수치심을 유발하는 표현이 있다면 상담이 중단될 수 있습니다. </li>
                </ul>
            </div>
            <label for="fileLabel">첨부파일</label>
            <div class="addFile">
                <!-- <input type="text" name="fileTxt" id="fileTxt"> -->
                <input type="file" name="userFile" id="userFile">
            </div>
            <p>문제가 발생하는 화면 캡쳐 이미지나 영상을 첨부해주세요.(최대 500KB까지 가능)</p>
        
            <label for="mailInput">
                이메일
            </label>
            <div class="email">
                <input type="text" name="email" id="email">
            </div>
            <label for="tellInput">
                연락처
            </label>
            <div class="tell">
                <input type="text" name="tell" id="tell">
            </div>

        <div class="agreeChk">
            <label for="chkbox">
            <input type="checkbox" name="chkbox" id="chkbox">
                개인정보 수집 및 이용 동의
            </label>
            <ul>
                <li> 1. 개인정보의 수집ㆍ이용 목적
                    밀리의 서재에서는 문의하신 내용에 대한 원인파악 및 원활한 상담을 위해 개인정보를 수집하고 있습니다. 수집된 개인정보는 상담 외 다른 용도로 사용되지 않습니다.
                </li>
                <li>
                    2. 수집하는 개인정보의 항목
                이메일, 연락처(휴대폰 번호), 단말 기기의 OS버전 정보, 앱 버전, 인터넷 환경에 대해, 고객님이 제공하시는 정보에 한해 수집합니다.

                </li>
                <li>
                    3. 개인정보의 보유ㆍ이용 기간
                    수집된 개인정보는 회원탈퇴 시점 또는 관련 법령(소비자의 불만 또는 분쟁처리에 관한 기록 3년)에 근거한 기간 동안 보관 후 삭제됩니다.
    
                </li>
            </ul>

        </div>
        <div class="btn">
            <button type="button" id="preBtn" onclick="location.href='myAccount.jsp'">이전</button>
            <button type="button" id="finishBtn">문의하기</button>
        </div>
        </div>
         <!--one end  -->


         <div class="contentBox two" id="two">
            <div class="what">
            <div class="noHave">
                <i class="fas fa-tasks"></i>
            </div>
            <span> 문의 내역이 없습니다. </span> 
          </div>

          </div>
</div>
  
<script>



$('document').ready(function(){
    $('.contentBox').hide();
    $('.contentBox').eq(0).show();

    $('ul.tabs li a').click(function(){
        $('ul.tabs li a').removeClass('active');
        $(this).addClass('active');
        $('.contentBox').hide();
        var opentab = $(this).attr('rel');
        $('#'+opentab).fadeIn();
        
    })

})


</script>
</body>
</html>