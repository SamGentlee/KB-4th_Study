<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 생성</title>
</head>
<body>

	<%
		Cookie c = new Cookie("visited", "Y");
		response.addCookie(c);
	%>
	<h1>쿠키 설정했슴</h1>
</body>
</html>