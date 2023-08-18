<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 작업 결과</title>
</head>
<body>

	<h1>게시판 작업 결과</h1>
	<p>메시지 : <%= request.getAttribute("msg") %></p>
	<p>메시지 : ${msg}</p>
	<p>메시지 : <%= request.getAttribute("msg1") %></p>
	<p>메시지 : ${msg1}</p>
	<p>제목 : ${param.title}</p>
	<p>작성자 : ${param["writer"]}</p>
	<hr>
	<a href="board?command=list">게시물 목록</a>

</body>
</html>