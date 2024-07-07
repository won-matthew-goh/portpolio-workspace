<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<link rel="stylesheet" href="/css/board-write.css" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String movieTitle = request.getParameter("movieTitle");
    String movieId = request.getParameter("movieId");
    String posterPath = request.getParameter("posterPath");
    String userId = "김씨"; // 예제용으로 고정된 사용자 ID. 실제 구현에서는 세션이나 인증 정보를 통해 받아와야 합니다.
%>
<div class="content-wrapper w100">
	<div class="content-wrap">
		<div class="content">
			<!-- Action URL과 버튼 텍스트를 수정 모드와 작성 모드에 따라 변경 -->
			<c:choose>
				<c:when test="${not empty board}">
					<form action="<c:url value='/review/edit'/>" method="post">
						<input type="hidden" name="reviewId" value="${board.reviewId}" />
						<h2>리뷰 수정</h2>
				</c:when>
				<c:otherwise>
                    <form action="<c:url value='/review/new'/>" method="post">
                        <input type="hidden" name="movieId" value="${movieId}" />
                        <input type="hidden" name="movieNm" value="${movieTitle}" />
                        <input type="hidden" name="posterUrl" value="${posterPath}" />
                        <input type="hidden" name="userId" value="${userId}" />
						<h2>리뷰 글쓰기</h2>
				</c:otherwise>
			</c:choose>

			<div name="userId" class="txt">
				사용자 ID<span class="txtspan">${userId}</span>
			</div>
			<div name="movieNm" class="txt">
				영화명<span class="txtspan">${movieTitle}</span>
			</div>

			<div class="title txt">
				글제목 <input name="title" class="title-input" type="text"
					placeholder="제목을 입력해주세요" value="${board.title}" />
			</div>

			<div class="score txt">
				평점
				<div class="rating">
					<c:forEach var="i" begin="0.5" end="5.0" step="0.5">
						<c:set var="starId" value="star${i}" />
						<label class="rating-label" for="${starId}"> <input
							type="radio" id="${starId}" class="rating-input" name="rating"
							value="${i}" <c:if test="${board.rating eq i}">checked</c:if> />
							<span class="star-icon"></span>
						</label>
					</c:forEach>
				</div>
			</div>

			<div class="txt txtarea-div">
				관객평
				<textarea name="comment" placeholder="관객평을 입력해주세요">${board.comment}</textarea>
			</div>

			<div class="bottom-btn">
				<button class="nav-bt bt-black" type="submit">
					<c:choose>
						<c:when test="${not empty board}">수정</c:when>
						<c:otherwise>등록</c:otherwise>
					</c:choose>
				</button>
				<a href="#" class="nav-bt bt-gray">취소</a>
			</div>
			</form>
		</div>
	</div>
</div>

<script src="/js/board-write.js"></script>