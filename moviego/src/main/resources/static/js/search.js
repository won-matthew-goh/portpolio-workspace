/*function enterkey() {
		//keycode = 13, 엔터일 경우 
        if (window.event.keyCode == 13) {
             test = document.getElementById("searchForm").submit();
             
        }
}*/

const keyword = document.getElementById("keyword");

keyword.addEventListener("keypress", (event) => {
    enterKey(event);
});

const enterKey = (event) => {
    if (event.code === "Enter") {
        showSearchResult();
    }
};

const showSearchResult = () => {
    let searchWord = keyword.value;
		window.location.href = `https://google.com/search?q=${searchWord}`;
		searchWord = "";
};



