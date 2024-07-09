<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<link rel="stylesheet" href="/css/board.css" />
<div class="board-wrapper">
	<div class="board_wrap">
		<div class="board_title">
			<h2><spring:message code="review.title" /></h2>
			<form name="searchForm" method="get" action="/review/search">
				<div class="search">
					<select class="search-option" name="searchOption"
						onchange="updatePlaceholder()">
						<option value="0"><spring:message code="review.choice" /></option>
						<option value="movie_nm"><spring:message code="review.movieTitle" /></option>
						<option value="title"><spring:message code="review.contentTitle" /></option>
					</select> <input id="searchInput" name="keyword" type="text"
						placeholder="<spring:message code="review.selectValidation" />" />
					<button id="searchButton" type="submit">
						<i class="fa-sharp fa-solid fa-magnifying-glass"></i>
					</button>
				</div>
			</form>
		</div>
		<div class="board_list_wrap">
			<div class="board_list">
				<div class="top">
					<div class="pnum">NO</div>
					<div class="name"><spring:message code="review.movieTitle" /></div>
					<div class="title"><spring:message code="review.contentTitle" /></div>
					<div class="writer"><spring:message code="review.username" /></div>
					<div class="readCnt"><spring:message code="review.readCnt" /></div>
					<div class="date"><spring:message code="review.date" /></div>
				</div>
				<!-- 글목록 조회 + 게시글 클릭 시 조회수 카운트 동작 -->
				<form action="<c:url value='/review/read'/>">
					<c:forEach var="lists" items="${list}">
						<div class="inside"
							onclick="location.href='/review/read?reviewId=${lists.reviewId}'">
							<div class="pnum">${lists.reviewId}</div>
							<div class="name">
								<a>${lists.movieNm}</a>
							</div>
							<div class="title">${lists.title}</div>
							<div class="writer">${lists.username}</div>
							<div class="readCnt">${lists.readCnt}</div>
							<div class="date">${lists.createdAt}</div>
						</div>
					</c:forEach>
				</form>
			</div>
			<!-- action에 설정한 컨트롤러 경로로 데이터 전송 -->
			<form action="/review" method="get">
				<div class="board_page">
					<c:if test="${pageMaker.prev}">
						<button type="submit" name="pageNum" value="${pageMaker.vo.pageNum - 1}" class="btn prev">◀◀</button>
						<button type="submit" name="pageNum" value="${pageMaker.beginPage - 1}" class="btn first">◀</button>
					</c:if>

					<c:forEach var="num" begin="${pageMaker.beginPage}" end="${pageMaker.endPage}">
						<button type="submit" name="pageNum" value="${num}" class="pnum click">${num}</button>
					</c:forEach>

					<c:if test="${pageMaker.next}">
						<button type="submit" name="pageNum" value="${pageMaker.vo.pageNum + 1}" class="btn next">▶</button>
						<button type="submit" name="pageNum" value="${pageMaker.endPage + 1}" class="btn last">▶▶</button>
					</c:if>

					<input type="hidden" name="countPerPage" value="${pageMaker.vo.countPerPage}">
				</div>
			</form>
		</div>
	</div>
</div>
<script src="/js/list.js"></script>
