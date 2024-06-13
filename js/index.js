const carouselSlide = document.querySelector('.banner-slide');
const carouselContents = document.querySelectorAll('.slide-item');

const prevBtn = document.querySelector('.prevBtn');
const nextBtn = document.querySelector('.nextBtn');

const btTop = document.querySelector('.arrow-top');

// Carousel 구현 부 --------------------------------------------------

//counter
let counter = 1;
const size = carouselContents[0].clientWidth;

carouselSlide.style.transform = 'translateX(' + -size * counter + 'px)';

//Button Listeners
nextBtn.addEventListener('click', () => {
  if (counter >= carouselContents.length - 1) return;
  carouselSlide.style.transition = 'transform 0.3s ease-in-out';
  counter++;
  carouselSlide.style.transform = 'translateX(' + -size * counter + 'px)';
});

prevBtn.addEventListener('click', () => {
  if (counter <= 0) return;
  carouselSlide.style.transition = 'transform 0.3s ease-in-out';
  counter--;
  carouselSlide.style.transform = 'translateX(' + -size * counter + 'px)';
});
console.log(carouselContents.length);

carouselSlide.addEventListener('transitionend', function () {
  if (carouselContents[counter].id === 'lastClone') {
    carouselSlide.style.transition = 'none';
    counter = carouselContents.length - 2;
    carouselSlide.style.transform = 'translateX(' + -size * counter + 'px)';
  }
  if (carouselContents[counter].id === 'firstClone') {
    carouselSlide.style.transition = 'none';
    counter = carouselContents.length - counter;
    carouselSlide.style.transform = 'translateX(' + -size * counter + 'px)';
  }
});

// Top scroll 버튼 구현부
btTop.addEventListener('click', function () {
  window.scrollTo({ top: 0, left: 0, behavior: 'smooth' });
});
