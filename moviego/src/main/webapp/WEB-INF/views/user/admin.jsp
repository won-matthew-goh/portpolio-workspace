<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- Custom styles -->
    <style>
        body {
            padding: 20px;
        }
        .table-container {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2 class="mt-4 mb-4">Admin Dashboard</h2>
    <a href="/" class="btn btn-dark btn-sm mb-2" style="display=inline;">Main Home</a>
    <!-- 회원 등록 폼 -->
    <div class="card mb-4">
        <h5 class="card-header">회원 등록</h5>
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/registerUser" method="post">
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" class="form-control" id="username" name="username" required>
                </div>
                <div class="form-group">
                    <label for="passwd">Password:</label>
                    <input type="password" class="form-control" id="passwd" name="passwd" required>
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>
                <button type="submit" class="btn btn-primary">등록</button>
            </form>
        </div>
    </div>
    
    <!-- 회원 목록 -->
    <div class="card mb-4">
        <h5 class="card-header">회원 목록</h5>
        <div class="card-body">
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>${user.userId}</td>
                            <td>${user.username}</td>
                            <td>${user.email}</td>
                            <td>
                                <%-- <a href="${pageContext.request.contextPath}/admin/editUser?userId=${user.userId}"
                                   class="btn btn-sm btn-info">수정</a> --%>
                                <%-- <form action="${pageContext.request.contextPath}/admin/editUser?userId=${user.userId}" method="post">
                                    <input type="hidden" name="userId" value="${user.userId}" /> <!-- 사용자 ID -->
                                    <button type="submit" class="btn btn-sm btn-danger">회원 수정</button>
                                </form> --%>
                                <form action="/admin/updateUser" method="post" style="display:inline;">
                                    <input type="hidden" name="userId" value="${user.userId}" />
                                    <input type="text" name="email" value="${user.email}" placeholder="새 이메일" />
                                    <button type="submit" class="btn btn-sm btn-info">이메일 수정</button>
                                </form>
                                <form action="/admin/resetPassword" method="post" style="display:inline;">
                                    <input type="hidden" name="userId" value="${user.userId}" />
                                    <button type="submit" class="btn btn-sm btn-primary">임시 비밀번호 발급</button>
                                </form>
                                <%-- <a href="${pageContext.request.contextPath}/admin/deleteUser?userId=${user.userId}"
                                   class="btn btn-sm btn-danger"
                                   onclick="return confirm('정말로 삭제하시겠습니까?')">삭제</a> --%>
                                <form action="${pageContext.request.contextPath}/admin/deleteUser?userId=${user.userId}" method="post" style="display: inline;">
                                    <input type="hidden" name="userId" value="${user.userId}" /> <!-- 사용자 ID -->
                                    <button type="submit" class="btn btn-sm btn-danger">회원 삭제</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    
    <!-- 게시물 신고 관리 -->
    <div class="card mb-4">
        <h5 class="card-header">게시물 신고 관리</h5>
        <div class="card-body">
            <table class="table">
                <thead>
                    <tr>
                        <th>게시물 ID</th>
                        <th>제목</th>
                        <th>신고 횟수</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${reportedReviews}" var="review">
                        <tr>
                            <td>${review.reviewId}</td>
                            <td>${review.title}</td>
                            <td>${review.reportCnt}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/admin/deleteReview?reviewId=${review.reviewId}"
                                   class="btn btn-sm btn-danger"
                                   onclick="return confirm('정말로 삭제하시겠습니까?')">삭제</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
