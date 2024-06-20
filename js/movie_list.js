AOS.init({});

/********** modal 열기 **********/

const modalwrap = document.querySelector('.modal-wrap');
const modalwrapper = document.querySelector('.modal-wrapper');
const movie = document.querySelectorAll('.movie');
const modalBg = document.querySelector('.modal-bg');

movie.forEach(function (a) {
  a.addEventListener('click', function () {
    modalwrap.style.display = 'block';
    modalwrapper.style.display = 'block';
    modalBg.style.display = 'block';
  });
});

/********** modal 닫기 **********/
const btn = document.querySelector('.btn');
const closebtn = document.querySelector('.close-btn');

btn.addEventListener('click', function () {
  close();
});

closebtn.addEventListener('click', function () {
  close();
});

modalBg.addEventListener('click', function () {
  close();
});

function close() {
  modalwrap.style.display = 'none';
  modalwrapper.style.display = 'none';
  modalBg.style.display = 'none';
}
