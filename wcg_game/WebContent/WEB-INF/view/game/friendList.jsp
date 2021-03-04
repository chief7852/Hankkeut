<%@page import="java.util.List"%>
<%@page import="vo.FriendVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<FriendVO> friendvo = (List<FriendVO>) request.getAttribute("friendvo");
	System.out.println("what?! " + friendvo);
%>
[
<%
	int i=0;
	for(FriendVO list : friendvo) {
		if(i > 0) out.println(",");
%>
		{
			"mem_id" : "<%=list.getMem_id()%>",
			"friend_id" : "<%=list.getFriend_id()%>",
			"friend_num" : "<%=list.getFriend_num()%>"
		}
<%
		i++;
	}
%>
]
