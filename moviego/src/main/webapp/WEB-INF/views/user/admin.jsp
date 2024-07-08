<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>
 <div class="member-list">
    <table class="admin-board-wrapper" id="user-admin">
      <thead class="admin-board-wrap">
        <tr>
          <th class="admin-board-head">유저명</th>
          <th class="admin-board-head">비밀번호</th>
          <th class="admin-board-head">가입일자</th>
          <th class="admin-board-head">게시글수</th>
          <th class="admin-board-head">신고수</th>
          <th class="admin-board-head">가입승인</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach var="vo" items="${userInfo}">
        <tr class="admin-board-content">
          <td class="admin-board-content">${vo.username}</td>
          <td class="admin-board-content">${vo.passwd}</td>
          <td class="admin-board-content">${vo.createdAt}</td>
          <td class="admin-board-content"><a href="#" class="modal-boardList-admin" data-user-id="${vo.userId}">${vo.boardCnt}</a></td>
          <td class="admin-board-content"><a href="#" class="modal-report-admin" data-user-id="${vo.userId}">${vo.reportCnt}</a></td>
          <td class="admin-board-content">
            <c:choose>
              <c:when test="${vo.reportCnt >= 5}">
                <button data-user-id="${vo.userId}" type="button" class="userDrop">강제탈퇴</button>
              </c:when>
              <c:otherwise>
                승인됨
              </c:otherwise>
            </c:choose>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
</body>
</html>

<script>
  document.addEventListener('DOMContentLoaded', function() {
    document.querySelectorAll('.userDrop').forEach(function(button) {
      button.addEventListener('click', function() {
        const userId = this.getAttribute('data-user-id');
        fetch(`/admin/deleteUser?userId=${userId}`, {
          method: 'DELETE'
        }).then(response => {
          if (response.ok) {
            alert('사용자가 성공적으로 삭제되었습니다.');
            location.reload();
          } else {
            alert('사용자 삭제 중 오류가 발생했습니다.');
          }
        });
      });
    });

    document.querySelectorAll('.modal-report-admin').forEach(function(link) {
      link.addEventListener('click', function() {
        const reviewId = this.getAttribute('data-user-id');
        fetch(`/admin/deleteReview?reviewId=${reviewId}`, {
          method: 'DELETE'
        }).then(response => {
          if (response.ok) {
            alert('리뷰가 성공적으로 삭제되었습니다.');
            location.reload();
          } else {
            alert('리뷰 삭제 중 오류가 발생했습니다.');
          }
        });
      });
    });
  });
</script>
