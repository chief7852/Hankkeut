<%@page import="vo.freeBoardVO"%>
<%@page import="vo.noticeBoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice</title>
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
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  <script type="text/javascript">
	$(function() {
		$('#addBtn').on('click', function() {
			cont = $(".reply textarea").val();
			
			cont = cont.replace(/\n/g, "<br>");
			$(".reply textarea").val(cont);
			
			var Form = $('#noticeBoard').get(0);
			
			console.log(">>>>"+Form)
			Form.action = "<%=request.getContextPath()%>/free/freeReplyInsert.ddit";
			Form.submit();
		});
	});
</script>
  
  
  
</head>
<body>

<form id="noticeBoard" action="<%=request.getContextPath()%>/free/freeReplyInsert.ddit">
<%
	freeBoardVO boardVo = (freeBoardVO) request.getAttribute("boardNum");
%>
	<div class="board_wrap">
		<div class="board_title">
			<strong>자유게시판</strong>
		</div>
		<div class="board_view_wrap">
			<div class="board_view">
				<div class="title">
					<%=boardVo.getF_board_title()%>
				</div>
				<div class="info">
					<dl>
						<dt>번호</dt>
						<dd name="board_no"><%=boardVo.getF_board_no()%></dd>					
					</dl>
					<dl>
						<dt>글쓴이</dt>
						<dd name="mem_id"><%=boardVo.getMem_id()%></dd>					
					</dl>
					<dl>
						<dt>작성일</dt>
						<dd name="co_date"><%=boardVo.getF_board_date()%></dd>					
					</dl>
					<dl>
						<dt>조회</dt>
						<dd><%=boardVo.getF_board_views()%></dd>					
					</dl>
				</div>
				<div class="cont">
					<%=boardVo.getF_board_contents()%>
				</div>
				
				
				<div class="reply">
					<textarea width="600" name="f_reply_contents" placeholder="댓글 입력"></textarea>
					<input id="addBtn" type="button" class="on" value="등록">
				</div>
				
				
				
				
				
				
				
				
				
				

				
				
			</div>
			
			
		
			<div class="bt_wrap">
				<a href="<%=request.getContextPath()%>/free/freeUpdateForm.ddit?boardNum=<%=boardVo.getF_board_no()%>">수정</a>
				<a href="<%=request.getContextPath()%>/free/freeList.ddit" class="on">목록</a>
				<a href="<%=request.getContextPath()%>/free/freeDelete.ddit?boardNum=<%=boardVo.getF_board_no()%>">삭제</a>
			</div>
		</div>
	</div>
	</form>
</body>
</html>