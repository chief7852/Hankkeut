<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
<script type="text/javascript">
	$(function() {
		$('#addBtn').on('click', function() {
			cont = $(".cont textarea").val();
			
			cont = cont.replace(/\n/g, "<br>");
			$(".cont textarea").val(cont);
			
			var Form = $('#noticeBoard').get(0);
			Form.action = "<%=request.getContextPath()%>/event/eventInsert2.ddit";
			Form.submit();
		});
	});
</script>

</head>
<body>
	<form id="noticeBoard">
	<div class="board_wrap">
		
		<div class="board_list_wrap">
			<div class="board_write">
				
					<div class="title">
						<dl>
						<dt>제목</dt>
						<dd>
							<input type="text" name="e_board_title" >
						</dd>
						</dl>
						</div>
						<div class="title">
						<dl>
						<dt>첨부이미지</dt>
						<dd>
						<form action="fileOk.jsp" method="post" enctype="multipart/form-data">
							<input type="file" name="e_board_email" >
						</form>
						</dd>
						</dl>
					
				</div>
				<hr>
				<div class="cont">
					<textarea name="i_board_contents" placeholder="내용입력" style='font-size:30pt'></textarea>
				</div>
			
			</div>


			<div class="bt_wrap">
				<input id="addBtn" type="button" class="on" value="등록">
				<a href="<%=request.getContextPath()%>/event/eventList.ddit">취소</a>
			</div>

		</div>
	</div>
</form>

</body>
</html>















