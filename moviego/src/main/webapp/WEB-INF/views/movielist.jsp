<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@include file="./includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />
    <link rel="stylesheet" href="/css/base.css" />
    <link rel="stylesheet" href="/css/common.css" />
    <link rel="stylesheet" href="/css/all.min.css" />
    <link rel="stylesheet" href="/css/movie_list.css" />
    <script src="https://kit.fontawesome.com/47341c9756.js" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<title>movie list</title>
</head>
<body>
	   <div class="content-wrapper">
      <div class="content-wrap" id="content-wrap">
        <div class="search">
          <input type="text" placeholder="영화 입력 " />
          <i class="fa-sharp fa-solid fa-magnifying-glass"></i>
        </div>
        <h2>박스오피스 순위</h2>
        <div class="box" data-aos="flip-up">
          <div class="movie">
            <img
              src="https://an2-img.amz.wtchn.net/image/v2/2sLPR0moUjGnMwiyERLGkQ.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk5Ea3dlRGN3TUhFNE1DSmRMQ0p3SWpvaUwzWXlMM04wYjNKbEwybHRZV2RsTHpReU5EYzROREUxT0RNM09UTTBPVGtpZlEuaDdDUXMyb0VLNldwRFl6WTNLaFl2UWlWYmw0RHhUWVBMdm45R3Q5SWEzaw"
              width="225"
            />
            <div class="movie-name">인사이드아웃2</div>
            <div class="release-date">2024</div>
            <div class="nation">미국</div>
          </div>
          <div class="movie">
            <img
              src="https://an2-img.amz.wtchn.net/image/v2/PwL0Vy4kfZnPQjwB2QxDbw.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk5Ea3dlRGN3TUhFNE1DSmRMQ0p3SWpvaUwzWXlMM04wYjNKbEwybHRZV2RsTHpRME1qWTRNamN4TWpNMk5qY3lOaUo5LnBqZlZ4RUx3bzl5VERXaVlCNXZ3N2lCY3RnbW05RnQ1ZjY3aE4wZUxrQkU"
              width="225"
            />
            <div class="movie-name">하이재킹</div>
            <div class="release-date">2024</div>
            <div class="nation">한국</div>
          </div>
          <div class="movie">
            <img
              src="https://an2-img.amz.wtchn.net/image/v2/sZSMMkkDY7FW6Uxp9yudhQ.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk5Ea3dlRGN3TUhFNE1DSmRMQ0p3SWpvaUwzWXlMM04wYjNKbEwybHRZV2RsTHpFek5qWTBNRGM0T1RReE9UTXdJbjAuazFWY1dsaDNnLW4wc01mNkdwOTlLRXFJMjEwYTJ1Vk9pN0lXclJjQkZrZw"
              width="225"
            />
            <div class="movie-name">탈주</div>
            <div class="release-date">2024</div>
            <div class="nation">한국</div>
          </div>
          <div class="movie">
            <img
              src="https://an2-img.amz.wtchn.net/image/v2/JygsVA2NdJ0REeVdp1riAA.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk5Ea3dlRGN3TUhFNE1DSmRMQ0p3SWpvaUwzWXlMM04wYjNKbEwybHRZV2RsTHpFME5qa3pPRGMxTVRNeE9Ua3pPVGNpZlEuOWFONWw2LUJaWlluSkg2VEZZOUNtb2pZOEdyNjJ4aWtySUJoQnVLdGJvbw"
              width="225"
            />
            <div class="movie-name">드라이브</div>
            <div class="release-date">2022</div>
            <div class="nation">한국</div>
          </div>
          <div class="movie">
            <img
              src="https://an2-img.amz.wtchn.net/image/v2/FdBNu2eOuavaFcePcqD-Ug.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk5Ea3dlRGN3TUhFNE1DSmRMQ0p3SWpvaUwzWXlMM04wYjNKbEwybHRZV2RsTHpnek9Ea3lNREU0TmpjME9ESTRNaUo5LjgzM19SUjlxeEpKM3NZQTdSNTZTNnlvcVdoNGNJRTlMZlU2dXRNYktsWHc"
              width="225"
            />
            <div class="movie-name">원더랜드</div>
            <div class="release-date">2024</div>
            <div class="nation">한국</div>
          </div>
        </div>
        <h2>공개예정작</h2>
        <div class="box" data-aos="flip-up">
          <div class="movie">
            <img
              src="https://an2-img.amz.wtchn.net/image/v2/g8LfrBmupKMH4LdtL5ynRw.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk5Ea3dlRGN3TUhFNE1DSmRMQ0p3SWpvaUwzWXlMM04wYjNKbEwybHRZV2RsTHpFM01ERXlOemMzTnpRME9UWTROVFF5TnpBaWZRLk1mZ2ozZVlabDE3ZVBYSXctZXhGVWJnZzgyLU9pLUhnWlVYNVZVcnZad2s"
              width="225"
            />
            <div class="movie-name">신차원! 짱구는 못말려 더 무비</div>
            <div class="release-date">2024-06-12</div>
            <div class="nation">미국</div>
          </div>
          <div class="movie">
            <img
              src="https://an2-img.amz.wtchn.net/image/v2/kI4hDdudiqpRSbvSKG76eg.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk5Ea3dlRGN3TUhFNE1DSmRMQ0p3SWpvaUwzWXlMM04wYjNKbEwybHRZV2RsTHpNek16UTFNakUyT1RRMU5qVTBNalVpZlEuUGVwQmxXVVNqaVUzYkRlYVpZUHN2RDZxRWUzX3FtY2k0MFN5SkluOE10SQ"
              width="225"
            />
            <div class="movie-name">밤낚시</div>
            <div class="release-date">2024-06-14</div>
            <div class="nation">미국</div>
          </div>
          <div class="movie">
            <img
              src="https://an2-img.amz.wtchn.net/image/v2/HQBjpSUqPDy-jspChQo7Aw.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk5Ea3dlRGN3TUhFNE1DSmRMQ0p3SWpvaUwzWXlMM04wYjNKbEwybHRZV2RsTHpJd09EQTJNekU0TnpRNE1EZ3pNemNpZlEuUHNjajN6cDJrcDhNeF9XTnZTbHlHcG9saGFmamRDazRNX1NnWW12eDMyNA"
              width="225"
            />
            <div class="movie-name">1초 앞, 1초 뒤</div>
            <div class="release-date">2024-06-19</div>
            <div class="nation">미국</div>
          </div>
          <div class="movie">
            <img
              src="https://an2-img.amz.wtchn.net/image/v2/nrHzu8RXsou24vL_ixkruw.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk5Ea3dlRGN3TUhFNE1DSmRMQ0p3SWpvaUwzWXhMM2N3TWpWcllYaGpjR0ZwTTNkbWRXVjRjR0prSW4wLjk2NHNGRVppOXdaNVdvRy1xSUdENTIyUnc3Qmt3bFg5SlJuZWxtYndUcFU"
              width="225"
            />
            <div class="movie-name">찰리와 초콜릿 공장</div>
            <div class="release-date">2024-06-19</div>
            <div class="nation">미국</div>
          </div>
          <div class="movie">
            <img
              src="https://an2-img.amz.wtchn.net/image/v2/zyLy1T1bKyYqVORJoxYbfQ.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk5Ea3dlRGN3TUhFNE1DSmRMQ0p3SWpvaUwzWXlMM04wYjNKbEwybHRZV2RsTHpFM09UVXhOVEUwTXpZME1ETXpOQ0o5LmdLYzJRUmJYaTZnMmFwelJET3VSbVpvQWxCRE04Z18wQnZtR2hRWko0dHc"
              width="225"
            />
            <div class="movie-name">북극백화점의 안내원</div>
            <div class="release-date">2024-06-19</div>
            <div class="nation">미국</div>
          </div>
        </div>
        <h2>평균 별점 높은 영화</h2>
        <div class="box" data-aos="flip-up">
          <div class="movie">
            <img
              src="https://an2-img.amz.wtchn.net/image/v2/2sLPR0moUjGnMwiyERLGkQ.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk5Ea3dlRGN3TUhFNE1DSmRMQ0p3SWpvaUwzWXlMM04wYjNKbEwybHRZV2RsTHpReU5EYzROREUxT0RNM09UTTBPVGtpZlEuaDdDUXMyb0VLNldwRFl6WTNLaFl2UWlWYmw0RHhUWVBMdm45R3Q5SWEzaw"
              width="225"
            />
            <div class="movie-name">인사이드아웃2</div>
            <div class="release-date">2024</div>
            <div class="nation">미국</div>
          </div>
          <div class="movie">
            <img
              src="https://an2-img.amz.wtchn.net/image/v2/PwL0Vy4kfZnPQjwB2QxDbw.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk5Ea3dlRGN3TUhFNE1DSmRMQ0p3SWpvaUwzWXlMM04wYjNKbEwybHRZV2RsTHpRME1qWTRNamN4TWpNMk5qY3lOaUo5LnBqZlZ4RUx3bzl5VERXaVlCNXZ3N2lCY3RnbW05RnQ1ZjY3aE4wZUxrQkU"
              width="225"
            />
            <div class="movie-name">하이재킹</div>
            <div class="release-date">2024</div>
            <div class="nation">한국</div>
          </div>
          <div class="movie">
            <img
              src="https://an2-img.amz.wtchn.net/image/v2/sZSMMkkDY7FW6Uxp9yudhQ.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk5Ea3dlRGN3TUhFNE1DSmRMQ0p3SWpvaUwzWXlMM04wYjNKbEwybHRZV2RsTHpFek5qWTBNRGM0T1RReE9UTXdJbjAuazFWY1dsaDNnLW4wc01mNkdwOTlLRXFJMjEwYTJ1Vk9pN0lXclJjQkZrZw"
              width="225"
            />
            <div class="movie-name">탈주</div>
            <div class="release-date">2024</div>
            <div class="nation">한국</div>
          </div>
          <div class="movie">
            <img
              src="https://an2-img.amz.wtchn.net/image/v2/JygsVA2NdJ0REeVdp1riAA.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk5Ea3dlRGN3TUhFNE1DSmRMQ0p3SWpvaUwzWXlMM04wYjNKbEwybHRZV2RsTHpFME5qa3pPRGMxTVRNeE9Ua3pPVGNpZlEuOWFONWw2LUJaWlluSkg2VEZZOUNtb2pZOEdyNjJ4aWtySUJoQnVLdGJvbw"
              width="225"
            />
            <div class="movie-name">드라이브</div>
            <div class="release-date">2022</div>
            <div class="nation">한국</div>
          </div>
          <div class="movie">
            <img
              src="https://an2-img.amz.wtchn.net/image/v2/FdBNu2eOuavaFcePcqD-Ug.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk5Ea3dlRGN3TUhFNE1DSmRMQ0p3SWpvaUwzWXlMM04wYjNKbEwybHRZV2RsTHpnek9Ea3lNREU0TmpjME9ESTRNaUo5LjgzM19SUjlxeEpKM3NZQTdSNTZTNnlvcVdoNGNJRTlMZlU2dXRNYktsWHc"
              width="225"
            />
            <div class="movie-name">원더랜드</div>
            <div class="release-date">2024</div>
            <div class="nation">한국</div>
          </div>
        </div>
        <h2>누적 관객수 순위</h2>
        <div class="box" data-aos="flip-up">
          <div class="movie">
            <img
              src="https://an2-img.amz.wtchn.net/image/v2/2sLPR0moUjGnMwiyERLGkQ.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk5Ea3dlRGN3TUhFNE1DSmRMQ0p3SWpvaUwzWXlMM04wYjNKbEwybHRZV2RsTHpReU5EYzROREUxT0RNM09UTTBPVGtpZlEuaDdDUXMyb0VLNldwRFl6WTNLaFl2UWlWYmw0RHhUWVBMdm45R3Q5SWEzaw"
              width="225"
            />
            <div class="movie-name">인사이드아웃2</div>
            <div class="release-date">2024</div>
            <div class="nation">미국</div>
          </div>
          <div class="movie">
            <img
              src="https://an2-img.amz.wtchn.net/image/v2/PwL0Vy4kfZnPQjwB2QxDbw.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk5Ea3dlRGN3TUhFNE1DSmRMQ0p3SWpvaUwzWXlMM04wYjNKbEwybHRZV2RsTHpRME1qWTRNamN4TWpNMk5qY3lOaUo5LnBqZlZ4RUx3bzl5VERXaVlCNXZ3N2lCY3RnbW05RnQ1ZjY3aE4wZUxrQkU"
              width="225"
            />
            <div class="movie-name">하이재킹</div>
            <div class="release-date">2024</div>
            <div class="nation">한국</div>
          </div>
          <div class="movie">
            <img
              src="https://an2-img.amz.wtchn.net/image/v2/sZSMMkkDY7FW6Uxp9yudhQ.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk5Ea3dlRGN3TUhFNE1DSmRMQ0p3SWpvaUwzWXlMM04wYjNKbEwybHRZV2RsTHpFek5qWTBNRGM0T1RReE9UTXdJbjAuazFWY1dsaDNnLW4wc01mNkdwOTlLRXFJMjEwYTJ1Vk9pN0lXclJjQkZrZw"
              width="225"
            />
            <div class="movie-name">탈주</div>
            <div class="release-date">2024</div>
            <div class="nation">한국</div>
          </div>
          <div class="movie">
            <img
              src="https://an2-img.amz.wtchn.net/image/v2/JygsVA2NdJ0REeVdp1riAA.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk5Ea3dlRGN3TUhFNE1DSmRMQ0p3SWpvaUwzWXlMM04wYjNKbEwybHRZV2RsTHpFME5qa3pPRGMxTVRNeE9Ua3pPVGNpZlEuOWFONWw2LUJaWlluSkg2VEZZOUNtb2pZOEdyNjJ4aWtySUJoQnVLdGJvbw"
              width="225"
            />
            <div class="movie-name">드라이브</div>
            <div class="release-date">2022</div>
            <div class="nation">한국</div>
          </div>
          <div class="movie">
            <img
              src="https://an2-img.amz.wtchn.net/image/v2/FdBNu2eOuavaFcePcqD-Ug.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk5Ea3dlRGN3TUhFNE1DSmRMQ0p3SWpvaUwzWXlMM04wYjNKbEwybHRZV2RsTHpnek9Ea3lNREU0TmpjME9ESTRNaUo5LjgzM19SUjlxeEpKM3NZQTdSNTZTNnlvcVdoNGNJRTlMZlU2dXRNYktsWHc"
              width="225"
            />
            <div class="movie-name">원더랜드</div>
            <div class="release-date">2024</div>
            <div class="nation">한국</div>
          </div>
        </div>
      </div>
    </div>
    <!-- modal -->
    <div class="modal-bg"></div>
    <div class="modal-wrap">
      <div class="btn">
        <i class="fa-solid fa-xmark"></i>
      </div>
      <div class="movie-name">[인사이드아웃2]</div>
      <div class="modal-wp">
        <div class="modal-poster">
          <img
            src="https://an2-img.amz.wtchn.net/image/v2/2sLPR0moUjGnMwiyERLGkQ.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk5Ea3dlRGN3TUhFNE1DSmRMQ0p3SWpvaUwzWXlMM04wYjNKbEwybHRZV2RsTHpReU5EYzROREUxT0RNM09UTTBPVGtpZlEuaDdDUXMyb0VLNldwRFl6WTNLaFl2UWlWYmw0RHhUWVBMdm45R3Q5SWEzaw"
          />
        </div>
        <div class="modal-info">
          <div id="release-date">
            <div class="title">개봉연도</div>
            <div class="content">2024</div>
          </div>
          <div id="nation">
            <div class="title">국가</div>
            <div class="content">미국</div>
          </div>
          <div id="genre">
            <div class="title">장르</div>
            <div class="content"></div>
          </div>
          <div id="grade">
            <div class="title">등급</div>
            <div class="content"></div>
          </div>
          <div id="time">
            <div class="title">러닝타임</div>
            <div class="content"></div>
          </div>
          <div id="Evaluation">
            <div class="title">별점</div>
            <div class="content"></div>
          </div>
          <div id="audience">
            <div class="title">누적 관객수</div>
            <div class="content"></div>
          </div>
        </div>
      </div>
      <div class="modal-box">
        <p class="content">내용입니다.</p>
        <div class="btn">
          <button class="close-btn">닫기</button>
        </div>
      </div>
    </div>
  <script src="/js/movie_list.js"></script>
</body>
</html>