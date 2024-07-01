<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="/css/all.min.css" />
    <link rel="stylesheet" href="/css/base.css" />
    <link rel="stylesheet" href="/css/common.css" />
    
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://unpkg.com/aos@next/dist/aos.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous"
    ></script>
    <title>Movie Go</title>
  </head>
  <body>
    <header class="header-wrapper w100">
      <div class="logo-wrap">
        <a class="logo" href="/">Movie Go</a>
      </div>
      <div class="navi-wrap">
        <a href="/movieList" class="nav-bt">리뷰 영화 찾기</a>
        <h1>|</h1>
        <a href="./board.html" class="nav-bt">모든 리뷰 목록</a>
        <h1>|</h1>
        <a href="/boxoffice" class="nav-bt">박스오피스</a>
        <a href="./login.html" class="nav-bt bt-black">로그인</a>
        <a href="./member_join.html" class="nav-bt bt-black">회원가입</a>
        <div class="lang-wp">
          <a href="#" class="nav-bt globeicon"><i class="fa-solid fa-earth-americas"></i></a>
          <div class="langs">
            <a href="#">한국어</a>
            <a href="#">English</a>
            <a href="#">日本語</a>
          </div>
        </div>
      </div>
    </header>