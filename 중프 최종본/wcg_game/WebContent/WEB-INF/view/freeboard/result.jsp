<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	int num = (Integer) request.getAttribute("boardStatus");

	if(num > 0) {
%>
		{
			"sw": "수정완료했습니다"
		}
<%
	} else {
%>
		{
			"sw": "수정실패했습니다"
		}
<%
	}
%>