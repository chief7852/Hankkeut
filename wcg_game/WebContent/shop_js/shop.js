	
	readItem = function(){
		
		$.ajax({
			url:'/wcggame/ListAllShop.do',
	//		data:'LIST',	//넘겨줄값?? ##이 없으면 안써도됨
			success:function(res){
					/*list이기 떄문에 for문을 써서 code로 받아옴*/ 
				code = '<div>';
				$.each(res, function(i, v){
					code += v.no;
					code += v.link;
					code += v.name;
					code += v.point;
				})
				code += '</div>';
				$('#test').append().html(code)
			},
			error:function(xhr){
				alert("상태 :" + xhr.status);
			},
			dataType : 'json'
			
		})
	}
	
	
	
