selectCharacter = function(id){
	//아이템 구매
	var itemPoint = $('#itempoint').val();
	$.ajax({
		url : '/wcggame/SelectChar.do',
		data : {"id" : id},
		method: "post",  
		success : function(res){
			id = res.mem_id;
		/*	console.log("id>>"+id);
			
			console.log("Point>> "+itemPoint);
			
			console.log("res.char_point>>"+res.char_point);*/
			
			ch_nickName = res.char_nickname;
			
			itemPoint = parseInt(itemPoint) 
			if(itemPoint > res.char_point){
				console.log("res.char_point"+res.char_point);
				alert("포인트가 부족합니닷");		
			}else{
				alert("아이템구매");
				updateBuyPoint(id,item);
			}
		},
		error : function(xhr){
			alert("상태:" + xhr.status);
		},
		dataType : 'json'
	})
}

selectMyCharacter = function(id){
	//내 캐릭터 조회
	$.ajax({
		url : '/wcggame/SelectChar.do',
		data : {"id" : id},
		method : 'post',
		success : function(res){
			idx = res.mem_id;
			code = '<td><img id="imges" width="200px" height="200px"  src="'+res.base_img+'"></td>';
			
			$('#myChShow').append().html(code);
			/*console.log("id출력이 안되나,,,,제발..." + idx);
			console.log(res.link);*/
		},
		error : function(xhr){
			alert("상태:" + xhr.status);
		},
		dataType : 'json'
	})
	
}


//내 닉네임 조회
selectMyNickname = function(id){
	$.ajax({
		url : '/wcggame/SelectChar.do',
		data : {"id" : id},
		method : 'post',
		success : function(res){
			idx = res.mem_id;
			code = '<td>'+res.char_nickname+'</td>';
			
			$('#selectNickName').append().html(code);	//닉네임 자리에 찍자!
			/*console.log("닉네임 출력이 되려나....?" +  res.char_nickname)*/
		},
		error : function(xhr){
			alert("상태:" + xhr.status);
		},
		dataType : 'json'
	})
}

//내 소지 포인트 조회
selectMyPoint = function(id){
	$.ajax({
		url : '/wcggame/SelectChar.do',
		data :{"id" : id},
		method : 'post',
		success : function(res){
			idx = res.mem_id;
			code = '<td>'+res.char_point+'</td>'
				
				$('#MyPOINT').append().html(code);
			
		},
		error : function(xhr){
			alert("상태:" + xhr.status);
		},
		dataType : 'json'
	})
}


	selectItem = function(itemNo){
		//미리보기창에 아이템 하나 출력
		$.ajax({
			url : '/wcggame/OneShop.do',
			data : {"item_no" : itemNo },
			success : function(res){
				item = res.point;
			    item_no = res.no;
				/*alert("selectItem  "+item);*/
				code = '  <table class="table">';
				code += '    <tbody>';
				code += '      <tr class="success">';
				code += '        <td><img id="imges" src="'+res.link+'"></td>';
				code += '      </tr>';
				code += '    </tbody>';
				code += '  </table>';
						
				$('#contents').append().html(code);
				$('#itempoint').val(res.point);
			},
			error : function(xhr){
				alert("상태:" + xhr.status);
			},
			dataType : 'json'
		})
	}
	



updateBuyPoint = function(id,item){

	$.ajax({
		//구입실행시 포인트 차감
		url : '/wcggame/UpdateBuyPoint.do',
		data : {"id" : id, "num" : item },
		method : "post",
		success : function(res){
			alert(res.sw);
			if(res.sw == "성공"){
				buyItemINInventory();
		 	 }
		},
		error : function(xhr){
			alert("상태:" + xhr.status);
		},
		dataType : 'json'
	})
	
}

buyItemINInventory = function(){
	//구입성공시 db의 인벤토리에 아이템 no를 추가
		/*	console.log("ch_nickName"+ch_nickName)
			console.log("item_no"+item_no)*/
			
			
			$.ajax({
				url:'/wcggame/insertInventory.do',
				data :{"item_no" : item_no, "char_nickname":ch_nickName},
				method : 'post',
		  	success : function(res){
			
				alert("아이템 구입이 완료되었습니다.")
				},
			error : function(xhr){
				alert("상태 : " + xhr.status) // 200 400 500 
				},
			dataType : 'json'
				
			})

}
