 function updatePlaceholder() {
            var searchOption = document.querySelector('.search-option').value;
            var searchInput = document.getElementById('searchInput');

            if (searchOption === 'title') {
                searchInput.placeholder = "글제목으로 입력";
            } else if (searchOption === 'movie_nm') {
                searchInput.placeholder = "영화명으로 입력";
            } else {
                searchInput.placeholder = "내용 입력";
            }
        }

