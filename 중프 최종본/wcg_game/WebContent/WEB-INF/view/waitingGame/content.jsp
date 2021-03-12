<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
     <script src="../waitingGame_js/waitingGame.js"></script>  
     <script src = "../preference_js/preference.js"></script>
     
     <style>
     .btnD{
     	background : black;
     	color : white;
     }
      .btnW{
     	color : black;
     }
     .btn btn-info{
     	width : 20px;
     }
     .a{
     visibility:hidden
     }
     body{
	     background : white;
	     color : black;
     } 
     .dark-mode{
     	background-color : black;
     	color : white;
     }
     </style>


	<div id="result"> </div>
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
					<br>
						<label>배경음악</label>
						<br><br><br>
						<label>효과음</label>
						<br><br><br>
					</div>
					<div id="option">
					<br>
						<button id="backmusicon" type="button" class="btn btn-info">ON</button>
						<button id="backmusoff" type="button" class="btn btn-info">OFF</button>
						<input type="range" value="50" min="0" max="100" class="a" id="aa"><br>
						
						<button id="effectsoundON"type="button" class="btn btn-info">ON</button>
						<button id="ebackmusiconffectsoundOFF"type="button" class="btn btn-info">OFF</button><br>
						<input type="range" value="50" min="0" max="100" class="a" id="bb"><br>
						<br>
					
						
					</div>
					<div id="result5"></div>
					<div id="result6"></div>
				</div>
			</div>

		</div>
	</div>
	
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


