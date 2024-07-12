<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@include file="./includes/header.jsp"%>
    <link rel="stylesheet" href="/css/movie_list.css" />
	  <div class="content-wrapper">
      <div class="content-wrap" id="content-wrap">
      <div class="search">
          <h5>Search 'SAMUI'!!</h5>
          <input id="searchInput" type="text" placeholder="<spring:message code='movie.search.placeholder'/>" name="query" />
          <button id="searchButton" type="submit">
          <i class="fa-sharp fa-solid fa-magnifying-glass"></i>
          </button>
      </div>
        <div class="box">
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
