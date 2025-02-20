/********board-write*********/
const rateWrap = document.querySelectorAll('.rating');
const label = document.querySelectorAll('.rating .rating-label');
const input = document.querySelectorAll('.rating .rating-input');
let labelLength = label.length;
const opacityHover = '0.5';

let stars = document.querySelectorAll('.rating .star-icon');

checkedRate();

rateWrap.forEach((wrap) => {
  wrap.addEventListener('mouseenter', () => {
    stars = wrap.querySelectorAll('.star-icon');

    stars.forEach((starIcon, idx) => {
      starIcon.addEventListener('mouseenter', () => {
        if (wrap.classList.contains('readonly') == false) {
          initStars(); // 기선택된 별점 무시하고 초기화
          filledRate(idx, labelLength); // hover target만큼 별점 active

          // hover 시 active된 별점의 opacity 조정
          for (let i = 0; i < stars.length; i++) {
            if (stars[i].classList.contains('filled')) {
              stars[i].style.opacity = opacityHover;
            }
          }
        }
      });

      starIcon.addEventListener('mouseleave', () => {
        if (wrap.classList.contains('readonly') == false) {
          starIcon.style.opacity = '1';
          checkedRate(); // 체크된 라디오 버튼 만큼 별점 active
        }
      });

      // rate wrap을 벗어날 때 active된 별점의 opacity = 1
      wrap.addEventListener('mouseleave', () => {
        if (wrap.classList.contains('readonly') == false) {
          starIcon.style.opacity = '1';
        }
      });

      // readonnly 일 때 비활성화
      wrap.addEventListener('click', (e) => {
        if (wrap.classList.contains('readonly')) {
          e.preventDefault();
        }
      });
    });
  });
});

// target보다 인덱스가 낮은 .star-icon에 .filled 추가 (별점 구현)
function filledRate(index, length) {
  if (index <= length) {
    for (let i = 0; i <= index; i++) {
      stars[i].classList.add('filled');
    }
  }
}

// 선택된 라디오버튼 이하 인덱스는 별점 active
function checkedRate() {
  let checkedRadio = document.querySelectorAll('.rating input[type="radio"]:checked');

  initStars();
  checkedRadio.forEach((radio) => {
    let previousSiblings = prevAll(radio);

    for (let i = 0; i < previousSiblings.length; i++) {
      previousSiblings[i].querySelector('.star-icon').classList.add('filled');
    }

    radio.nextElementSibling.classList.add('filled');

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

// 별점 초기화 (0)
function initStars() {
  for (let i = 0; i < stars.length; i++) {
    stars[i].classList.remove('filled');
  }
}

// 폼 내용 및 제목 Validation
function validateForm() {
  var title = document.querySelector('input[name="title"]').value.trim();
  var comment = document.querySelector('textarea[name="comment"]').value.trim();

  if (title === "") {
    alert("제목을 입력해주세요. \nPlease enter the title. \nタイトルを入力してください。");
    return false; // Prevent form submission
  }

  if (comment === "") {
    alert("내용을 입력해주세요. \nPlease enter the content. \n内容を入力してください。");
    return false; // Prevent form submission
  }

  return true; // Allow form submission
}

