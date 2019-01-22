<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function insertCheck(){
		document.getElementById("insertBoardForm").submit();
	}
	function updateCheck(){
		document.getElementById("updateContentForm").submit();
	}
</script>
</head>
<body>
	<c:if test="${board!=null }">
		<h1>수정하기</h1>
		<form action="updateContent" id="updateContentForm" method="post" enctype="multipart/form-data">
		<input type="hidden" name="boardSeq" value="${board.boardSeq }">
		제목 : <input type="text" name="boardTitle" value="${board.boardTitle}"><br>
		내용 : <textarea name="boardContent"  style="resize: none;" cols="40" rows="20">${board.boardContent }</textarea><br>
		<h3>파일 업로드</h3>
		<input type="file" name="uploadFile" value="board.fileName_org">
			 <input type="button" value="완료" onclick="updateCheck()">
		</form>
	</c:if>
	
	<c:if test="${board==null }">
	<h1>게시물 작성하기</h1>
	<form action="insertBoard" enctype="multipart/form-data" method="post" id="insertBoardForm">
		제목 : <input type="text" name="boardTitle" value="${board.boardTitle}"><br>
		내용 : <textarea name="boardContent"  style="resize: none;" cols="40" rows="20">${board.boardContent }</textarea><br>
		<h3>파일 업로드</h3>
		<input type="file" name="uploadFile" value="board.fileName_org">
			 <input type="button" value="완료" onclick="insertCheck()">		
	</form>
	</c:if>
</body>
</html>