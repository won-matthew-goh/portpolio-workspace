<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<link rel="stylesheet" href="/css/board-write.css" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String movieTitle = request.getParameter("movieTitle");
String movieIdStr = request.getParameter("movieId");
String posterPath = request.getParameter("posterPath");
String userIdStr = "1"; // 예제용으로 고정된 사용자 ID. 실제 구현에서는 세션이나 인증 정보를 통해 받아와야 합니다.

int movieId = movieIdStr != null ? Integer.parseInt(movieIdStr) : 0;
int userId = userIdStr != null ? Integer.parseInt(userIdStr) : 0;
request.setAttribute("movieTitle", movieTitle);
request.setAttribute("movieId", movieId);
request.setAttribute("posterPath", posterPath);
request.setAttribute("userId", userId);
%>

<!-- 평점 배열을 JSTL을 사용하여 정의 -->
<c:set var="ratings"
	value="${[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0]}" />

<div class="content-wrapper w100">
	<div class="content-wrap">
		<div class="content">
			<c:choose>
				<c:when test="${not empty board}">
					<form action="<c:url value='/review/edit'/>" method="post" onsubmit="return validateForm()">
						<input type="hidden" name="reviewId" value="${board.reviewId}" />
						<input type="hidden" name="userId" value="${board.userId}" />
						<input type="hidden" name="username" value="${board.username}" />
						<h2>리뷰 수정</h2>
				</c:when>
				<c:otherwise>
					<form action="<c:url value='/review/new'/>" method="post" onsubmit="return validateForm()">
						<input type="hidden" name="movieId" value="${movieId}" />
						<input type="hidden" name="movieNm" value="${movieTitle}" />
						<input type="hidden" name="posterUrl" value="${posterPath}" />
						<input type="hidden" name="userId" value="${userId}" />
						<input type="hidden" name="username" value="${username}" />
						<h2>리뷰 글쓰기</h2>
				</c:otherwise>
			</c:choose>
			<div class="txt colh">
				<p class="listcolumn"><spring:message code="review.username" /></p>
				<span class="txtspan">${username}</span>
			</div>
			<div class="txt colh">
				<p class="listcolumn"><spring:message code="review.movieTitle" /></p>
				<span class="txtspan">
				<c:choose>
					<c:when test="${not empty board.movieNm || empty movieTitle}">
					${board.movieNm}
					</c:when>
					<c:when test="${empty board.movieNm || not empty movieTitle}">
					${movieTitle}
					</c:when>
				</c:choose>
			</span>
			</div>

			<div class="title txt colh">
				<p class="listcolumn"><spring:message code="review.contentTitle" /></p>
				<input name="title" class="title-input" type="text"
					placeholder="제목을 입력해주세요" value="${board.title}" />
			</div>

			<div class="score txt colh">
				<p class="listcolumn"><spring:message code="review.rating" /></p>
				<div class="rating">
					<c:forEach var="i" items="${ratings}" varStatus="status">
						<c:set var="starId" value="star${status.index}" />
						<label class="rating-label  <c:choose>
											            <c:when test="${status.index mod 2 eq 0}">rating-half</c:when>
											            <c:otherwise>rating-full</c:otherwise>
											        </c:choose>" for="${starId}"> 
							<input type="radio" id="${starId}" class="rating-input" name="rating" value="${i}" <c:if test="${board.rating == i}">checked</c:if> />
							<span class="star-icon"<c:if test="${board.rating >= i}">class="filled"</c:if>></span>
						</label>
					</c:forEach>
				</div>
			</div>

			<div class="txt txtarea-div">
				<p class="listcolumn"><spring:message code="review.content" /></p>
				<textarea name="comment" placeholder="<spring:message code="review.contentPHolder" />">${board.comment}</textarea>
			</div>

			<div class="bottom-btn">
				<button class="nav-bt bt-black" type="submit">
					<c:choose>
						<c:when test="${not empty board}"><spring:message code="review.edit" /></c:when>
						<c:otherwise><spring:message code="review.write" /></c:otherwise>
					</c:choose>
				</button>
				<a href="/movieList" class="nav-bt bt-gray"><spring:message code="review.cancel" /></a>
			</div>
			</form>
		</div>
	</div>
</div>

<script src="/js/board-write.js"></script>
