<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href="/css/member_join.css" />

<div class="content-wrapper w100">
    <div class="content-wrap">
        <form class="join-form" action="/user/joinProc" method="post">
            <h1>Movie Go</h1>
            <h2><spring:message code="signup.title"/></h2>

            <!-- 서버에서 전달된 에러 메시지 처리 -->
            <c:if test="${not empty error}">
                <p class="notice-txt" style="color: red;">* ${error}</p>
            </c:if>

            <!-- 유효성 검사 오류 메시지 -->
            <c:forEach items="${errors}" var="error">
                <p class="notice-txt duplicatemsg" style="color: red;">* ${error.defaultMessage}</p>
            </c:forEach>

            <!-- 유저명 관련 에러 메시지 -->
            <p class="notice-txt alert-invaild-username" style="display: none;"><spring:message code="signup.username.invalid"/></p>
            <%-- <p class="notice-txt alert-duplicate-username" style="display: none;">* <spring:message code="error.duplicate.username" arguments="${error}"/></p> --%>
            <p class="notice"><spring:message code="signup.username.notice"/></p>
            <input class="usernm-input" type="text" name="username" placeholder="<spring:message code='signup.username'/>" />

            <!-- 비밀번호 관련 에러 메시지 -->
            <p class="notice-txt alert-psswd-txt" style="display: none;"><spring:message code="signup.password.mismatch"/></p>
            <p class="notice"><spring:message code="signup.password.notice"/></p>
            <input class="pw-input" type="password" name="passwd" placeholder="<spring:message code='signup.password'/>" />
            <input class="pw-vali-input" type="password" name="password_vali" placeholder="<spring:message code='signup.confirm-password'/>" />

            <!-- 이메일 관련 에러 메시지 -->
            <%-- <p class="notice-txt alert-duplicate-email" style="display: none;">* <spring:message code="error.duplicate.email" arguments="${error}"/></p> --%>
            <input class="email-input" type="text" name="email" placeholder="<spring:message code='signup.email'/>" />

            <button class="nav-bt bt-black bt-submit" type="submit"><spring:message code="signup.button"/></button>
            <button class="nav-bt bt-gray" type="reset"><spring:message code="signup.cancel"/></button>
        </form>
    </div>
</div>
</body>
<script>const errorMsg = "${error}";</script>
<script src="/js/memberjoin.js"></script>
</html>