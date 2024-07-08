<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
<link rel="stylesheet" href="/css/member_join.css" />

<div class="content-wrapper w100">
    <div class="content-wrap">
        <form class="join-form" action="/user/joinProc" method="post">
            <h1>Movie Go</h1>
            <h2>회원가입</h2>
            <c:forEach items="${errors}" var="error">
                <p class="notice-txt" style="color: red;">* ${error.defaultMessage}</p>
            </c:forEach>
            <p class="notice-txt alert-invaild-username" style="display: none;">유저명은 영문 소문자와 숫자만 사용하실 수 있습니다.</p>
            <input class="usernm-input" type="text" name="username" placeholder="유저명" />
            <p class="notice-txt alert-psswd-txt" style="display: none;">* 비밀번호가 일치하지 않습니다.</p>
            <input class="pw-input" type="password" name="passwd" placeholder="비밀번호" />
            <input class="pw-vali-input" type="password" name="password_vali" placeholder="비밀번호 확인" />
            <p class="notice-txt alert-duplicate-email" style="display: none;">* ${error}</p>
            <input class="email-input" type="text" name="email" placeholder="이메일" />
            <button class="nav-bt bt-black bt-submit" type="submit">가입</button>
            <button class="nav-bt bt-gray" type="reset">취소</button>
        </form>
    </div>
</div>
</body>
<script>const errorMsg = "${error}";</script>
<script src="/js/memberjoin.js"></script>
</html>
