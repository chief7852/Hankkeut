<%@page import="vo.freeBoardVO"%>
<%@page import="vo.noticeBoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardList</title>
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
	List<freeBoardVO> boardList = (List<freeBoardVO>) request.getAttribute("free");
	
%>
<%=boardList%>
	<div class="board_wrap">
		<div class="board_title">
			<strong>자유게시판</strong>

		</div>
		<div class="board_list_wrap>">
			<div class="board_list">
				<div class="top">
					<div class="num">번호</div>
					<div class="title">제목</div>
					<div class="writer">글쓴이</div>
					<div class="date">작성일</div>
					<div class="count">조회</div>
				</div>
				<%
					// int index = boardList.size()+1;
					for (freeBoardVO notice : boardList) {
						// --index;
				%>
				<div>
					<div class="num"><%=notice.getF_board_no()%></div>
					<div class="title">
						<a href="<%=request.getContextPath()%>/free/freeForm.ddit?boardNum=<%=notice.getF_board_no()%>"><%=notice.getF_board_title()%></a>
					</div>notice.getN_board_title()
					<div class="writer"><%=notice.getMem_id()%></div>
					<div class="date"><%=notice.getF_board_date()%></div>
					<div class="count"><%=notice.getF_board_views()%></div>
				</div>

				<%
					}
				%>
			</div>
			 <div class="board_page">
				<a href="#" class="bt first">&lt;</a> 
				<!-- <a href="#" class="bt prev">&lt;&lt;</a> -->
				<%
					int sPage = (Integer)request.getAttribute("sPage");
					int ePage = (Integer)request.getAttribute("ePage");
					int i;
					for(i=sPage; i<=ePage; i++) {
				%>
						<a href="<%=request.getContextPath()%>/free/freeList.ddit?page=<%=i%>" class="num"><%=i%></a>
				<%
					}
				%>
				<%-- pager = `<ul class="pul pagination pager">`;
				for(i=res.sPage; i<=res.ePage; i++) {
					if(cPage == i) {
						pager += `<li class="active"><a class="paging" href="#">${i}</a></li>`;
					} else {
						pager += `<li><a class="paging" href="#">${i}</a></li>`;
					}
				}--%>
				<a href="#" class="bt next">&gt;</a> 
				<!-- <a href="#" class="bt last">&gt;&gt;</a> -->
			</div> 
			<div class="bt_wrap">
				<a href="<%=request.getContextPath()%>/free/freeInsertForm.ddit" class="on">글쓰기</a> 
				<!-- <input type="button" id="addText" value="글쓰기"> -->
				<!-- <a href="#">수정</a> -->
			</div>

		</div>
	</div>
</body>
</html>