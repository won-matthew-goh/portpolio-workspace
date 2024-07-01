<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@include file="./includes/header.jsp"%>
    <link rel="stylesheet" href="/css/movie_list.css" />
	  <div class="content-wrapper">
      <div class="content-wrap" id="content-wrap">
        <div class="search">
          <input type="text" placeholder="영화 입력 " />
          <i class="fa-sharp fa-solid fa-magnifying-glass"></i>
        </div>
        <div class="box">
        <c:forEach var="movie" items="${movies}">
          <div class="movie" data-aos="flip-up">
            <img
              src="https://image.tmdb.org/t/p/w200${movie.posterPath}"
              width="225" height="337.5"
            />
            <div class="movie-id">${movie.id}</div>
            <div class="movie-name">${movie.title}</div>
            <div class="release-date">${movie.releaseDate}</div>
            <div class="nation">
            <c:choose>
               <c:when test="${movie.originalLanguage eq 'en'}">
                미국
               </c:when>
               <c:when test="${movie.originalLanguage eq 'ko'}">
                한국
               </c:when>
               <c:when test="${movie.originalLanguage eq 'fr'}">
               프랑스
               </c:when>
               <c:when test="${movie.originalLanguage eq 'bn'}">
               브루나이
               </c:when>
               <c:when test="${movie.originalLanguage eq 'pl'}">
               폴란드
               </c:when>
               <c:otherwise>
                미상
               </c:otherwise>
            </c:choose>
            </div>
          </div>
        </c:forEach>
        </div>
      </div>
    </div>
    <!-- modal -->
    <div class="modal-bg"></div>
    <div class="modal-wrap">
      <div class="btn">
        <i class="fa-solid fa-xmark"></i>
      </div>
      <div class="movie-name">[인사이드아웃2]</div>
      <div class="modal-wp">
        <div class="modal-poster">
          <img
            src="https://an2-img.amz.wtchn.net/image/v2/2sLPR0moUjGnMwiyERLGkQ.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk5Ea3dlRGN3TUhFNE1DSmRMQ0p3SWpvaUwzWXlMM04wYjNKbEwybHRZV2RsTHpReU5EYzROREUxT0RNM09UTTBPVGtpZlEuaDdDUXMyb0VLNldwRFl6WTNLaFl2UWlWYmw0RHhUWVBMdm45R3Q5SWEzaw"
          />
        </div>
        <div class="modal-info">
          <div id="release-date">
            <div class="title">개봉일자</div>
            <div class="content">2024</div>
          </div>
          <div id="nation">
            <div class="title">국가</div>
            <div class="content">미국</div>
          </div>
          <div id="genre">
            <div class="title">장르</div>
            <div class="content"></div>
          </div>
          <div id="grade">
            <div class="title">등급</div>
            <div class="content"></div>
          </div>
          <div id="evaluation">
            <div class="title">평점</div>
            <div class="content"></div>
          </div>
          <div id="voteCnt">
            <div class="title">총 투표수</div>
            <div class="content"></div>
          </div>
        </div>
      </div>
      <div class="modal-box">
        <p class="content">내용입니다.</p>
        <div class="btn">
          <button class="btn btn-light">리뷰쓰러가기</button>
          <button class="close-btn">닫기</button>
        </div>
      </div>
    </div>
  </body>
  <script>
  const apiKey = "${apikey}";
  </script>
  <script src="/js/movie_list.js"></script>
</html>
