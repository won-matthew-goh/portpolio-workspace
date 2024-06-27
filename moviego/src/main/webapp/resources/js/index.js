AOS.init({ duration: 1200 });

// /********* Jquery 이용한 Carousels *******/
// /*************** global init **************/
// var $wrapper = $('.banner-wrapper');
// var $slide = $wrapper.find('.banner-slide');
// var $pager = $wrapper.find('.pager');
// var $btPrev = $wrapper.find('.prevBtn');
// var $btNext = $wrapper.find('.nextBtn');
// var interval; // setInterval을 넣어놓을 변수
// var idx = 0; // animation이 움직일 값의 인자 0, -100%, -200% ...
// var gap = 3000; // setInterval의 간격
// var speed = 500; // animation speed
// var depth = 1; // z-index
// var last = $slide.find('.slide-item').length - 1; // $('.slide')의 마지막 index

// /*************** user function **************/
// function ani() {
//   $slide.stop().animate({ left: -(idx * 100) + '%' }, speed);
//   $pager.removeClass('active');
//   $pager.eq(idx === last ? 0 : idx).addClass('active');
// }

// /*************** event callback *************/
// function onEnter() {
//   clearInterval(interval);
// }

// function onLeave() {
//   interval = setInterval(onInterval, gap);
// }

// function onInterval() {
//   interval = setInterval(onNext, gap);
// }

// function onPager() {
//   idx = $(this).index();
//   ani();
// }

// function onPrev() {
//   // idx = idx === 0 ? last - 1 : idx - 1;
//   if (idx === 0) {
//     $slide.css('left', -last * 100 + '%');
//     idx = last;
//   }
//   idx--;
//   ani();
// }

// function onNext() {
//   if (idx === last) {
//     $slide.css('left', 0);
//     idx = 0;
//   }
//   idx++;
//   ani();
// }

// /*************** event init *****************/
// // $wrapper.mouseenter(onEnter).mouseleave(onLeave);
// $pager.click(onPager);
// $btPrev.click(onPrev);
// $btNext.click(onNext);

// /*************** start init *****************/
// interval = setInterval(onNext, gap);

/********* JavaScript로 변환된 Carousels *******/
/*************** global init **************/
var wrapper = document.querySelector('.banner-wrapper');
var slide = wrapper.querySelector('.banner-slide');
var pager = wrapper.querySelectorAll('.pager');
var btPrev = wrapper.querySelector('.prevBtn');
var btNext = wrapper.querySelector('.nextBtn');
var interval; // setInterval을 넣어놓을 변수
var idx = 0; // animation이 움직일 값의 인자 0, -100%, -200% ...
var gap = 3000; // setInterval의 간격
var speed = 500; // animation speed
var last = slide.querySelectorAll('.slide-item').length - 1; // ('.slide-item')의 마지막 index

/*************** user function **************/
function ani() {
  slide.style.transition = `left ${speed}ms ease`;
  slide.style.left = -(idx * 100) + '%';
  pager.forEach(function (el) {
    el.classList.remove('active');
  });
  pager[idx === last ? 0 : idx].classList.add('active');
}

/*************** event callback *************/
function onEnter() {
  clearInterval(interval);
}

function onLeave() {
  interval = setInterval(onNext, gap);
}

function onInterval() {
  interval = setInterval(onNext, gap);
}

function onPager(event) {
  idx = Array.from(pager).indexOf(event.target);
  ani();
}

function onPrev() {
  if (idx === 0) {
    slide.style.left = -last * 100 + '%';
    idx = last;
  } else {
    idx--;
  }
  ani();
}

function onNext() {
  if (idx === last) {
    slide.style.left = 0;
    idx = 0;
  } else {
    idx++;
  }
  ani();
}

/*************** event init *****************/
// wrapper.addEventListener('mouseenter', onEnter);
// wrapper.addEventListener('mouseleave', onLeave);
pager.forEach(function (el) {
  el.addEventListener('click', onPager);
});
btPrev.addEventListener('click', onPrev);
btNext.addEventListener('click', onNext);

/*************** start init *****************/
interval = setInterval(onNext, gap);

// Top scroll 버튼 구현부
const btTop = document.querySelector('.arrow-top');

btTop.addEventListener('click', function () {
  window.scrollTo({ top: 0, left: 0, behavior: 'smooth' });
});
