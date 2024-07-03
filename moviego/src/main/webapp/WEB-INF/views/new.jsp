<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./includes/header.jsp"%>
<link rel="stylesheet" href="/css/board-write.css" />
 <div class="content-wrapper w100">
      <div class="content-wrap">
        <div class="content">
          <form action= "<c:url value='/review/new'/>" method= "post">
          <h2>리뷰 글쓰기</h2>
          <div name="userId" class="txt">사용자 ID<span class="txtspan">김씨</span></div>
          <div name="movieNm" class="txt">영화명<span class="txtspan">인사이드아웃2</span></div>
          <div class="title txt">
            글제목
            <input name="title" class="title-input" type="text" placeholder="제목을 입력해주세요" />
          </div>
          <div class="score txt">
            평점
            <div class="rating">
              <label class="rating-label rating-half" for="starhalf">
                <input type="radio" id="starhalf" class="rating-input" name="rating" value="0.5" />
                <span class="star-icon"></span>
              </label>
              <label class="rating-label rating-full" for="star1">
                <input type="radio" id="star1" class="rating-input" name="rating" value="1.0" />
                <span class="star-icon"></span>
              </label>
              <label class="rating-label rating-half" for="star1half">
                <input type="radio" id="star1half" class="rating-input" name="rating" value="1.5" />
                <span class="star-icon"></span>
              </label>
              <label class="rating-label rating-full" for="star2">
                <input type="radio" id="star2" class="rating-input" name="rating" value="" />
                <span class="star-icon"></span>
              </label>
              <label class="rating-label rating-half" for="star2half">
                <input type="radio" id="star2half" class="rating-input" name="rating" value="" />
                <span class="star-icon"></span>
              </label>
              <label class="rating-label rating-full" for="star3">
                <input type="radio" id="star3" class="rating-input" name="rating" value="" />
                <span class="star-icon"></span>
              </label>
              <label class="rating-label rating-half" for="star3half">
                <input type="radio" id="star3half" class="rating-input" name="rating" value="" />
                <span class="star-icon"></span>
              </label>
              <label class="rating-label rating-full" for="star4">
                <input type="radio" id="star4" class="rating-input" name="rating" value="" />
                <span class="star-icon"></span>
              </label>
              <label class="rating-label rating-half" for="star4half">
                <input type="radio" id="star4half" class="rating-input" name="rating" value="" />
                <span class="star-icon"></span>
              </label>
              <label class="rating-label rating-full" for="star5">
                <input type="radio" id="star5" class="rating-input" name="rating" value="" />
                <span class="star-icon"></span>
              </label>
            </div>
          </div>
          <div class="txt txtarea-div">
            관객평
            <textarea name="comment" placeholder="관객평을 입력해주세요"></textarea>
          </div>
          <div class="bottom-btn">
            <button class="nav-bt bt-black" value="등록"></button>
            <a href="#" class="nav-bt bt-gray">취소</a>
          </div>
          </form>
        </div>
      </div>
    </div>
  </body>
  <script src="/js/board-write.js"></script>
</body>
</html>