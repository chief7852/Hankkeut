<%@page import="vo.RoomVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	RoomVO roomvo = (RoomVO) request.getAttribute("hostRoomInfo");
	System.out.println("roomvo jsp : " + roomvo.getRoom_no());
%>
{
	"room_no" : "<%=roomvo.getRoom_no()%>", 
	"room_pass" : "<%=roomvo.getRoom_pass()%>",
	"room_round" : "<%=roomvo.getRoom_round()%>", 
	"room_theme" : "<%=roomvo.getRoom_theme()%>",
	"room_name" : "<%=roomvo.getRoom_name()%>",
	"nickname" : "<%=roomvo.getNickname()%>",
	"allow_no" : "<%=roomvo.getAllow_no()%>",
	"room_host" : "<%=roomvo.getRoom_host()%>",
	"room_time" : "<%=roomvo.getRoom_time()%>"
}