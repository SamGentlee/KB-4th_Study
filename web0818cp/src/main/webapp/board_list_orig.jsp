<%@page import="board.dto.BoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BoardDto> list = (List)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>
<style type="text/css">
	a{ text-decoration: none; color: black;}
	a:hover{ text-decoration: underline; color: blue; }
</style>
</head>
<body>
	<h1>게시물 목록</h1>
	<a href="board?command=insert_form">게시물 등록</a> <br>
	
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<% for(BoardDto dto: list){ %>
		<tr>
			<td><a href="board?command=detail&no=<%= dto.getNo() %>"><%= dto.getNo() %></a></td>
			<td><a href="board?command=detail&no=<%= dto.getNo() %>"><%= dto.getTitle() %></a></td>
			<td><%= dto.getWriter() %></td>
			<td><%= dto.getRegdate() %></td>
		</tr>
		<% }  %>
	</table>

</body>
</html>