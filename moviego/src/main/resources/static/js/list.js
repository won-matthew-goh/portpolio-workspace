 function updatePlaceholder() {
            var searchOption = document.querySelector('.search-option').value;
            var searchInput = document.getElementById('searchInput');

            if (searchOption === 'title') {
                searchInput.placeholder = "글제목으로 입력";
            } else if (searchOption === 'userId') {
                searchInput.placeholder = "사용자명으로 입력";
            } else {
                searchInput.placeholder = "내용 입력";
            }
        }

