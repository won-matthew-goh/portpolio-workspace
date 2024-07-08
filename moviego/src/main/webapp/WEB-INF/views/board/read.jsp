<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
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
					<p class="user-id">사용자</p>
					<p class="user-id">${board.username}</p>
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
				<img src="${board.posterUrl}" alt="${board.movieNm} 포스터" />

			</div>
		</div>
		<div class="bottom-btn">
			<form action="<c:url value='/review/report'/>" method="post"
				style="display: inline;">
				<input type="hidden" name="reviewId" value="${board.reviewId}" />
				<button type="submit" class="btn btn-danger py-2 px-3">신고하기</button>
			</form>

			<c:if test="${board.userId == 1}">
				<!-- sessionScope.userId로 바꿔주어야함 -->
				<button onclick="editReview()" class="btn btn-dark py-2 px-3">수정</button>
				<form action="<c:url value='/review/delete'/>" method="post"
					style="display: inline;">
					<input type="hidden" name="reviewId" value="${board.reviewId}" />
					<button type="submit" class="btn btn-light py-2 px-3">삭제</button>
				</form>
			</c:if>
		</div>
	</div>
</div>
</body>
<script>
	function editReview() {
		document.location.href = "<c:url value='/review/edit?reviewId=${board.reviewId}'/>"
	}
</script>
</html>
