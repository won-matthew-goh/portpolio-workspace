<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h2>Hello world</h2>
  <h2>전체카운트 : ${cnt}</h2>
  <h2>이름 : ${userId.username} id : ${userId.userId}</h2>
  <c:forEach items="${list}" var="list" varStatus="status">
    <p>${status.index}</p>
    <p>${list.userId}</p>
    <p>${list.username}</p>
    <br>
  </c:forEach>
</body>
</html>