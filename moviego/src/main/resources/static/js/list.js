// 검색 옵션 선택 후 검색어 입력하기
function updatePlaceholder() {
	var searchOption = document.querySelector('.search-option').value;
	var searchInput = document.getElementById('searchInput');

	if (searchOption === 'movie_nm') {
		searchInput.placeholder = "영화명으로 입력";
	} else if (searchOption === 'title') {
		searchInput.placeholder = "글제목으로 입력";
	} else {
		searchInput.placeholder = "검색 옵션을 선택해주세요";
	}
}

// 검색옵션 선택 안할 경우, 알림창 띄우기
document.getElementById('searchButton').addEventListener('click', function(e) {
	var searchOption = document.querySelector('.search-option').value;
	if (searchOption === "0") {
		e.preventDefault();
		alert("검색 옵션을 선택해주세요");
	}
});
