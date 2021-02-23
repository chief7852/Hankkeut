<%@page import="vo.noticeBoardVO"%>

<%@page import="java.util.List"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<noticeBoardVO> boards = (List<noticeBoardVO>) request.getAttribute("board");
%>
[
<%
	int i = 0;
	for(noticeBoardVO board : boards) {
		if(i>0) out.print(",");
	
%>
	{
		"num" : "<%=board.getN_board_num() %>",
		"title" : "<%=board.getN_board_title() %>",
		"writer" : "<%=board.getManager_id() %>",	
		"content" : "<%=board.getN_board_contents() %>",
		"hit" : "<%=board.getN_board_views() %>",
		"date" : "<%=board.getN_board_date() %>"
		
	}
<%
		i++;
	}
%>
]
