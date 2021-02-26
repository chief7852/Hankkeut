<%@page import="java.io.PrintWriter"%>
<%@page import="vo.MemberVO"%>
<%@page import="java.util.Map"%> 
<%@page import="java.util.List"%> 
<%@page import="javax.mail.Transport"%> 
<%@page import="javax.mail.Message"%> 
<%@page import="javax.mail.Address"%> 
<%@page import="javax.mail.internet.InternetAddress"%>
 <%@page import="javax.mail.internet.MimeMessage"%> 
<%@page import="javax.mail.Session"%> 
<%@page import="javax.mail.Authenticator"%> 
<%@page import="java.util.Properties"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	response.setCharacterEncoding("utf-8");
	PrintWriter out1 = response.getWriter();
	out1.println("<h1> 이메일 성공적으로 보냄! </h1>");
%>