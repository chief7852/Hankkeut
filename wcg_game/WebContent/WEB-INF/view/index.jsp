
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<title>HAN KKEUT</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./css/main.css"></link>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
}
</style>
<script type="text/javascript">
	  $(document).on('mouseover', '.topMenu span', function() {
		    $('.dept01').slideDown(1000);
		});
		$(document).on('mouseleave', 'div', function() {
			if (!$(this).hasClass('topMenu')) {
		        $('.dept01').slideUp(1000);
		    }
		})
  </script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<!-- <a class="navbar-brand" href="#">Portfolio</a> -->
				<a href="<%=request.getContextPath()%>/index.ddit"><img src="./img/logo.png" style="width: 150px; hegiht: 100px;"></a>
			</div>
			
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
				<%
					String userId = (String) session.getAttribute("userid");
					if(userId == null || userId == "") {
				%>
					<li><a href="/wcggame/home_sign/login.html"><span class="glyphicon glyphicon-log-in"></span>
							Login</a></li>
					<li><a href="/wcggame/home_sign/sign_up.html"><span class="glyphicon glyphicon-user"></span>
							Join</a></li>
				<%
					} else {
						if(userId.equals("admin")) {	// 어드민 접속
							
				%>
							<li>
								<a style="cursor:default"><span id="idStyle"><%=userId%> 님</span></a>
							</li>
							<li>
								<a herf="<%=request.getContextPath()%>/admin/manager.ddit" style="cursor:pointer">
									<span class="glyphicon glyphicon glyphicon-edit"></span>회원관리
								</a>
							</li>
							<li>
								<a herf="<%=request.getContextPath()%>/logout.ddit" style="cursor:pointer" target="_top">
									<span class="glyphicon glyphicon-log-out"></span>로그아웃
								</a>
							</li>
				<%
						}
						else {	// 일반 회원 접속
				%>
							<li>
								<a style="cursor:default"><span id="idStyle"><%=userId%> 님</span></a>
							</li>
							<li>
								<a href="<%=request.getContextPath()%>/mypage.ddit" target="ifr" style="cursor:pointer">
									<span class="glyphicon glyphicon glyphicon-edit"></span>마이페이지
								</a>
							</li>
							<li>
								<a href="<%=request.getContextPath()%>/logout.ddit" style="cursor:pointer" target="_top">
									<span class="glyphicon glyphicon-log-out"></span>로그아웃
								</a>
								<!-- <button id="logout" type="button" class="btn btn-default">로그아웃</button> -->
							</li>
				<%
						}
					}
				%>
				</ul>
			</div>
			<div class="collapse navbar-collapse topMenu" id="myNavbar">
				<ul class="menu01">
					<li><span>새소식</span>
						<ul class="dept01">
							<li class="nop"><a href="<%=request.getContextPath()%>/notice/boardList.ddit" target="ifr">공지사항</a></li>
							<li class="nop"><a href="<%=request.getContextPath()%>/event/eventList.ddit" target="ifr">이벤트</a></li>
						</ul></li>
					<li><span>가이드</span>
						<ul class="dept01">
							<li class="nop"><a href="./guide/guide_main.html" target="ifr">게임 가이드</a></li>
						</ul></li>
					<li><span>커뮤니티</span>
						<ul class="dept01">
							<li class="nop"><a href="<%=request.getContextPath()%>/free/freeList.ddit" target="ifr">자유게시판</a></li>
						</ul></li>
					<li><span>고객센터</span>
						<ul class="dept01">
							<li class="nop"><a href="<%=request.getContextPath()%>/inquiry/inquiryInsertForm.ddit"target="ifr">문의게시판</a></li>
							
						</ul></li>
				</ul>
				<ul class="menu02">
					<li>
						<%-- <%
							if(userId == null || userId == "") {
						%>
								<img src="./img/gameBtn.PNG" onClick="window.open('<%=request.getContextPath()%>/WaitingGame/main.jsp', '','width= 1700, height= 800px, resizable=no')" style="width: 200px; hegiht: 100px;">
								<img src="./img/gameBtn.PNG" onClick="window.open('<%=request.getContextPath()%>/login/isLogin.ddit', '','width= 1700, height= 800px, resizable=no')" style="width: 200px; hegiht: 100px;">								
						<%
							} else {
								boolean isChar = (boolean) session.getAttribute("isChar");
								System.out.println("index.jsp isChar : " + isChar);
								if(isChar == true) {
						%>
									<img src="./img/gameBtn.PNG" onClick="window.open('<%=request.getContextPath()%>/WaitingGame/main.jsp', '','width= 1700, height= 800px, resizable=no')" style="width: 200px; hegiht: 100px;">
						<%
								} else {
						%>
									<img src="./img/gameBtn.PNG" onClick="window.open('<%=request.getContextPath()%>/WaitingGame/createNickName.jsp', '','width= 1700, height= 800px, resizable=no')" style="width: 200px; hegiht: 100px;">
						<%
								}
							}
						%> --%>
						<img src="./img/gameBtn.PNG" onClick="window.open('<%=request.getContextPath()%>/login/isLogin.ddit', '','width= 1700, height= 800px, resizable=no')" style="width: 200px; hegiht: 100px;">
					</li>
				</ul>
			</div>
		</div>
	</nav>
	
	<section>
	  	<article>
	  		<iframe title="" name="ifr" src="./home_main/main.html"></iframe>
	  	</article>
	</section>

	<footer>
		<p>대전 중구 중앙로 76 (우.34940) 302호실 | 팀장 최희수 | 팀원 양지수 전형섭 정이삭</p>
		<p>Copyright © MUHAYU Inc. All rights reserved. Since 2021</p>
	</footer>

</body>
</html>
