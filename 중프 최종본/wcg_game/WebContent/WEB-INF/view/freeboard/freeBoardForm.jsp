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
   	String num =boardVo.getMem_id();
   String userId = (String)session.getAttribute("userid");
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
  					         	 "작성자:"+v.memid+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
  					         "작성일:"+v.codate+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>"+
  					         "내용:<br><br><span class='cont'>"+v.cont+"</span>"
  					          "<br><br> </p>";
  					        if(memId=="<%=userId%>"){
  					     recode+=	" <p class='p2'>" +
  "<input id='rmodi' idx="+v.conum+" idx2="+v.bonum+" type='button' class='on rmodi' value='댓글수정'>"+
  "<input id='addBtn3' idx3="+v.conum+" type='button' class='on addBtn3' value='댓글삭제'>"+
  					        
  		  						"</p>";
  					        }
  					      recode+= "</div>";
  						               	                         
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
			cont = $(this).parents(".reply").find('textarea').val();
			//cont = $(".reply textarea").val();
			
			cont = cont.replace(/\n/g, "<br>");
			$(this).parents(".reply").find('textarea').val(cont);
			//$(".reply textarea").val(cont);
			
			var Form = $('#noticeBoard').get(0);
			
			console.log(">>>>"+Form)
			Form.action = "<%=request.getContextPath()%>/free/freeReplyInsert.ddit";
			Form.submit();
		});
		
		$('#pbdy').on('click',".addBtn3",function(){
			reqply={}; 
			
			
			vidx3 = $(this).attr('idx3');
			
			 reqply.conum =vidx3;
			
			deleteReply(this);
		});
		$('#modireset').on('click',function(){
			$(this).parents('.rep').find('#rmodi').prop('disabled',false);
			replyReset();
		})
		

		
	 	$('#pbdy').on('click',".rmodi",function(){
	 		vidx = $(this).attr('idx');
	 		vidx2 = $(this).attr('idx2');
	 		
			
			$(this).prop('disabled',true);	
			
			if($('#modifyForm').css('display') != "none"){
				//현재 어딘가에 보이고 있다 
				
				//modifyForm의 textarea 의 내용을 가져온다 
				//원래 span class="cont" 에 다시 출력해주고
				//modifyForm 을 body로 append()한다 
				replyReset(); //현재 열려있는 modifyForm 을 닫는다 (취소버튼 )그리고 원래 내용으로 다시 돌아간다 .		
			}
			modifycont = $(this).parents(".rep").find(".cont").html();
			modifycont = modifycont.replace(/<br>/g,"\n");
			
			
			
			$('#modifyForm > textarea').val(modifycont);
			
			$(this).parents(".rep").find(".cont").empty();
			$(this).parents(".rep").find(".cont").append($('#modifyForm'));
			$('#modifyForm').show();
			
		
			
		}) 
		
		replyReset = function(){
			$('#modifyForm').parents('.rep').find('#rmodi').prop('disabled',false); //span 태그  = 댓글내용
			spancont = $('#modifyForm').parent();
			
			//수정폼을 다시 body로 append 잘라서 붙여넣기 한다 
			$('body').append('#modifyForm');
			$('#modifyForm').hide();
			
			//modifycont = $(this).parents(".rep").find(".cont").html();
			
			
			//원래내용을 가져와서 수정폼에 출력하기 위해서 
			//br 태그를 \n으로 바꾼적이 있는것을 
			//다시 span태그로 출력하기 위해서 \n을 br태그로 바꾼다 
			modifycont = modifycont.replace(/\n/g,"<br>");
			
			$(spancont).append(modifycont); //원래 span에 있었던 글내용
		   // $('pbdy').append($('#modifyForm'));
			
		} 
		
 		$('#modiok').on('click',function(){
 			 comment = {};
 			
			$(this).parents('.rep').find('#rmodi').prop('disabled' ,false);
			
			modicont = $('#modifyForm textarea').val()
			
			modicont = modicont.replace(/\n/g,"<br>");

						
			spancont = $('#modifyForm').parent();
			
			
			 
			$('body').append($('#modifyForm'));
			$('#modifyForm').hide();
			
			$(spancont).html(modicont); 
			
			//db에서 수정  -reply 객체를 이용해서  cont ,renum을 설정 
			
			comment.cont = modicont;
			comment.renum = vidx;
			comment.bonum =vidx2;
			console.log("cont=" + modicont)
			console.log("renum=" + vidx)
			
			updateReply()
		
		})  
	});
		
		
		
			deleteReply = function(re){
 			$.ajax({
 				url :"<%=request.getContextPath()%>/free/freeReplyDelete.ddit",
 				
 				data:{"renum":vidx3},
 				dataType:'json',
 				success:function(res){
 					alert("댓글삭제완료");
 					$(re).parents('.rep').remove();
 				},
 				error : function(xhr){
 					alert("상태 : " +xhr.status);
 				}
 			})
 		} 
		
		
		
		
		updateReply=function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/free/freeReplyUpdate.ddit",				
				
				data: comment, //reply객체 cont,renum이 저장
				dataType:'json',
				success:function(res){
					 
					 alert("수정완료했습니다");
				},
				error : function(xhr){
					alert("상태 : " +xhr.status);
				}
				
			})
		}
		
	
	
</script>
  
<style>
	#modifyForm{
  		display:none;
  	}
</style>
</head>
<body>
	<!-- 댓글 수정폼 -->
<div id="modifyForm">
	<textarea rows="5" cols="30"></textarea>
	<input type="button" value="확인" id="modiok">
	<input type="button" value="취소" id="modireset">
</div>

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
				
				
				
				<%
				if(userId!=null){
				%>
				
				<div class="reply">
					<textarea width="600" name="f_reply_contents" placeholder="댓글 입력"></textarea>
					<input id="addBtn" type="button" class="on" value="등록">
				</div>
				<%
					}
				%>
				
				<div id="pbdy">
				
				</div>
				
				
				
				
				
				
				
				
				

				
				
			</div>
			
			
		
			<div class="bt_wrap">

			<%System.out.println("여기가뜨는것이요 ?"+num); %>
			<%
				try{
				String userId2 = (String) session.getAttribute("userid");
				
				if(userId2.equals(num) || userId2.equals("admin")){
			%>

					<a href="<%=request.getContextPath()%>/free/freeUpdateForm.ddit?boardNum=<%=boardVo.getF_board_no()%>">수정</a>			
				<a href="<%=request.getContextPath()%>/free/freeDelete.ddit?boardNum=<%=boardVo.getF_board_no()%>">삭제</a>
			<%
				}
				} catch (Exception e) {

					e.printStackTrace();
				}
			%>
				<a href="<%=request.getContextPath()%>/free/freeList.ddit" class="on">목록</a>
			</div>
		</div>
	</div>
	</form>
</body>
</html>