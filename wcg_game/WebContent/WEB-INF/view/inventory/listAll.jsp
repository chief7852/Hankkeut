
<%@page import="vo.InventoryVO"%>
<%@page import="vo.ShopVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
    
   [
 <%
   List<InventoryVO> list = (List<InventoryVO>)request.getAttribute("list");
 
   for(int i=0; i<list.size(); i++){
	   InventoryVO  vo = list.get(i);
	   
	   if(i > 0) out.print(",");
%>

	 {
	    "number" : "<%= i%>",
	        "no" : "<%= vo.getIn_no()%>",
	      "link" : "<%= vo.getItem_no() %>",
	      "name" : "<%= vo.getChar_nickname() %>",
	     "point" : "<%= vo.getIn_allow() %>"
	 }   
	   
 <% 
 }	
 %>
 ]
 
  