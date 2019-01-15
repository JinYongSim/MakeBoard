<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function check(){
		document.getElementById("loginForm").submit();
	}
</script>
</head>
<body>
	<h1>로그인</h1>
	<form action="loginMember" method="post" id="loginForm">
		ID : <input type="text" name="id">
		PW : <input type="text" name="pw">
			 <input type="button" value="submit" onclick="check()">
	</form>
</body>
</html>