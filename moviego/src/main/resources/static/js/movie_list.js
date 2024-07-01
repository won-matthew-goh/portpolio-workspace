AOS.init({ duration: 1200 });

/********** modal 열기 **********/

const modalwrap = document.querySelector('.modal-wrap');
const movie = document.querySelectorAll('.movie');
const modalBg = document.querySelector('.modal-bg');

movie.forEach(function (a) {
  a.addEventListener('click', function () {
    modalwrap.style.display = 'block';
    modalBg.style.display = 'block';
  });
});

/********** modal 닫기 **********/
const btn = document.querySelector('.btn');
const closebtn = document.querySelector('.close-btn');

modalBg.addEventListener('click', function () {
  close();
});

btn.addEventListener('click', function () {
  close();
});

closebtn.addEventListener('click', function () {
  close();
});

function close() {
  modalwrap.style.display = 'none';
  modalBg.style.display = 'none';
  // modalwrap.innerHTML = '';
}

/****** movielist 스크롤 이벤트로 불러오기 ******/
/* 
(() => {
const moviebox = document.querySelector('.content-wrap .box');
let movieboxContent;
let count = moviebox.children.length;

document.addEventListener('scroll', () => {
//window height + window scrollY 값이 document height보다 클 경우,
  if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
  	++count;
	for(let i = 0; i < 20; i++) {
		switch(movieArray[i].nation) {
			case "en":
				movieArray[i].nation = "미국";
				break;
			case "ko":
				movieArray[i].nation = "한국";
				break;
			case "bn":
				movieArray[i].nation = "브루나이";
				break;
			case "pl":
				movieArray[i].nation = "폴란드";
				break;
			default:
				movieArray[i].nation = "미상";
		}
		
     	movieboxContent = moviebox.innerHTML += "<div class=\"movie\" data-aos=\"flip-up\">"
                                            + "<img src=\"https://image.tmdb.org/t/p/w200"
                                            + movieArray[i].posterPath
                                            + "\" width=\"225\" height=\"337.5\"/>"
                                            + "<div class=\"movie-id\">"
                                            + "</div>"
                                            + "<div class=\"movie-name\">"
                                            + movieArray[i].title
                                            + "</div>"
                                            + "<div class=\"release-date\">"
                                            + movieArray[i].releaseDate
                                            + "</div>"
                                            + "<div class=\"nation\">"
                                            + movieArray[i].nation
                                            + "</div>"
                                            + "</div>";
		}
    }
  })
})();
*/

let movieArray = [];
  let currentPage = 2;
  const totalPages = 10;
 
	
  const fetchMovies = async (page) => {
    try {
      const response = await fetch(`https://api.themoviedb.org/3/discover/movie?api_key=${apiKey}&language=ko-KR&page=${page}`);
      const data = await response.json();
      movieArray = movieArray.concat(data.results);
      return data.results;
    } catch (error) {
      console.error('Error fetching movies:', error);
    }
  };

  const translateNation = (nationCode) => {
    switch (nationCode) {
      case "en":
        return "미국";
      case "ko":
        return "한국";
      case "bn":
        return "브루나이";
      case "pl":
        return "폴란드";
      default:
        return "미상";
    }
  };

  const loadMoreMovies = (movies) => {
    const moviebox = document.querySelector('.content-wrap .box');

    movies.forEach(movie => {
      const movieHTML = `
        <div class="movie" data-aos="flip-up">
          <img src="https://image.tmdb.org/t/p/w200${movie.poster_path}" width="225" height="337.5"/>
          <div class="movie-id">${movie.id}</div>
          <div class="movie-name">${movie.title}</div>
          <div class="release-date">${movie.release_date}</div>
          <div class="nation">${translateNation(movie.original_language)}</div>
        </div>
      `;
      moviebox.innerHTML += movieHTML;
    });
  };

  document.addEventListener('scroll', async () => {
    if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight && currentPage < totalPages) {
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