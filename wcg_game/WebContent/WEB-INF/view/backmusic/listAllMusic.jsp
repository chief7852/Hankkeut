<%@page import="vo.BackMusicVO"%>
<%@page import="vo.CharVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>

    
[   
 <%
   List<BackMusicVO> list = (List<BackMusicVO>)request.getAttribute("list");
 
   for(int i=0; i<list.size(); i++){
	   BackMusicVO  vo = list.get(i);
	   
	   if(i > 0) out.print(",");
%>

	 {
	 	"backmusic_no"  :"<%=vo.getBackmusic_no() %>",
		"backmusicname" :"<%=vo.getBackmusicname() %>",
		"room_num"      :"<%=vo.getRoom_num() %>",
		"backmusicfile" :"<%=vo.getBackmusicfile() %>"
	 
	 }   
	   
 <% 
 }	
 %>
 ]
 
