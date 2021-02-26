	
	readItem = function(){
		
		$.ajax({
			url:'/wcggame/ListAllShop.do',
	//		data:'LIST',	//넘겨줄값?? ##이 없으면 안써도됨
			success:function(res){
					/*list이기 떄문에 for문을 써서 code로 받아옴*/ 
				code = '<div>';
				$.each(res, function(i, v){
					code +=' <p>' + 'no : '+ v.no + '</p>';
					code +=' <p>' + 'name : '+v.name +'</p>';
					code +=' <img id="imges" src="'+v.link+'"> '
					
					code +=' <p>' + 'point : '+v.point +'</p>';
					code += '<hr>'
				})
				code += '</div>';
				$('div').append().html(code)
				
			},
			error:function(xhr){
				alert("상태 :" + xhr.status);
			},
			dataType : 'json'
			
		})
	}
	