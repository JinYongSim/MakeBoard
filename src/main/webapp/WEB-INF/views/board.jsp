<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td{
		width:30%;
	}
</style>
</head>
<body>
	<form action="board">
		<input type="submit" value="게시판글쓰기">
	</form>
	
	<table>
		<tr>
			<td>작성자</td>
			<td>제목</td>
			<td>조회수</td>
			<td>작성일</td>
		</tr>
	</table>
	<table>
		<c:forEach var="boardList" items="${boardList }">
			<tr>
				<td>${boardList.id }</td>
				<td>${boardList.boardTitle }</td>
				<td>${boardList.hitCount }</td>
				<td>${boardList.indate }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>