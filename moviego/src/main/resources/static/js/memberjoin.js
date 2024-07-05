document.addEventListener('DOMContentLoaded', () => {  
  if (errorMsg && errorMsg !== '') {
    if (errorMsg.includes('username')) {
      document.querySelector('.alert-duplicate-username').style.display = 'block';
    }
    if (errorMsg.includes('email')) {
      document.querySelector('.alert-duplicate-email').style.display = 'block';
    }
  }
});
