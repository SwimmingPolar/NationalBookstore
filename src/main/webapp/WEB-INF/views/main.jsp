<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <title>National Bookstore</title>
  <!-- Google Fonts -->
  <link
    href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Nanum+Gothic|Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap"
    rel="stylesheet" />
  <!-- Fontawesome API -->
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
    font-family: 'Noto Sans KR', sans-serif;
    font-family: 'Black Han Sans', sans-serif;
    font-family: 'Nanum Gothic', sans-serif;
    -->
  <!-- css reset -->
  <link rel="stylesheet" href="../../resources/styles/reset.css" />
  <!-- individual page stylesheet -->
  <link rel="stylesheet" href="../../resources/styles/main.css" />
  <link rel="stylesheet" href="../../resources/styles/common.css" />

  <!-- jQuery CDN -->
  <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
  <!-- slidify sliders and fadeInUp reveal -->
  <script src="../../resources/js/common.js"></script>
</head>
<body>
  <div class="container">
    <div class="head fadeInUp">
      <div class="head-upper">
        <div class="logo">
          <a href="#">
            <h2>NATIONAL BOOKSTORE</h2>
          </a>
        </div>
        <div class="search-wrapper">
          <div class="filter">
            <ul>
              <li class="selected">제목</li>
            </ul>
          </div>
          <form action="#" method="get">
            <button><span class="far fa-search"></span></button>
            <input class="hasResult" name="query" type="text" placeholder="제목, 저자, 해쉬태그 검색" autocomplete="off" spellcheck="false">
            <input type="hidden" name="filter" value="title">
            <div class="search-result hasResult">
              <ul>
                <li>아이언</li>
                <li>브론즈</li>
                <li>실버</li>
                <li>골드</li>
                <li>플레티넘</li>
                <li>다이아</li>
                <li>마스터</li>
                <li>챌린저</li>
                <li>아이언</li>
                <li>브론즈</li>
                <li>실버</li>
                <li>골드</li>
                <li>플레티넘</li>
                <li>다이아</li>
                <li>마스터</li>
                <li>챌린저</li>
              </ul>
            </div>
          </form>
        </div> 
        <!-- toggle filter menu on click -->
        <script>
          $(document).ready(function() {
            const filterList = document.querySelector('.head .search-wrapper .filter ul');
            const filterMenus = ['제목', '저자', '해쉬태그'];
            const filterItems = {
              '제목': 'title',
              '저자': 'author',
              '해쉬태그': 'hashtag'
            };
            const filterHiddenInput = document.querySelector('.search-wrapper input[name="filter"]');

            filterList.addEventListener('click', event => {
              filterList.classList.toggle('active');
              // append other menu lists on click
              if (filterList.classList.contains('active')) {
                filterMenus.forEach(menu => {
                  if (menu === event.target.textContent) return;
                  const list = document.createElement('li');
                  list.textContent = menu;
                  filterList.appendChild(list);
                });
              }
              // switch to selected menu list
              else {
                filterList.innerHTML = '';
                event.target.classList.add('selected');
                filterHiddenInput.value = filterItems[event.target.textContent];
                filterList.appendChild(event.target);
              }
            });
          });
        </script>
      </div>
      <div class="head-lower">
        <nav class="lnb">
          <ul>
            <li>
              <a href="books">
                <span>전체 도서</span>
              </a>
            </li>
            <li>
              <a href="bestseller">
                <span>베스트 셀러</span>
              </a>
            </li>
            <li>
              <a href="paper">
                <span>도서 구매</span>
              </a>
            </li>
            <li>
              <a href="event">
                <span>이벤트</span>
              </a>
            </li>
          </ul>
          <div class="accent-slider"></div>
        </nav>
      </div>
      <!-- make it sticky on scroll -->
      <script>
        $(document).ready(function() {
          const headLower = document.querySelector('.head .head-lower');
          window.addEventListener('scroll', () => {
            if (headLower.getBoundingClientRect().top < 0)
              headLower.classList.add('sticky');
            else
              headLower.classList.remove('sticky');
          });
        });
      </script>
      <!-- move accent slider on hover -->
      <script>
        $(document).ready(function() {
          const accentSlider = document.querySelector('.lnb .accent-slider');
          const lnbMenus = [...(document.querySelectorAll('.lnb li'))];
          const lnb = document.querySelector('.lnb');

          lnbMenus.forEach((menu, index) => {
            menu.addEventListener('mouseover', () => {
              accentSlider.classList.add('isBeingHovered');
              menu.classList.add('isBeingHovered');
              accentSlider.style.transform = 'translateX(' + 100 * index + '%)';
            });
            menu.addEventListener('mouseout', () => {
              menu.classList.remove('isBeingHovered');
            });
          });

          lnb.addEventListener('mouseout', () => {
            accentSlider.classList.remove('isBeingHovered');
          });
        });
      </script>
    </div>
    <div class="body-wrapper">
      <section class="recommendation fadeInUp">
        <div class="left-section">
          <h2>오늘의 추천도서</h2>
          <div class="slider-wrapper slider-window infinite-slider-window">
            <div class="prev button-wrapper">
              <svg fill="#ffffff" height="2em" width="1em" viewBox="0 0 40 40">
                <g>
                  <path d="m28.5 12.5l-5-5-12.5 12.5 12.5 12.5 5-5-7.5-7.5 7.5-7.5z"></path>
                </g>
              </svg>
            </div>
            <div class="next button-wrapper">
              <svg fill="#ffffff" height="2em" width="1em" viewBox="0 0 40 40">
                <g>
                  <path d="m16 7.5l-5 5 7.5 7.5-7.5 7.5 5 5 12.5-12.5-12.5-12.5z"></path>
                </g>
              </svg>
            </div>
            <div class="slider-indicator">
              <ul>
                <li class="active"><label for=""><input type="radio"></label></li>
                <li><label for=""><input type="radio"></label></li>
                <li><label for=""><input type="radio"></label></li>
                <li><label for=""><input type="radio"></label></li>
                <li><label for=""><input type="radio"></label></li>
                <li><label for=""><input type="radio"></label></li>
              </ul>
            </div>
            <div class="slider infinite-slider">
              <div class="slide infinite-slide"><a href="" src="#"><img src="https://via.placeholder.com/250x320/aaafff" alt=""></a></div>
              <div class="slide infinite-slide"><a href="" src="#"><img src="https://via.placeholder.com/250x320/faaaff" alt=""></a></div>
              <div class="slide infinite-slide"><a href="" src="#"><img src="https://via.placeholder.com/250x320/ffaaaf" alt=""></a></div>
              <div class="slide infinite-slide"><a href="" src="#"><img src="https://via.placeholder.com/250x320/fffaaa" alt=""></a></div>
              <div class="slide infinite-slide"><a href="" src="#"><img src="https://via.placeholder.com/250x320/afffaa" alt=""></a></div>
              <div class="slide infinite-slide"><a href="" src="#"><img src="https://via.placeholder.com/250x320/aafffa" alt=""></a></div>
            </div>
          </div>
        </div>
        <div class="right-section">
          <h2>
            <a href="#">#힐링</a>
            <a href="#">#여행</a>
            <a href="#">#개발</a>
          </h2>
          <div class="bookshelf-wrapper">
            <div class="shelf">
              <div class="bookend-left"></div>
              <div class="bookend-right"></div>
              <div class="reflection"></div>
              <ul>
                <li>
                  <a href="#">
                    <img src="https://via.placeholder.com/55x75" alt="">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="https://via.placeholder.com/55x75" alt="">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="https://via.placeholder.com/55x75" alt="">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="https://via.placeholder.com/50x75" alt="">
                  </a>
                </li>
              </ul>
            </div>
            <div class="shelf">
              <div class="bookend-left"></div>
              <div class="bookend-right"></div>
              <div class="reflection"></div>
              <ul>
                <li>
                  <a href="#">
                    <img src="https://via.placeholder.com/55x75" alt="">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="https://via.placeholder.com/55x75" alt="">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="https://via.placeholder.com/55x75" alt="">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="https://via.placeholder.com/55x75" alt="">
                  </a>
                </li>
              </ul>
            </div>
            <div class="shelf">
              <div class="bookend-left"></div>
              <div class="bookend-right"></div>
              <div class="reflection"></div>
              <ul>
                <li>
                  <a href="#">
                    <img src="https://via.placeholder.com/55x75" alt="">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="https://via.placeholder.com/55x75" alt="">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="https://via.placeholder.com/55x75" alt="">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="https://via.placeholder.com/55x75" alt="">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="https://via.placeholder.com/50x75" alt="">
                  </a>
                </li>
              </ul>
            </div>
          </div>
          <!-- emphasize shelf on hover -->
          <!-- <script>
            $(document).ready(function() {
              const bookshelfWrapper = document.querySelector('.recommendation .bookshelf-wrapper');
              const bookshelfList = [...(bookshelfWrapper.querySelectorAll('.shelf'))];
              let previousShelf = undefined;
              bookshelfWrapper.addEventListener('mouseover', event => {
                const bookshelf = bookshelfList.filter(bookshelf => bookshelf.contains(event.target))[0];

                // if bookshelf to be emphasized is the same bookshelf as previously selected then ignore
                if (!bookshelf || previousShelf === bookshelf) return;
               
                bookshelfList.forEach(bookshelf => bookshelf.classList.remove('emphasized'));
                bookshelf.classList.add('emphasized');

                previousShelf = bookshelf;
              });
            });
          </script> -->
        </div>
      </section>
      <section class="trending fadeInUp">
        <h2 class="section-heading">
          <div class="clock">
            <i class="fas fa-clock"></i>
            <span>10시 13분</span>
          </div>
          사람들이 많이 읽은 책
        </h2>
        <!-- initialize clock -->
        <script>
          $(document).ready(function() {
            const clock = document.querySelector('div.clock span');
            function updateClock() {
              const date = new Date();
              const hour = date.getHours();
              const minutes = String(date.getMinutes()).length === 1 ? '0' + date.getMinutes() : date.getMinutes();
              const timeString = hour + '시 ' + minutes + '분';
              clock.textContent = timeString;
            }
            // initialize clock
            updateClock();

            // renew clock every second
            setInterval(function() {
              updateClock();
            }, 1000);
          });
        </script>
        <div class="list-container">
          <ul>
          	<c:set var="count" value="${1 }"/>
          	<c:forEach var="read" items="${bestReadBook }">
          		<li>
              	<a href="#">
                	<div class="img-wrapper">
                  		<img src="${pageContext.request.contextPath}${read.bookThumbnail}" alt="" width="50px" height="75px">
                	</div>
                	<div class="text-wrapper">
                  	<div class="ranking">
                    	<h3><c:out value="${count }"/> </h3>
                  	</div>
                  	<div class="meta-data">
                    	<span class="title">${read.bookTitle }</span>
                    	<span class="author">author</span>
                  	</div>
                	</div>
              	</a>
            </li>
            <c:set var="count" value="${count + 1 }"/>
          	</c:forEach>
          </ul>
        </div>
      </section>
      <section class="best-seller fadeInUp">
        <h2 class="section-heading">베스트셀러</h2>
        <div class="content-wrapper">
          <div class="filter-container">
            <div class="time-filter">
              <ul>
                <li>월간</li>
              </ul>
              <span class="far fa-chevron-down"></span>
            </div>
            <div class="category-filter">
              <ul>
                <li class="selected"><button type="button">종합</button></li>
                <li><button type="button">소설</button></li>
                <li><button type="button">트렌딩</button></li>
                <li><button type="button">교양</button></li>
              </ul>
            </div>
          </div>
          <!-- toggle filter click -->
          <script>
            // ajax callback
            function updateBestSeller() {
              const timeFilter = document.querySelector('.best-seller .time-filter li').textContent.trim();
              const categoryFilter = document.querySelector('.best-seller .category-filter li.selected button').textContent.trim();
              
              console.log('ajax fired: time=' + timeFilter + '&category=' + categoryFilter);

              // const xhr = new XMLHttpRequest();
              // xhr.open('GET', 'controller-url');
              // xhr.onreadystatechange = () => {
              //   if (!(xhr.readyState === 4 && xhr.status === 200)) return;

              //   const result = JSON.parse(xhr.response);

              //   // ajax 작업
              //   // ajax 작업
              //   // ajax 작업
              // };
              // xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
              // xhr.send('time=' + timeFilter + '&category=' + categoryFilter);
            }
            $(document).ready(function() {
              const filterList = document.querySelector('.best-seller .time-filter ul');
              const filterMenus = ['월간', '일간', '주간', '연간'];

              filterList.addEventListener('click', event => {
                // prevent event.target being parent itself
                if (event.target === filterList) return;

                filterList.classList.toggle('active');
                // append other menu lists on click
                if (filterList.classList.contains('active')) {
                  filterMenus.forEach(menu => {
                    if (menu === event.target.textContent) return;
                    const list = document.createElement('li');
                    list.textContent = menu;
                    filterList.appendChild(list);
                  });
                }
                // switch to selected menu list
                else {
                  filterList.innerHTML = '';
                  event.target.classList.add('selected');
                  filterList.appendChild(event.target);
                  updateBestSeller();
                }
              });
            });
            $(document).ready(function() {
              const filterButtonContainer = document.querySelector('.best-seller .category-filter ul');
              const filterButtons = [...(document.querySelectorAll('.best-seller .category-filter li'))];
              filterButtonContainer.addEventListener('click', event => {
                if (event.target.type !== 'button') return;

                // remove selected class from all li
                filterButtons.forEach(button => button.classList.remove('selected'));
                // add selected class to clicked li
                event.target.parentElement.classList.add('selected');

                // if time filter is opened then close
                const timeFilterContainer = document.querySelector('.best-seller .time-filter ul');
                const currentTimeFilter = document.querySelector('.best-seller .time-filter li');
                if (timeFilterContainer.classList.contains('active')) 
                  currentTimeFilter.click();
                else
                  updateBestSeller();
              });
            });
          </script>
          <div class="list-container slider-wrapper flexible-slider-window">
            <ul class="slider flexible-slider">
              <li class="flexible-slide">
                <a href="#">
                  <div class="thumbnail-wrapper">
                    <img src="https://via.placeholder.com/100x150" alt="">
                  </div>  
                  <div class="text-wrapper">
                    <div class="meta-data">
                      <h3>1</h3>
                      <strong>title</strong>
                      <span>author  </span>
                    </div>
                  </div>
                </a>
              </li>
              <li>
                <a href="#">
                  <div class="thumbnail-wrapper">
                    <img src="https://via.placeholder.com/100x150" alt="">
                  </div>  
                  <div class="text-wrapper">
                    <div class="meta-data">
                      <h3>2</h3>
                      <strong>title</strong>
                      <span>author  </span>
                    </div>
                  </div>
                </a>
              </li>
              <li class="flexible-slide">
                <a href="#">
                  <div class="thumbnail-wrapper">
                    <img src="https://via.placeholder.com/100x150" alt="">
                  </div>  
                  <div class="text-wrapper">
                    <div class="meta-data">
                      <h3>3</h3>
                      <strong>title</strong>
                      <span>author  </span>
                    </div>
                  </div>
                </a>
              </li>
              <li>
                <a href="#">
                  <div class="thumbnail-wrapper">
                    <img src="https://via.placeholder.com/100x150" alt="">
                  </div>  
                  <div class="text-wrapper">
                    <div class="meta-data">
                      <h3>4</h3>
                      <strong>title</strong>
                      <span>author  </span>
                    </div>
                  </div>
                </a>
              </li>
              <li class="flexible-slide">
                <a href="#">
                  <div class="thumbnail-wrapper">
                    <img src="https://via.placeholder.com/100x150" alt="">
                  </div>  
                  <div class="text-wrapper">
                    <div class="meta-data">
                      <h3>5</h3>
                      <strong>title</strong>
                      <span>author  </span>
                    </div>
                  </div>
                </a>
              </li>
              <li>
                <a href="#">
                  <div class="thumbnail-wrapper">
                    <img src="https://via.placeholder.com/100x150" alt="">
                  </div>  
                  <div class="text-wrapper">
                    <div class="meta-data">
                      <h3>6</h3>
                      <strong>title</strong>
                      <span>author  </span>
                    </div>
                  </div>
                </a>
              </li>
              <li class="flexible-slide">
                <a href="#">
                  <div class="thumbnail-wrapper">
                    <img src="https://via.placeholder.com/100x150" alt="">
                  </div>  
                  <div class="text-wrapper">
                    <div class="meta-data">
                      <h3>7</h3>
                      <strong>title</strong>
                      <span>author  </span>
                    </div>
                  </div>
                </a>
              </li>
              <li>
                <a href="#">
                  <div class="thumbnail-wrapper">
                    <img src="https://via.placeholder.com/100x150" alt="">
                  </div>  
                  <div class="text-wrapper">
                    <div class="meta-data">
                      <h3>8</h3>
                      <strong>title</strong>
                      <span>author  </span>
                    </div>
                  </div>
                </a>
              </li>
              <li class="flexible-slide">
                <a href="#">
                  <div class="thumbnail-wrapper">
                    <img src="https://via.placeholder.com/100x150" alt="">
                  </div>  
                  <div class="text-wrapper">
                    <div class="meta-data">
                      <h3>9</h3>
                      <strong>title</strong>
                      <span>author  </span>
                    </div>
                  </div>
                </a>
              </li>
              <li>
                <a href="#">
                  <div class="thumbnail-wrapper">
                    <img src="https://via.placeholder.com/100x150" alt="">
                  </div>  
                  <div class="text-wrapper">
                    <div class="meta-data">
                      <h3>10</h3>
                      <strong>title</strong>
                      <span>author  </span>
                    </div>
                  </div>
                </a>
              </li>
              <li class="flexible-slide">
                <a href="#">
                  <div class="thumbnail-wrapper">
                    <img src="https://via.placeholder.com/100x150" alt="">
                  </div>  
                  <div class="text-wrapper">
                    <div class="meta-data">
                      <h3>11</h3>
                      <strong>title</strong>
                      <span>author  </span>
                    </div>
                  </div>
                </a>
              </li>
              <li>
                <a href="#">
                  <div class="thumbnail-wrapper">
                    <img src="https://via.placeholder.com/100x150" alt="">
                  </div>  
                  <div class="text-wrapper">
                    <div class="meta-data">
                      <h3>12</h3>
                      <strong>title</strong>
                      <span>author  </span>
                    </div>
                  </div>
                </a>
              </li>
              <li class="flexible-slide">
                <a href="#">
                  <div class="thumbnail-wrapper">
                    <img src="https://via.placeholder.com/100x150" alt="">
                  </div>  
                  <div class="text-wrapper">
                    <div class="meta-data">
                      <h3>13</h3>
                      <strong>title</strong>
                      <span>author  </span>
                    </div>
                  </div>
                </a>
              </li>
              <li>
                <a href="#">
                  <div class="thumbnail-wrapper">
                    <img src="https://via.placeholder.com/100x150" alt="">
                  </div>  
                  <div class="text-wrapper">
                    <div class="meta-data">
                      <h3>14</h3>
                      <strong>title</strong>
                      <span>author  </span>
                    </div>
                  </div>
                </a>
              </li>
              <li class="flexible-slide">
                <a href="#">
                  <div class="thumbnail-wrapper">
                    <img src="https://via.placeholder.com/100x150" alt="">
                  </div>  
                  <div class="text-wrapper">
                    <div class="meta-data">
                      <h3>15</h3>
                      <strong>title</strong>
                      <span>author  </span>
                    </div>
                  </div>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </section>
      <section class="paperbook-sale content-area fadeInUp">
        <h2 class="section-heading">빈 책장을 채우는 기회</h2>
        <div class="content-wrapper">
          <h3><span class="fal fa-file-check"></span>이달의 할인</h3>
          <div class="list-container slider-wrapper flexible-slider-window">
            <ul class="slider flexible-slider"> 
              <li class="flexible-slide">
                <a href="#">
                  <div class="thumbnail-wrapper">
                    <span class="discount-rate">10<span>%</span></span>
                    <img src="https://via.placeholder.com/150x200" alt="">
                  </div>
                  <div class="text-wrapper">
                    <strong>title</strong>
                    <span>author</span>
                  </div>
                </a>
              </li>
              <li class="flexible-slide">
                <a href="#">
                  <div class="thumbnail-wrapper">
                    <span class="discount-rate">10<span>%</span></span>
                    <img src="https://via.placeholder.com/150x200" alt="">
                  </div>
                  <div class="text-wrapper">
                    <strong>title</strong>
                    <span>author</span>
                  </div>
                </a>
              </li>
              <li class="flexible-slide">
                <a href="#">
                  <div class="thumbnail-wrapper">
                    <span class="discount-rate">10<span>%</span></span>
                    <img src="https://via.placeholder.com/150x200" alt="">
                  </div>
                  <div class="text-wrapper">
                    <strong>title</strong>
                    <span>author</span>
                  </div>
                </a>
              </li>
              <li class="flexible-slide">
                <a href="#">
                  <div class="thumbnail-wrapper">
                    <span class="discount-rate">10<span>%</span></span>
                    <img src="https://via.placeholder.com/150x200" alt="">
                  </div>
                  <div class="text-wrapper">
                    <strong>title</strong>
                    <span>author</span>
                  </div>
                </a>
              </li>
              <li class="flexible-slide">
                <a href="#">
                  <div class="thumbnail-wrapper">
                    <span class="discount-rate">10<span>%</span></span>
                    <img src="https://via.placeholder.com/150x200" alt="">
                  </div>
                  <div class="text-wrapper">
                    <strong>title</strong>
                    <span>author</span>
                  </div>
                </a>
              </li>
              <li class="flexible-slide">
                <a href="#">
                  <div class="thumbnail-wrapper">
                    <span class="discount-rate">10<span>%</span></span>
                    <img src="https://via.placeholder.com/150x200" alt="">
                  </div>
                  <div class="text-wrapper">
                    <strong>title</strong>
                    <span>author</span>
                  </div>
                </a>
              </li>
              <li class="flexible-slide">
                <a href="#">
                  <div class="thumbnail-wrapper">
                    <span class="discount-rate">10<span>%</span></span>
                    <img src="https://via.placeholder.com/150x200" alt="">
                  </div>
                  <div class="text-wrapper">
                    <strong>title</strong>
                    <span>author</span>
                  </div>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </section>
      <section class="coming-soon content-area fadeInUp">
        <h2 class="section-heading">출시 예정 도서</h2>
        <div class="content-wrapper slider-wrapper flexible-slider-window">
          <ul class="slider flexible-slider">
            <li class="flexible-slide">
              <a href="#">
                <div class="thumbnail-wrapper">
                  <img src="https://via.placeholder.com/100x140" alt="">
                  <div class="overlay">
                    <div class="meta-data">
                      <span></span>
                      <strong>D-12</strong>
                    </div>
                  </div>
                </div>
                <div class="text-wrapper">
                  <strong>title</strong>
                  <span>author</span>
                </div>
              </a>
              <button>
                <div class="button-content-wrapper">
                  <div class="icon">
                    <i class="far fa-bell"></i>
                  </div>
                  <span>알람받기</span>
                </div>
              </button>
            </li>
            <li class="flexible-slide">
              <a href="#">
                <div class="thumbnail-wrapper">
                  <img src="https://via.placeholder.com/100x140" alt="">
                  <div class="overlay">
                    <div class="meta-data">
                      <span></span>
                      <strong>D-12</strong>
                    </div>
                  </div>
                </div>
                <div class="text-wrapper">
                  <strong>title</strong>
                  <span>author</span>
                </div>
              </a>
              <button>
                <div class="button-content-wrapper">
                  <div class="icon">
                    <i class="far fa-bell"></i>
                  </div>
                  <span>알람받기</span>
                </div>
              </button>
            </li>
            <li class="flexible-slide">
              <a href="#">
                <div class="thumbnail-wrapper">
                  <img src="https://via.placeholder.com/100x140" alt="">
                  <div class="overlay">
                    <div class="meta-data">
                      <span></span>
                      <strong>D-12</strong>
                    </div>
                  </div>
                </div>
                <div class="text-wrapper">
                  <strong>title</strong>
                  <span>author</span>
                </div>
              </a>
              <button>
                <div class="button-content-wrapper">
                  <div class="icon">
                    <i class="far fa-bell"></i>
                  </div>
                  <span>알람받기</span>
                </div>
              </button>
            </li>
            <li class="flexible-slide">
              <a href="#">
                <div class="thumbnail-wrapper">
                  <img src="https://via.placeholder.com/100x140" alt="">
                  <div class="overlay">
                    <div class="meta-data">
                      <span></span>
                      <strong>D-12</strong>
                    </div>
                  </div>
                </div>
                <div class="text-wrapper">
                  <strong>title</strong>
                  <span>author</span>
                </div>
              </a>
              <button>
                <div class="button-content-wrapper">
                  <div class="icon">
                    <i class="far fa-bell"></i>
                  </div>
                  <span>알람받기</span>
                </div>
              </button>
            </li>
            <li class="flexible-slide">
              <a href="#">
                <div class="thumbnail-wrapper">
                  <img src="https://via.placeholder.com/100x140" alt="">
                  <div class="overlay">
                    <div class="meta-data">
                      <span></span>
                      <strong>D-12</strong>
                    </div>
                  </div>
                </div>
                <div class="text-wrapper">
                  <strong>title</strong>
                  <span>author</span>
                </div>
              </a>
              <button>
                <div class="button-content-wrapper">
                  <div class="icon">
                    <i class="far fa-bell"></i>
                  </div>
                  <span>알람받기</span>
                </div>
              </button>
            </li>
            <li class="flexible-slide">
              <a href="#">
                <div class="thumbnail-wrapper">
                  <img src="https://via.placeholder.com/100x140" alt="">
                  <div class="overlay">
                    <div class="meta-data">
                      <span></span>
                      <strong>D-12</strong>
                    </div>
                  </div>
                </div>
                <div class="text-wrapper">
                  <strong>title</strong>
                  <span>author</span>
                </div>
              </a>
              <button>
                <div class="button-content-wrapper">
                  <div class="icon">
                    <i class="far fa-bell"></i>
                  </div>
                  <span>알람받기</span>
                </div>
              </button>
            </li>
            <li class="flexible-slide">
              <a href="#">
                <div class="thumbnail-wrapper">
                  <img src="https://via.placeholder.com/100x140" alt="">
                  <div class="overlay">
                    <div class="meta-data">
                      <span></span>
                      <strong>D-12</strong>
                    </div>
                  </div>
                </div>
                <div class="text-wrapper">
                  <strong>title</strong>
                  <span>author</span>
                </div>
              </a>
              <button>
                <div class="button-content-wrapper">
                  <div class="icon">
                    <i class="far fa-bell"></i>
                  </div>
                  <span>알람받기</span>
                </div>
              </button>
            </li>
            <li class="flexible-slide">
              <a href="#">
                <div class="thumbnail-wrapper">
                  <img src="https://via.placeholder.com/100x140" alt="">
                  <div class="overlay">
                    <div class="meta-data">
                      <span></span>
                      <strong>D-12</strong>
                    </div>
                  </div>
                </div>
                <div class="text-wrapper">
                  <strong>title</strong>
                  <span>author</span>
                </div>
              </a>
              <button>
                <div class="button-content-wrapper">
                  <div class="icon">
                    <i class="far fa-bell"></i>
                  </div>
                  <span>알람받기</span>
                </div>
              </button>
            </li>
            <li class="flexible-slide">
              <a href="#">
                <div class="thumbnail-wrapper">
                  <img src="https://via.placeholder.com/100x140" alt="">
                  <div class="overlay">
                    <div class="meta-data">
                      <span></span>
                      <strong>D-12</strong>
                    </div>
                  </div>
                </div>
                <div class="text-wrapper">
                  <strong>title</strong>
                  <span>author</span>
                </div>
              </a>
              <button>
                <div class="button-content-wrapper">
                  <div class="icon">
                    <i class="far fa-bell"></i>
                  </div>
                  <span>알람받기</span>
                </div>
              </button>
            </li>
            <li class="flexible-slide">
              <a href="#">
                <div class="thumbnail-wrapper">
                  <img src="https://via.placeholder.com/100x140" alt="">
                  <div class="overlay">
                    <div class="meta-data">
                      <span></span>
                      <strong>D-12</strong>
                    </div>
                  </div>
                </div>
                <div class="text-wrapper">
                  <strong>title</strong>
                  <span>author</span>
                </div>
              </a>
              <button>
                <div class="button-content-wrapper">
                  <div class="icon">
                    <i class="far fa-bell"></i>
                  </div>
                  <span>알람받기</span>
                </div>
              </button>
            </li>
            <li class="flexible-slide">
              <a href="#">
                <div class="thumbnail-wrapper">
                  <img src="https://via.placeholder.com/100x140" alt="">
                  <div class="overlay">
                    <div class="meta-data">
                      <span></span>
                      <strong>D-12</strong>
                    </div>
                  </div>
                </div>
                <div class="text-wrapper">
                  <strong>title</strong>
                  <span>author</span>
                </div>
              </a>
              <button>
                <div class="button-content-wrapper">
                  <div class="icon">
                    <i class="far fa-bell"></i>
                  </div>
                  <span>알람받기</span>
                </div>
              </button>
            </li>
            <li class="flexible-slide">
              <a href="#">
                <div class="thumbnail-wrapper">
                  <img src="https://via.placeholder.com/100x140" alt="">
                  <div class="overlay">
                    <div class="meta-data">
                      <span></span>
                      <strong>D-12</strong>
                    </div>
                  </div>
                </div>
                <div class="text-wrapper">
                  <strong>title</strong>
                  <span>author</span>
                </div>
              </a>
              <button>
                <div class="button-content-wrapper">
                  <div class="icon">
                    <i class="far fa-bell"></i>
                  </div>
                  <span>알람받기</span>
                </div>
              </button>
            </li>
            <li class="flexible-slide">
              <a href="#">
                <div class="thumbnail-wrapper">
                  <img src="https://via.placeholder.com/100x140" alt="">
                  <div class="overlay">
                    <div class="meta-data">
                      <span></span>
                      <strong>D-12</strong>
                    </div>
                  </div>
                </div>
                <div class="text-wrapper">
                  <strong>title</strong>
                  <span>author</span>
                </div>
              </a>
              <button>
                <div class="button-content-wrapper">
                  <div class="icon">
                    <i class="far fa-bell"></i>
                  </div>
                  <span>알람받기</span>
                </div>
              </button>
            </li>
            <li class="flexible-slide">
              <a href="#">
                <div class="thumbnail-wrapper">
                  <img src="https://via.placeholder.com/100x140" alt="">
                  <div class="overlay">
                    <div class="meta-data">
                      <span></span>
                      <strong>D-12</strong>
                    </div>
                  </div>
                </div>
                <div class="text-wrapper">
                  <strong>title</strong>
                  <span>author</span>
                </div>
              </a>
              <button>
                <div class="button-content-wrapper">
                  <div class="icon">
                    <i class="far fa-bell"></i>
                  </div>
                  <span>알람받기</span>
                </div>
              </button>
            </li>
            <li class="flexible-slide">
              <a href="#">
                <div class="thumbnail-wrapper">
                  <img src="https://via.placeholder.com/100x140" alt="">
                  <div class="overlay">
                    <div class="meta-data">
                      <span></span>
                      <strong>D-12</strong>
                    </div>
                  </div>
                </div>
                <div class="text-wrapper">
                  <strong>title</strong>
                  <span>author</span>
                </div>
              </a>
              <button>
                <div class="button-content-wrapper">
                  <div class="icon">
                    <i class="far fa-bell"></i>
                  </div>
                  <span>알람받기</span>
                </div>
              </button>
            </li>
          </ul>
        </div>
      </section>
      <section class="recent-posts content-area fadeInUp">
        <h2 class="section-heading">최신 리뷰엉이</h2>
        <div class="content-wrapper">
          <ul>
            <li>
              <div class="profile-thumbnail-wrapper">
                <a href="#">
                  <img src="https://picsum.photos/250" width="42px" height="42px" alt="">
                </a>
              </div>
              <div class="message-bubble">
                <a href="#" class="user-nickname">user nickname</a>
                <div class="message-wrapper">
                  <span class="message">
                    <pre>이게 나라냐
