<%@page import="vo.RoomVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<RoomVO> roomList = (List<RoomVO>) request.getAttribute("roomList");
%>
[
<%
	int i=0;
	for(RoomVO room : roomList) {
		if(i > 0) out.println(",");
%>
		{ 
			"room_no" : "<%=room.getRoom_no()%>", 
			"room_pass" : "<%=room.getRoom_pass()%>",
			"room_round" : "<%=room.getRoom_round()%>", 
			"room_theme" : "<%=room.getRoom_theme()%>",
			"room_name" : "<%=room.getRoom_name()%>",
			"nickname" : "<%=room.getNickname()%>",
			"allow_no" : "<%=room.getAllow_no()%>",
			"room_host" : "<%=room.getRoom_host()%>",
			"room_time" : "<%=room.getRoom_time()%>"
		}
<%
		i++;
	}
%>
]