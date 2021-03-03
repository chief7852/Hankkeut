<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>닉네임 생성</title>
<style type="text/css">
	body {
		text-align: center;
	}
	.form-control {	
		margin: 0 auto;
		width: 250px;
	}
	.form-group img {
		border: 1px solid black;
		width:300px; height: 350px;
	}
	.form-group img:hover {
		border: 3px solid green;
		cursor:pointer;
	}
	
</style>
<script type="text/javascript">
	$(function() {
		img = "";
		$('#nickCreateBtn').on('click', function() {
			var form = $('#nickNameCreateForm').get(0);
			form.action="<%=request.getContextPath()%>/game/createNickName.ddit";
			form.submit();
		});
		$('#boyImg').on('click', function() {
			$(this).css("border", "3px solid green");
			$("#grilImg").css("border", "1px solid black");
			img = $(this).attr("src");
			console.log("createNickName img : " + img);
			$("#charGender").val(img);
		});
		$('#grilImg').on('click', function() {
			$(this).css("border", "3px solid green");
			$("#boyImg").css("border", "1px solid black");
			img = $(this).attr("src");
			console.log("createNickName img : " + img);
			$("#charGender").val(img);
		});
	});
</script>
</head>
<body>
<!-- 캐릭터 닉네임 생성 페이지 -->
<%-- <%
	String userId = (String) session.getAttribute("userid");
%>
<input type="hidden" name="<%=userId%>" value="<%=userId%>"> --%>

<form id="nickNameCreateForm">
	<input type="hidden" name="charImg" id="charGender">
    <div class="form-group">
      <label for="usr">닉네임 입력</label>
      <input type="text" class="form-control" name="char_nickname">
    </div>
    <div class="form-group">
    	<img id="boyImg" alt="" src="../img/boy_basic.png">
	    
    	<img id="grilImg" alt="" src="../img/girl_basic.png">
    	
    </div>
	<input type="button" id="nickCreateBtn" value="생성">
	<input type="button" onClick="window.close()" value="나가기">
 </form>

</body>
</html>