const movie = document.querySelector(".movie");
const modalwp = document.querySelector(".modal-wp");

movie.addEventListener("click", function () {
  //display 속성을 block로 변경
  modalwp.style.display = "flex";
});

const modalclose = document.querySelector(".modal_close");

modalclose.addEventListener("click", function () {
  modalwp.style.display = "none";
});
