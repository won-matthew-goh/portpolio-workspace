<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<link rel="stylesheet" href="/css/board.css" />
<div class="board-wrapper">
	<div class="board_wrap">
		<div class="board_title">
			<h2>관객 리뷰</h2>
			<div class="search">
				<select class="search-option" name="searchOption"
					onchange="select()">
					<option value="0">선택</option>
					<option value="title">제목</option>
					<option value="userId">사용자</option>
				</select> <input id="searchInput" type="text" placeholder="제목 입력 " />
				<button id="searchButton" type="submit">
					<i class="fa-sharp fa-solid fa-magnifying-glass"></i>
				</button>
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
						<div class="name">
							<a>${lists.movieNm}</a>
						</div>
						<div class="title">${lists.title}</div>
						<div class="writer">${lists.userId}</div>
						<div class="readCnt">${lists.readCnt}</div>
						<div class="date">${lists.createdAt}</div>
					</div>
				</c:forEach>

			</div>
			<!-- action에 설정한 컨트롤러 경로로 데이터 전송 -->
			<form action="/review" method="get">
				<div class="board_page">
					<c:if test="${pageMaker.prev}">
						<button type="submit" name="pageNum"
							value="${pageMaker.beginPage - 1}" class="btn first">◀◀</button>
						<button type="submit" name="pageNum"
							value="${pageMaker.vo.pageNum - 1}" class="btn prev">◀</button>
					</c:if>

					<c:forEach var="num" begin="${pageMaker.beginPage}"
						end="${pageMaker.endPage}">
						<button type="submit" name="pageNum" value="${num}"
							class="pnum click">${num}</button>
					</c:forEach>

					<c:if test="${pageMaker.next}">
						<button type="submit" name="pageNum"
							value="${pageMaker.vo.pageNum + 1}" class="btn next">▶</button>
						<button type="submit" name="pageNum"
							value="${pageMaker.endPage + 1}" class="btn last">▶▶</button>
					</c:if>

					<input type="hidden" name="countPerPage"
						value="${pageMaker.vo.countPerPage}">
				</div>
			</form>
		</div>
	</div>
</div>