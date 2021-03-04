<%@page import="vo.EventBoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <% request.setCharacterEncoding("UTF-8");%>
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




</head>
<body>
<%
	List<EventBoardVO> boardList = (List<EventBoardVO>) request.getAttribute("eventlist");
	
%>


<div id="board">


	<%
					// int index = boardList.size()+1;
					for (EventBoardVO notice : boardList) {
						// --index;
	%>

	
	<div id="event">
		<img alt="" src="<%=notice.getE_board_img() %>" style="width:400px; height:300px;"
		onClick="window.open('<%=request.getContextPath()%>/event/eventForm.ddit?boardNum=<%=notice.getE_board_num()%>')">
		<div>
			
				<h3><%=notice.getE_board_contents() %></h3>
			
		</div>
	</div>

<%
					}
%>
				

</div>
			<%
			try{
			String userId = (String) session.getAttribute("userid");
			
			if(userId.equals("admin")){
			%>

				<div class="bt_wrap" style="text-align:right;margin-right: 300px;">
					<a style="text-align:center;" href="<%=request.getContextPath()%>/event/eventInsert.ddit" class="on">글쓰기</a> 
					
				</div>
				<%
						}
					}
			catch (Exception e) {
				
				e.printStackTrace();
			}
				%>
		

</body>
</html>
















