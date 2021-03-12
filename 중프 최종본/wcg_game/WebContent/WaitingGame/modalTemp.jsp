<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 550px
}

/* Set gray background color and 100% height */
.sidenav {
	background-color: #f1f1f1;
	height: 100%;
}

/* On small screens, set height to 'auto' for the grid */
@media screen and (max-width: 767px) {
	.row.content {
		height: auto;
	}
}

table {
	width: 100%;
	text-align: center;
}

.tab-content {
	text-align: center;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
        
        // 친구추가 버튼 클릭
         $('#addFriend').on('click' ,function() {
        	var form = $('#friendForm').get(0);
        	form.action = "<%=request.getContextPath()%>/friend/addFriend.ddit";
        	form.submit();
        });
        
        //
        $('.modal-content .modal-header ul li').on('click', function() {
        	var id = $(this).attr('id');
        	console.log("modalTemp.jsp : " + id);
        	if(id == "friendWin") { // 친구 창
        		<%-- location.href="<%=request.getContextPath()%>/friend/addFriend.ddit"; --%>
        		friendList();
        	} else if(id == "waiting"){  // 친구 대기
        		<%-- location.href="<%=request.getContextPath()%>/friend/waitFriend.ddit"; --%>
        		wattingFriend();
        	}
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
					<!-- <h4 class="modal-title">친구 창</h4> -->
					<ul class="nav nav-tabs">
						<li id="friendWin" class="active"><a data-toggle="tab" href="#home">친구창</a></li>
						<li id="waiting"><a data-toggle="tab" href="#menu1">친구대기</a></li>
					</ul>
				</div>
				<!-- 친구 창 -->
				<div class="tab-content">
					<div id="home" class="tab-pane fade in active">
					<form id="friendForm" action="<%=request.getContextPath()%>/friend/addFriend.ddit">
						<input type="text" name="userId"> 
						<input id="addFriend" type="button" value="친구추가">
					</form>
						<table>
							<thead id="thead">
								<tr>
									<td>ID</td>
									<td>귓속말</td>
									<td>친구삭제</td>
								</tr>
							</thead>
							<tbody id="friendList">
								<!-- <tr>
									<td>ooo</td>
									<td><button type="button">귓속말</button></td>
									<td><button type="button">친구삭제</button></td>
								</tr> -->
							</tbody>
						</table>
					</div>
					<!-- 친구 대기 -->
					<div id="menu1" class="tab-pane fade">
						<table id="waitingF">
							<thead id="thead">
								<tr>
									<td col>ID</td>
									<td colspan="2">수락/거절</td>
								</tr>
							</thead>
							<tbody id="wtbody">
								<!-- <tr>
									<td>ooo</td>
									<td colspan="2">
										<button type="button">수락</button>
										<button type="button">거절</button>
									</td>
								</tr> -->
							</tbody>
						</table>
					</div>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				</div>
			</div>

		</div>
	</div>
	</div>

<!-- Setting Modal -->
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
                  <label>자동레디</label>
                  <!-- <br><br><br>
                  <label>자동친구추가</label> -->
               </div>
               <div id="option">
               <br>
                  <button id="backmusicon" type="button" class="btn btn-info">ON</button>
                  <button id="backmusoff" type="button" class="btn btn-info">OFF</button>
                  <input type="range" value="50" min="0" max="100" class="a" id="aa" style="display:none"><br>
                  <br><br>
                  
                  <button id="effectsoundON"type="button" class="btn btn-info">ON</button>
                  <button id="ebackmusiconffectsoundOFF"type="button" class="btn btn-info">OFF</button><br>
                  <input type="range" value="50" min="0" max="100" class="a" id="bb" style="display:none"><br>
                  <br>
                  
                  <button id="autoready1"type="button" class="btn btn-info">ON</button>
                  <button id="autoready2"type="button" class="btn btn-info">OFF</button><br>
                  <input type="range" value="50" min="0" max="100" class="a" id="bb"><br>
                  <br>
                  
                  <!-- <button id="effectsoundON"type="button" class="btn btn-info">ON</button>
                  <button id="ebackmusiconffectsoundOFF"type="button" class="btn btn-info">OFF</button><br>
                  <input type="range" value="50" min="0" max="100" class="a" id="bb"><br> -->
                  <br>
               
                  
               </div>
               <div id="result5"></div>
               <div id="result6"></div>
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
						<label>제목</label> <label>비밀번호</label> <label>라운드 수</label> <label>게임
							시간</label> <label>게임 유형</label>
					</div>
					<div id="option">
						<input type="text" name="room_name"><br> 
						<input type="password" name="room_pass"><br> 
						<!-- <input type="text" name="room_round"> -->
						<select name="room_round" id="gRound">
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select><br>
						<select name="room_time" id="gStart">
							<option value="60">60초</option>
							<option value="80">80초</option>
							<option value="120">120초</option>
						</select><br>
						<select name="room_theme" id="gType">
							<option value="쿵쿵따">쿵쿵따</option>
							<option value="끝말잇기">끝말잇기</option>
						</select>
					</div>
				</div>
				<div class="modal-footer">
					<button id="createRoomBtn" type="button" class="btn btn-default"
						data-dismiss="modal">생성</button>
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
					<label>제목</label> <label>비밀번호</label> <label>인원 수</label> <label>게임
						시간</label> <label>게임 유형</label>
				</div>
				<div id="option">
					<input type="text" name="roomTitle"><br> <input
						type="password" name="roomPw"><br> <input type="text"
						name="number"><br> <select name="gameStart"
						id="gStart">
						<option value="60">60초</option>
						<option value="80">80초</option>
						<option value="120">120초</option>
					</select> <br> <select name="gameType" id="gType">
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

