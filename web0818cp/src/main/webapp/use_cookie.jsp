<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 사용하기</title>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();
	String msg = "처음 방문";
	for(Cookie c : cookies){
		if(c.getName().equals("visited") && c.getValue().equals("Y")){
			msg = "방문 했음";
			break;
		}
	}
	
%>



</body>
</html>