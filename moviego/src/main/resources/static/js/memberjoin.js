const noticeUsername = document.querySelector('.alert-duplicate-username');
const noticeEmail = document.querySelector('.alert-duplicate-email');

document.addEventListener('DOMContentLoaded', async () => {
  if (errorMsg != null || error != '') {
    if (errorMsg.search('username') > 0) {
      noticeUsername.style.display = 'inline-block';
    }
    if (errorMsg.search('email') > 0) {
      noticeEmail.style.display = 'inline-block';
    }
  }
})