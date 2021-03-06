waitingRoomList = function() {
	$.ajax({
		url: "/wcggame/waitingGame.do",
		method: "post", 
		success : function(res){
			code = '';
			$.each(res, function(i,v) {
				code += `
						<div class="col-sm-3 roomDiv" onclick="isPwCheck(${v.room_no})" id="${v.room_no}">
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

isPwCheck = function(room_vo) {
	console.log("room_vo : " + room_vo);
	$.ajax({
		url: "/wcggame/pwCheck.do",
		method: "post",
		data: {"room_vo": room_vo},
		success : function(res){
			//alert("pw : " + res.room_pass);
			var pw = res.room_pass.trim();
			console.log("pw : " + pw);
			
//			if(pw != null) {
//				console.log("true");
//			} else {
//				console.log("fasle");
//			}
			if(pw == "null") {
				//console.log("true");
				entrance(room_vo);
			} else {
				//console.log("false");
				inputPw(res.room_pass, room_vo);
			}
		},
		error: function(xhr) {
			alert("서버 상태 : " + xhr.status);
		},
		dataType: 'json'
	});
}

inputPw = function(pass, room_vo) {
	pw = parseInt(prompt("비밀번호 입력"));
	
	if(pass == pw) {
		entrance(room_vo)
	}
}
entrance = function(room_vo) {
	//location.href= "/wcggame/game/waitingGameInfo.ddit?room_vo="+room_vo+"&check=" + check;
	$.ajax({
		url: "/wcggame/waitingGameInfo.do",
		method: "post",
		data: {"room_vo": room_vo},
		success : function(res){
			$('#view').html(res);
		},
		error: function(xhr) {
			//alert("서버 상태 : " + xhr.status);
		},
		dataType: 'html'
	});
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