<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./includes/header.jsp"%>
<link rel="stylesheet" href="/css/boxoffice.css" />
    <div class="content-wrapper w100">
    <h1>${movie }</h1>
      <div class="rank-wrap">
        <c:forEach var="movie" items="${movies}">
          <h1>${movie.movieNm}</h1>
          <h1>${movie.audiCnt}</h1>
        </c:forEach>
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
            <tr>
              <td>1</td>
              <td>원더랜드</td>
              <td>2024-06-05</td>
              <td>464330</td>
              <td>468801</td>
            </tr>
            <tr>
              <td>2</td>
              <td>퓨리오사: 매드맥스 사가</td>
              <td>2024-05-22</td>
              <td>367596</td>
              <td>1418622</td>
            </tr>
            <tr>
              <td>3</td>
              <td>그녀가 죽었다</td>
              <td>2024-05-15</td>
              <td>181122</td>
              <td>1134094</td>
            </tr>
            <tr>
              <td>4</td>
              <td>범죄도시4</td>
              <td>2024-04-24</td>
              <td>148225</td>
              <td>11421632</td>
            </tr>
            <tr>
              <td>5</td>
              <td>설계자</td>
              <td>2024-05-29</td>
              <td>129786</td>
              <td>501892</td>
            </tr>
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
  <script src="/js/boxoffice.js"></script>
</html>
