<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@include file="./includes/header.jsp"%>
    <link rel="stylesheet" href="/css/movie_list.css" />
	  <div class="content-wrapper">
      <div class="content-wrap" id="content-wrap">
      <div class="search">
     <!-- <form class="search" id="search" method="get" action="/movieList/search"> -->
          <input id="searchInput" type="text" placeholder="영화 입력 " name="query" />
          <button id="searchButton" type="submit">
          <i class="fa-sharp fa-solid fa-magnifying-glass"></i>
          </button>
<!--         </form> -->
      </div>
        <div class="box">
<%--         <c:forEach var="movie" items="${movies}">
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
        </c:forEach> --%>
        </div>
      </div>
    </div>
    <!-- modal -->
    <div class="modal-bg"></div>
    <div class="modal-wrap">
    </div>
  </body>
  <script src="/js/util/location.js"></script>
  <script src="/js/util/genre.js"></script>
  <script src="/js/movie_list.js"></script>
  <script src="/js/search.js"></script>
</html>
