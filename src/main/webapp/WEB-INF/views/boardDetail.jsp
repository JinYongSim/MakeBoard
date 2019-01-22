<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td{
		width:30%;
	}
</style>
</head>
<body>
	<c:if test="${board.id==sessionScope.loginId }">
	<form action="updateBoard" method="post">
		<input type="hidden" name="boardSeq" value="${board.boardSeq }">
		<input type="submit" value="수정">
	</form>
	<form action="deleteBoard" method="post">
		<input type="hidden" name="boardSeq" value="${board.boardSeq }">
		<input type="submit" value="삭제">
	</form>
	</c:if>	
	<table>
		<tr>
			<td>작성자 : ${board.id }</td>
			<td>작성일 : ${board.indate }</td>
			<td>조회수 : ${board.hitCount }</td>
		</tr>
		<tr>
			<td><hr></td>
		</tr>
		<tr>
			<td><font color="red" size=10px>${board.boardTitle }</font></td>
		</tr>
		<tr>
			<td>${board.boardContent }</td>			
		</tr>
	</table>
	<br>
	<a href="fileDownLoad?boardSeq=${board.boardSeq }">${board.fileName_org }</a>
	
	
</body>
</html>