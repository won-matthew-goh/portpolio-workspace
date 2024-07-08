<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container w100 p-3 text-light-emphasis bg-dark-subtle border border-dark-subtle rounded-3" style="height: 100vh; display: flex; flex-direction: column; justify-content: center; gap: 1em;">
    <h1 style="width: 100%; text-align: center;'"><spring:message code="signup.success.welcome"/></h1>
    <h2 style="width: 100%; text-align: center;'"><spring:message code="signup.success.redirect"/></h2>
</div>

</body>
<script>
alert('<spring:message code="signup.success.alert"/>');
setTimeout(function() {location.href='/login';}, 5000);
</script>
</html>