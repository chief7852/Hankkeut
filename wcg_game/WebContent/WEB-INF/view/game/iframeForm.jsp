<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한끝</title>
<style type="text/css">
	body {
		margin:0px;padding:0px;overflow:hidden;
	}
	iframe {
		overflow:hidden;
		overflow-x:hidden;
		overflow-y:hidden;
		height:100%;
		width:100%;
		position:absolute;
		top:0px;
		left:0px;
		right:0px;
		bottom:0px;
	}
</style>
</head>
<body>
<%
	int roomNo = (int) request.getAttribute("roomNo");
	String check = (String) request.getAttribute("check");
%>
<iframe title="" name="ifr" frameborder="0" target="_self"
	src="<%=request.getContextPath()%>/game/enterTheRoom.ddit?roomNo=<%=roomNo%>&check=<%=check%>">
</iframe>
</body>
</html>