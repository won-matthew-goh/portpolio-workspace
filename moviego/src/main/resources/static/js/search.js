let currentquery = "";

const fetchSearch = async (query) => {
    try {
        const response = await fetch(`/movieList/search?query=${encodeURIComponent(query)}`);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        console.log('Search results:', data);
        return data.movies || [];
    } catch (error) {
        console.error('Error fetching movies:', error);
        return [];
    }
};

const SearchMovies = (movies) => {
    const moviebox = document.querySelector('.content-wrap .box');
    const contentwrap = document.querySelector('.content-wrap');
    moviebox.innerHTML = ''; // 이전 검색 결과 초기화

    if (movies && movies.length > 0) {
        movies.forEach((movie) => {
            const movieJSON = encodeURIComponent(JSON.stringify(movie));
            const movieHTML = `
                <div class="movie" data-aos="flip-up" data-movie="${movieJSON}" onclick="openModal(this)">
                    <img src="https://image.tmdb.org/t/p/w200${movie.posterPath || ''}" width="225" height="337.5" onerror="this.src='/path/to/placeholder/image.jpg'"/>
                    <div class="movie-name">${movie.title || 'No Title'}</div>
                    <div class="release-date">${movie.releaseDate || 'No Date'}</div>
                    <div class="nation">${translateNation(movie.originalLanguage) || 'Unknown'}</div>
                </div>
            `;
            moviebox.innerHTML += movieHTML;
        });

        if (movies.length <= 10) {
            contentwrap.style.height = '88.7vh';
            contentwrap.style.padding = '0';
        } else {
            contentwrap.style.height = '';
            contentwrap.style.padding = '0 0 180px 0';
        }
    } else {
        moviebox.innerHTML = '<p class="no-results">No results found.</p>';
        contentwrap.style.height = '88.7vh';
        contentwrap.style.padding = '0';
    }

    document.removeEventListener('scroll', handleScroll);
};

document.addEventListener('DOMContentLoaded', () => {
    const searchButton = document.getElementById('searchButton');
    const searchInput = document.getElementById('searchInput');

    async function searchEvent() {
        currentquery = searchInput.value.trim();
        if (currentquery == 'SAMUI') {
          document.location.href = '/SAMUI';
        }
        if (currentquery) {
            const movies = await fetchSearch(currentquery);
            SearchMovies(movies);
        } else {
            console.log('Empty search query');
        }
    }

    searchButton.addEventListener('click', searchEvent);
    searchInput.addEventListener('keydown', function(e) {
        if (e.key === 'Enter') {
            e.preventDefault(); // Prevent form submission
            searchEvent();
        }
    });
});