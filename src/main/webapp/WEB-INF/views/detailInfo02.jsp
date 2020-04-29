<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <link rel="stylesheet" href="../../resources/css/detailInfo.css">
    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
    <script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

</head>
<body>

    <header>
        National Bookstore
    </header>
    <div class="wrapper">
    <div class="top-container">
        <div class="leftBox">
    <div class="imageBox">
     <img src="../../resources/image/book02.jpg" alt="없음">
    </div>
    <div class="preview">
    <a href="preview.html" onclick="window.open(this.href, '좋아요','width=1000, height=700');return false;" target="_blank" 
    style="color:black;">
        <i class="fas fa-search"></i> 미리보기</a>
    </div>

</div>
    <!-- imageBox -->
    <div class="introWrite">
    <h3> 책 제목 입력하는 곳입니다. </h3>
    <ul>
        <li> 저자이름 </li>
        <li style="color:gray; "> 출판사 / 출판날짜 </li>
        <li style="color:lightgray;""> 장르/분류 : 기술> aa > bb </li>
    </ul> 

    <div class ="bookStarScore">
        <i class="fal fa-star empty"></i>
        <i class="fal fa-star empty"></i>
        <i class="fal fa-star empty"></i>
        <i class="fal fa-star empty"></i>
        <i class="fal fa-star empty"></i>

        <i class="fas fa-star full"></i>
        <i class="fas fa-star full"></i>
        <i class="fas fa-star full"></i>
        <i class="fas fa-star full"></i>
        <i class="fas fa-star full"></i>

    </div>

    <div class="choiceBtnOne">
        <input type="button" value="바로보기" class="choiceBtn">
        <input type="button" value="다운로드" class="choiceBtn">
        <input type="button" value="종이책 구매" class="choiceBtn">

    </div>
    <div class ="likeChk">
    
        <a href="#modalGo" id="modalOpen">
        <span class="likePeople">
            <i class="far fa-user-circle prof" ></i>
            <i class="fas fa-user-circle prof" ></i>
            <i class="far fa-user-circle prof" ></i>
          
        </span>
        <span class="likePeople2" style="color: black;">
            좋아하는 사람들
        </span>
    </a>
        <span class="likeBtn">
            <div class="heartSoo">
            <input type="text" value="0" id='countNum' size='5' >
            </div>
            <div class="heartC">
            <!-- <c:if test="${id != null}"> -->
            <form action="">
                <input type="checkbox" id="heartClick">
                <label for="heartClick">
                    <i class="far fa-heart" aria-hidden="true"></i>
                    <i class="fa fa-heart" aria-hidden="true"></i>
                </label>
            </form>
          <!-- </c:if> -->
            </div>
        </span>

    </div>  
    <!-- likeChk end -->
<div id ="modalGo" class="modal">
    
        <h2> 테스트 중 </h2>
    <div class="modal_content">
        모달창 예시입니다.
    </div>

</div>

    </div>
    <!-- introWrite -->

    </div> 
    <!-- top-container -->


    <div class="body-container"> 

        <div class="firstBox">
            <h2>  # 감성태그 </h2>
            
            <div class="hashtagDetail"> 

                <div class="hashTag">       
                <form action="" method="post" name="hashtagChk"> 

                    <input type="checkbox" name="tagChkbox" id="chk1" onclick="chkboxCnt(this)"> 
                    <label for="chk1"> #좋아요
                    </label>
                    <input type="checkbox" name="tagChkbox" id="chk2" onclick="chkboxCnt(this)">
                    <label for="chk2"> #특이해요
                    </label>
                    <input type="checkbox" name="tagChkbox" id="chk3" onclick="chkboxCnt(this)">    
                    <label for="chk3"> #과거세대와의 소통
                    </label>
                    <input type="checkbox" name="tagChkbox" id="chk4" onclick="chkboxCnt(this)">
                    <label for="chk4"> #노잼
                    </label>
                    <input type="checkbox" name="tagChkbox" id="chk5" onclick="chkboxCnt(this)">
                    <label for="chk5"> #표지부터 소장각
                    </label>
                </form>
                </div>
                <form action="" method="POST"></form>
                <input type="text" name="emoTag" class="emoTag" placeholder ="해시태그를 입력해주세요 (최대 6자)">
                <input type="button" value="남기기" class="inputBtn">
            
            </div> 
        </div>

        <!-- firstBox end -->

        <div class="secondBox">
            <h2> 책소개 </h2>
            <div class="bookDetail">
                책소개하는 칸입니다. 

