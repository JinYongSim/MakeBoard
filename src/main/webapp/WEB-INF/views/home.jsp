<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>MakeBoard</title>
</head>
<body>
	<form action="signUp">
		<input type="submit" value="회원가입">
	</form>
	<c:if test="${sessionScope.loginId==null }">
	<form action="login">
		<input type="submit" value="로그인">
	</form>
	</c:if>
	<c:if test="${sessionScope.loginId!=null }">
	<form action="logout">
		<input type="submit" value="로그아웃">
	</form>
	</c:if>
	<form action="selectBoardList">
		<input type="submit" value="게시판">
		<input type="hidden" name="page" value="1">
	</form>
	<h1><a href="selectBoardList?page=1">게시판가기</a></h1>
</body>
</html>
