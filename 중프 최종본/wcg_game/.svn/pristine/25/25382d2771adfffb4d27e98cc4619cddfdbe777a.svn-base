<%@page import="vo.EventBoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Event</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/home_js/jquery-3.5.1.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://static-hid.gslb.toastoven.net/css/members/hangame_join.css?v=494f495ee8f6ef563e71d9dc5af9b6811707b319">
<link rel="stylesheet" href="../css/css.css">
<link rel="stylesheet" href="../css/indexCSS.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
	<%
		EventBoardVO eventForm = (EventBoardVO) request.getAttribute("eventBoard");
		
	%>
</head>
<body>
		<div class="board_wrap">
		<div class="board_title">
			<strong>이벤트게시판</strong>
		</div>
	
		<div class="board_view_wrap">
			<div class="board_view">
				<div class="title">
					<%=eventForm.getE_board_title()%>
				</div>
				<div class="info">
					<dl>
						<dt>번호</dt>
						<dd><%=eventForm.getE_board_num()%></dd>					
					</dl>
					<dl>
						<dt>글쓴이</dt>
						<dd><%=eventForm.getManager_id()%></dd>					
					</dl>
					<dl>
						<dt>작성일</dt>
						<dd><%=eventForm.getE_board_date()%></dd>					
					</dl>
					<dl>
						<dt>조회</dt>
						<dd><%=eventForm.getE_board_views()%></dd>					
					</dl>
				</div>
				<div class="cont">
					
					<img alt="" src="<%=eventForm.getE_board_img() %> " style="width:350px; height:500px;">
				</div>
				<div class="cont">
					
					<%=eventForm.getE_board_contents() %>
				</div>
				<div class="bt_wrap">
				<a href="<%=request.getContextPath()%>/event/eventList.ddit" class="on">목록</a>
				
					<%
				
				try{
				String userId = (String) session.getAttribute("userid");
				
				if(userId.equals("admin")) {
					
				
			%>
				<a href="<%=request.getContextPath()%>/event/eventDelete.ddit?boardNum=<%=eventForm.getE_board_num()%>">삭제</a>
					<%
					}
				}
				catch (Exception e) {
					
					e.printStackTrace();
				}
				
				
			%>
				
				</div>
			</div>	
		</div>
			
	</div>
		

</body>
</html>