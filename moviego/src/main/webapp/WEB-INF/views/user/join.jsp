<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<link rel="stylesheet" href="/css/member_join.css" />
<div class="content-wrapper w100">
  <div class="content-wrap">
    <form class="join-form" action="/user/joinProc" method="post">
      <h1>Movie Go</h1>
      <h2>회원가입</h2>
      
      <c:if test="${not empty usernameError}">
        <p class="notice-txt alert-duplicate-username">* ${usernameError}</p>
      </c:if>
      
      <c:if test="${not empty validationErrors}">
        <c:forEach items="${validationErrors}" var="error">
          <c:if test="${error.field == 'username'}">
            <p class="notice-txt alert-invalid-username">* ${error.defaultMessage}</p>
          </c:if>
        </c:forEach>
      </c:if>
      
      <input class="usernm-input" type="text" name="username" placeholder="유저명" />
      
      <c:if test="${not empty validationErrors}">
        <c:forEach items="${validationErrors}" var="error">
          <c:if test="${error.field == 'passwd'}">
            <p class="notice-txt alert-invalid-password">* ${error.defaultMessage}</p>
          </c:if>
        </c:forEach>
      </c:if>
      
      <input class="pw-input" type="password" name="passwd" placeholder="비밀번호" />
      <input class="pw-vali-input" type="password" name="password_vali" placeholder="비밀번호 확인" />
      
      <c:if test="${not empty emailError}">
        <p class="notice-txt alert-duplicate-email">* ${emailError}</p>
      </c:if>
      
      <c:if test="${not empty validationErrors}">
        <c:forEach items="${validationErrors}" var="error">
          <c:if test="${error.field == 'email'}">
            <p class="notice-txt alert-invalid-email">* ${error.defaultMessage}</p>
          </c:if>
        </c:forEach>
      </c:if>
      
      <input class="email-input" type="text" name="email" placeholder="이메일" />
      
      <button class="nav-bt bt-black" type="submit">가입</button>
      <button class="nav-bt bt-gray" type="reset">취소</button>
    </form>
  </div>
</div>
<script>
  const errorMsg = '${error}';
</script>
<script src="/js/memberjoin.js"></script>
</html>
