	
	readItem = function(){
		
		$.ajax({
			url:'/wcggame/ListAllShop.do',
//			data:'LIST',	//넘겨줄값?? ##이 없으면 안써도됨
			success:function(res){
				code = '<div class="container">';
				code += ' <h2>SHOP</h2>';
				result = '';
				$.each(res, function(i, v){
//					result = v.link;
					code += '  <table class="table">';
					code += '    </thead>';
					code += '    <tbody>';
					code += '      <tr>';
					code += '        <td></td>';
					code += '        <td></td>';
					code += '        <td></td>';
					code += '      </tr>';
					code += '      <tr class="success">';
					code += '        <td><img id="imges" src="'+v.link+'"></td>';
					code += '			<button type="button" id="showItem" class="btn btn-danger">show</button>'
					code += '      </tr>';
					code += '      <tr class="danger">';
					code += '        <td>'+v.category+'</td>';
					code += '      </tr>';
					code += '      <tr class="info">';
					code += '        <td>'+v.name+'</td>';
					code += '      </tr>';
					code += '      <tr class="warning">';
					code += '        <td> '+v.point+'</td>';
					code += '      </tr>';
					code += '      <tr class="active">';
					code += '      </tr>';
					code += '    </tbody>';
					code += '  </table>';
				})
						code += '</div>';
					
				
				$('#res').append().html(code)
//				$('#res').append().html(result)
			},
				
			error:function(xhr){
				alert("상태 :" + xhr.status);
			},
			dataType : 'json'
			
		})
	}
	
	

	selectItem = function(){
		
		$.ajax({
			url : '/wcggame/ListAllShop.do',
			success : function(res){
				result = "";
				$.each(res, function(i,v){
					result = '<td><img id="imges" src="'+v.link+'"></td>';
				})
				
				$('#contents').append().html(result);
				
			},
			error : function(xhr){
				alert("상태:" + xhr.status);
			},
			dataType : 'json'
			
		})
		
		
	}
	
	
	
	
	
	
	
