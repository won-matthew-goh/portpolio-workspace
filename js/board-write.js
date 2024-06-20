/********board-write*********/

const rateWrap = document.querySelectorAll(".rating"),
  label = document.querySelectorAll(".rating.rating-half");
input = document.querySelectorAll(".rating.rating-input");
(labelLength = label.length), (opacityHover = "0.5");

let stars = document.querySelectorAll(".rating.star-icon");

checkedRate();

rateWrap.forEach((wrap) => {
  wrap.addEventListener("mouseenter", () => {
    stars = wrap.querySelectorAll(".star-icon");

    stars.forEach((starIcon, idx) => {
      starIcon.addEventListener("mouseenter", () => {
        if (wrap.classList.contains("readonly") == false) {
          initStars();
          filledRate(idx, labelLengh);

          for (let i = 0; i < stars.length; i++) {
            if (stars[i].classList.contains("filled")) {
              stars[i].computedStyleMap.opacity = opacityHover;
            }
          }
        }
      });
      starIcon.addEventListener("mouseleave", () => {
        if (wrap.classList.contains("readonly") == false) {
          starIcon.style.opacity = "1";
          checkedRate();
        }
      });
      
      wrap.addEventListener("mouseleave", () => {
        if (wrap.classList.contains("readonly")) {
          e.preventDefault();
        }
      });

    });
  });
});



/******function****** */
function filledRate(index, length) {
  if (index <= length) {
    for (let i = 0; i <= index; i++) {
      stars[i].classList.add("filled");
    }
  }
}

function checkedRate() {
  let checkedRadio = document.querySelectorAll(
    '.rating input[type = "radio"]:checked'
  );

  initStars();
  checkedRadio.forEach((radio) => {
    let previousSiblings = prevAll(radio);

    for (let i = 0; i < previousSiblings.length; i++) {
      previousSiblings[i].querySelector(".star-icon").classList.add("filled");
    }
    radio.nextElementSibling.classList.add("filled");

    function prevAll() {
      let radioSiblings = [],
        prevSibling = radio.parentElement.previousElementSibling;

      while (prevSibling) {
        radioSiblings.push(prevSibling);
        prevSibling = prevSibling.previousElementSibling;
      }
      return radioSiblings;
    }
  });
}

/*******별점 초기화********/
function initStars() {
  for (let i = 0; i < stars.length; i++) {
    stars[i].classList.remove("filled");
  }
}
