<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<table>
		<tr>
			<td>작성자 : ${detail.id }</td>
			<td>작성일 : ${detail.indate }</td>
			<td>조회수 : ${detail.hitCount }</td>
		</tr>
		<tr>
			<td><hr></td>
		</tr>
		<tr>
			<td><font color="red" size=10px>${detail.boardTitle }</font></td>
		</tr>
		<tr>
			<td>${detail.boardContent }</td>			
		</tr>
	</table>
	<br>
	<a href="fileDownLoad?boardSeq=${detail.boardSeq }">${detail.fileName_org }</a>
	
	
</body>
</html>