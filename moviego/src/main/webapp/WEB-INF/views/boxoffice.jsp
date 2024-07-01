<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./includes/header.jsp"%>
<link rel="stylesheet" href="/css/boxoffice.css" />
    <div class="content-wrapper w100">
      <div class="rank-wrap">
      <h1>금주의 관객별 박스오피스 순위</h1>
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
<!--   <script src="/js/boxoffice.js"></script> -->
  <script>
  	let weekCt = document.getElementById('weekChart');
  	let movieArray = [];
  	
  	<c:forEach var="movie" items="${movies}">
  		movieArray.push({
          movieNm: "${movie.movieNm}",
          audiInten: "${movie.audiInten}"
      });
	</c:forEach>
  	
  	let weekChart = new Chart(weekCt, {
  	  type: 'bar',
  	  data: {
  	    axis: 'y',
  	    labels: [movieArray[0].movieNm, movieArray[1].movieNm, movieArray[2].movieNm, movieArray[3].movieNm, movieArray[4].movieNm],
  	    datasets: [
  	      {
  	        label: '관객수 증감',
  	        data: [movieArray[0].audiInten, movieArray[1].audiInten, movieArray[2].audiInten, movieArray[3].audiInten, movieArray[4].audiInten],
  	        backgroundColor: ['rgba(255, 99, 132, 0.2)', 'rgba(255, 159, 64, 0.2)', 'rgba(255, 205, 86, 0.2)', 'rgba(75, 192, 192, 0.2)', 'rgba(54, 162, 235, 0.2)'],
  	        borderColor: ['rgb(255, 99, 132)', 'rgb(255, 159, 64)', 'rgb(255, 205, 86)', 'rgb(75, 192, 192)', 'rgb(54, 162, 235)'],
  	        borderWidth: 1,
  	      },
  	    ],
  	  },
  	  options: {
  	    indexAxis: 'y',
  	  },
  	});
  </script>
</html>
