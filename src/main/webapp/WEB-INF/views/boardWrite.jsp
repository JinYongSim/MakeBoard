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
	<form action="insertBoard" method="post" id="insertBoardForm">
		제목 : <input type="text" name="boardTitle"><br>
		내용 : <input type="text" name="boardContent"><br>
			 <input type="button" value="완료" onclick="check()">		
	</form>
</body>
</html>