<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<link rel="stylesheet" href="/css/board.css" />
 <div class="board-wrapper">
      <div class="board_wrap">
        <div class="board_title">
          <h2>관객 리뷰</h2>
          <div class="search">
            <input type="text" placeholder="영화 입력 " />
            <i class="fa-sharp fa-solid fa-magnifying-glass"></i>
            <i class="fa-sharp fa-solid fa-magnifying-glass"></i>
          </div>
        </div>
        <div class="board_list_wrap">
          <div class="board_list">
            <div class="top">
              <div class="pnum">NO</div>
              <div class="name">영화명</div>
              <div class="title">글제목</div>
              <div class="writer">사용자</div>
              <div class="readCnt">조회수</div>
              <div class="date">작성일자</div>
            </div>
            <c:forEach var="lists" items="${list}">
            <div class="inside" href="/html/board-write.html">
              <div class="pnum">${lists.reviewId}</div>
              <div class="name"><a>${lists.movieNm}</a></div>
              <div class="title">${lists.title}</div>
              <div class="writer">${lists.userId}</div>
              <div class="readCnt">${lists.readCnt}</div>
              <div class="date">${lists.createdAt}</div>
            </div>
            </c:forEach>
          	
          </div>
          <div class="board_page">
            <a href="#" class="btn first"><<</a>
            <a href="#" class="btn prev"><</a>
          	<c:forEach var="page" items="${pages}" varStatus="status">
        	<a href="#" class="pnum click">${page}</a>
		    </c:forEach>
            <a href="#" class="btn next">></a>
            <a href="#" class="btn last">>></a>
          </div>
        </div>
      </div>
    </div>
</body>
</html>