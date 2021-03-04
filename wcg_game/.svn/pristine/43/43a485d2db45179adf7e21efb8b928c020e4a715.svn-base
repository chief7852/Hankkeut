<%@page import="vo.CommentVO"%>
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
   <%
	freeBoardVO boardVo = (freeBoardVO) request.getAttribute("boardNum");
   
%>
  <script type="text/javascript">

  replyListServer= function(but){
  	$.ajax({
  		url :"<%=request.getContextPath()%>/free/freeReplyList.ddit",
  		data : {'board_no' : '<%=boardVo.getF_board_no()%>'},
  		success : function(res){
  			recode="";
  			var memId = "";
  			$.each(res, function(i,v){
  				memId= v.memid;
  				recode+=
  					"<div class='panel-body rep' style='border: 2px solid #ccbbbb;'>"+
         	       		"<p class='p1'>"+
         	       		 "답글자:"+v.memid+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
         		         "작성일:"+v.codate+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>"+
         		       	 "내용:"+v.cont+
         		         "<br><br><span class='cont'>${v.cont}</span> </p></div>";
         	     /*   <p class="p2">
         		     <button id="rmodi" idx="${v.conum}" type="button" name="r_modify" class="action">댓글수정</button>
         		     <button idx="${v.renum}" type="button" name="r_delete" class="action">댓글삭제</button>
         	       </p> */
         	       
                   
  			})
  			$(but).parents('.panel').find('.rep').remove();
  			$(but).parents('.panel').find('.pbody').append(memId);
  			$("#pbdy").html(recode);	
  			
  			
  		},
  		error : function (xhr) {
  			alert("상태 : " + xhr.status);
  		},
  		dataType : 'json'
  	})
  }
	$(function() {
		replyListServer();
		
		
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

	<div class="board_wrap">
		<div class="board_title">
			<strong>자유게시판</strong>
		</div>
		<input type="hidden" name="board_no" value="<%=boardVo.getF_board_no()%>">
		
		<div class="board_view_wrap">
			<div class="board_view">
				<div class="title">
					<%=boardVo.getF_board_title()%>
				</div>
				<div class="info">
					<dl>
						<dt>번호</dt>
						<dd><%=boardVo.getF_board_no()%></dd>					
					</dl>
					<dl>
						<dt>글쓴이</dt>
						<dd><%=boardVo.getMem_id()%></dd>					
					</dl>
					<dl>
						<dt>작성일</dt>
						<dd><%=boardVo.getF_board_date()%></dd>					
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
				<div id="pbdy">
				
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