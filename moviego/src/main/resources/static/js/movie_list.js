AOS.init({ duration: 1200 });

/********** modal 열기 **********/

const modalwrap = document.querySelector('.modal-wrap');
const modalBg = document.querySelector('.modal-bg');

function openModal(movieElement) {
  const movieData = JSON.parse(movieElement.getAttribute('data-movie'));
  // console.log(genreKr(movieData.genreIds));
  modalwrap.style.display = 'block';
  modalBg.style.display = 'block';
  modalwrap.innerHTML = `
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
          <div class="content">${genreKr(movieData.genreIds).join(', ')}</div>
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
        <button class="close-btn" onclick="closeModal()">닫기</button>
      </div>
    </div>
  `;
}

function closeModal() {
  modalwrap.style.display = 'none';
  modalBg.style.display = 'none';
}

modalBg.addEventListener('click', function () {
  closeModal();
});

/****** movielist 스크롤 이벤트로 불러오기 ******/
let currentPage = 1;

const fetchMovies = async (page) => {
  try {
    const response = await fetch(`/movieList/ajax?pageCnt=${page}`);
    const data = await response.json();
    return data.movies;
  } catch (error) {
    console.error('Error fetching movies:', error);
  }
};

const translateNation = (nationCode) => {
  switch (nationCode) {
    case 'en':
      return '미국';
    case 'ko':
      return '한국';
    case 'bn':
      return '브루나이';
    case 'pl':
      return '폴란드';
    case 'th':
      return '태국';
    default:
      return '미상';
  }
};

function genreKr(genreIds) {
  return genreIds.map((id) => {
    switch (id) {
      case 28:
        return '액션';
      case 12:
        return '모험';
      case 16:
        return '애니메이션';
      case 35:
        return '코미디';
      case 80:
        return '범죄';
      // 다른 장르들도 추가할 수 있습니다.
      default:
        return '기타';
    }
  });
}

// genereKr For문 스타일
// function genreKr(genreIds) {
//   const genres = [];
//   for (let i = 0; i < genreIds.length; i++) {
//     switch (genreIds[i]) {
//       case 28:
//         genres.push('액션');
//         break;
//       case 12:
//         genres.push('모험');
//         break;
//       case 16:
//         genres.push('애니메이션');
//         break;
//       case 35:
//         genres.push('코미디');
//         break;
//       case 80:
//         genres.push('범죄');
//         break;
//       // 다른 장르들도 추가할 수 있습니다.
//       default:
//         genres.push('기타');
//         break;
//     }
//   }
//   return genres;
// }

const loadMoreMovies = (movies) => {
  const moviebox = document.querySelector('.content-wrap .box');

  movies.forEach((movie) => {
    const movieHTML = `
      <div class="movie" data-aos="flip-up" data-movie='${JSON.stringify(movie)}' onclick="openModal(this)">
        <img src="https://image.tmdb.org/t/p/w200${movie.posterPath}" width="225" height="337.5"/>
        <div class="movie-name">${movie.title}</div>
        <div class="release-date">${movie.releaseDate}</div>
        <div class="nation">${translateNation(movie.originalLanguage)}</div>
      </div>
    `;
    moviebox.innerHTML += movieHTML;
  });
};

document.addEventListener('scroll', async () => {
  if (window.innerHeight + window.scrollY >= document.body.offsetHeight) {
    currentPage++;
    const newMovies = await fetchMovies(currentPage);
    loadMoreMovies(newMovies);
  }
});

// 초기 로딩
(async () => {
  const initialMovies = await fetchMovies(currentPage);
  loadMoreMovies(initialMovies);
})();
