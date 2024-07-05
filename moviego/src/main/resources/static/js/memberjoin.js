document.addEventListener('DOMContentLoaded', () => {
  const errorMsg = '${error}';
  const noticeUsername = document.querySelector('.alert-duplicate-username');
  const noticeEmail = document.querySelector('.alert-duplicate-email');
  const noticePassword = document.querySelector('.alert-psswd-txt');

  if (errorMsg && errorMsg !== '') {
    if (errorMsg.includes('username')) {
      noticeUsername.style.display = 'inline-block';
    }
    if (errorMsg.includes('email')) {
      noticeEmail.style.display = 'inline-block';
    }
  }

  const pwInput = document.querySelector('.pw-input');
  const pwValiInput = document.querySelector('.pw-vali-input');
  const btSubmit = document.querySelector('.bt-submit');

  pwValiInput.addEventListener('input', () => {
    if (pwInput.value !== pwValiInput.value) {
      btSubmit.addEventListener('click'), (e) => {
        e.preventDefatult;
      }
      noticePassword.style.display = 'inline-block';
    } else {
      noticePassword.style.display = 'none';
    }
  });
});

