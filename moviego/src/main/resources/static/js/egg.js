// 국적선택

// if (window.location.search.startsWith('?q=')) {
//   try {
//     document.getElementById('question').textContent = atob(window.location.search.slice('?q='.length));
//   } catch {
//     window.location.href = 'set';
//   }
// } else window.location.href = 'set';

// module aliases
var Engine = Matter.Engine,
  Render = Matter.Render,
  Runner = Matter.Runner,
  Bodies = Matter.Bodies,
  Body = Matter.Body,
  Bounds = Matter.Bounds,
  Composite = Matter.Composite;

// create an engine
var engine = Engine.create();

// create a renderer
var renderAbove = Render.create({
  element: document.getElementById('renderer'),
  engine: engine,
  options: {
    width: 500,
    height: 96,
    hasBounds: true,
    background: 'transparent',
  },
});
var renderTop = Render.create({
  element: document.getElementById('renderer'),
  engine: engine,
  options: {
    width: 500,
    height: 48,
    background: 'transparent',
  },
});
var renderBottom = Render.create({
  element: document.getElementById('renderer'),
  engine: engine,
  options: {
    width: 500,
    height: 250,
    hasBounds: true,
    background: 'transparent',
  },
});
renderAbove.options.wireframes = false;
renderTop.options.wireframes = false;
renderBottom.options.wireframes = false;
renderBottom.canvas.height = 48;

Bounds.translate(renderAbove.bounds, { x: 0, y: -100 }); //move renderbottom's view above the world (where the check will be)
Bounds.translate(renderBottom.bounds, { x: 0, y: 452 }); //move renderbottom's view to the bottom of the world (where the bottom of the checkboxes will be)

// create objects
var boxVertices = Matter.Vertices.fromPath(
  'M 200 500 L 100 500 L 100 450 L 105 450 L 105 495 L 195 495 L 195 450 L 250 400 L 305 450 L 305 495 L 395 495 L 395 450 L 495 350 L 495 150 L 395 50 L 395 5 L 305 5 L 305 50 L 250 100 L 195 50 L 195 5 L 105 5 L 105 50 L 5 150 L 5 350 L 105 450 L 100 452 L 0 352 L 0 148 L 100 48 L 100 0 L 200 0 L 200 48 L 250 93 L 300 48 L 300 0 L 400 0 L 400 48 L 500 148 L 500 352 L 400 452 L 400 500 L 300 500 L 300 452 L 250 407 L 200 452 Z'
);
var box = Bodies.fromVertices(250, 250, boxVertices, { isStatic: true, render: { fillStyle: '#000000' } });
var checkVertices = Matter.Vertices.fromPath('M 42.2604 4.1666 L 18.75 28.2646 L 7.7375 17.825 L 0 25.5666 L 18.75 43.75 L 50 11.9063 Z');
var check = Bodies.fromVertices(0, -500, checkVertices, { isStatic: true, friction: 0, restitution: 1, render: { fillStyle: '#000000' } }, true);

// create plinks
const plinkRows = 5;
const topPlinkRowY = 150;
const bottomPlinkRowY = 500 - topPlinkRowY;
const plinksPerRow = 6;
const leftPlinkX = 20;
const rightPlinkX = 500 - leftPlinkX;
const plinkRadius = 5;

var plinks = [];
for (let i = 0; i < plinkRows; i++) {
  let longRow = Boolean(i % 2);
  let y = topPlinkRowY + (bottomPlinkRowY - topPlinkRowY) * (i / (plinkRows - 1));
  let plinksInRow = plinksPerRow - (longRow ? 0 : 1);
  for (let j = 0; j < plinksInRow; j++) {
    let x = leftPlinkX + (rightPlinkX - leftPlinkX) * ((longRow ? j : j + 0.5) / (plinksPerRow - 1));

    plinks.push(Bodies.circle(x, y, plinkRadius, { isStatic: true }));
  }
}

// add all of the bodies to the world
Composite.add(engine.world, [box, check, ...plinks]);

// run the renderer
Render.run(renderAbove);
Render.run(renderTop);
Render.run(renderBottom);

// create runner
var runner = Runner.create();

// run the engine
Runner.run(runner, engine);

//on choose yes or no
const timeToWaitTillExpand = 3000;
const timeToWaitTillDrop = 1500;
const expandTime = 4000;
const startHeight = 48;
const targetHeight = 250;
var chosen = false;
var startTime = null;
var startFadeTime = null;

function choose(checkPos) {
  [...document.getElementById('buttons').children].forEach((e) => e.remove()); //delete buttons
  Body.setPosition(check, { x: checkPos + 48, y: -50 });
  fadeCheck();
  setTimeout(expand, timeToWaitTillExpand);
}

