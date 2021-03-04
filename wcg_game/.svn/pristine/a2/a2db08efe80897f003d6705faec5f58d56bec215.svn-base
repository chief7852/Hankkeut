<%@page import="vo.FriendTargetVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<FriendTargetVO> list = (List<FriendTargetVO>) request.getAttribute("ftvo");
%>
[
<%
	int i = 0;
	for(FriendTargetVO ftvo : list) {
		if(i > 0) out.println(",");
%>
		{
			"mem_id" : "<%=ftvo.getMem_id()%>",
			"target_id" : "<%=ftvo.getTarget_id()%>",
			"target_date" : "<%=ftvo.getTarget_date()%>",
			"target_num" : "<%=ftvo.getTarget_num()%>",
			"target_allow" : "<%=ftvo.getTarget_allow()%>"
		}
<%
		i++;
	}
%>
]