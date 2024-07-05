<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<link rel="stylesheet" href="/css/member_join.css" />
    <div class="content-wrapper w100">
      <div class="content-wrap">
        <form class="join-form" action="/user/joinProc" method="post">
          <h1>Movie Go</h1>
          <h2>회원가입</h2>
          <p class="notice-txt">* 중복되는 사용자 명이 존재합니다.</p>
          <p>유저명은 영문 소문자와 숫자, '_', '-'의 특수기호만 사용하실 수 있습니다.</p>
          <input class="usernm-input" type="text" name="login" placeholder="유저명" />
          <p class="notice-txt">* 비밀번호가 일치하지 않습니다.</p>
          <input class="pw-input" type="password" name="password" placeholder="비밀번호" />
          <input class="pw-vali-input" type="password" name="password_vali" placeholder="비밀번호 확인" />
          <input class="email-input" type="text" name="login" placeholder="이메일" />
          <button class="nav-bt bt-black" type="submit">가입</button>
          <button class="nav-bt bt-gray" type="reset">취소</button>
        </form>
      </div>
    </div>
  </body>
</html>
