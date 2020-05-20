<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<footer class="fixed">
  <div class="container">
    <ul>
      <li>
        <a href="/">
          <i class="far fa-home-alt"></i>
          <span>홈</span>
        </a>
      </li>
      <li>
        <a href="/search">
          <i class="far fa-search"></i>
          <span>검색</span>
        </a>
      </li>
      <li>
        <a href="/feed">
          <i class="fad fa-stream"></i>
          <span>피드</span>
        </a>
      </li>
      <li>
        <a href="/booklist/myLibList">
          <i class="fas fa-books"></i>
          <span>내서재</span>
        </a>
      </li>
      <li>
        <a href="/myaccount">
          <i class="far fa-user"></i>
          <span>관리</span>
        </a>
      </li>
    </ul>
    <button type="button" class="scroll-to-top">
      <i class="fad fa-chevron-double-up"></i>
    </button>
    <!-- add scroll-to-top function -->
    <script>
      $(document).ready(function () {
        const button = document.querySelector("footer .scroll-to-top");
        button.addEventListener("click", () => {
          document.documentElement.style.scrollBehavior = "smooth";
          document.documentElement.scrollTop = 0;
          document.documentElement.style.scrollBehavior = "";
        });

        let timeoutID = null;
        window.addEventListener("scroll", () => {
          if (document.documentElement.scrollTop === 0) {
            button.classList.remove("visible");
            return;
          }
          if (!button.classList.contains("visible")) {
            button.style.transition = '';
            button.classList.add("visible");
          }
          timeoutID =
            clearTimeout(timeoutID) ||
            setTimeout(() => {
              button.style.transition = "0.4s ease";
              button.classList.remove("visible");
            }, 1200);
        });
      });
    </script>
  </div>
</footer>
