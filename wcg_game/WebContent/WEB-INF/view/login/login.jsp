<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://static-hid.gslb.toastoven.net/css/members/hangame_join.css?v=494f495ee8f6ef563e71d9dc5af9b6811707b319">
<!-- 한게임 폰트사용 -->
<script src="/webjars/jquery/1.12.4/jquery.min.js"></script>
<link rel="stylesheet" href="./css/h_signCSS.css">
</head>
<body>
	<div class="is_pc">
		<div class="wrap">
			<header id="header" class="header">
				<em class="logo_area"> <!--로고 링크-->
				</em>
			</header>
			<div id="container">
				<!-- 전체 틀 -->
				<div class="content join_type_select">
					<div class="tit_wrap is_underline">
						<h1 class="h_txt">
							한끝 회원가입<br class="is_pc_skip">
						</h1>
						<div class="btn_wrap">
							<a href="sign_up.html" class="btn">한끝 계정으로 회원가입</a>
						</div>

					</div>
					<!-- api연결 못함(sns 계정연동 api구현 예정) -->
					<div class="form_wrap">
						<span class="intro_txt">SNS 계정으로 회원가입</span>
						<ul class="lst_btn_regis">
							<li><a href="#" class="btn btn_regis" data-sns-code="google"
								onclick="alert('미구현')"><span class="이미지"></span>Google 아이디로
									회원가입</a></li>
							<li><a href="#" class="btn btn_regis"
								data-sns-code="facebook" onclick="alert('미구현')"><span
									class="이미지"></span>Facebook 아이디로 회원가입</a></li>

							<!-- <li id="naverIdLogin"><a href="#" class="btn btn_regis" data-sns-code="naver" onclick="alert('미구현')"><span class="이미지"></span>NAVER 아이디로 회원가입</a></li> -->
							<li id="naverIdLogin"><a id="naverIdLogin_loginButton"
								href="#" class="btn btn_regis" data-sns-code="naver"><span
									class="이미지"></span>NAVER 아이디로 회원가입</a></li>
						</ul>
					</div>
				</div>
				<!-- 전체 틀 끝! -->


			</div>
		</div>
	</div>
</body>
</html>