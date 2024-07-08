<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href="/css/login.css" />
<div class="content-wrapper w100">
    <div class="content-wrap">
        <form class="login-form" method="post" action="<c:url value='/login'/>">
            <h1>Movie Go</h1>
            <h2><spring:message code="login.title"/></h2>
            <c:if test="${param.error != null}">
                <p class="error-message">
                    <spring:message code="login.error"/>
                </p>
            </c:if>
            <input class="id-input" type="text" name="username" placeholder="<spring:message code='login.username'/>" />
            <input class="pw-input" type="password" name="password" placeholder="<spring:message code='login.password'/>" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button class="nav-bt bt-black" type="submit"><spring:message code="login.button"/></button>
            <div class="img-wp">
                <img class="naverlogin" src="https://upload.wikimedia.org/wikipedia/commons/f/f2/Kakao_logo.jpg" alt="kakao" />
                <img class="kakaologin" src="https://i.namu.wiki/i/p_1IEyQ8rYenO9YgAFp_LHIAW46kn6DXT0VKmZ_jKNijvYth9DieYZuJX_E_H_4GkCER_sVKhMqSyQYoW94JKA.svg" alt="naver" />
            </div>
        </form>
    </div>
</div>
</body>
</html>