<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./includes/header.jsp"%>
<link rel="stylesheet" href="/css/index.css" />
 <div class="banner-wrapper">
      <div class="banner-wrap">
        <div class="banner-slide">
          <div class="slide-item"><div class="releasedt">🎬 ${movies[0].title} / ${movies[0].releaseDate}</div><img src="https://image.tmdb.org/t/p/original${movies[0].backdropPath}" alt="banner1" /></div>
          <div class="slide-item"><div class="releasedt">🎬 ${movies[1].title} / ${movies[1].releaseDate}</div><img src="https://image.tmdb.org/t/p/original${movies[1].backdropPath}" alt="banner2" /></div>
          <div class="slide-item"><div class="releasedt">🎬 ${movies[2].title} / ${movies[2].releaseDate}</div><img src="https://image.tmdb.org/t/p/original${movies[2].backdropPath}" alt="banner3" /></div>
          <div class="slide-item"><div class="releasedt">🎬 ${movies[3].title} / ${movies[3].releaseDate}</div><img src="https://image.tmdb.org/t/p/original${movies[3].backdropPath}" alt="banner4" /></div>
          <div class="slide-item"><div class="releasedt">🎬 ${movies[4].title} / ${movies[4].releaseDate}</div><img src="https://image.tmdb.org/t/p/original${movies[4].backdropPath}" alt="banner5" /></div>
          <div class="slide-item"><div class="releasedt">🎬 ${movies[0].title} / ${movies[0].releaseDate}</div><img src="https://image.tmdb.org/t/p/original${movies[0].backdropPath}" alt="banner1" /></div>
        </div>
      </div>
      <div class="pager-wrap">
        <i class="pager active fa fa-circle"></i>
        <i class="pager fa fa-circle"></i>
        <i class="pager fa fa-circle"></i>
        <i class="pager fa fa-circle"></i>
        <i class="pager fa fa-circle"></i>
      </div>
      <div class="buttons">
        <a class="prevBtn"><i class="fa-solid fa-caret-left"></i></a>
        <a class="nextBtn"><i class="fa-solid fa-caret-right"></i></a>
      </div>
    </div>
    <div class="content-wrapper w100">
      <div class="content-wrap">
        <div class="content-wp">
          <div class="desc-item" data-aos="fade-right">
            <h1>${movies[0].title}</h1>
            <p>
              <c:set var="name" value="${movies[0].overview}" />
              <c:if test="${movies[0].overview eq ''}">
                <c:out value="해당 영화는 영화사로부터 줄거리가 제공되지 않았습니다." />
              </c:if>
              ${movies[0].overview}
            </p>
            <a href="/movieList" class="nav-bt bt-black">More</a>
          </div>
          <div class="img-item" data-aos="fade-left">
            <img src="https://image.tmdb.org/t/p/original${movies[0].backdropPath}" alt="" />
          </div>
        </div>
        <div class="content-wp" data-aos="fade-up">
          <div class="img-item">
            <img src="https://image.tmdb.org/t/p/original${movies[1].backdropPath}" alt="" />
          </div>
          <div class="desc-item">
            <h1>${movies[1].title}</h1>
            <p>
              <c:set var="name" value="${movies[1].overview}" />
              <c:if test="${movies[1].overview eq ''}">
                <c:out value="해당 영화는 영화사로부터 줄거리가 제공되지 않았습니다." />
              </c:if>
              ${movies[1].overview}
            </p>
            <a href="/movieList" class="nav-bt bt-black">More</a>
          </div>
        </div>
        <div class="content-wp" data-aos="fade-up">
          <div class="desc-item" data-aos="fade-right">
            <h1>${movies[2].title}</h1>
            <p>
              <c:set var="name" value="${movies[2].overview}" />
              <c:if test="${movies[2].overview eq ''}">
                <c:out value="해당 영화는 영화사로부터 줄거리가 제공되지 않았습니다." />
              </c:if>
              ${movies[2].overview}
            </p>
            <a href="/movieList" class="nav-bt bt-black">More</a>
          </div>
          <div class="img-item" data-aos="fade-left">
            <img src="https://image.tmdb.org/t/p/original${movies[2].backdropPath}" alt="" />
          </div>
        </div>
        <div class="content-wp" data-aos="fade-up">
          <div class="img-item" data-aos="fade-right">
            <img src="https://image.tmdb.org/t/p/original${movies[3].backdropPath}" alt="" />
          </div>
          <div class="desc-item" data-aos="fade-left">
            <h1>${movies[3].title}</h1>
            <p>
              <c:set var="name" value="${movies[3].overview}" />
              <c:if test="${movies[3].overview eq ''}">
                <c:out value="해당 영화는 영화사로부터 줄거리가 제공되지 않았습니다." />
              </c:if>
              ${movies[3].overview}
            </p>
            <a href="/movieList" class="nav-bt bt-black">More</a>
          </div>
        </div>
        <div class="content-wp" data-aos="fade-up">
          <div class="desc-item" data-aos="fade-right">
            <h1>${movies[4].title}</h1>
            <p>
              <c:set var="name" value="${movies[4].overview}" />
              <c:if test="${movies[4].overview eq ''}">
                <c:out value="해당 영화는 영화사로부터 줄거리가 제공되지 않았습니다." />
              </c:if>
              ${movies[4].overview}
            </p>
            <a href="/movieList" class="nav-bt bt-black">More</a>
          </div>
          <div class="img-item" data-aos="fade-left">
            <img src="https://image.tmdb.org/t/p/original${movies[4].backdropPath}" alt="" />
          </div>
        </div>
      </div>
    </div>
    <div class="footer-wrapper">
      <a class="arrow-top"><i class="fa-solid fa-arrow-up"></i></a>
    </div>
  </body>
  <script src="../js/index.js"></script>
</html>
