<%@page import="java.util.List"%>

<%@page import="vo.MemberVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한끝 - 마이페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="../home_js/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="./css/mypage.css">
<script type="text/javascript">

	$(function() {
		$('.nav li').on('click', function() {
			liAttr = $(this).attr('id');
			if(liAttr == 'passUpdateLi') {
				$('#passUpdateForm').css('display', 'block');
				$('#addrUpdateForm').css('display', 'none');
				$('#telUpdateForm').css('display', 'none');
				$('#deleteUserForm').css('display', 'none');
			} else if(liAttr == 'addrUpdateLi') {
				$('#passUpdateForm').css('display', 'none');
				$('#addrUpdateForm').css('display', 'block');
				$('#telUpdateForm').css('display', 'none');
				$('#deleteUserForm').css('display', 'none');
			} else if(liAttr == 'telUpdateLi') {
				$('#passUpdateForm').css('display', 'none');
				$('#addrUpdateForm').css('display', 'none');
				$('#telUpdateForm').css('display', 'block');
				$('#deleteUserForm').css('display', 'none');
			} else if(liAttr == 'deleteUser') {
				$('#passUpdateForm').css('display', 'none');
				$('#addrUpdateForm').css('display', 'none');
				$('#telUpdateForm').css('display', 'none');
				$('#deleteUserForm').css('display', 'block');
			}
		})
	});
</script>
<style>
	#addrUpdateForm, #telUpdateForm, #deleteUserForm{
		display: none;
	}
</style>
</head>
<body>
<%
	List<MemberVO> boardList = (List<MemberVO>) request.getAttribute("list");
%>
	<!-- 왼쪽 메뉴바 -->
	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">
				<h2>관리자페이지</h2>
				<ul class="nav nav-pills nav-stacked">
					<li id="passUpdateLi" class="active"><a href="#passUpdate" data-toggle="tab">회원 목록</a></li>
				<!-- 	<li id="addrUpdateLi"><a href="#addrUpdate" data-toggle="tab">주소 수정</a></li>
					<li id="telUpdateLi"><a href="#telUpdate" data-toggle="tab">핸드폰 번호 수정</a></li>
					<li id="deleteUser"><a href="#withdrawal" data-toggle="tab">회원탈퇴</a></li -->>
				</ul>
			</div>

			<!-- 오른쪽 컨텐츠 -->
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
				<%
					// int index = boardList.size()+1;
					for (MemberVO notice : boardList) {
						// --index;
				%>
				<div>
					<div class="num"><%=notice.getMem_id()%></div>
					<div class="title">
						<%=notice.getGender()%>
					</div>
					<div class="writer"><%=notice.getMem_mail()%></div>
					<div class="date"><%=notice.getMem_hp()%>
					</div>
					<a href="<%=request.getContextPath()%>/free/freeInsertForm.ddit" class="on">삭제</a> 
				</div>

				<%
					}
				%>
		
			</div>
		</div>
	</div>
		</div>
	</div>
</body>
</html>