<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardList</title>
<script type="text/javascript">
	window.onload = function(){
		var addText = document.getElementById("addText");
		addText.onclick = function(){
			location.href="<%=request.getContextPath()%>/member/memberForm.ddit";
			
		}
	}
</script>
</head>
<body>
			<div class="board_wrap">
		<div class="board_title">
			<strong>공지사항</strong>
			
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
				<div>
					<div class="num">5</div>
					<div class="title"><a href="view.html">글제목5</a></div>
					<div class="writer">전형섭5</div>
					<div class="date">2021.02.20</div>
					<div class="count">33</div>
				</div>
					<div>
					<div class="num">4</div>
					<div class="title"><a href="view.html">글제목4</a></div>
					<div class="writer">전형섭4</div>
					<div class="date">2021.02.20</div>
					<div class="count">33</div>
				</div>
					<div>
					<div class="num">3</div>
					<div class="title"><a href="view.html">글제목3</a></div>
					<div class="writer">전형섭3</div>
					<div class="date">2021.02.20</div>
					<div class="count">33</div>
				</div>
					<div>
					<div class="num">2</div>
					<div class="title"><a href="view.html">글제목2</a></div>
					<div class="writer">전형섭2</div>
					<div class="date">2021.02.20</div>
					<div class="count">33</div>
				</div>
					<div>
					<div class="num">1</div>
					<div class="title"><a href="view.html">글제목1</a></div>
					<div class="writer">전형섭1</div>
					<div class="date">2021.02.20</div>
					<div class="count">33</div>
				</div>
			</div>
			<div class="board_page">
				<a href="#" class="bt first">&lt;</a>
				<a href="#" class="bt prev">&lt;&lt;</a>
				<a href="#" class="num">1</a>
				<a href="#" class="num">2</a>
				<a href="#" class="num">3</a>
				<a href="#" class="num">4</a>
				<a href="#" class="num">5</a>			
				<a href="#" class="bt next">&gt;</a>
				<a href="#" class="bt last">&gt;&gt;</a>
			</div>
			<div class="bt_wrap">
				<a href="write.html" class="on">등록</a>
				<input type="button" id="addText" value="글쓰기">
				<!-- <a href="#">수정</a> -->
			</div>
		
		</div>
	</div>

	<footer>
		<p>대전 중구 중앙로 76 (우.34940) 302호실 | 팀장 최희수 | 팀원 양지수 전형섭 정이삭</p>
		<p>Copyright © MUHAYU Inc. All rights reserved. Since 2021</p>
	</footer>
</body>
</html>