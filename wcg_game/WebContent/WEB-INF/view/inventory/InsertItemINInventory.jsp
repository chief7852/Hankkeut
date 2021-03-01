<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String item_no = (String) request.getAttribute("result");
	
	if(item_no == null ){
		//id가 이미 있다 a001 - 사용 불가능
%>

	{
		"sw" : "이벤토리 추가 성공"
	}
	
<%		
	}else{
		//id가 이미 있다 a001 - 사용 불가능
%>
	{
		"sw" : "이벤토리 추가 실패"
	}


<% 
}
    
%>
  