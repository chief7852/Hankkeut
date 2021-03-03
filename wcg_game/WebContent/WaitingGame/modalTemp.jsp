<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 550px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
        
    /* On small screens, set height to 'auto' for the grid */
    @media screen and (max-width: 767px) {
      .row.content {height: auto;} 
    }
  </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="../waitingGame_js/waitingGame.js"></script>  
	<script type="text/javascript">
		$(function() {
			$("#createRoomBtn").on('click', function() {
				<%-- var url = "<%=request.getContextPath()%>/game/waitingRoom.ddit";
				createRoom(url); --%>
				var form = $('#createRoomForm').get(0);
				form.action = "<%=request.getContextPath()%>/game/waitingRoom.ddit";
				console.log("next");
				form.submit();
			});
		})
	</script>
	<!-- Friend Modal -->
	<div class="modal fade" id="friend" data-backdrop="static">
		<div class="modal-dialog modal-sm">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">친구 창</h4>
				</div>
				<div class="modal-friend">
					<table>
						<thead id="thead">
							<tr>
								<td>ID</td>
								<td>귓속말</td>
								<td>친구 삭제</td>
							</tr>
						</thead>
						
						<tbody>
						
							<tr>
								<td>ooo</td>
								<td><button type="button">귓속말</button></td>
								<td><button type="button">친구삭제</button></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				</div>
			</div>

		</div>
	</div>
	</div>

	<!-- Setting Modal -->
	<div class="modal fade" id="setting" data-backdrop="static">
		<div class="modal-dialog modal-sm">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">설정</h4>
				</div>
				<div class="modal-setting">
					<div id="label">
						<label>배경음악</label>
						<label>효과음</label>
						<label>요청거부</label>
						<label>자동 레디</label>
						<label>배경 테마</label>
					</div>
					<div id="option">
						<input type="range" value="50" min="0" max="100"><br>
						<input type="range" value="50" min="0" max="100"><br>
					
						<input type="checkbox">초대
						<input type="checkbox">친구추가
						<input type="checkbox">귓속말<br>
						
						<input type="checkbox">자동레디<br>
						
						<input type="radio" name="bg">Dark
						<input type="radio" name="bg">White
					</div>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">저장</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				</div>
			</div>

		</div>
	</div>
	
	<!-- Create Room Modal -->
	<form id="createRoomForm">
		<div class="modal fade" id="createRoom" data-backdrop="static">
			<div class="modal-dialog modal-sm">
	
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">방 생성</h4>
					</div>
					<div class="modal-room">
						<div id="label">
							<label>제목</label>
							<label>비밀번호</label>
							<label>라운드 수</label>
							<label>게임 시간</label>
							<label>게임 유형</label>
						</div>
						<div id="option">
							<input type="text" name="room_name"><br>
							<input type="password" name="room_pass"><br>
							<input type="text" name="room_round"><br>
							
							<select name="room_time" id="gStart">
								<option value="60">60초</option>
								<option value="80">80초</option>
								<option value="120">120초</option>
							</select>
							<br>
							<select name="room_theme" id="gType">
								<option value="쿵쿵따">쿵쿵따</option>
								<option value="끝말잇기">끝말잇기</option>
							</select>
						</div>
					</div>
					<div class="modal-footer">
						<button id="createRoomBtn" type="button" class="btn btn-default" data-dismiss="modal">생성</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>
	</form>
	
	<!-- shop modal생성 -->
	<div class="modal fade" id="create" data-backdrop="static">
		<div class="modal-dialog modal-sm">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">방 생성</h4>
				</div>
				<div class="modal-room">
					<div id="label">
						<label>제목</label>
						<label>비밀번호</label>
						<label>인원 수</label>
						<label>게임 시간</label>
						<label>게임 유형</label>
					</div>
					<div id="option">
						<input type="text" name="roomTitle"><br>
						<input type="password" name="roomPw"><br>
						<input type="text" name="number"><br>
						
						<select name="gameStart" id="gStart">
							<option value="60">60초</option>
							<option value="80">80초</option>
							<option value="120">120초</option>
						</select>
						<br>
						<select name="gameType" id="gType">
							<option value="쿵쿵따">쿵쿵따</option>
							<option value="끝말잇기">끝말잇기</option>
						</select>
					</div>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">생성</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
				</div>
			</div>

		</div>
	</div>


