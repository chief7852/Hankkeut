<%@page import="vo.CharVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	int result = (Integer)request.getAttribute("CHVO");
	
	
	if(result > 0){
%>

	{
		"sw" : "����"
	}
	
<%		
	}else{
%>
	{
		"sw" : "����"
	}


<% 
}
    
%>
  