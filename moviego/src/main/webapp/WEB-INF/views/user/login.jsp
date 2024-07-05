<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<link rel="stylesheet" href="/css/login.css" />
    <div class="content-wrapper w100">
      <div class="content-wrap">
        <form class="login-form" method="post" action="/">
          <h1>Movie Go</h1>
          <h2>로그인</h2>
          <input class="id-input" type="text" name="login" placeholder="유저명" />
          <input class="pw-input" type="password" name="password" placeholder="비밀번호" />
          <button class="nav-bt bt-black">로그인</button>
          <div class="img-wp">
            <img class="naverlogin" src="https://upload.wikimedia.org/wikipedia/commons/f/f2/Kakao_logo.jpg" alt="kakao" />
            <img class="kakaologin" src="https://i.namu.wiki/i/p_1IEyQ8rYenO9YgAFp_LHIAW46kn6DXT0VKmZ_jKNijvYth9DieYZuJX_E_H_4GkCER_sVKhMqSyQYoW94JKA.svg" alt="naver" />
          </div>
        </form>
      </div>
    </div>
  </body>
</html>
    