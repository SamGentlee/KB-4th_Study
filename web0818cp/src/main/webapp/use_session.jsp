<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 사용하기</title>
</head>
<body>

	<h1>myname = ${ sessionScope['myname'] }</h1>
	<h1>myname = <%= session.getAttribute("myname") %></h1>
	
</body>
</html>