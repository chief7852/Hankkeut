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
			alert("hostIp ==> " + res.hostIp);
			waitingRoomList();
			createRoomInfo(res.hostIp);
		},
		error: function(xhr) {
			alert("서버 상태 : " + xhr.status);
		},
		dataType: 'json'
	});
}

createRoomInfo = function(hostIp) {
	console.log("waitingGame.js hostIp : " + hostIp);
//	$.ajax({
//		//url: "/wcggame/insertRoom.do",
//		url: url,
//		method: "post", 
//		success : function(res){
//			waitingRoomList();
//		},
//		error: function(xhr) {
//			alert("서버 상태 : " + xhr.status);
//		},
//		dataType: 'html'
//	});
}

entrance = function(room_vo) {
	alert(room_vo + "입니다.");
	$.ajax({
		url: "/wcggame/game/enterRoom.ddit",
		method: "post", 
		data: {"room_vo" : room_vo},
		success : function(res){
			waitingRoomList();
		},
		error: function(xhr) {
			alert("서버 상태 : " + xhr.status);
		},
		dataType: 'json'
	});
}