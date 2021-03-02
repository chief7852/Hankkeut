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
<style>
/* Set height of the grid so .sidenav can be 100% (adjust if needed) */
.row.content {
	height: 1500px
}

/* Set gray background color and 100% height */
.sidenav {
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}

.subMenu {
	list-style: none;
}
</style>
<script type="text/javascript">
	function daumPostcode() {
	    new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
	            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	            var roadAddr = data.roadAddress; // 도로명 주소 변수
	            var extraRoadAddr = ''; // 참고 항목 변수
	
	            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                extraRoadAddr += data.bname;
	            }
	            // 건물명이 있고, 공동주택일 경우 추가한다.
	            if(data.buildingName !== '' && data.apartment === 'Y'){
	               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	            }
	            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	            if(extraRoadAddr !== ''){
	                extraRoadAddr = ' (' + extraRoadAddr + ')';
	            }
	
	            // 우편번호와 주소 정보를 해당 필드에 넣는다.
	            document.getElementById('zip').value = data.zonecode;
	            document.getElementById("add1").value = roadAddr;
	           
	            var guideTextBox = document.getElementById("guide");
	        }
	    }).open();
	}
</script>
</head>
<body>
	<!-- 왼쪽 메뉴바 -->
	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">
				<h2>마이페이지</h2>
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="#passUpdate" data-toggle="tab">비밀번호 수정</a></li>
					<li><a href="#addrUpdate" data-toggle="tab">주소 수정</a></li>
					<li><a href="#telUpdate" data-toggle="tab">핸드폰 번호 수정</a></li>
					<li><a href="#withdrawal" data-toggle="tab">회원탈퇴</a></li>
				</ul>
			</div>

			<!-- 오른쪽 컨텐츠 -->
			<div class="tab-content col-sm-9">
				<div id="passUpdate" class="tab-pane fade in active">
					<!-- 비밀번호 수정 -->
					<label for="usr">현재 비밀번호</label> <input type="text"
						class="form-control" id="usr"> <label for="usr">새비밀번호</label> 
						<input type="text" class="form-control" id="usr"> 
						<label for="usr">새 비밀번호 확인</label> <input type="text" class="form-control" id="usr">
						<button type="button" class="btn btn-success">수정하기</button>
						<button type="button" class="btn btn-default">취소</button>
				</div>

				<div id="addrUpdate" class="tab-pane fade">
					<!-- 주소 수정 -->
					<div class="form-group">
						<label class="control-label col-sm-3" for="zip"><span
							class="asterisk"></span>우편번호:</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="zip" name="zip_code"
								placeholder="우편번호">
						</div>

						<input class="btn pressDownButton" type="button"
							onclick="daumPostcode()" value="우편번호 찾기">
					</div>

					<!-- 주소 -->
					<div class="form-group">
						<label class="control-label col-sm-1" for="add1">주소:</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="add1" name="mem_add1" placeholder="도로명주소">
						</div>
					</div>

					<!-- 상세주소 -->
					<div class="form-group">
						<label class="control-label col-sm-3" for="add2">상세주소:</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="add2" name="mem_add2" placeholder="상세주소">
						</div>
					</div>
					<button type="button" class="btn btn-success">수정하기</button>
					<button type="button" class="btn btn-default">취소</button>
				</div>

				<div id="telUpdate" class="tab-pane fade">
					<!-- 핸드폰 번호 수정 -->
					<button type="button" class="btn btn-success">수정하기</button>
					<button type="button" class="btn btn-default">취소</button>
				</div>

				<div id="withdrawal" class="tab-pane fade">
					<!-- 회원탈퇴 -->
					<button type="button" class="btn btn-success">수정하기</button>
					<button type="button" class="btn btn-default">취소</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>