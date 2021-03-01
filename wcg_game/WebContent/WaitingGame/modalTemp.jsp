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

	
	<!-- Create Room Modal -->
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


