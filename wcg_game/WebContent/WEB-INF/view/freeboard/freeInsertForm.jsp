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
<script type="text/javascript">
	$(function() {
		$('#addBtn').on('click', function() {
			cont = $(".cont textarea").val();
			
			cont = cont.replace(/\n/g, "<br>");
			$(".cont textarea").val(cont);
			
			var Form = $('#noticeBoard').get(0);
			Form.action = "<%=request.getContextPath()%>/free/freeInsert.ddit";
			Form.submit();
		});
	});
</script>
</head>
<body>

	


<form id="noticeBoard" action="<%=request.getContextPath()%>/free/freeInsert.ddit">
	<div class="board_wrap">
		<div class="board_title">
			<strong>자유게시판</strong>

		</div>
		<div class="board_list_wrap">
			<div class="board_write">
				<div class="title">
					<dl>
						<dt>제목</dt>
						<dd>
							<input type="text" name="n_board_title" placeholder="제목입력">
							
						</dd>
					</dl>
				</div>
				<hr>
				<div class="cont">
					<textarea name="n_board_contents" placeholder="내용입력"></textarea>
				</div>
			</div>


			<div class="bt_wrap">
				<input id="addBtn" type="button" class="on" value="등록">
				<a href="<%=request.getContextPath()%>/free/freeList.ddit">취소</a>
			</div>

		</div>
	</div>
</form>
</body>
</html>