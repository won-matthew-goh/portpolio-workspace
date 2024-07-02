AOS.init({ duration: 1200 });

/********** modal 열기 **********/

const modalwrap = document.querySelector('.modal-wrap');
const movie = document.querySelectorAll('.movie');
const modalBg = document.querySelector('.modal-bg');

function openModal(movieElement) {
  const movie = JSON.parse(movieElement.getAttribute('data-movie'));
  modalwrap.style.display = 'block';
  modalBg.style.display = 'block';
  modalwrap.innerHTML = `
					     <div class="btn">
					       <i class="fa-solid fa-xmark" onclick="close()"></i>
					     </div>
					     <div class="movie-name">${movie.title}</div>
					     <div class="modal-wp">
					       <div class="modal-poster">
					         <img src="https://image.tmdb.org/t/p/w200${movie.posterPath}" />
					       </div>
					       <div class="modal-info">
					         <div id="release-date">
					           <div class="title">개봉연도</div>
					           <div class="content">${movie.releaseDate}</div>
					         </div>
					         <div id="nation">
					           <div class="title">국가</div>
					           <div class="content">${translateNation(movie.originalLanguage)}</div>
					         </div>
					         <div id="genre">
					           <div class="title">장르</div>
					           <div class="content">${genreIds.genreIds}</div>
					         </div>
					         <div id="grade">
					           <div class="title">평점</div>
					           <div class="content">${movie.voteAverage}</div>
					         </div>
					         <div id="Evaluation">
					           <div class="title">총 투표수</div>
					           <div class="content">${movie.voteCount}</div>
					         </div>
					       </div>
					     </div>
					     <div class="modal-box">
					       <p class="content">${movie.overview}</p>
					       <div class="btn">
					         <button class="close-btn" onclick="close()">닫기</button>
					       </div>
					     </div>
   `;

}

/********** modal 닫기 **********/

function close() {
  modalwrap.style.display = 'none';
  modalBg.style.display = 'none';
//  modalwrap.innerHTML = '';
}

modalBg.addEventListener('click', function () {
  close();
});

/****** movielist 스크롤 이벤트로 불러오기 ******/
let movieArray = [];
let currentPage = 1;

const fetchMovies = async (page) => {
  try {
    const response = await fetch(`/movieList/ajax?pageCnt=${page}`);
    const data = await response.json();
    movieArray = genreArray.concat(data.genreIds);
	console.log(movieArray);
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
