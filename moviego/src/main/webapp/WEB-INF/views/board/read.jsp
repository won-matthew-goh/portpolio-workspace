<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<link rel="stylesheet" href="/css/board-result.css" />
 <div class="content-wrapper w100">
      <div class="content-wrap">
        <h2>관객 코멘트</h2>
        <div class="content-wp">
          <div class="contents">
            <div class="user-id-div content">
              <p class="main-title">글제목</p>
              <p class="main-title">정말 추천합니다!</p>
            </div>
            <div class="user-id-div content">
              <p class="user-id">사용자 ID</p>
              <p class="user-id">김씨</p>
            </div>
            <div class="title-div content">
              <p class="title">영화명</p>
              <p class="title">인사이드아웃2</p>
            </div>
            <div class="star-div content">
              <p class="star">평점</p>
              <p class="star">★★★★★</p>
            </div>
            <div class="comment-div content">
              <p class="comment">관객평</p>
              <p class="comment">어제 보고 왔는데 너무 재밌어요. 인사이드 1부터 쭉 팬이었는데 2가 더 재미있는것 같아요. 랄랄라</p>
            </div>
          </div>
          <div class="img-btn-div">
          	<!-- 영화명과 일치하는 영화 포스터 url api 호출 -->
            <img src="https://i.namu.wiki/i/GjZfWIr1ASIrhzYSmiT8OmmeenSiqUYWQiy_-OJeP6Aj_cNVjyib18awcji_D6n8qXwfp2tyubWKF036aAwMVA.webp" />
          </div>
        </div>
        	<!-- 글을 작성한 본인글이면 수정, 삭제 버튼 노출, 아니면 수정 버튼 제거 -->
        <div class="bottom-btn">
          <a class="nav-bt bt-black">수정</a>
          <a class="nav-bt bt-gray">삭제</a>
        </div>
      </div>
    </div>
</body>
</html>