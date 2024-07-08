
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
        const userId = this.getAttribute('data-user-id');
        fetch(`/admin/deleteReview?userId=${userId}`, {
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

