<%@page import="vo.CharVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	int result = (Integer)request.getAttribute("chvo");
	//System.out.println("=======================");
	//System.out.println(result);
	//System.out.println("=================1======");
	
	
	
	
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
  