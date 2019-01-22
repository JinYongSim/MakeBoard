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
		width:20%;
	}
</style>
<script type="text/javascript">
function submitForm(page){
	
	document.getElementById("page").value=page;
	document.getElementById("myForm").submit();
	
}
</script>
</head>
<body>
	<form action="board">
		<input type="submit" value="게시판글쓰기">
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
	
	<table>
		<tr>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
			
		</tr>
	<c:if test="${boardList != null }">
		<c:forEach var="boardList" items="${boardList }">
			<tr>
				<td><a href="selectBoardDetail?boardSeq=${boardList.boardSeq}">${boardList.boardTitle }</a></td>
				<td>${boardList.id }</td>
				<td>${boardList.indate }</td>
				<td>${boardList.hitCount }</td>
			</tr>
		</c:forEach>
	</c:if>
	</table>
	
	<a href="javascript:submitForm('${navi.currentPage-1}')">이전페이지</a>
	<c:forEach var="page" begin="${navi.startPageGroup}" end="${navi.endPageGroup}">
	
	<c:if test="${navi.currentPage==page}">
	&nbsp;<a href="javascript:submitForm('${page}')"><b>${page}</b></a>&nbsp;
	</c:if>
	
	<c:if test="${navi.currentPage!=page}">
	&nbsp;<a href="javascript:submitForm('${page}')">${page}</a>&nbsp;
	</c:if>
	
	</c:forEach>
	<a href="javascript:submitForm('${navi.currentPage+1}')">다음페이지</a>
	
	<form action="selectBoardList" id="myForm">
		<input type="hidden" name="page" id="page" value="${navi.currentPage}">
		검색 : <input type="text" name="search" id="search" value="${search }">
		<input type="submit" value="검색">
	</form>
</body>
</html>