/********** modal 열기 **********/
const movie = document.querySelector(".movie");
const modalwrap = document.querySelector(".modal-wrap");
const modalwrapper = document.querySelector(".modal-wrapper");

movie.addEventListener("click", function () {
  modalwrap.style.display = "block";
  modalwrapper.style.display = "block";
});

/********** modal 닫기 **********/
const btn = document.querySelector(".btn");
const closebtn = document.querySelector(".close-btn");

btn.addEventListener("click", function () {
  modalwrap.style.display = "none";
  modalwrapper.style.display = "none";
});

closebtn.addEventListener("click", function () {
  modalwrap.style.display = "none";
  modalwrapper.style.display = "none";
});
