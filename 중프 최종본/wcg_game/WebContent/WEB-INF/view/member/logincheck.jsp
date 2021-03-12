<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
//controller에서 request에 저장된 값을 가져온다.

String result = (String)request.getAttribute("logincheck");
if(result != null){
	//id가 이미 있다 a001 - 사용불가능

%>
	{
		"sw" : "로그인완료"
	}
<%}else{
	//id가 없다 -korea - 사용가능
%>
	{
		"sw" : "로그인실패"
	}
	
<%
}
%>