Ut cillum non reprehenderit eiusmod.</pre>
                  </span>
                  <small class="date">16:39</small>
                </div>
              </div>
            </li>
            <li>
              <div class="profile-thumbnail-wrapper">
                <a href="#">
                  <img src="https://picsum.photos/250" width="42px" height="42px" alt="">
                </a>
              </div>
              <div class="message-bubble">
                <a href="#" class="user-nickname">user nickname</a>
                <div class="message-wrapper">
                  <span class="message">
                    <pre>Dolor do laboris sit magna in incididunt officia.</pre>
                  </span>
                  <small class="date">16:39</small>
                </div>
              </div>
            </li>
            <li>
              <div class="profile-thumbnail-wrapper">
                <a href="#">
                  <img src="https://picsum.photos/250" width="42px" height="42px" alt="">
                </a>
              </div>
              <div class="message-bubble">
                <a href="#" class="user-nickname">user nickname</a>
                <div class="message-wrapper">
                  <span class="message">
                    <pre>is this country?</pre>
                  </span>
                  <small class="date">16:39</small>
                </div>
              </div>
            </li>
            <li>
              <div class="profile-thumbnail-wrapper">
                <a href="#">
                  <img src="https://picsum.photos/250" width="42px" height="42px" alt="">
                </a>
              </div>
              <div class="message-bubble">
                <a href="#" class="user-nickname">user nickname</a>
                <div class="message-wrapper">
                  <span class="message">
                    <pre>Ut cillum non reprehenderit eiusmod.
