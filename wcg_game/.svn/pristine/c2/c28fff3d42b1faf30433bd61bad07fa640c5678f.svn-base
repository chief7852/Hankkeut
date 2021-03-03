selectCharacter = function(id){
	//아이템 구매
	var itemPoint = $('#itempoint').val();
	$.ajax({
		url : '/wcggame/SelectChar.do',
		data : {"id" : id},
		method: "post",  
		success : function(res){
			id = res.mem_id;
			
			ch_nickName = res.char_nickname;
			
			itemPoint = parseInt(itemPoint) 
			
			
			if(itemPoint > res.char_point){
				console.log("res.char_point"+res.char_point);
				alert("포인트가 부족합니다");		
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

selectId = function(id){
	//id값 받아오는..
	var itemPoint = $('#itempoint').val();
	$.ajax({
		url : '/wcggame/SelectChar.do',
		data : {"id" : id},
		method: "post",  
		success : function(res){
			id = res.mem_id;
			char_nickname = res.char_nickname;	// 전역변수에 저장
			console.log(">>" + char_nickname);
		
			
		    selectMyCharacter(id);
			selectMyNickname(id);
			selectMyPoint(id);
			BuyItemINInvettorySelectAll(char_nickname);
		},
		error : function(xhr){
			alert("상태:" + xhr.status);
		},
		dataType : 'json'
	})
}


selectCharacter = function(id){
	//아이템 구매
	var itemPoint = $('#itempoint').val();
	$.ajax({
		url : '/wcggame/SelectChar.do',
		data : {"id" : id},
		method: "post",  
		success : function(res){
			id = res.mem_id;
			
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
		//-------------------보내는값
		
		
		//----성공시받는값
		success : function(res){
			//console.log(">> ");
			idx = res.mem_id;
			code = '<td><img id="imges" width="200px" height="200px"  src="'+res.base_img+'"></td>';
			
			$('#myChShow').append().html(code);
			console.log("id출력이 안되나,,,,제발..." + id);
			console.log(res.link);
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
			console.log("selectMyNickname");
			
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
			console.log("selectMyPoint");
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

BuyItemINInvettorySelectAll = function(char_nickname){	//캐릭터닉네임을 기준으로 소지 item_no를 출력
	$.ajax({
		url:'/wcggame/ListAllInventory.do',
		data:{"char_nickname":char_nickname},	//1.char_nickname이 이름으로 2.char_nickname이값을 보내는데 2.값은 html혹은 jsp에 변수로 있엉 ㅑ한다., 
		method : 'post',
		//주는값-------------------------------
		
		//--------------------------
		success:function(res){
			
			showLinkedItemListAll(char_nickname);
		},
		
		
		error:function(xhr){
			alert("상태:" + xhr.status);
		},
		dataType : 'json'
	})
	
}

showLinkedItemListAll = function(char_nickname){
	
	$.ajax({
		url : '/wcggame/selectLink.do',
		data : {"char_nickname" : char_nickname},
		method : 'post',
		//주는값 --------------------------------------
		
		//받는값-----------------------------------
		success : function(res){
			code = '<div class="row">';
			$.each(res, function(i,v){
				code += '   <div class="col-sm-3">';
				code += '     <div class="well">';
				code += '       <h4>아이템'+i+'</h4>';
				code += '       <p id="show1" class="showclass"><td><img id="imges" src="'+v.item_link+'"></td></p>';
				code += '       <button type="button" class="btn btn-info">착용</button>';
				code += '     </div>';
				code += '   </div>';
			
			})
			code += '</div>'
				
			$('#showItem').append().html(code);
		},
		error : function(xhr){
			alert("상태:" + xhr.status);
		},
		dataType : 'json'
	})
}


//착용 버튼 눌렀을떄 이미지 입혀지도록 할 계획임
UpdateItemLinkIMG = function(id){
	
	//console.log("-123--"+id)
	
	$.ajax({
		
		url : '/wcggame/UpdateIMGLink.do',
		data : {"mem_id" : id},
		method : 'post',
	//servlet에 주는 값---------------------------
		
	//받는값---------------------------
		success : function(res){
			alert(res.sw)
			if(res.sw == "성공"){
			selectId(id);	
			}
			
		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : 'json'
		
	})
}






