function fadeCheck() {
  let time = Date.now();
  if (startFadeTime == null) startFadeTime = time;
  let elapsedTime = time - startFadeTime;
  elapsedTime = Math.min(timeToWaitTillExpand, elapsedTime);
  let amountDone = elapsedTime / timeToWaitTillExpand;

  renderAbove.canvas.style.opacity = amountDone;

  if (elapsedTime < timeToWaitTillExpand) setTimeout(fadeCheck, 16); //would love to use requestanimationframe but it makes the canvases disappear :)
}

function expand() {
  let time = Date.now();
  if (startTime == null) startTime = time;
  let elapsedTime = time - startTime;
  elapsedTime = Math.min(expandTime, elapsedTime);
  let amountDone = elapsedTime / expandTime;

  let height = startHeight + (targetHeight - startHeight) * amountDone;
  for (let i of [renderTop, renderBottom]) i.canvas.height = height;
  Bounds.translate(renderBottom.bounds, { x: 0, y: 500 - height - renderBottom.bounds.min.y });
  console.log(renderBottom.bounds);

  if (elapsedTime < expandTime) setTimeout(expand, 16); //would love to use requestanimationframe but it makes the canvases disappear :)
  else setTimeout(drop, timeToWaitTillDrop);
}

function drop() {
  Body.setPosition(check, { x: check.position.x, y: check.position.y + 100 });
  Body.setStatic(check, false);
}

// 폼 제출 (이 부분은 기존 코드에 추가)
const form = document.getElementById('signupForm');
form.onsubmit = function (e) {
  e.preventDefault();
  alert('축하합니다! 회원가입이 완료되었습니다... 아마도요?');
};

