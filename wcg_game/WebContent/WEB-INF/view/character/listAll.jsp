<%@page import="vo.CharVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>

    
[   
 <%
   List<CharVO> list = (List<CharVO>)request.getAttribute("list");
 
   for(int i=0; i<list.size(); i++){
	   CharVO  vo = list.get(i);
	   
	   if(i > 0) out.print(",");
%>

	 {
	 	"char_nickname" :   "<%=vo.getChar_nickname() %>",
		"mem_id"        :   "<%=vo.getMem_id() %>",
		"char_level"    :   "<%=vo.getChar_level() %>",
		"char_exp"      :   "<%=vo.getChar_exp() %>",
		"char_win"      :   "<%=vo.getChar_win() %>",
		"char_lose"     :   "<%=vo.getChar_lose() %>",
		"char_about"    :   "<%=vo.getChar_about() %>",
		"char_point"    :   "<%=vo.getChar_point() %>",
		"char_rank"     :   "<%=vo.getChar_rank() %>",
		"char_login"    :   "<%=vo.getChar_login() %>",
		"base_img"      :   "<%=vo.getBase_img() %>"
	 
	 }   
	   
 <% 
 }	
 %>
 ]
 
