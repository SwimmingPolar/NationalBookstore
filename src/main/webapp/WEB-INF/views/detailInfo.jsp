<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8" />
    <meta name="viewport"
        content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>도서 상세 - ${bookdetail.bookTitle}</title>
    <!-- Google Fonts -->
    <link
        href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Nanum+Gothic|Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap"
        rel="stylesheet" />
    <!-- Fontawesome API-->
    <script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
    <!--
    Available Fonts
    Main Font:
    font-family: 'Kaushan Script', cursive;

    Article Choices:
    font-family: 'Roboto', sans-serif;
    font-family: 'Open Sans', sans-serif;
    font-family: 'Montserrat', sans-serif;

    Korean Font:
    font-family: '맑은 고딕', sans-serif;
    font-family: 'Noto Sans KR', sans-serif;
    font-family: 'Black Han Sans', sans-serif;
    font-family: 'Nanum Gothic', sans-serif;
    -->

    <!-- css reset -->
    <link rel="stylesheet" href="../../resources/styles/reset.css" />
    <!-- individual page stylesheet -->
    <link rel="stylesheet" href="../../resources/styles/detailInfo.css">
    <link rel="stylesheet" href="../../resources/styles/common.css" />

    <!-- jQuery CDN -->
    <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
    <!-- slidify sliders and fadeInUp reveal -->
    <script src="../../resources/js/common.js"></script>
</head>

