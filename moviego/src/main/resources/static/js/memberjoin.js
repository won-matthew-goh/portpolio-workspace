document.addEventListener('DOMContentLoaded', () => {
    const noticeUsername = document.querySelector('.alert-duplicate-username');
    const noticeEmail = document.querySelector('.alert-duplicate-email');
    const noticePassword = document.querySelector('.alert-psswd-txt');
    const pwInput = document.querySelector('.pw-input');
    const pwValiInput = document.querySelector('.pw-vali-input');
    const btSubmit = document.querySelector('.bt-submit');

    if (errorMsg.length > 1) {
        if (errorMsg.includes('username')) {
            noticeUsername.style.display = 'inline-block';
        }
        if (errorMsg.includes('email')) {
            noticeEmail.style.display = 'inline-block';
        }
    }

    const validatePasswords = () => {
        if (pwInput.value !== pwValiInput.value) {
            noticePassword.style.display = 'inline-block';
            btSubmit.disabled = true; // Disable submit button
        } else {
            noticePassword.style.display = 'none';
            btSubmit.disabled = false; // Enable submit button
        }
    };

    pwInput.addEventListener('input', validatePasswords);
    pwValiInput.addEventListener('input', validatePasswords);
});
