<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
  //서블릿에서 실행된 결과값 
  int num = (Integer)request.getAttribute("selectItem");
  if(num > 0) {
%>
	   {
	     "num"  :  "<%=num %>"
	   }
	  
<%   }else{ %>

	   {
	     "num"  :  "실패"
	   }
<%	  
  }
%>

