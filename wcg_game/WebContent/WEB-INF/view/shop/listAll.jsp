
<%@page import="vo.ShopVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
    
   [
 <%
   List<ShopVO> list = (List<ShopVO>)request.getAttribute("list");
 
   for(int i=0; i<list.size(); i++){
	   ShopVO  vo = list.get(i);
	   
	   if(i > 0) out.print(",");
%>

	 {
	    "no"      : "<%= vo.getItem_no() %>",
	    "link"  : "<%= vo.getItem_link() %>",
	    "name"   : "<%= vo.getItem_name() %>",
	    "point"     : "<%= vo.getItem_point() %>"
	 }   
	   
 <% 
 }	
 %>
 ]
 
  