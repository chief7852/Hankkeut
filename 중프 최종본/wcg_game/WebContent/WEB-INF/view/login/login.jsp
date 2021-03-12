<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>한끝 로그인</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/wcggame/css/loginCSS.css">
<script type="text/javascript">
	$(function() {
		var login_ck = <%=(String)request.getAttribute("login_ck")%>;
		console.log("login_ck : " + login_ck);
		if(login_ck == 0) {
			alert("아이디가 존재하지 않거나\n아이디나 비밀번호가 틀립니다.");
		}
	});
	
</script>
</head>
<body>
	<form action="<%=request.getContextPath()%>/login/login.ddit">
		<div class="center">
			<!-- <input type="checkbox" id="show"> <label for="show" class="show-btn">View Form</label> -->
			<div class="container">
				<label for="show" class="close-btn fas fa-times" title="close"></label>
				<div class="text">한끝 로그인</div>
				<!-- <div class="data">
				  <label>Danger!</label> Indicates a dangerous or potentially negative action.
				</div> -->
				<form action="#">					
					<div class="data">
						<label>ID</label> <input type="text" name="mem_id" required>
					</div>
					<div class="data">
						<label>Password</label> <input type="password" name="mem_pass" required>
					</div>
					<div class="forgot-pass">
						<a href="#">Forgot Password?</a>
						
					</div>
					
					<div class="btn">
						<div class="inner"></div>
						<button type="submit">login</button>
					</div>
					<div class="signup-link">
						Not a member? <a href="/wcggame/home_sign/sign_up.html">SignUp</a>
					</div>
				</form>
			</div>
		</div>
	</form>
</body>
</html>
