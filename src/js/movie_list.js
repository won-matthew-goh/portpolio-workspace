AOS.init({ duration: 1200 });

/********** modal 열기 **********/

const modalwrap = document.querySelector('.modal-wrap');
const movie = document.querySelectorAll('.movie');
const modalBg = document.querySelector('.modal-bg');

movie.forEach(function (a) {
  a.addEventListener('click', function () {
    modalwrap.style.display = 'block';
    modalBg.style.display = 'block';
  });
});

/********** modal 닫기 **********/
const btn = document.querySelector('.btn');
const closebtn = document.querySelector('.close-btn');

modalBg.addEventListener('click', function () {
  close();
});

btn.addEventListener('click', function () {
  close();
});

closebtn.addEventListener('click', function () {
  close();
});

function close() {
  modalwrap.style.display = 'none';
  modalBg.style.display = 'none';
  // modalwrap.innerHTML = '';
}