‘이 소설 자체가 순수한 마법’이라는 최고의 극찬을 받으며 2017년 뉴베리 수상의 영광을 차지한 작품이다. 고요하지만 위험한 숲속에 해마다 아기가 버려진다. 또한 매년 그런 아기를 구하러 오는 마녀가 있다. 그런데 이상하다. 마녀 잰은 유독 이번 아기에게 눈길을 빼앗긴다. 그러다가 그만 실수로 아기에게 달빛을 먹이고 만다. 사실 달빛에는 어마어마한 마법이 깃들어 있다.

잰은 어쩔 수 없이 분화구 가장자리 늪에 있는 자신의 집으로 아기를 데려간다. 그렇게 마법 아기 루나는 기억을 꽁꽁 감추고 사는 마녀 잰, 시를 사랑하는 늪 괴물 글럭, 망상 속에 사는 용 피리언과 함께 이상한 가족의 일원이 된다. 마법이 무엇인지도 모른 채 온갖 말썽을 부리며 자라는 루나와 그런 루나에게 무한한 사랑과 우정을 보여주는 가족들.

하지만 루나는 점차 자신의 정체성에 혼란을 느끼고 이런저런 의문에 시달린다. 또한 미쳐서 탑에 갇힌 한 여자의 환영에 아련한 향수마저 느끼는데…. 사실 가족 모두에겐 저마다 묻어둔 아픔이 있고 그것은 ‘보호령’이라는 도시와 깊은 연관이 있다. 해마다 숲속 마녀에게 아기를 갖다 바쳐야 한 해가 무사하다고 믿는 슬픔의 도시 보호령의 진짜 비밀은 무엇일까?

과연 달빛 마신 소녀 루나와 이상한 가족들은 보호령의 검은 장막을 걷어내고 사람들을 무겁게 휘감은 슬픔과 두려움을 사라지게 할 수 있을까? 이들이 펼치는 사랑과 모험의 환상적인 달빛 마법이 시작된다.

            </div>
            <input type="button" value="더보기" class="moreChk">
            
        </div>
        <div class="thirdBox">
            <h2> 목차 </h2> 
            <div class="listDetail"> 목차 칸입니다. 
                1장 이야기를 하다∥2장 불행한 여자가 미쳐 버리다 ∥ 3장 마녀가 실수로 아기에게 마법을 걸다 ∥ 4장 그냥 꿈일 뿐인 이야기 ∥ 5장 늪 괴물도 결국 사랑에 빠지다 ∥ 6장 앤테인이 곤경에 처하다 ∥ 7장 마법의 아이가 좀 지나치게 골칫거리다 ∥ 8장 이야기에 일말의 진실이 있다 ∥ 9장 여러 가지 문제가 발생하다 ∥ 10장 마녀가 문을 찾고 기억도 찾다 ∥ 11장 마녀가 결단을 내리다 ∥ 12장 아이가 습지에 관해 배우다 ∥ 13장 앤테인이 미친 여자를 만나러 가다 ∥ 14장 행동에 결과가 따르다 ∥ 15장 앤테인이 거짓말을 하다 ∥ 16장 종이가 너무나 많다 ∥ 17장 호두알에 갈라진 틈이 있다 ∥ 18장 마녀가 발각되다 ∥ 19장 자유도시에 다녀오다 ∥ 20장 루나가 이야기하다 ∥ 21장 피리언이 장화를 발견하다 ∥ 22장 다른 이야기가 있다 ∥ 23장 루나가 지도를 그리다 ∥ 24장 앤테인이 해결책을 내놓다 ∥ 25장 루나가 새로운 세상을 배우다 ∥ 26장 미친 여자가 종이를 만들다 ∥ 27장 루나가 원하는 것보다 더 많이 배우다 ∥ 28장 여러 사람이 숲으로 가다 ∥ 29장 화산이 나오는 이야기 ∥30장 계획보다 일이 더 꼬이다 ∥ 31장 미친 여자가 나무 집을 발견하다 ∥ 32장 루나가 종이 새를 아주 많이 발견하다 ∥ 33장 마녀가 오래전에 알던 이를 만나다 ∥ 34장 루나가 숲에서 한 여자를 만나다 ∥ 35장 글럭이 불쾌한 냄새를 맡다 ∥ 36장 지도가 별 쓸모가 없다 ∥ 37장 마녀가 충격적인 사실을 알게 되다 ∥ 38장 안개가 서서히 걷히다 ∥ 39장 글럭이 피리언에게 진실을 말하다 ∥ 40장 장화를 두고 다툼이 벌어지다 ∥ 41장 몇 개의 길이 만나다 ∥ 42장 세상이 파랗고 은빛이고 은빛이고 파랗다 ∥ 43장 루나가 처음으로 의도를 갖고 마법을 걸다 ∥ 44장 마음이 움직이다 ∥ 45장 거대한 용이 거대한 결단을 내리다 ∥ 46장 몇 가족이 다시 만나다 ∥ 47장 글럭이 여행을 떠나며 시를 남기다 ∥ 48장 마지막 이야기를 하다


            </div>
            <input type="button" value="더보기" class="moreChk2">
        </div>
        <div class="fourthBox">
            <h2> 리뷰 </h2>
            <div class="reviewDetail"> 리뷰하는 칸입니다. </div>
            <input type="button" value="더보기" class="moreChk3">
        </div>
        <div class="fifthBox">
            <h2> 관련 도서 </h2>
            <div class="similarBook">
                <img src="../../resources/image/similarBook.jpg" alt="error">
                <img src="../../resources/image/similarBook.jpg" alt="error">
                <img src="../../resources/image/similarBook.jpg" alt="error">
                <img src="../../resources/image/similarBook.jpg" alt="error">
                <img src="../../resources/image/similarBook.jpg" alt="error">
                
            </div>

        </div>

    </div>
    <!-- body-container -->

