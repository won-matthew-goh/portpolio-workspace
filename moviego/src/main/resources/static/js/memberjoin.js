/*
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
 */


document.addEventListener('DOMContentLoaded', () => {
    const noticeUsername = document.querySelector('.alert-duplicate-username');
    const noticeEmail = document.querySelector('.alert-duplicate-email');
    const noticePassword = document.querySelector('.alert-psswd-txt');
    const pwInput = document.querySelector('.pw-input');
    const pwValiInput = document.querySelector('.pw-vali-input');
    const btSubmit = document.querySelector('.bt-submit');

    // 서버에서 전달된 errorMsg 변수가 정의되어 있다면
    if (errorMsg.length > 1) {
        // username 관련 에러가 포함되어 있다면 메시지 표시
        if (errorMsg.includes('username')) {
            noticeUsername.style.display = 'inline-block';
        }
        // email 관련 에러가 포함되어 있다면 메시지 표시
        if (errorMsg.includes('email')) {
            noticeEmail.style.display = 'inline-block';
        }
    }

    // 비밀번호 유효성 검사 함수
    const validatePasswords = () => {
        if (pwInput.value !== pwValiInput.value) {
            noticePassword.style.display = 'inline-block';
            btSubmit.disabled = true; // Submit 버튼 비활성화
        } else {
            noticePassword.style.display = 'none';
            btSubmit.disabled = false; // Submit 버튼 활성화
        }
    };

    // 비밀번호 입력 필드에 input 이벤트 리스너 추가
    pwInput.addEventListener('input', validatePasswords);
    pwValiInput.addEventListener('input', validatePasswords);
});