<body>
    <header class="topbar">
        <nav>
            <div class="container">
                <a href="javascript: history.back();"><i class="far fa-arrow-left"></i></a>
                <h2>도서 상세 - ${bookdetail.bookTitle}</h2>
            </div>
        </nav>
    </header>
    <div class="wrapper">
        <div class="top-container">
            <div class="leftBox">
                <div class="imageBox">
                    <img src="${pageContext.request.contextPath }${bookdetail.bookThumbnail }" alt="없음">
                </div>
                <div class="preview">
                    <a href="preview.jsp"
                        onclick="window.open(this.href, '좋아요','width=1000, height=700');return false;" target="_blank"
                        style="color:black;">
                        <i class="fas fa-search"></i><span>미리보기</span> 
                    </a>
                </div>
            </div>
            <div class="introWrite">
                <h3> ${bookdetail.bookTitle} </h3>
                <ul>
                    <li> ${bookdetail.bookWriter} </li>
                    <li style="color:gray; "> ${bookdetail.bookPublisher } /
                        <fmt:formatDate value="${bookdetail.bookPbDate }" pattern="yyyy.MM.dd" />
                    </li>
                    <li style="color:lightgray;"> 장르/분류 :${bookdetail.firstCategory } <i class="fas fa-chevron-right"></i> ${bookdetail.bookCategory }  
                    </li>
                </ul>
                <!-- data-rate 숫자에 따라 색 칠해짐,,,,, -->
                <div class="bookStarScore" data-rate="${bookgrade}">
                  <span><i class="fas fa-star"></i></span>
          		  <span><i class="fas fa-star"></i></span>
            	  <span><i class="fas fa-star"></i></span>
            	  <span><i class="fas fa-star"></i></span>
                  <span><i class="fas fa-star"></i></span>
                  <span id="starScore"> 0 </span> <a>점</a> 
                </div>
                <div class="choiceBtnOne">
                    <form action="/book/insertreadbook">
                  		<input type="hidden" name="booknumber" value="${bookdetail.bookNum }">
                        <input type="submit" value="바로읽기" class="choiceBtn">
                        <button type="button" class="choiceBtn"><i class="fas fa-plus-circle"></i> 찜하기</button>
                        <input type="button" value="종이책 구매" class="choiceBtn">
                    </form>
                </div>
                <div class="likeChk">
                    <a href="#" id="modalOpen">
                        <div class="likelists">
                            <div class="likePeople">
                                <c:forEach var="p" items="${likepeople}" begin="1" end="3">
                                <img src="${pageContext.request.contextPath}">
                                </c:forEach>
                            </div>
                            </div> 
                            <span id="people"> 좋아하는 사람들</span>
                    </a>
                    <span class="likeBtn">
                        <div class="heartSoo">
                            <input type="text" value="${booklike}" id="countNum" size='5' readonly>
                        </div>
                        <div class="heartC">
                            <!-- <input type="checkbox" id="heartClick">
                            <label for="heartClick" id="heartStyle"> -->
                            <c:choose>
                                <c:when test="${likecheck }">
                                    <form action="/book/insertlike">
                                        <input type="checkbox" id="heartClick">
                                        <label for="heartClick">
                                            <i class="far fa-heart"></i>
                                            <i class="fas fa-heart"></i>
                                        </label>
                                    </form>
                                </c:when>
                                <c:otherwise>
                                    <form action="/book/insertlike">
                                        <input type="checkbox" id="heartClick">
                                        <label for="heartClick">
                                            <i class="far fa-heart"></i>
                                            <i class="fas fa-heart"></i>
                                        </label>
                                    </form>
                                </c:otherwise>
                            </c:choose>
                            <%--  </c:if> --%>
                      </div>
                    </span>

                </div>
                <!-- likeChk end -->
                <div id="modalGo" class="modal">
                    <div class="modal_content">
                        <p> <i class="far fa-laugh-beam"></i> 좋아요한 사람들 </p>
                        <div class="allList">
                            <div class="likeList">
                                <c:forEach var="p" items="${likepeople}">
                                    <ul>
                                        <li> <span>
                                                <img id="myFaceImage"
                                                    src="${pageContext.request.contextPath}">
                                            </span>
                                            <span>
                                                <a>${p.memberNickName } 님</a> <br>
                                                <a>by ${p.memberEmail }</a>
                                            </span>
                                        </li>
                                    </ul>
                                </c:forEach>
                                <!-- forEach, ajax  좋아요한 사람들 불러올거임-->
                            </div>
                            <!-- likelist end -->
                        </div>
                        <!-- modal_content end -->
                        <span id="modalCloseBtn">
                            <button type="button" id="peopleChkBtn"> 확인 </button>
                        </span>
                    </div>
                    <!-- modalGo end -->
                </div>
            </div>
            <!-- introWrite -->
        </div>


    <!-- top-container -->

    <div class="body-container"> 

        <!-- top-container -->
        <div class="body-container">
            <div class="firstBox">
                <h2> # 해시태그 </h2>
                <div class="hashtagDetail">
                    <div class="hashTag">
                        <c:set var="count" value="${1 }" />
                        <c:forEach var="h" items="${hashtag}">
                            <c:if test="${count <= 5 }">
                                <%-- <input type="checkbox" name="chkbox" id="chk1" value=${h.hashTag }>${h.hashTag }	 --%>
                                <form action="" method="post" name="hashtagChk">
                                    <%--  <input type="checkbox" name="chkbox" class="tagChkbox" id="chk1" onclick="chkboxCnt(this)" value=${h.hashTag }>
                    <label for="chk1"> # ${h.hashTag }>${h.hashTag } --%>
                                    <%-- 	<input type="checkbox" name="chkbox" id="chk1" value=${h.hashTag }>${h.hashTag }				
						<form action="" method="post" name="hashtagChk">  --%>
                                    <input type="checkbox" name="tagChkbox" class="tagChkbox" id="chk${h.hashNum }"
                                        onclick="chkboxCnt(this)" value=${h.hashTag }>
                                    <label for="chk${h.hashNum }"> # ${h.hashTag }<%-- >${h.hashTag } --%>
                                    </label>
                                </form>
                                <!-- 	</form> -->
                            </c:if>
                            <c:set var="count" value="${count+1 }" />
                        </c:forEach>
                    </div>
                </div>
                <div class="tagtag">
                    <form action="/book/inserthashtag">
                        <c:choose>
                            <c:when test="${hashtagCookieCheck }">
                                <input type="text" name="emoTag" class="emoTag" placeholder="이 책에 대한 나만의 #감성태그를 달아주세요">
                                <input type="hidden" name="bookNum" value="${bookdetail.bookNum }">
                                <input type="button" value="등록" class="inputBtn">
                            </c:when>
                            <c:otherwise>
                                <input type="text" name="hashTag" class="emoTag" placeholder="해시태그는 24시간에 1번만 입력 가능합니다."
                                    readonly="readonly">
                            </c:otherwise>
                        </c:choose>
                    </form>
                </div>
            </div>
            <div class="secondBox">
                <h2> 책소개 </h2>
                <div class="bookDetail">
                    <!-- 책 소개 부분 없음 -->
                    책소개하는 칸입니다.

                    ‘이 소설 자체가 순수한 마법’이라는 최고의 극찬을 받으며 2017년 뉴베리 수상의 영광을 차지한 작품이다. 고요하지만 위험한 숲속에 해마다 아기가 버려진다. 또한 매년 그런
                    아기를 구하러 오는 마녀가 있다. 그런데 이상하다. 마녀 잰은 유독 이번 아기에게 눈길을 빼앗긴다. 그러다가 그만 실수로 아기에게 달빛을 먹이고 만다. 사실 달빛에는 어마어마한
                    마법이 깃들어 있다.

                    잰은 어쩔 수 없이 분화구 가장자리 늪에 있는 자신의 집으로 아기를 데려간다. 그렇게 마법 아기 루나는 기억을 꽁꽁 감추고 사는 마녀 잰, 시를 사랑하는 늪 괴물 글럭, 망상 속에
                    사는 용 피리언과 함께 이상한 가족의 일원이 된다. 마법이 무엇인지도 모른 채 온갖 말썽을 부리며 자라는 루나와 그런 루나에게 무한한 사랑과 우정을 보여주는 가족들.

                    하지만 루나는 점차 자신의 정체성에 혼란을 느끼고 이런저런 의문에 시달린다. 또한 미쳐서 탑에 갇힌 한 여자의 환영에 아련한 향수마저 느끼는데…. 사실 가족 모두에겐 저마다 묻어둔
                    아픔이 있고 그것은 ‘보호령’이라는 도시와 깊은 연관이 있다. 해마다 숲속 마녀에게 아기를 갖다 바쳐야 한 해가 무사하다고 믿는 슬픔의 도시 보호령의 진짜 비밀은 무엇일까?

                    과연 달빛 마신 소녀 루나와 이상한 가족들은 보호령의 검은 장막을 걷어내고 사람들을 무겁게 휘감은 슬픔과 두려움을 사라지게 할 수 있을까? 이들이 펼치는 사랑과 모험의 환상적인
                    달빛 마법이 시작된다.

                </div>
                <input type="button" value="더보기" class="moreChk">
            </div>
            <div class="thirdBox">
                <h2> 목차 </h2>
                <div class="listDetail"> 목차 칸입니다.
                    1장 이야기를 하다∥2장 불행한 여자가 미쳐 버리다 ∥ 3장 마녀가 실수로 아기에게 마법을 걸다 ∥ 4장 그냥 꿈일 뿐인 이야기 ∥ 5장 늪 괴물도 결국 사랑에 빠지다 ∥ 6장
                    앤테인이 곤경에 처하다 ∥ 7장 마법의 아이가 좀 지나치게 골칫거리다 ∥ 8장 이야기에 일말의 진실이 있다 ∥ 9장 여러 가지 문제가 발생하다 ∥ 10장 마녀가 문을 찾고 기억도
                    찾다 ∥ 11장 마녀가 결단을 내리다 ∥ 12장 아이가 습지에 관해 배우다 ∥ 13장 앤테인이 미친 여자를 만나러 가다 ∥ 14장 행동에 결과가 따르다 ∥ 15장 앤테인이 거짓말을
                    하다 ∥ 16장 종이가 너무나 많다 ∥ 17장 호두알에 갈라진 틈이 있다 ∥ 18장 마녀가 발각되다 ∥ 19장 자유도시에 다녀오다 ∥ 20장 루나가 이야기하다 ∥ 21장 피리언이
                    장화를 발견하다 ∥ 22장 다른 이야기가 있다 ∥ 23장 루나가 지도를 그리다 ∥ 24장 앤테인이 해결책을 내놓다 ∥ 25장 루나가 새로운 세상을 배우다 ∥ 26장 미친 여자가
                    종이를 만들다 ∥ 27장 루나가 원하는 것보다 더 많이 배우다 ∥ 28장 여러 사람이 숲으로 가다 ∥ 29장 화산이 나오는 이야기 ∥30장 계획보다 일이 더 꼬이다 ∥ 31장 미친
                    여자가 나무 집을 발견하다 ∥ 32장 루나가 종이 새를 아주 많이 발견하다 ∥ 33장 마녀가 오래전에 알던 이를 만나다 ∥ 34장 루나가 숲에서 한 여자를 만나다 ∥ 35장 글럭이
                    불쾌한 냄새를 맡다 ∥ 36장 지도가 별 쓸모가 없다 ∥ 37장 마녀가 충격적인 사실을 알게 되다 ∥ 38장 안개가 서서히 걷히다 ∥ 39장 글럭이 피리언에게 진실을 말하다 ∥
                    40장 장화를 두고 다툼이 벌어지다 ∥ 41장 몇 개의 길이 만나다 ∥ 42장 세상이 파랗고 은빛이고 은빛이고 파랗다 ∥ 43장 루나가 처음으로 의도를 갖고 마법을 걸다 ∥ 44장
                    마음이 움직이다 ∥ 45장 거대한 용이 거대한 결단을 내리다 ∥ 46장 몇 가족이 다시 만나다 ∥ 47장 글럭이 여행을 떠나며 시를 남기다 ∥ 48장 마지막 이야기를 하다
                </div>
                <input type="button" value="더보기" class="moreChk2">
            </div>
            <div class="fourthBox">
                <h2> 리뷰 </h2>
                <div class="reviewDetail">
                    <c:forEach var="r" items="${bookreview}">
                        <!-- 리뷰 -->
                        ${r.reviewTitle }<br />
                        ${r.reviewContent }
                    </c:forEach>
                    <div class="reviewDetail">
                        <table>
                            <tbody>
                                <c:forEach var="r" items="${bookreview}">
                                    <tr>
                                        <td>${memberEmail}</td>
                                        <td>${r.reviewRegdate}</td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">${r.reviewTitle }</td>
                                    </tr>
                                    <tr>
                                        <td colspan="2"><textarea name="reviewContent" id="reviewContent" readonly>
                                           ${r.reviewContent }
                                         </textarea></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <input type="button" value="더보기" class="moreChk3">
                </div>
             
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
            <!-- body-container -->
        </div>
        <!-- wrapper end -->
    </div>
    </div>
    <script>
        $(function () {
            var cnt = 0;
            $('.moreChk').click(function () {
                cnt++;
                if (cnt % 2 == 1) {
                    var aa = $('.bookDetail');
                    aa.height('auto');
                } else {
                    var aa = $('.bookDetail');
                    aa.height(110);
                }
            });
            $('.moreChk2').click(function () {
                cnt++;
                if (cnt % 2 == 1) {
                    var aa = $('.listDetail');
                    aa.height('auto');
                } else {
                    var aa = $('.listDetail');
                    aa.height(110);
                }
            });
            $('.moreChk3').click(function () {
                cnt++;
                if (cnt % 2 == 1) {
                    var aa = $('.reviewDetail');
                    aa.height('auto');
                } else {
                    var aa = $('.reviewDetail');
                    aa.height(110);
                }
            });
        });
    </script>

    <!-- <script>
    
        var count = 0;
        $(function () {
            $('#heartClick').click(function () {
            	alert('${bookdetail.bookNum }');
                $.ajax({
                    url: "/book/insertlike",
                    type: "get",
                    data: {
                        booknumber: '${bookdetail.bookNum }'
                    },
                    success: function (data) {
                    	alert(data);
                    	 $("#countNum").html(data);
                        //heartCount();
                    },
                })

    </script>  -->
    <script>
  $(document).ready(function(){ 
	  var check = "${likecheck}";
	  alert(check);
            $('#heartClick').change(function () {
            	var memberId = "${ryanMember.memberNickName}";
            	if(memberId==""){
            		alert("로그인을 먼저 해주세요");	
            	}else{
                    $.ajax({
                        url: "/book/insertlike",
                        type: "get",
                        data: {
                            booknumber: '${bookdetail.bookNum}'
                        },
                 //       dataType:"json",
                        success: function (response) {
    						var result = response.split("+");
  //  		                $("#countNum").replaceWith("<span>"+result[0]+"</span>");
  							if(result[1]){
  								$("#countNum").replaceWith("<input type='text' value="+result[0]+" id='countNum' size='5'>");
  								$("#fa fa-heart").attr("class","far fa-heart");
  							}else if(!result[1]){
  								$("#countNum").replaceWith("<input type='text' value="+result[0]+" id='countNum' size='5'>");
  								$("#far fa-heart").attr("class","fa fa-heart");
  							}
    		                
                        },
                        error: function(request,status, error) {
                            alert("code = "+reqeust.status+"message = "+request.responseText);
                        },
                    });
            	}
            	
            	})
            });

    </script>

    <script>
        var modal = document.getElementById('modalGo');
        var openBtn = document.getElementById('modalOpen');
        var closeBtn = document.getElementById('modalCloseBtn');

        openBtn.onclick = function () {
            modal.style.display = "block";
        }

        closeBtn.onclick = function () {
            modal.style.display = "none";
        }

        window.onclick = function (event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    </script>
    
    

    <script>
        var maxChkbox = 3;
        var cnt = 0;

        function chkboxCnt(gogo) {
            if (gogo.checked) {
                cnt += 1;
            } else {
                cnt -= 1;
            }
            if (cnt > maxChkbox) {
                alert("3개까지 선택가능합니다. ");
                gogo.checked = false;
                cnt -= 1;
            }
        }
    </script>
    
    <script>
        $("#chk1").change(function () {
            var isChk = this.checked;
            if (isChk) {
                $(".emoTag").val($(".chkbox").val());
            }
        });
    </script>
    
    
    <script>
        function chkboxCnt(gogo) {
            var chkvalue = gogo.val();
            $.ajax({
                url: "/book/inserthashtag",
                type: "post",
                data: {
                    bookNum: '${bookdetail.bookNum}',
                    hashTag: chkvalue
                },
                success: function (hashtagList) {
                },
            })
        }
    </script>
    <script>
        var count = 0;
        $(function () {
            $('.inputBtn').click(function () {
                $.ajax({
                    url: "/book/inserthashtag",
                    type: 'post',
                    data: {
                        bookNum: '${bookdetail.bookNum}',
                        hashTag: $('#hashTag').val()
                    },
                    success: function (data) {
                        /* var result = data.json;
                        alert(data); */
                        $('.hashTag').html('');
                        $.each(data, function (idx, val) {
                            $(".hashTag").append("<label>" + val.hashTag + "</label>");
                            count++;
                            if (count == 5) {
                                return false;
                            }
                        });
                    },
                });
            });
        })
    </script>



    <script>
    
    $(function() {
    var rating = $('.bookStarScore');

    rating.each(function(){
        var targetScore = $(this).attr('data-rate');
        console.log(targetScore);
        $(this).find('span:nth-child(-n+'+targetScore+')').css({color:'#f1c40f'});
        $('#starScore').html(targetScore);
    });

 });
    
    </script>
    
    <%@ include file="template/footer.jsp" %>
    
</body>

</html>