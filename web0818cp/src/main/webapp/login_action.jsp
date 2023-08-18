<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mmid = request.getParameter("mid");
	String mpwd = request.getParameter("mpwd");
	if( mmid != null && 
			mmid.equals("abc") && 
			mpwd != null &&
			mpwd.equals("123") ){
		//인증 성공
		session.setAttribute("mid", "abc");
	}
%>

<%
	//로그인 여부는 session.getAttribute("mid") 값이 없으면 로그인전
	String mid = (String)session.getAttribute("mid");
	if( mid == null ){ //로그인 안한상태
		response.sendRedirect("login_form.jsp");
		return;
	}else{ //로그인 한 상태
		response.sendRedirect("index.jsp");
	}
%>