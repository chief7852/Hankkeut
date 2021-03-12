<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
//controller에서 request에 저장된 값을 가져온다.

String result = (String)request.getAttribute("idcheck");
if(result != null){

%>
	{
		"sw" : "사용불가능한 아이디"
	}
<%}else{
	//id가 없다 -korea - 사용가능
%>
	{
		"sw" : "사용가능한 아이디"
	}
	
<%
}
%>