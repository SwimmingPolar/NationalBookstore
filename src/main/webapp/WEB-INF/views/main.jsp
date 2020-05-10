<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>National Bookstore</title>
  <!-- Google Fonts -->
  <link
    href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Nanum+Gothic|Kaushan+Script|Montserrat|Noto+Sans+KR|Open+Sans|Roboto&display=swap"
    rel="stylesheet" />
  <!-- Fontawesome -->
  <script src="https://kit.fontawesome.com/201657538f.js" crossorigin="anonymous"></script>
  <!--
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

  <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
</head>

<body>
  <header class="fixed">
    <ul>
      <li class="active">
        <a href="#">
          <i class="far fa-home-alt"></i>
          <span>홈</span>
        </a>
      </li>
      <li>
        <a href="#">
          <i class="far fa-search"></i>
          <span>검색</span>
        </a>
      </li>
      <li>
        <a href="#">
          <i class="fad fa-stream"></i>
          <span>피드</span>
        </a>
      </li>
      <li>
        <a href="#">
          <i class="fas fa-books"></i>
          <span>내서재</span>
        </a>
      </li>
      <li>
        <a href="#">
          <i class="far fa-user"></i>
          <span>관리</span>
        </a>
      </li>
    </ul>
  </header>
  <div class="container">
    <div class="head">
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
              <a href="#">
                <span>전체 도서</span>
              </a>
            </li>
            <li>
              <a href="#">
                <span>베스트 셀러</span>
              </a>
            </li>
            <li>
              <a href="#">
                <span>도서 구매</span>
              </a>
            </li>
            <li>
              <a href="#">
                <span>이벤트</span>
              </a>
            </li>
          </ul>
          <div class="accent-slider"></div>
        </nav>
      </div>
    </div>
    <div class="body-wrapper">
      <section class="recommendation">
        <div class="left-section fadeInUp">
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
        <div class="right-section fadeInUp">
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
            <li>
              <a href="#">
                <div class="img-wrapper">
                  <img src="https://via.placeholder.com/50x75" alt="">
                </div>
                <div class="text-wrapper">
                  <div class="ranking">
                    <h3>1</h3>
                  </div>
                  <div class="meta-data">
                    <span class="title">title</span>
                    <span class="author">author</span>
                  </div>
                </div>
              </a>
            </li>
            <li>
              <a href="#">
                <div class="img-wrapper">
                  <img src="https://via.placeholder.com/50x75" alt="">
                </div>
                <div class="text-wrapper">
                  <div class="ranking">
                    <h3>2</h3>
                  </div>
                  <div class="meta-data">
                    <span class="title">title</span>
                    <span class="author">author</span>
                  </div>
                </div>
              </a>
            </li>
            <li>
              <a href="#">
                <div class="img-wrapper">
                  <img src="https://via.placeholder.com/50x75" alt="">
                </div>
                <div class="text-wrapper">
                  <div class="ranking">
                    <h3>3</h3>
                  </div>
                  <div class="meta-data">
                    <span class="title">title</span>
                    <span class="author">author</span>
                  </div>
                </div>
              </a>
            </li>
            <li>
              <a href="#">
                <div class="img-wrapper">
                  <img src="https://via.placeholder.com/50x75" alt="">
                </div>
                <div class="text-wrapper">
                  <div class="ranking">
                    <h3>4</h3>
                  </div>
                  <div class="meta-data">
                    <span class="title">title</span>
                    <span class="author">author</span>
                  </div>
                </div>
              </a>
            </li>
            <li>
              <a href="#">
                <div class="img-wrapper">
                  <img src="https://via.placeholder.com/50x75" alt="">
                </div>
                <div class="text-wrapper">
                  <div class="ranking">
                    <h3>5</h3>
                  </div>
                  <div class="meta-data">
                    <span class="title">title</span>
                    <span class="author">author</span>
                  </div>
                </div>
              </a>
            </li>
            <li>
              <a href="#">
                <div class="img-wrapper">
                  <img src="https://via.placeholder.com/50x75" alt="">
                </div>
                <div class="text-wrapper">
                  <div class="ranking">
                    <h3>6</h3>
                  </div>
                  <div class="meta-data">
                    <span class="title">title</span>
                    <span class="author">author</span>
                  </div>
                </div>
              </a>
            </li>
            <li>
              <a href="#">
                <div class="img-wrapper">
                  <img src="https://via.placeholder.com/50x75" alt="">
                </div>
                <div class="text-wrapper">
                  <div class="ranking">
                    <h3>7</h3>
                  </div>
                  <div class="meta-data">
                    <span class="title">title</span>
                    <span class="author">author</span>
                  </div>
                </div>
              </a>
            </li>
            <li>
              <a href="#">
                <div class="img-wrapper">
                  <img src="https://via.placeholder.com/50x75" alt="">
                </div>
                <div class="text-wrapper">
                  <div class="ranking">
                    <h3>8</h3>
                  </div>
                  <div class="meta-data">
                    <span class="title">title</span>
                    <span class="author">author</span>
                  </div>
                </div>
              </a>
            </li>
            <li>
              <a href="#">
                <div class="img-wrapper">
                  <img src="https://via.placeholder.com/50x75" alt="">
                </div>
                <div class="text-wrapper">
                  <div class="ranking">
                    <h3>9</h3>
                  </div>
                  <div class="meta-data">
                    <span class="title">title</span>
                    <span class="author">author</span>
                  </div>
                </div>
              </a>
            </li>
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
  <footer>
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

  <!-- flexible slidify -->
  <script>
    function flexibleSlidify(sliderWindow) {
      // const sliderWindow = target.querySelector('.flexible-slider-window');
      const slider = sliderWindow.querySelector('.flexible-slider');
      const slides = [...(slider.querySelectorAll('.flexible-slide'))];

      // set current states
      let isGrabbing = false;
      let isMoved = false;

      // set current slider window width
      const sliderWindowWidth = sliderWindow.clientWidth || Number(window.getComputedStyle(sliderWindow).width.replace('px', ''));
      // set current slider's max width (sum of current slides width);
      // width, padding, margin taken into account
      const sliderWidth = slides.reduce((totalWidth, slide) => {
        const margin = Number(window.getComputedStyle(slide).marginLeft.replace('px', '')) +
                     Number(window.getComputedStyle(slide).marginRight.replace('px', ''));
        const width = slide.clientWidth || Number(window.getComputedStyle(slide).width.replace('px', ''));
        return totalWidth += margin + width;
      }, 0);
      // mouse travel time: mouse button released time - mouse button pressed time
      let mouseUpTimestamp = 0;
      let mouseDownTimestamp = 0;
      let mouseTravelTime = 0;
      // offset between last event's clientX and current event's clientX (works for same event only)
      let movementX = 0;
      // sliding duration
      // default: 800ms
      // when sliding back to start(0px) and/or end(sliderWidth - sliderWindowWidth)px: 300ms
      let slidingDuration = 800;
      
      // final sliding offset
      let slidingOffset = 0;
      // current slider position
      let currentX = 0;

      // prevent clicking on 'a' and/or 'button' tag after moving slider
      document.addEventListener('click', event => {
        if (!isMoved) return;
        event.stopPropagation();
        event.preventDefault();
      });
      document.addEventListener('mousedown', event => {
        // enable sliding only if event target is descendant of slider
        if (!(slider.contains(event.target))) return;
        isGrabbing = true;
        isMoved = false;
      });
      document.addEventListener('mousemove', event => {
        if (!isGrabbing) return;
        isMoved = true;
        movementX = event.movementX;
        mouseDownTimestamp = event.timeStamp;

        // if mouse move does not occur right above the slider
        // limit slider move to 70% of mouse move
        currentX = (function(futureX) {
          if (futureX > 0)
            return currentX + Math.floor(event.movementX*0.375);
          else if (futureX < -1*(sliderWidth - sliderWindowWidth))
            return currentX + Math.floor(event.movementX*0.375);
          else
            return currentX + event.movementX;
        }(currentX + event.movementX));

        // remove transition effect
        slider.style.transition = '';

        // move slider to current position
        slider.style.transform = 'translateX(' + currentX + 'px)';
      });
      document.addEventListener('mouseup', event => {
        isGrabbing = false;
        mouseUpTimestamp = event.timeStamp;
        // time < 1 : add sliding effect when swing mouse to accelerate
        // time < 150 : add soft sliding effect when moderately slided
        // else : remove sliding effect when slide and hold more than 150ms
        mouseTravelTime = (function(time) {
          if (time < 1)
            return 1 - time;
          else if (time < 150)
            return 1;
          else
            return 0;
        }(Math.abs(mouseUpTimestamp - mouseDownTimestamp)));

        // slidingOffset : total distance to be added to current slider position after valid mouse release
        // 0.05: sliding coefficient to be multiply to sliding offset (0.01: stiff ~ 0.05: smooth recommended)
        slidingOffset = mouseTravelTime * movementX * 0.05 * sliderWindowWidth;

        // add transition properties
        slider.style.transitionDuration = slidingDuration + 'ms';
        slider.style.transitionTimingFunction = 'cubic-bezier(0.33, 1, 0.68, 1)';

        currentX = (function(currentX) {
          if (currentX > 0) {
            slider.style.transitionDuration = '400ms';
            return 0;
          }
          else if (currentX < -1*(sliderWidth - sliderWindowWidth)) {
            slider.style.transitionDuration = '400ms';
            return (sliderWidth - sliderWindowWidth)*-1;
          }
          else
            return currentX;
        }(currentX + slidingOffset));

        // add transition
        slider.style.transform = 'translateX(' + currentX + 'px)'
      });
    }
    // slidify flexible slider windows
    $(document).ready(function() {
      const flexibleSliderWindows = [...(document.querySelectorAll('.flexible-slider-window'))];
      flexibleSliderWindows.forEach(sliderWindow => flexibleSlidify(sliderWindow));
    });
  </script>

  <!-- infinite slidify -->
  <script>
    // infinite slider must be loaded prior to "window.onload"
    function infiniteSlidify(sliderWindow) {
      const slider = sliderWindow.querySelector('.infinite-slider');
      const sliderIndicators = [...(sliderWindow.querySelectorAll('.slider-indicator li'))];
      // HTML Live List needed for duplicated slides insertion (getElementsByClassName)
      const slides = slider.getElementsByClassName('infinite-slide');

      // duplicate slides for infinite sliding
      // 4 slides each to start and end for cushion
      // filter to remove undefined element and map to clone element node
      const getSlides = (startIndex, lastIndex) => [...slides].filter((slide, index) => startIndex <= index && index < lastIndex).map(slide => slide.cloneNode(true));
      const appendSlides = (pos, slides) => slides.forEach(slide => slider.insertAdjacentElement(pos, slide).classList.add('duplicated-infinite-slide'));

      const clonedSlides = {
        // last slides should be reversed for FILO style insertion
        'afterbegin': getSlides(slides.length - 4, slides.length).reverse(),
        'beforeend': getSlides(0, 4)
      };
      Object.keys(clonedSlides).forEach(key => appendSlides(key, clonedSlides[key]));

      // returns element width;
      // const getWidth = element => element.clientWidth || Number(window.getComputedStyle(element).width.replace('px', ''));
      const getWidth = element => {
        const margin = (Number(window.getComputedStyle(element).marginLeft.replace('px', '')) || 0) +
                     (Number(window.getComputedStyle(element).marginRight.replace('px', '')) || 0);
        const width = element.clientWidth || Number(window.getComputedStyle(element).width.replace('px', ''));
        return margin + width;
      };
      const slideWidth = getWidth(slides[0]);

      // remove transition style before adjusting position
      slider.style.transition = '';
      // adjust slider position to prior state after cloning
      slider.style.transform = 'translateX(' + -1 * getWidth(slides[0]) * clonedSlides['afterbegin'].length + 'px)';
      
      let isGrabbing = false;
      let isMoved = false;

      const sliderWindowWidth = getWidth(sliderWindow);
      const sliderWidth = [...slides].reduce((totalWidth, slide) => totalWidth + getWidth(slide), 0);

      let mouseUpTimestamp = 0;
      let mouseDownTimestamp = 0;
      let mouseTravelTime = 0;

      let movementX = 0;

      let slidingDuration = 400;

      let slidingOffset = 0;

      // total duplicated slides length
      const duplicatedSlidesLength = [...(sliderWindow.querySelectorAll('.duplicated-infinite-slide'))].length;
      // get current slider's position
      const getCurrentX = () => Number(window.getComputedStyle(slider).transform.split(',')[4]);
      // get closest slide starting position
      const getClosest = futureX => Math.round(futureX / slideWidth) * slideWidth;
      const getValidSliderPosition = function(evaluatingX) {
        const index = (-1 * evaluatingX) / slideWidth;
        if (index < duplicatedSlidesLength/2)
          return slides.length - duplicatedSlidesLength/2 - (duplicatedSlidesLength/2 - index);
        if (index >= slides.length - duplicatedSlidesLength/2)
          return duplicatedSlidesLength - (slides.length - index);
        return index;
      };
      // re-style indicator
      const adjustIndicator = function(index) {
        if (!sliderIndicators.length) return;
        sliderIndicators.forEach(indicator => {
          if (indicator.classList.contains('active'))
            indicator.classList.remove('active');
        });
        sliderIndicators[index].classList.add('active');
      }

      // lock slider when moving
      let transitionLock = false;

      // add indicator events
      if (sliderIndicators) {
        sliderIndicators.forEach((indicator, index) => {
          indicator.addEventListener('click', () => {
            if (transitionLock) return;

            adjustIndicator(index);

            slider.style.transitionDuration = slidingDuration + 'ms';
            slider.style.transitionTimingFunction = 'cubic-bezier(0.33, 1, 0.68, 1)';
            slider.style.transform = 'translateX(' + (-1 * (index + duplicatedSlidesLength/2) * slideWidth)  + 'px)'
          });
        });
      }

      // add click event to prev, next if any
      const buttons = {
        'prev': sliderWindow.querySelector('.prev'),
        'next': sliderWindow.querySelector('.next')
      };
      Object.keys(buttons).forEach(direction => {
        if (!buttons[direction]) return;
        buttons[direction].addEventListener('click', event => {
          if (transitionLock) return;

          const step = direction === 'prev' ? 1 : -1;
          const currentX = getCurrentX() + (slideWidth * step);
          slider.style.transitionDuration = slidingDuration + 'ms';
          slider.style.transitionTimingFunction = 'cubic-bezier(0.33, 1, 0.68, 1)';
          slider.style.transform = 'translateX(' + getClosest(currentX) + 'px)'

          const indicatorIndex = getValidSliderPosition(currentX) - duplicatedSlidesLength/2;
          adjustIndicator(indicatorIndex);
        });
      });

      let intervalID = undefined;
      let isViewportVisible = document.hasFocus() && document.visibilityState;

      // stop slider when the current page lost focus or otherwise switch to other tab or program
      document.addEventListener('visibilitychange', () => document.hidden ? isViewportVisible = false : isViewportVisible = true);
      window.addEventListener('blur', () => isViewportVisible = false);
      window.addEventListener('focus', () => isViewportVisible = true);
      // auto sliding function
      function autoSliding() {
        // clear scheduled callback and re-initiate
        intervalID = clearInterval(intervalID) || setInterval(() => {
          // if any of below lock is not cleared then do not slide (transisionLock)
          // viewport must be visible to user to be slided automatically (isViewportVisible, isPartiallyVisible)
          if (transitionLock || !isViewportVisible || !isPartiallyVisible(sliderWindow)) return;
          if (isPartiallyVisible(sliderWindow))
            buttons['next'].click();
        }, 3500);
      }

      // lock slider when traisition starts
      slider.addEventListener('transitionstart', () => transitionLock = true);
      slider.addEventListener('transitionend', () => {
        // unlock slider after transition ends
        transitionLock = false;

        // reset auto sliding timer after manual sliding
        autoSliding();

        const currentIndex = Math.floor(-1 * getCurrentX() / slideWidth);
        const moveTo = getValidSliderPosition(getCurrentX());

        if (currentIndex === moveTo) return;
                  
        // instantly reposition slider
        slider.style.transitionDuration = '';
        slider.style.transitionTimingFunction = '';
        slider.style.transform = 'translateX(' + -1 * moveTo * slideWidth + 'px)'
      });

      document.addEventListener('click', event => {
        if (!isMoved) return;
        event.stopPropagation();
        event.preventDefault();
      });
      document.addEventListener('mousedown', event => {
        if (!(slider.contains(event.target))) return;
        isGrabbing = true;
        isMoved = false;
      });
      document.addEventListener('mousemove', event => {
        if (!isGrabbing) return;
        transitionLock = true;
        isMoved = true;
        movementX = event.movementX;
        mouseDownTimestamp = event.timeStamp;

        let currentX = getCurrentX() || 0;
        currentX = (function(futureX) {
          if (futureX > 0)
            return currentX + Math.floor(event.movementX*0.1);
          else if (futureX < -1*(sliderWidth - slideWidth))
            return currentX + Math.floor(event.movementX*0.1);
          else
            return currentX + Math.floor(event.movementX*0.75);
        }(currentX + event.movementX));

        slider.style.transition = '';

        slider.style.transform = 'translateX(' + currentX + 'px)';
      });
      document.addEventListener('mouseup', event => {
        if (!isGrabbing) return;
        isGrabbing = false;
        mouseUpTimestamp = event.timeStamp;

        mouseTravelTime = (function(time) {
          if (time < 1)
            return 1 - time;
          else
            return 0;
        }(Math.abs(mouseUpTimestamp - mouseDownTimestamp)));

        slidingOffset = mouseTravelTime * movementX * 0.01 * slideWidth;

        slider.style.transitionDuration = slidingDuration + 'ms';
        slider.style.transitionTimingFunction = 'cubic-bezier(0.33, 1, 0.68, 1)';

        let currentX = getCurrentX() || 0;
        currentX = (function(currentX) {
          if (currentX > 0)
            return 0;
          else if (currentX < -1*(sliderWidth - slideWidth))
            return (sliderWidth - slideWidth)*-1;
          else
            return currentX;
        }(currentX + slidingOffset));

        slider.style.transform = 'translateX(' + getClosest(currentX) + 'px)'

        const indicatorIndex = getValidSliderPosition(getClosest(currentX)) - duplicatedSlidesLength/2;
        adjustIndicator(indicatorIndex);
      });
      // start auto sliding
      autoSliding();
    }
    // slidify infinite slider windows
    $(document).ready(function() {
      const infiniteSliderWindows = [...(document.querySelectorAll('.infinite-slider-window'))];
      infiniteSliderWindows.forEach(infiniteSliderWindow => infiniteSlidify(infiniteSliderWindow));
    })
  </script>

  <!-- element visibility functions -->
  <script>
    // returns true if given element is fully visible on the viewport
    function isFullyVisible(element) {
      const {top, bottom, left, right} = element.getBoundingClientRect();
      return (top >= 0 && bottom >= 0 ) && (left >= 0 && right >= 0);
    }
    // returns true if any portion of given element is visible on the viewport
    function isPartiallyVisible(element) {
      const {top, bottom, left, right} = element.getBoundingClientRect();
      return (top <= window.innerHeight && bottom >= 0) &&
             (left <= window.innerWidth && right >= 0);
    }
    // returns true if 'threshhold' percentage of given element's height is visible on the viewport
    function isVerticallyVisible(element, threshhold = 0.25) {
      const {top, bottom, height} = element.getBoundingClientRect();
      return (top + (height * threshhold) <= window.innerHeight && top > 0) ||
             (bottom >= (height * threshhold) && top < 0);
    }
    // remove 'targets' from 'original' array
    function removeElementsFrom(original, targets) {
      return original.filter(originalElement => !(targets.includes(originalElement)));
    }
    // reveals valid elements and
    // returns un-revealed elements
    function revealElements(hiddenElements) {
      let revealed = hiddenElements.filter(element => isVerticallyVisible(element));
      // add elements placed before current scroll position
      const priorElements = hiddenElements.filter(element => element.getBoundingClientRect().top <= 0);
      revealed = [...priorElements, ...revealed];
      // sort elements in vertically descending order
      revealed = revealed.sort((prev, next) => prev.getBoundingClientRect().top - next.getBoundingClientRect().top);

      revealed.forEach(element => element.classList.add('revealed'));
      // returns un-revealed elements
      return removeElementsFrom(hiddenElements, revealed);
    }
    // add 'fadeInUp reveal effect' on elements with '.fadeInUp' class
    function addFadeInUpEffects() {
      // reveal elements on document.ready and return leftover hidden elements
      let targetElements = [...(document.querySelectorAll('.fadeInUp'))];
      // initiate first round of revealing
      targetElements = revealElements(targetElements);

      window.addEventListener('scroll', function fadeInUp() {
        targetElements = revealElements(targetElements);
        // if there are no elements to be revealed then detach fadeInUp scroll event
        if (targetElements.length === 0)
          window.removeEventListener('scroll', fadeInUp);
      });
    }
    $(document).ready(function() {
      addFadeInUpEffects();
    });
  </script>
</body>
</html>