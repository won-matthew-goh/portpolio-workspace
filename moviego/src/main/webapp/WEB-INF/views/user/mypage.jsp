<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href="/css/mypage.css" />

<div class="content-wrapper w100">
    <div class="content-wrap">
        <h1><spring:message code="mypage.title"/></h1>
        <form class="change-password-form" action="/user/changePassword" method="post">
            <h2><spring:message code="mypage.chpasswd.title"/></h2>
            <input class="pw-input" type="password" name="currentPassword" placeholder="<spring:message code='mypage.password.current'/>" />
            <input class="pw-input" type="password" name="newPassword" placeholder="<spring:message code='mypage.password.new'/>" />
            <input class="pw-vali-input" type="password" name="newPasswordConfirm" placeholder="<spring:message code='mypage.password.confirm'/>" />
            <button class="nav-bt bt-black bt-submit" type="submit"><spring:message code="mypage.password.button"/></button>
        </form>

        <form class="change-email-form" action="/user/changeEmail" method="post">
            <h2><spring:message code="mypage.chemail.title"/></h2>
            <input class="email-input" type="text" name="newEmail" placeholder="<spring:message code='mypage.email.new'/>" />
            <button class="nav-bt bt-black bt-submit" type="submit"><spring:message code="mypage.email.button"/></button>
        </form>
    </div>
</div>
</body>
<!-- <script src="/js/mypage.js"></script> -->
</html>
