<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="../waitingGame_js/waitingGame.js"></script>
<style>
	#con {
	    margin-bottom: 30px;
	}
	li {
		background-color: white;
	}
</style>
<%
	String userId = (String)session.getAttribute("userid");
%>
	<div class="container" id="con">
		<ul class="nav nav-tabs nav-justified">
			
			<%
				if(userId.contains("guest")) {
			%>
					<li id="Setting">
						<button type="button" class="btn btn-info btn-lg"
							data-toggle="modal" onclick="alert('회원 전용입니다.')">
							<span class="material-icons">build</span>
						</button>
					</li>
					<li>
						<button type="button" class="btn btn-info btn-lg"
							data-toggle="modal" onclick="alert('회원 전용입니다.')">
							<span class="material-icons">face</span>
						</button>
					</li>
					<li id="watingmove" class="li_width"><a href="#" onclick="alert('회원 전용입니다.')">인벤토리</a></li>
					<li id="watingmove" class="active li_width"><a data-toggle="tab" href="#waiting">대기실</a></li>
					<li class="li_width"><a data-toggle="modal" href="#createRoom">방 만들기</a></li>
					<li id="shopmove" class="li_width"><a href="#" onclick="alert('회원 전용입니다.')">상점</a></li>
					<li class="li_width"><a href="#" onclick="alert('회원 전용입니다.')">랭킹</a></li>
			<%
				} else {
			%>
					<li id="Setting">
						<button type="button" class="btn btn-info btn-lg"
							data-toggle="modal" data-target="#setting">
							<span class="material-icons">build</span>
						</button>
					</li>
					<li>
						<button type="button" class="btn btn-info btn-lg"
							data-toggle="modal" data-target="#friend" onclick="friendList()">
							<span class="material-icons">face</span>
						</button>
					</li>
					<li id="watingmove" class="li_width"><a data-toggle="tab" href="#inventory">인벤토리</a></li>
					<li id="watingmove" class="active li_width"><a data-toggle="tab" href="#waiting">대기실</a></li>
					<li class="li_width"><a data-toggle="modal" href="#createRoom">방 만들기</a></li>
					<li id="shopmove" class="li_width"><a data-toggle="tab" href="#shop">상점</a></li>
					<li class="li_width"><a data-toggle="tab" href="#rank">랭킹</a></li>
			<%
				}
			%>
		</ul>
	</div>
