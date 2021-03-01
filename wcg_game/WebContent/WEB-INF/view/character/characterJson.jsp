<%@page import="vo.CharVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	CharVO vo = (CharVO)request.getAttribute("character");
%>

{
	"char_nickname"  :  "<%=vo.getChar_nickname()%>",
	"mem_id"         :  "<%=vo.getMem_id()%>",
	"char_level"     :  "<%=vo.getChar_level()%>",
	"char_exp"       :  "<%=vo.getChar_exp()%>",
	"char_win"       :  "<%=vo.getChar_win()%>",
	"char_lose"      :  "<%=vo.getChar_lose()%>",
	"char_about"     :  "<%=vo.getChar_about()%>",
	"char_point"     :  "<%=vo.getChar_point()%>",
	"char_rank"      :  "<%=vo.getChar_rank()%>",
	"char_login"     :  "<%=vo.getChar_login()%>",
	"base_img"		 :  "<%=vo.getBase_img()%>"
}