</div>
<!-- wrapper end -->

<div class="footer">
    <div class="ulStyle" style="text-align: center; margin:10px; ">
        
            <ul>
                <li><a href="#">
                    <img src="../../resources/image/home.png" alt="없음" width=24 height=24>
                홈</a> </li>
                <li><a href="#">
                    <img src="../../resources/image/search.png" alt="없음" width=24 height=24>
                    검색</a></li>
                <li><a href="#">
                    <img src="../../resources/image/book.png" alt="없음" width=24 height=24>
                    피드 </a></li>
                <li><a href="myLibrary.html">
                    <img src="../../resources/image/book.png" alt="없음" width=24 height=24>
                    내서재</a></li>
                <li><a href="#">
                    <img src="../../resources/image/person.png" alt="없음" width=24 height=24>
                    관리</a></li>

            </ul>

    </div>

</div>


<script>

$(function() {
    
    var cnt=0;
    $('.moreChk').click(function(){
        cnt++;
        if(cnt%2==1) {
        var aa = $('.bookDetail');
        aa.height(400);
         }else { 
        var aa = $('.bookDetail');
        aa.height(110);
         }

    });

    $('.moreChk2').click(function(){
        cnt++;
        if(cnt%2==1) {
        var aa = $('.listDetail');
        aa.height(500);
         }else {
        var aa = $('.listDetail');
        aa.height(110);
         }

    });

    $('.moreChk3').click(function(){
        cnt++;
        if(cnt%2==1) {
        var aa = $('.reviewDetail');
        aa.height(400);
         }else {
            var aa = $('.reviewDetail');
        aa.height(110);
        
         }

    });


});
</script>


<script>

var count=0;
$(function() {

    $('#heartClick').click(function() {
        $.ajax({
            url: "heartGo.do",
            type: "get",
            data: {
                id: '${id}'
                
            },

            success: function () {
                heartCount();
            },
        })
   
    })

        function heartCount() {
    $.ajax( {
        url: "heartNumber.do",
        type: "get",
        data: {
            
        },
        success: function (count) {
            $(".countNum").val(count);
        },
    
        })
    };

    heartCount();


</script>

<script>

        $(".modalOpen").click(function(){
            $(".modal").attr("style", "display:block");
        });

        $(".modalClose").click(function(){
            $(".modal").attr("style","display:none");

        });

</script>

<script>
$('a[href="#modalGo"]').click(function(event){
    event.preventDefault();

    $(this).modal({
        fadeDuration:250
    });

});

</script>


<script>

var maxChkbox = 3; 
var cnt=0;

function chkboxCnt(gogo) {
    if(gogo.checked) {
        cnt +=1;
    }else {
        cnt -=1;
    }

    if(cnt > maxChkbox) {
        alert("3개까지 선택가능합니다. ");
        gogo.checked=false;
        cnt -= 1;
        
    }

}

</script>

<script>

function chkboxCnt(gogo) {
    var chkvalue = gogo.val();
    $.ajax( {
        url:"/book/inserthashtag",
        type:"post",
        data {
            bookNum : '${bookdetail.bookNum}',
            hashTag : chkvalue

        },
        success:function (hashtagList) {

        },

    })
}

</script>


<script>

    $(function() {
        $('.inputBtn').click(function(){

            $.ajax({
                url: "/book/inserthashtag",
                type:'post',
                data {

                    bookNum: '${bookdetail.bookNum}'

                },
                success:function() {
                    $(".hashTag").html('<input type="checkbox" name="tagChkbox" id="chk1" onclick="chkboxCnt(this)">');

                },

            })

        });
    });

</script>


</body>
</html>