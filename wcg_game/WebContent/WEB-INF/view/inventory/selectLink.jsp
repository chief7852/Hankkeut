
<%@page import="vo.InventoryVO"%>
<%@page import="vo.ShopVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	List<ShopVO> list = (List<ShopVO>) request.getAttribute("list");
 %>
    
   [
<%
   
   for(int i=0; i<list.size(); i++){
	   ShopVO  vo = list.get(i);
	   
	   if(i > 0) out.print(",");
%>

	 {
	     "item_no"         : "<%= vo.getItem_no()%>",
         "item_link"       : "<%= vo.getItem_link()%>",
         "item_name" 	   : "<%= vo.getItem_name()%>",
         "item_point"      : "<%= vo.getItem_point()%>",
         "itemp_category"  : "<%= vo.getItemp_category()%>"
	 }   
	   
 <% 
 }	
 %>
 ]
 
  
  
  
