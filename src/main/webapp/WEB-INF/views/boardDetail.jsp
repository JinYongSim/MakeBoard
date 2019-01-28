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
<script>
	function check(){
		document.getElementById("commentForm").submit();
	}
</script>
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
	<a href="fileDownLoad?boardSeq=${board.boardSeq }">${board.fileName_org }</a><br>
	<table>
	<c:forEach var="cList" items="${cList}">
		<tr>
			<td>${cList.id }</td>
			<td>${cList.comments }</td>
			<td>${cList.indate }</td>
			<c:if test="${sessionScope.loginId==cList.id}">
			<td>
				<form action="deleteComment" method="post">
					<input type="hidden" name="commentSeq" value="${cList.commentSeq}">
					<input type="hidden" name="boardSeq" value="${cList.boardSeq }"> 
					<input type="submit" value="삭제">
				</form>
			</td>
			</c:if>
		</tr>
	</c:forEach>
	</table>
	<form action="insertComment" method="post" id="commentForm">
		<input type="hidden" name="boardSeq" value="${board.boardSeq }">
		<input type="hidden" name="id" value="${sessionScope.loginId}">
		<input type="text" name="comments" value="">
		<input type="button" value="댓글등록" onclick="check()">
	</form>
</body>
</html>