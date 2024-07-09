<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="/css/board-result.css" />
<div class="content-wrapper w100">
    <div class="content-wrap">
        <h2><spring:message code="review.read.audience.comment"/></h2>
        <div class="content-wp">
            <div class="contents">
                <div class="user-id-div content">
                    <p class="main-title"><spring:message code="review.read.title"/></p>
                    <p class="main-title"><c:out value="${board.title}"/></p>
                </div>
                <div class="user-id-div content">
                    <p class="user-id"><spring:message code="review.read.user"/></p>
                    <p class="user-id"><c:out value="${board.username}"/></p>
                </div>
                <div class="title-div content">
                    <p class="title"><spring:message code="review.read.movie.name"/></p>
                    <p class="title"><c:out value="${board.movieNm}"/></p>
                </div>
                <div class="star-div content">
                    <p class="star"><spring:message code="review.read.rating"/></p>
                    <p class="star"><c:out value="${board.rating}"/></p>
                </div>
                <div class="comment-div content">
                    <p class="comment"><spring:message code="review.read.audience.review"/></p>
                    <p class="comment"><c:out value="${board.comment}"/></p>
                </div>
            </div>
            <div class="img-btn-div">
                <img src="https://image.tmdb.org/t/p/w200${fn:escapeXml(board.posterUrl)}" alt="<spring:message code="review.read.poster.alt" arguments="${board.movieNm}"/>" />
            </div>
        </div>
        <div class="bottom-btn">
            <form action="<c:url value='/review/report'/>" method="post" style="display: inline;">
                <input type="hidden" name="reviewId" value="${board.reviewId}" />
                <button type="submit" class="btn btn-light py-2 px-3"><spring:message code="review.read.report"/></button>
            </form>

            <c:if test="${currentUser != null && currentUser.userId == board.userId}">
                <button onclick="editReview()" class="btn btn-success py-2 px-3"><spring:message code="review.read.edit"/></button>
                <form action="<c:url value='/review/delete'/>" method="post" style="display: inline;">
                    <input type="hidden" name="reviewId" value="${board.reviewId}" />
                    <button type="submit" class="btn btn-danger py-2 px-3"><spring:message code="review.read.delete"/></button>
                </form>
            </c:if>
        </div>
    </div>
</div>
</body>
<script>
function editReview() {
    document.location.href = "<c:url value='/review/edit?reviewId=${board.reviewId}'/>";
}
</script>
</html>