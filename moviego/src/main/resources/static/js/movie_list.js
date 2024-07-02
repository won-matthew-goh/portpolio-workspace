AOS.init({ duration: 1200 });

/********** modal 열기 **********/

const modalwrap = document.querySelector('.modal-wrap');
const movie = document.querySelectorAll('.movie');
const modalBg = document.querySelector('.modal-bg');

function openModal(movieElement) {
//	console.log(movieElement);
  const movieData = movieElement.getAttribute('data-movie').split(',');
//  console.log(movieData);
    const movie = {};
	const genreIds = {};
    for (let i = 0; i < movieData.length; i += 2) {
      movie[movieData[i]] = movieData[i + 1];
    }
    for (let i = 0; i < movieData.length; i += 2) {
      genreIds[movieData[i]] = movieData[i + 1];
    }
//  console.log(movie);
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
					           <div class="content">${genreIds.genreIdsArray}</div>
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
// const btn = document.querySelector('.btn');
// const closebtn = document.querySelector('.close-btn');

modalBg.addEventListener('click', function () {
  close();
});

function close() {
  modalwrap.style.display = 'none';
  modalBg.style.display = 'none';
//  modalwrap.innerHTML = '';
}

/****** movielist 스크롤 이벤트로 불러오기 ******/
let genreArray = [];
let currentPage = 1;

const fetchMovies = async (page) => {
  try {
    const response = await fetch(`/movieList/ajax?pageCnt=${page}`);
    const data = await response.json();
    genreArray = genreArray.concat(data.genreIds);
    return data.movies;
  } catch (error) {
    console.error('Error fetching movies:', error);
  }
};

const fetchGenres = async (page) => {
  try {
    const response = await fetch(`/movieList/ajax?pageCnt=${page}`);
    const data = await response.json();
    genreArray = genreArray.concat(data.genreIds);
    return data.genreIds;
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

function validationIds(movie, genre) {
	if(genre.id == movie.id) {return data.genreIds.id}
}

const loadMoreMovies = (movies, genreIds) => {
  const moviebox = document.querySelector('.content-wrap .box');
  const movieboxchild = document.querySelector('.box .movie');

  movies.forEach((movie) => {
    const movieHTML = `
        <div class="movie" data-aos="flip-up" data-movie="${Object.entries(movie)}" onclick="openModal(this)">
          <img src="https://image.tmdb.org/t/p/w200${movie.posterPath}" width="225" height="337.5"/>
          <div class="movie-name">${movie.title}</div>
          <div class="release-date">${movie.releaseDate}</div>
          <div class="nation">${translateNation(movie.originalLanguage)}</div>
        </div>
      `;
    moviebox.innerHTML += movieHTML;
  });
  
  console.log(genreIds);
  
  genreIds.forEach((genre) => {
	movieboxchild.innerHTML += `<div class="movie" style="display: none" data-genre="${genre}">`
  });
};

document.addEventListener('scroll', async () => {
  if (window.innerHeight + window.scrollY >= document.body.offsetHeight) {
    currentPage++;
    const newMovies = await fetchMovies(currentPage);
    const newGenres = await fetchGenres(currentPage);
    loadMoreMovies(newMovies, newGenres);
  }
});

// 초기 로딩
(async () => {
  const initialMovies = await fetchMovies(currentPage);
  const initialGenres = await fetchGenres(currentPage);
  loadMoreMovies(initialMovies, initialGenres);
})();
