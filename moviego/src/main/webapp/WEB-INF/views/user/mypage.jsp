<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/mypage.css" />

<div class="content-wrapper w100">
    <div class="content-wrap">
        <h1><spring:message code="mypage.title"/></h1>

        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>

        <form class="change-password-form" action="/mypage/changePassword" method="post">
            <h2><spring:message code="mypage.chpasswd.title"/></h2>
            <input class="pw-input" type="password" name="currentPassword" placeholder="<spring:message code='mypage.password.current'/>" required />
            <input class="pw-input" type="password" name="newPassword" placeholder="<spring:message code='mypage.password.new'/>" required />
            <input class="pw-vali-input" type="password" name="newPasswordConfirm" placeholder="<spring:message code='mypage.password.confirm'/>" required />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button class="nav-bt bt-black bt-submit" type="submit"><spring:message code="mypage.password.button"/></button>
        </form>

        <form class="change-email-form" action="/mypage/changeEmail" method="post">
            <h2><spring:message code="mypage.chemail.title"/></h2>
            <input class="email-input" type="email" name="newEmail" placeholder="<spring:message code='mypage.email.new'/>" required />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button class="nav-bt bt-black bt-submit" type="submit"><spring:message code="mypage.email.button"/></button>
        </form>
    </div>
</div>
</body>
</html>