document.addEventListener('DOMContentLoaded', function () {
  // 비밀번호
  ('use strict');

  const lock = document.querySelector('.lock');
  const confirmLock = document.querySelector('.confirm-lock');
  const input = document.querySelector('.text');
  const confirmInput = document.querySelector('.confirm-text');
  const textPath = lock.querySelector('textPath');
  const confirmTextPath = confirmLock.querySelector('textPath');
  const clearButton = document.querySelector('.clear');
  const confirmClearButton = document.querySelector('.confirm-clear');
  const errorMessage = document.getElementById('errorMessage');
  const charset = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';

  let isDragging = false;
  let isConfirmDragging = false;
  let startAngle = 0;
  let confirmStartAngle = 0;
  let currentRotation = 0;
  let confirmCurrentRotation = 0;
  let password = '';
  let confirmPassword = '';

  textPath.textContent = charset;
  confirmTextPath.textContent = charset;

  function rotateElement(element, angle) {
    element.setAttribute('transform', `rotate(${angle} 50 50)`);
  }

  function getAngle(event, element) {
    const rect = element.getBoundingClientRect();
    const center = {
      x: rect.left + rect.width / 2,
      y: rect.top + rect.height / 2,
    };
    const x = (event.clientX || event.touches[0].clientX) - center.x;
    const y = (event.clientY || event.touches[0].clientY) - center.y;
    return Math.atan2(y, x) * (180 / Math.PI);
  }

  function updateInput(rotation, inputElement, passwordVar) {
    const normalizedRotation = ((-rotation % 360) + 360) % 360;
    const index = Math.round(normalizedRotation / 10) % charset.length;
    const selectedChar = charset[index];

    passwordVar += selectedChar;
    inputElement.value = passwordVar;
    return passwordVar;
  }

  function handleStart(e, isConfirm) {
    if (isConfirm) {
      isConfirmDragging = true;
      confirmStartAngle = getAngle(e, confirmLock) - confirmCurrentRotation;
    } else {
      isDragging = true;
      startAngle = getAngle(e, lock) - currentRotation;
    }
  }

  function handleMove(e, isConfirm) {
    if (isConfirm && isConfirmDragging) {
      const angle = getAngle(e, confirmLock);
      confirmCurrentRotation = (angle - confirmStartAngle + 360) % 360;
      rotateElement(confirmTextPath.parentNode, confirmCurrentRotation);
    } else if (!isConfirm && isDragging) {
      const angle = getAngle(e, lock);
      currentRotation = (angle - startAngle + 360) % 360;
      rotateElement(textPath.parentNode, currentRotation);
    }
  }

  function handleEnd(isConfirm) {
    if (isConfirm && isConfirmDragging) {
      isConfirmDragging = false;
      confirmPassword = updateInput(confirmCurrentRotation, confirmInput, confirmPassword);
    } else if (!isConfirm && isDragging) {
      isDragging = false;
      password = updateInput(currentRotation, input, password);
    }
    validatePasswords();
  }

  function addEventListeners(element, isConfirm) {
    element.addEventListener('mousedown', (e) => handleStart(e, isConfirm));
    element.addEventListener('touchstart', (e) => handleStart(e, isConfirm));

    document.addEventListener('mousemove', (e) => handleMove(e, isConfirm));
    document.addEventListener('touchmove', (e) => handleMove(e, isConfirm));

    document.addEventListener('mouseup', () => handleEnd(isConfirm));
    document.addEventListener('touchend', () => handleEnd(isConfirm));
  }

  addEventListeners(lock, false);
  addEventListeners(confirmLock, true);

  clearButton.addEventListener('click', () => {
    password = '';
    input.value = '';
    currentRotation = 0;
    rotateElement(textPath.parentNode, currentRotation);
    validatePasswords();
  });

  confirmClearButton.addEventListener('click', () => {
    confirmPassword = '';
    confirmInput.value = '';
    confirmCurrentRotation = 0;
    rotateElement(confirmTextPath.parentNode, confirmCurrentRotation);
    validatePasswords();
  });

  function validatePasswords() {
    if (password.length === 0 && confirmPassword.length === 0) {
      errorMessage.textContent = '';
      return;
    }

    const hasNumber = /\d/.test(password);
    const hasLetter = /[A-Z]/.test(password);

    if (password.length < 10) {
      errorMessage.textContent = '비밀번호는 10자리 이상이어야 합니다.';
      errorMessage.style.color = 'red';
      return;
    }

    if (!hasNumber || !hasLetter) {
      errorMessage.textContent = '비밀번호는 숫자와 문자를 모두 포함해야 합니다.';
      errorMessage.style.color = 'red';
      return;
    }

    if (password !== confirmPassword) {
      errorMessage.textContent = '비밀번호와 확인 비밀번호가 일치하지 않습니다.';
      errorMessage.style.color = 'red';
      return;
    }

    errorMessage.textContent = '유효한 비밀번호입니다.';
    errorMessage.style.color = 'green';
  }

  // 이메일
  const canvas = document.querySelector('.atcanvas');
  const ctx = canvas.getContext('2d');
  let isDrawing = false;
  let points = [];

  function startDrawing(e) {
    isDrawing = true;
    points = [];
    const rect = canvas.getBoundingClientRect();
    points.push([e.clientX - rect.left, e.clientY - rect.top]);
    draw(e);
  }

  function draw(e) {
    if (!isDrawing) return;
    const rect = canvas.getBoundingClientRect();
    const x = e.clientX - rect.left;
    const y = e.clientY - rect.top;

    points.push([x, y]);

    ctx.lineWidth = 2;
    ctx.lineCap = 'round';
    ctx.lineTo(x, y);
    ctx.stroke();
    ctx.beginPath();
    ctx.moveTo(x, y);
  }

  function stopDrawing() {
    isDrawing = false;
    ctx.beginPath();
    checkAtSymbol();
  }

  function checkAtSymbol() {
    if (points.length < 20) {
      clearCanvas();
      // alert("'@' 모양을 더 크게 그려주세요!");
      return;
    }

    // 그려진 점들을 정규화 및 단순화
    const normalizedPoints = normalizeAndSimplifyPoints(points, 20);

    // '@' 모양의 주요 특징 확인
    const isAtSymbol = checkAtSymbolFeatures(normalizedPoints);

    if (isAtSymbol) {
      addAtSymbol();
    } else {
      alert("'@' 모양을 그려주세요!");
      clearCanvas();
    }
  }

  function normalizeAndSimplifyPoints(points, targetLength) {
    // 점들을 0~1 범위로 정규화
    const xValues = points.map((p) => p[0]);
    const yValues = points.map((p) => p[1]);
    const minX = Math.min(...xValues);
    const maxX = Math.max(...xValues);
    const minY = Math.min(...yValues);
    const maxY = Math.max(...yValues);

    const normalizedPoints = points.map((p) => [(p[0] - minX) / (maxX - minX), (p[1] - minY) / (maxY - minY)]);

    // 점의 개수를 targetLength로 단순화
    const simplifiedPoints = [];
    for (let i = 0; i < targetLength; i++) {
      const index = Math.floor((i / targetLength) * normalizedPoints.length);
      simplifiedPoints.push(normalizedPoints[index]);
    }

    return simplifiedPoints;
  }

  function checkAtSymbolFeatures(points) {
    // '@' 모양의 주요 특징 확인
    let hasLoop = false;
    let hasTail = false;
    let centerX = 0,
      centerY = 0;

    // 중심점 계산
    points.forEach((p) => {
      centerX += p[0];
      centerY += p[1];
    });
    centerX /= points.length;
    centerY /= points.length;

    // 루프와 꼬리 확인
    let loopStart = -1,
      loopEnd = -1;
    for (let i = 0; i < points.length; i++) {
      const [x, y] = points[i];
      const nextIndex = (i + 1) % points.length;
      const [nextX, nextY] = points[nextIndex];

      // 루프 시작점 찾기
      if (loopStart === -1 && x < centerX && y > centerY) {
        loopStart = i;
      }

      // 루프 끝점 찾기
      if (loopStart !== -1 && loopEnd === -1 && x > centerX && y < centerY) {
        loopEnd = i;
        hasLoop = true;
      }

      // 꼬리 확인
      if (hasLoop && !hasTail && x > centerX && y > centerY) {
        hasTail = true;
      }
    }

    return hasLoop && hasTail;
  }

  function addAtSymbol() {
    const emailInput = document.getElementById('emailInput');
    emailInput.value += '@';
    clearCanvas();
  }

  function clearCanvas() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    points = [];
  }

  canvas.addEventListener('mousedown', startDrawing);
  canvas.addEventListener('mousemove', draw);
  canvas.addEventListener('mouseup', stopDrawing);
  canvas.addEventListener('mouseout', stopDrawing);

  // '@추가' 버튼 제거 (옵션)
  // const addAtSymbolBtn = document.getElementById('addAtSymbolBtn');
  // addAtSymbolBtn.remove();
  const sendButton = document.getElementById('sendButton');
  sendButton.addEventListener('mousemove', moveButton);

  function moveButton() {
    const maxX = window.innerWidth - sendButton.offsetWidth;
    const maxY = window.innerHeight - sendButton.offsetHeight;
    const newX = Math.random() * maxX;
    const newY = Math.random() * maxY;
    sendButton.style.left = newX + 'px';
    sendButton.style.top = newY + 'px';
  }

  // 새로 추가된 코드: '@' 문자 입력 방지
  const emailInput = document.getElementById('emailInput');
  emailInput.addEventListener('keypress', function (e) {
    if (e.key === '@') {
      e.preventDefault();
      alert("'@' 문자는 그려서 입력해주세요!");
    }
  });

  // 전화번호 슬라이더
  const phoneSlider = document.getElementById('phoneSlider');
  const phoneDisplay = document.getElementById('phoneDisplay');
  const angleSlider = document.getElementById('angleSlider');
  const advancedModeCheckbox = document.getElementById('advancedMode');

  let angle = 0;
  let speed = 0;
  let friction = 0.99;
  let value = Number(phoneSlider.value);

  function formatPhoneNumber(value) {
    return `(${value.toString().substr(0, 2)}) ${value.toString().substr(2, 3)}-${value.toString().substr(5, 4)}-${value.toString().substr(9, 4)}`;
  }

  function updatePhone() {
    angle = Number(angleSlider.value);
    value = Number(phoneSlider.value);
    speed += Math.sin((angle * Math.PI) / 180) * 10000000000;
    speed *= friction;
    value += Math.round(speed);

    if (value > phoneSlider.max) {
      value = phoneSlider.max;
      speed *= -1;
    } else if (value < phoneSlider.min) {
      value = phoneSlider.min;
      speed *= -1;
    }
    phoneSlider.value = value;
    phoneDisplay.innerHTML = formatPhoneNumber(value);
  }

  setInterval(updatePhone, 10);

  advancedModeCheckbox.addEventListener('change', function () {
    if (this.checked) {
      angleSlider.style.display = 'block';
      phoneSlider.style.width = '100%';
    } else {
      angleSlider.style.display = 'none';
      phoneSlider.style.width = '100%';
      angleSlider.value = 0;
      phoneSlider.style.transform = 'rotate(0deg)';
    }
  });

  phoneSlider.oninput = function () {
    speed = 0;
  };

  angleSlider.oninput = function () {
    angle = Number(angleSlider.value);
    phoneSlider.style.transform = 'rotate(' + angle + 'deg)';
  };

  // 생년월일 선택기
  const earlierBtn = document.getElementById('earlierBtn');
  const laterBtn = document.getElementById('laterBtn');
  const birthdayDisplay = document.getElementById('birthdayDisplay');

  let minDate = new Date(1900, 0, 1);
  let maxDate = new Date();
  let currentDate = new Date(minDate.getTime() + (maxDate.getTime() - minDate.getTime()) / 2);

  function updateBirthdayDisplay() {
    const year = currentDate.getFullYear();
    const month = String(currentDate.getMonth() + 1).padStart(2, '0');
    const day = String(currentDate.getDate()).padStart(2, '0');
    birthdayDisplay.textContent = `${year}년 ${month}월 ${day}일`;
  }

  earlierBtn.onclick = function () {
    maxDate = new Date(currentDate.getTime());
    currentDate = new Date(minDate.getTime() + (maxDate.getTime() - minDate.getTime()) / 2);
    updateBirthdayDisplay();
  };

  laterBtn.onclick = function () {
    minDate = new Date(currentDate.getTime());
    currentDate = new Date(minDate.getTime() + (maxDate.getTime() - minDate.getTime()) / 2);
    updateBirthdayDisplay();
  };

  updateBirthdayDisplay();
});
