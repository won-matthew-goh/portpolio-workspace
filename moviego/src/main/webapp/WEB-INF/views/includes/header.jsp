<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:formatDate value="${date}" type="date" dateStyle="full"/>
<fmt:formatNumber value="${number}" type="currency"/>
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
        <a href="/movieList" class="nav-bt"><spring:message code="nav.findMovie"/></a>
        <h1 class="nav-h1">|</h1>
        <a href="/review" class="nav-bt"><spring:message code="nav.allReviews"/></a>
        <h1 class="nav-h1">|</h1>
        <a href="/boxoffice" class="nav-bt"><spring:message code="nav.boxOffice"/></a>
        
        <sec:authorize access="isAuthenticated()">
            <sec:authorize access="hasRole('ADMIN')">
                <a href="/admin" class="nav-bt bt-black"><spring:message code="nav.adminPage"/></a>
            </sec:authorize>
            <sec:authorize access="!hasRole('ADMIN')">
                <a href="/mypage" class="nav-bt bt-black"><spring:message code="nav.myPage"/></a>
            </sec:authorize>
            <form action="/logout" method="post" style="display: inline;">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <button type="submit" class="nav-bt bt-black logout-btn"><spring:message code="nav.logout"/></button>
            </form>
        </sec:authorize>
        
        <sec:authorize access="!isAuthenticated()">
            <a href="/login" class="nav-bt bt-black"><spring:message code="nav.login"/></a>
            <a href="/user/join" class="nav-bt bt-black"><spring:message code="nav.signup"/></a>
        </sec:authorize>
        
        <div class="lang-wp">
          <a href="#" class="nav-bt globeicon"><i class="fa-solid fa-earth-americas"></i></a>
          <div class="langs">
            <a href="?lang=ko">한국어</a>
            <a href="?lang=en">English</a>
            <a href="?lang=ja">日本語</a>
          </div>
        </div>
      </div>
    </header>