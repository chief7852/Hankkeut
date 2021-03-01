BuyItemINInvettorySelectAll = function(){
	
	$.ajax({
		url:'wcggame/ListAllInventory.do',
		data:{"char_nickname":char_nickname},
		success:function(res){
				
			SMC(id);
			code = '<div class="row">';
			
			$.each(res, function(i,v){
				code += '   <div class="col-sm-3">';
				code += '     <div class="well">';
				code += '       <h4>아이템1</h4>';
				code += '       <p id="show1" class="showclass">'+v.getItem_no+'</p>';
				code += '       <button type="button" class="btn btn-info">착용</button>';
				code += '     </div>';
				code += '   </div>';
			})
			code += '</div>'
				
			('#showItem').append().html(code);
		},
		error:function(xhr){
			alert("상태:" + xhr.status);
		},
		dataType : 'json'
	})
	
	
}

SMC = function(id){	//selectMyCharacter
	//내 캐릭터 조회
	$.ajax({
		url : '/wcggame/SelectChar.do',
		data : {"id" : id},
		method : 'post',
		success : function(res){
			idcc = res.mem_id;
			alert("캐릭터 조회 성공")
		},
		error : function(xhr){
			alert("상태:" + xhr.status);
		},
		dataType : 'json'
	})
	
}