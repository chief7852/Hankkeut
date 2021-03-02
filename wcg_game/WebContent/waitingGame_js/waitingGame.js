waitingRoomList = function() {
	$.ajax({
		url: "/wcggame/waitingGame.do",
		method: "post", 
		success : function(res){
			code = '';
			$.each(res, function(i,v) {
				code += `
						<div class="col-sm-3">
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

createRoom = function() {
	$.ajax({
		//url: "/wcggame/insertRoom.do",
		url:"/wcggame/room/waitingRoom.ddit",
		method: "post", 
		success : function(res){
			waitingRoomList();
		},
		error: function(xhr) {
			alert("서버 상태 : " + xhr.status);
		},
		dataType: 'json'
	});
}