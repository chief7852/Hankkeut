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
</head>
<body>
<%
	noticeBoardVO boardVo = (noticeBoardVO) request.getAttribute("boardVo");
%>
	<div class="board_wrap">
		<div class="board_title">
			<strong>공지사항</strong>
		</div>
		<div class="board_view_wrap">
			<div class="board_view">
				<div class="title">
					<%=boardVo.getN_board_title()%>
				</div>
				<div class="info">
					<dl>
						<dt>번호</dt>
						<dd><%=boardVo.getN_board_num()%></dd>					
					</dl>
					<dl>
						<dt>글쓴이</dt>
						<dd><%=boardVo.getManager_id()%></dd>					
					</dl>
					<dl>
						<dt>작성일</dt>
						<dd><%=boardVo.getN_board_date()%></dd>					
					</dl>
					<dl>
						<dt>조회</dt>
						<dd><%=boardVo.getN_board_views()%></dd>					
					</dl>
				</div>
				<div class="cont">
					<%=boardVo.getN_board_contents()%>
				</div>
			</div>
		
			<div class="bt_wrap">
				<a href="<%=request.getContextPath()%>/notice/boardUpdateForm.ddit?boardNum=<%=boardVo.getN_board_num()%>">수정</a>
				<a href="<%=request.getContextPath()%>/notice/boardList.ddit" class="on">목록</a>
				<a href="<%=request.getContextPath()%>/notice/boardDelete.ddit?boardNum=<%=boardVo.getN_board_num()%>">삭제</a>
			</div>
		</div>
	</div>
</body>
</html>