Consequat nulla deserunt in sint esse magna laboris.
Ut officia nisi voluptate officia proident velit dolore eu eiusmod do.
Mollit et velit minim qui reprehenderit labore irure Lorem do consequat elit.</pre>
                  </span>
                  <small class="date">16:39</small>
                </div>
              </div>
            </li>
          </ul>
        </div>
      </section>
    </div>
  </div>
  <footer class="main-footer">
    <div class="footer-above">
      <div class="container">
        <ul>
          <li><a href="#">공지사항</a></li>
          <li><a href="#">1:1 문의</a></li>
          <li><a href="#">FAQ</a></li>
          <li><a href="#">회사소개</a></li>
          <li><a href="#">이용약관</a></li>
        </ul>
      </div>
    </div>
    <div class="footer-below">
      <div class="container">
        <div class="customer-service">
          <h3>고객센터 070 - 2745 - 4257</h3>
          <p>영업시간 평일 09:00 ~ 17:00</p>
        </div>  
        <hr />
        <div class="company-information">
          <p><span>상호</span> National Bookstore</p>
          <p>서울시 종로구 묘동 돈화문로 26</p>
          <p><span>사업자등록번호</span> 623-25-72312 / 통신판매번호: 제 2008-서울종로 26-03128호</p>
          <p><span>광고/제휴문의</span> 070 - 2745 - 7524 / marketing@nationalbookstore.com</p>
        </div>
        <div class="copy-right">
          <p><span>© 2020. (주)National Bookstore. All Rights Reserved</span></p>
        </div>
      </div>
    </div>
  </footer>
  <!-- activate 'home' tab -->
  <script>
    $(document).ready(() => {
      const li = document.querySelector('footer.fixed a[href="/"]').parentElement;
      const ul = li.parentElement;
      [ul, li].forEach(element => element.classList.add('active'));
    });
  </script>
	<%@ include file="template/footer.jsp" %>
</body>
</html>