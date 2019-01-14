<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function insertCheck(){
		document.getElementById("insertForm").submit();
	}
</script>
</head>
<body>
	<h1>회원가입</h1>
	<form action="insertMember" method="post" id="insertForm">
		ID : <input type="text" name="id"><br>
		PW : <input type="text" name="pw"><br>
		NAME : <input type="text" name="name"><br>
		PHONE : <input type="text" name="phone"><br>
		EMAIL : <input type="text" name="email"><br>
		BIRTHDATE : <input type="text" name="birthdate"><br>
		<input type="button" value="submit" onclick="insertCheck()">
	</form>
</body>
</html>