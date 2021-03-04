waitingRoomList = function() {
	$.ajax({
		url: "/wcggame/waitingGame.do",
		method: "post", 
		success : function(res){
			code = '';
			$.each(res, function(i,v) {
				code += `
						<div class="col-sm-3 roomDiv" onclick="entrance(${v.room_no})" id="${v.room_no}">
						  <div class="well">
						  	<input type="hidden" value="${v.room_no}">
					        <h4>${v.room_no}</h4>
					        <p>${v.room_name}</p> 
					        <p>인원수</p>
					      </div>
						</div>
						`;
			});	
			$('#roomList').html(code);
		},
		error: function(xhr) {
			alert("서버 상태 : " + xhr.status);
		},
		dataType: 'json'
	});

}

createRoom = function(url) {
	$.ajax({
		//url: "/wcggame/insertRoom.do",
		url: url,
		method: "post", 
		success : function(res){
		},
		error: function(xhr) {
			alert("서버 상태 : " + xhr.status);
		},
		dataType: 'json'
	});
}

entrance = function(room_vo) {
	location.href= "/wcggame/game/waitingGameInfo.ddit?room_vo="+room_vo;
}

wattingFriend = function() {
	$.ajax({
		url: "/wcggame/waitFriend.do",
		method: "post",
		success : function(res){
			code = "";
			$.each(res, function(i, v) {
				code += `
							<tr>
								<td>${v.mem_id}</td>
								<td colspan="2">
									<button type="button" onclick="acceptFriend('${v.mem_id}')">수락</button>
									<button type="button">거절</button>
								</td>
							</tr>
						`;
			});
			$('#wtbody').html(code);
		},
		error: function(xhr) {
			//alert("서버 상태 : " + xhr.status);
		},
		dataType: 'json'
	});
}

// 친구 수락 눌렀을 경우
acceptFriend = function(mem_id) {
	//alert("aceptFriend");
	location.href= "/wcggame/friend/acceptFriend.ddit?mem_id="+mem_id;
}

friendList = function() {
	$.ajax({
		url: "/wcggame/friendList.do",
		method: "post",
		success : function(res){
			code = "";
			$.each(res, function(i, v) {
				code += `
							<tr>
								<td>${v.friend_id}</td>
								<td colspan="2">
									<button type="button">귓속말</button>
									<button type="button" onclick="deleteFriend('${v.friend_id}')">삭제</button>
								</td>
							</tr>
						`;
			});
			$('#friendList').html(code);
		},
		error: function(xhr) {
			//alert("서버 상태 : " + xhr.status);
		},
		dataType: 'json'
	});
}

deleteFriend = function(friend_id) {
	
}