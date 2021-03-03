<%@page import="vo.RoomVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberList페이지</title>
</head>
<body>
<%
	RoomVO roomVo = (RoomVO) request.getAttribute("roomVo");
	System.out.println("gameRoom.jsp roomVo : " + roomVo.getRoom_no());
%>
	<h1>gameRoom</h1>
	<%-- <div id="header">
		<span><%=roomVo.getRoom_no()%></span>
		<span><%=roomVo.getRoom_name()%></span>
		<span><%=roomVo.getRoom_theme()%></span>
		<span><%=roomVo.getAllow_no()%></span>
	</div>
	
	<div id="content">
	
	</div>
	
	<div id="chatting">
	</div> --%>
</body>
</html>