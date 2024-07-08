AOS.init({ duration: 1200 });

/********** modal 열기 **********/
const modalwrap = document.querySelector('.modal-wrap');
const modalBg = document.querySelector('.modal-bg');

function openModal(movieElement) {
  // data-movie 속성에서 JSON 문자열을 가져와서 객체로 변환
  const movieDataString = decodeURIComponent(movieElement.getAttribute('data-movie'));
  const movieData = JSON.parse(movieDataString);

  // 장르 ID를 변환하여 문자열로 만듭니다
  const genreText = genreKr(movieData.genreIds).join(', ');

  const modalContent = `
      <div class="btn">
        <i class="fa-solid fa-xmark" onclick="closeModal()"></i>
      </div>
      <div class="movie-name">${movieData.title}</div>
      <div class="modal-wp">
        <div class="modal-poster">
          <img src="https://image.tmdb.org/t/p/w200${movieData.posterPath}" />
        </div>
        <div class="modal-info">
          <div id="release-date">
            <div class="title">개봉연도</div>
            <div class="content">${movieData.releaseDate}</div>
          </div>
          <div id="nation">
            <div class="title">국가</div>
            <div class="content">${translateNation(movieData.originalLanguage)}</div>
          </div>
          <div id="genre">
            <div class="title">장르</div>
            <div class="content">${genreText}</div>
          </div>
          <div id="grade">
            <div class="title">평점</div>
            <div class="content">${movieData.voteAverage}</div>
          </div>
          <div id="Evaluation">
            <div class="title">총 투표수</div>
            <div class="content">${movieData.voteCount}</div>
          </div>
        </div>
      </div>
      <div class="modal-box">
        <p class="content">${movieData.overview}</p>
        <div class="btn">
          <button class="btn btn-light" onclick="writeReview('${movieData.title}', '${movieData.id}', '${movieData.posterPath}')">리뷰 등록</button>
          <button class="close-btn" onclick="closeModal()">닫기</button>
        </div>
      </div>
    `;

  modalwrap.innerHTML = modalContent;
  modalwrap.style.display = 'block';
  modalBg.style.display = 'block';
}

function writeReview(title, id, posterPath) {
  const url = `/review/new?movieTitle=${encodeURIComponent(title)}&movieId=${id}&posterPath=${encodeURIComponent(posterPath)}`;
  window.location.href = url;
}

function closeModal() {
  modalwrap.classList.add('hide');
  modalBg.classList.add('hide');
  setTimeout(() => {
    modalwrap.style.display = 'none';
    modalBg.style.display = 'none';
    modalwrap.classList.remove('hide');
    modalBg.classList.remove('hide');
  }, 400);
}

modalBg.addEventListener('click', function() {
  closeModal();
});

/****** movielist 스크롤 이벤트로 불러오기 ******/
let currentPage = 1;
let isLoading = false;

const fetchMovies = async (page) => {
  try {
    const response = await fetch(`/movieList/ajax?pageCnt=${page}`);
    const data = await response.json();
    return data.movies;
  } catch (error) {
    console.error('Error fetching movies:', error);
  }
};

const handleScroll = async () => {
  if (window.innerHeight + window.scrollY >= document.body.offsetHeight && !isLoading) {
    isLoading = true;
    currentPage++;
    const newMovies = await fetchMovies(currentPage);
    loadMoreMovies(newMovies);
    isLoading = false;
  }
};

/****** JSON안의 " 문자로 인한 오류 치환으로 해결하는 funtion ******/
function escapeQuotes(str) {
  return str.replace(/"/g, '\\"').replace(/'/g, "\\'");
}

const loadMoreMovies = (movies) => {
  const moviebox = document.querySelector('.content-wrap .box');

  movies.forEach((movie) => {
    const movieJSON = encodeURIComponent(JSON.stringify(movie));
    const movieHTML = `
      <div class="movie" data-aos="flip-up" data-movie="${movieJSON}" onclick="openModal(this)">
        <img src="https://image.tmdb.org/t/p/w200${movie.posterPath}" width="225" height="337.5"/>
        <div class="movie-name">${movie.title}</div>
        <div class="release-date">${movie.releaseDate}</div>
        <div class="nation">${translateNation(movie.originalLanguage)}</div>
      </div>
    `;
    moviebox.innerHTML += movieHTML;
  });
};

document.addEventListener('scroll', handleScroll);

// 초기 로딩
(async () => {
  const initialMovies = await fetchMovies(currentPage);
  loadMoreMovies(initialMovies);
})();
