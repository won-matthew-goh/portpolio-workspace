<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./includes/header.jsp"%>
<link rel="stylesheet" href="/css/boxoffice.css" />
    <div class="content-wrapper w100">
      <div class="rank-wrap">
      <h1>한 주간 관객별 박스오피스 순위</h1>
        <table class="rank-table">
          <thead>
            <tr>
              <th scope="col">순위</th>
              <th scope="col">영화명</th>
              <th scope="col">개봉일</th>
              <th scope="col">주간 관객수</th>
              <th scope="col">누적 관객수</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="movie" items="${movies}">
              <tr>
                <td>${movie.rank}</td>
                <td>${movie.movieNm}</td>
                <td>${movie.openDt}</td>
                <td>${movie.audiCnt}</td>
                <td>${movie.audiAcc}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <div class="chart-wrap">
        <h1>관객수 증감</h1>
        <div class="chart-wp">
          <canvas id="weekChart" width="300" height="100"></canvas>
        </div>
      </div>
    </div>
  </body>
  <script>
  /****** JSTL + EL로 빈 배열에 영화 정보 push ******/
  	let movieArray = [];
  	
  	<c:forEach var="movie" items="${movies}">
  		movieArray.push({
          movieNm: "${movie.movieNm}",
          audiInten: "${movie.audiInten}"
      });
	</c:forEach>
  </script>
  <script src="/js/boxoffice.js"></script>
</html>
