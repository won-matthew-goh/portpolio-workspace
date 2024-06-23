/********board-write*********/
/********새로운 별점 매기기 스크립트*******/
const ratingStars = [...document.getElementsByClassName("rating__star")];
const ratingResult = document.querySelector(".rating__result");

printRatingResult(ratingResult);

function executeRating(stars, result) {
  const starClassActive = "rating__star fas fa-star";
  const starClassUnactive = "rating__star far fa-star";
  const starsLength = stars.length;
  let i;
  stars.map((star) => {
    star.onclick = () => {
      i = stars.indexOf(star);

      if (star.className.indexOf(starClassUnactive) !== -1) {
        printRatingResult(result, i + 1);
        for (i; i >= 0; --i) stars[i].className = starClassActive;
      } else {
        printRatingResult(result, i);
        for (i; i < starsLength; ++i) stars[i].className = starClassUnactive;
      }
    };
  });
}

function printRatingResult(result, num = 0) {
  result.textContent = `${num}/5`;
}

executeRating(ratingStars, ratingResult);

/////

const rateWrap = document.querySelectorAll(".rating"),
  label = document.querySelectorAll(".rating.rating-label"),
  input = document.querySelectorAll(".rating.rating-input"),
  labelLength = label.length,
  opacityHover = "0.5";

let stars = document.querySelectorAll(".rating.star-icon");

checkedRate();

rateWrap.forEach((rating) => {
  rating.addEventListener("mouseenter", () => {
    stars = rating.querySelectorAll(".star-icon"); //star-icon class 잡아서 stars에 담기

    stars.forEach((starIcon, idx) => {
      starIcon.addEventListener("mouseenter", () => {
        if (rating.classList.contains("readonly") == false) {
          initStars();
          filledRate(idx, labelLengh);

          for (let i = 0; i < stars.length; i++) {
            if (stars[i].classList.contains("filled")) {
              stars[i].computedStyleMap.opacity = opacityHover; // computedStyleMap 제대로 알아보기
            }
          }
        }
      }); //addEventListner mouseenter 시 function

      starIcon.addEventListener("mouseleave", () => {
        if (rating.classList.contains("readonly") == false) {
          starIcon.style.opacity = "1";
          checkedRate();
        }
      }); //addEventListner mouseleave 시 function

      rating.addEventListener("mouseleave", () => {
        if (rating.classList.contains("readonly") == false) {
          starIcon.style.opacity = "1";
        }
      });

      rating.addEventListener("click", (e) => {
        if (rating.classList.contains("readonly")) {
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

//funtion 구간
//checkRate = 선택된 라디오 버튼 이하 인덱스 별점 활성화
function checkedRate() {
  let checkedRadio = document.querySelectorAll('.rating input[type = "radio"]:checked');

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
      return radioSiblings; //이 부분 이해 필요
    }
  });
}

/********별점 초기화*********/
function initStars() {
  for (let i = 0; i < stars.length; i++) {
    stars[i].classList.remove("filled");
  }
}
