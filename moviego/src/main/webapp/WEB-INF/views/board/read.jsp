<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<link rel="stylesheet" href="/css/board-result.css" />
 <div class="content-wrapper w100">
      <div class="content-wrap">
        <h2>관객 코멘트</h2>
        <div class="content-wp">
          <div class="contents">
            <div class="user-id-div content">
              <p class="main-title">글제목</p>
              <p class="main-title">${board.title}</p>
            </div>
            <div class="user-id-div content">
              <p class="user-id">사용자 ID</p>
              <p class="user-id">${board.userId}</p>
            </div>
            <div class="title-div content">
              <p class="title">영화명</p>
              <p class="title">${board.movieNm}</p>
            </div>
            <div class="star-div content">
              <p class="star">평점</p>
              <p class="star">${board.rating}</p>
            </div>
            <div class="comment-div content">
              <p class="comment">관객평</p>
              <p class="comment">${board.comment}</p>
            </div>
          </div>
          <div class="img-btn-div">
          	<!-- 영화명과 일치하는 영화 포스터 url api 호출 -->
            <img src="${board.posterUrl}" />
          </div>
        </div>
        	<!-- 글을 작성한 본인글이면 수정, 삭제 버튼 노출, 아니면 수정 버튼 제거 -->
         <div class="bottom-btn">
            <c:if test="${board.userId == sessionScope.userId}">
                <a href="<c:url value='/review/edit?reviewId=${board.reviewId}'/>" class="nav-bt bt-black">수정</a>
                <form action="<c:url value='/review/delete'/>" method="post" style="display:inline;">
                    <input type="hidden" name="reviewId" value="${board.reviewId}" />
                    <button class="nav-bt bt-gray" type="submit">삭제</button>
                </form>
            </c:if>
        </div>
      </div>
    </div>
</body>
</html>