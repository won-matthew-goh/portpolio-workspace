let currentquery = "";

const fetchSearch = async (query) => {
  try {
    const response = await fetch(`/movieList/search?query=${encodeURIComponent(query)}`);
    const data = await response.json();
    console.log(data.movies);
    return data.movies;
  } catch (error) {
    console.error('Error fetching movies:', error);
    return [];
  }
};

const SearchMovies = (movies) => {
  const moviebox = document.querySelector('.content-wrap .box');
  const contentwrap = document.querySelector('.content-wrap');
  moviebox.innerHTML = ''; // 이전 검색 결과 초기화

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

  document.removeEventListener('scroll', handleScroll);

  if (movies.length <= 10 && movies.length > 0) {
    contentwrap.style.height = '88.7vh';
    contentwrap.style.padding = '0';
  } else if (movies.length == 0) {
    document.location.href = '/movieList';
  } else {
    contentwrap.style.height = '';
    contentwrap.style.padding = '0 0 180px 0';
  }
}

document.addEventListener('DOMContentLoaded', () => {
  const searchButton = document.getElementById('searchButton');
  const searchInput = document.getElementById('searchInput');

  async function serachEvent() {
    currentquery = searchInput.value;
    const movies = await fetchSearch(currentquery);
    console.log('a');
    SearchMovies(movies);
  }

  searchButton.addEventListener('click', serachEvent);
  searchInput.addEventListener('keydown', function(e) {
    if (e.key === 'Enter') {
      serachEvent();
    }
  });
});