<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

String result = (String)request.getAttribute("result");

if(result != null)
{
%>
	{
		"sw" : "이미 존재하는 아이디입니다."
	}
<%
}
else
{
%>
	{
		"sw" : "사용가능"
	}
<%
}
%>