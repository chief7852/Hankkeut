
<%@page import="vo.ShopVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
    
   
 <%
  ShopVO vo = (ShopVO)request.getAttribute("vo");
 //System.out.println("표시중~~");
 //System.out.println(vo.getItem_link());
 
%>

	 {
	        "no" : "<%= vo.getItem_no() %>",
	      "link" : "<%= vo.getItem_link() %>",
	      "name" : "<%= vo.getItem_name() %>",
	     "point" : "<%= vo.getItem_point() %>",
	  "category" : "<%= vo.getItemp_category() %>"
	 }   
	   
 
  