<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<div class="container w100 p-3 text-light-emphasis bg-dark-subtle border border-dark-subtle rounded-3" style="height: 100vh; display: flex; flex-direction: column; justify-content: center; gap: 1em;">
<h1 style="width: 100%; text-align: center;'">회원 가입을 환영합니다.</h1>
<h2 style="width: 100%; text-align: center;'">5초 뒤, 로그인 페이지로 이동합니다.</h2>
</div>

</body>
<script>
  alert('회원 가입을 환영합니다!');
  setTimeout(function() {location.href='/login';}, 5000);
</script>
</html>