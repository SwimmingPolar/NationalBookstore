<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://fonts.googleapis.com/css?family=Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap" rel="stylesheet">


<style>

li{
    list-style: none;
}

a {

    text-decoration: none;
}

body{
    
    /* font-family: 'Roboto', sans-serif;
    font-family: 'Open Sans', sans-serif; */
    font-family: 'Montserrat', sans-serif;

}

.wrapper {
    /* border:2px solid red; */
    display:flex;
    flex-direction: column;
    height:1000px;
    width:50%;
    margin:0 auto;
    /* border:2px solid blue; */
   
}


.firstColumn {

width:100%;
height:100%;
text-align:center;
position:relative;
z-index:1;
/* border:2px solid red; */

}

.firstColumn::after {

    width:100%; 
    height:100%; 
    content:"";
    background-image:url('../../resources/image/photo2.jpg');
    position:absolute;
    top:0; 
    left:0;
    z-index:-1;
    opacity:0.4;
    border-radius: 7px;
    
}


.secondColumn {

    width:100%;
    height:70%;
    /* border:2px solid orange; */
    padding-top: 20px;
    /* border:1px solid #e8e8e8; */
    border-radius: 5px;
    /* border:2px solid pink; */
}


input[type="radio"] {
    display:none;

}


.content {
    display:none;
    padding:30px;
    border:1px solid #e8e8e8;
    width: 90%;
    margin:0 auto;
    height: 300px;
    margin-top:20px;
}


#mybook:checked ~ .one{
    display:block;

}

#mybookcart:checked ~ .two{
    display:block;

}

#paperbook:checked ~ .three{
    display:block;

}

#mypost:checked ~ .four{
    display:block;

}


input[type="radio"]:checked + label {

    border-bottom: 3px solid black;
    font-weight: bold;

}


label {

    margin:20px;    
}


.two .makeNewBook {

    margin: 100px;

}

.makeNewBook input[type="button"] {
    width: 200px;
    height: 50px;
    font-size: 20px;
    margin-left: 100px;

}

header {

font-family: 'Kaushan Script', cursive;
color:red;
font-size:35px;
margin-bottom:20px;
border-bottom:1px solid lightgray;
padding:20px 20px 20px 600px;

}

.profileP {
    width: 200px;
    height:200px;
    margin-top:50px;
    margin-left:10px;

}


.profileP span {

 display:block;
color:white;
font-weight: bold;
font-size:24px;
width: 300px;

}


.goSubscribe {

margin-top: 100px;
width:650px;
text-align: left;
padding: 10px 0px 50px 30px;
color:black;
font-weight: bold;
border-top:1px solid white;
}


.four .postInput {
    border-radius: 6px;
    float:right;
    background-color: #FFF190;
    width:120px;
    height: 40px;
    border:none;
    font-size: 16px;
}


.footer a {

/* margin:60px; */
/* position:efixed; */
color:gray;
margin: 50px;
height:50px;

}


.footer a:active {
    color:#ffc105;

}

.footer a:visited {
  
}


.footer {
margin:0 auto;
position:fixed;
background: #e8e8e8;
left:0;
right:0;
bottom:0;
height:4rem;
z-index:40;
border-top: 1px solid #eee;
background: #fff;
font-size: 14px;

}


.ulStyle ul li {

display:inline;

}

</style>

</head>
<body>

 <header>
        National Bookstore
 </header>

<div class="wrapper">
<div class="firstColumn">
<!-- 배경화면 넣는곳 -->
<div class="profileP">
<a href="#"><img src="../../resources/image/person.png" alt="없음" width=90 height=90></a>
<span> 다채로운 마력 님의 서재</span>
<p style="font-size:17px; ">다채로운 마력</p>

<div class="goSubscribe">

<a href="#" style="color:black;" >지금 바로 정기구독을 시작하세요. <p>
목표와 함께라면 독서가 일상이 됩니다!</a>

</div>

</div>
</div>
<!-- firstColumn end -->
<div class="secondColumn">
<input type="radio" name="myPage" id="mybook" ><label for="mybook"> 내 책</label>
<input type="radio" name="myPage" id="mybookcart"><label for="mybookcart">책장</label>
<input type="radio" name="myPage" id="paperbook"><label for="paperbook">종이책 주문</label>
<input type="radio" name="myPage" id="mypost"><label for="mypost">포스트</label>

<div class="content one">
    <span> 0개의 도서</span>
</div>
<div class="content two">
    <span> 0개의 책장</span>

    <div class="makeNewBook">
        <input type="button" value=" + 새 책장 만들기" >    
        <!-- <a href = "#" onclick="window.open('likePeople','name','resizable=no width=300 heigth=500');return false"></a>     -->
    </div>
</div>
<div class="content three">
    <span> 0개의 주문현황</span>
</div>
<div class="content four">
    <span> 0개의 포스트</span>
    <input type="button" value="+ 포스트 작성" class="postInput" 
    onclick="window.open('postInsert.html','popupOpen','width=600, height=700, location=no, status=no, scrollbars=no');">

</div>
</div>
<!-- secondColumn end -->
</div>


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


</body>
</html>