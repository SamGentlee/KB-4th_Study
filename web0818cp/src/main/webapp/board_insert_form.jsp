<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 등록 폼</title>
</head>
<body>
	<h1>게시물 등록</h1>
	<form action="board" method="post">
		<input type="hidden" name="command" value="insert_action">
		게시물 제목 : <input name="title"><br>
		게시물 작성자 : <input name="writer"><br>
		게시물 내용 : <br>
		<textarea rows="3" cols="60" name="content"></textarea>
		<br>
		<input type="submit" value="게시물 등록">
	</form>
</body>
</html>