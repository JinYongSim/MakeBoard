<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check(){
		document.getElementById("insertBoardForm").submit();
	}
</script>
</head>
<body>
	<h1>게시물 작성하기</h1>
	<form action="insertBoard" enctype="multipart/form-data" method="post" id="insertBoardForm">
		제목 : <input type="text" name="boardTitle"><br>
		내용 : <textarea name="boardContent" style="resize: none;" cols="40" rows="20"></textarea><br>
		<h3>파일 업로드</h3>
		<input type="file" name="uploadFile">
			 <input type="button" value="완료" onclick="check()">		
	</form>
	
</body>
</html>