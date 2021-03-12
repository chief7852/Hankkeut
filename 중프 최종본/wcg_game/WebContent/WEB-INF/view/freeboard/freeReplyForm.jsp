<%@page import="vo.CommentVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<CommentVO> list =
		(List<CommentVO>)request.getAttribute("reply");
	
%>
[
<%
	int i=0;
	for(CommentVO li:list){
		if(i>0) out.print(",");
	
%>
{
	"conum" : "<%=li.getCo_no() %>",
	"bonum" : "<%=li.getBoard_no() %>",
	"memid" : "<%=li.getMem_id() %>",
	"cont" : "<%=li.getCo_contents()%>",
	"codate":"<%=li.getCo_date() %>"
	}
	<%
	i++;
	}
	%>
]
