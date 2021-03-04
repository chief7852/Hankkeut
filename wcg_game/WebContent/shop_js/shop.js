	
	readItem = function(){
		
		$.ajax({
//			data:'LIST',	//넘겨줄값?? ##이 없으면 안써도됨
			success:function(res){
				code = '<div class="row">';
				result = '';
				$.each(res, function(i, v){
					code += ' <div class="col-sm-4">';
			        code += '  <div class="well">';
			        code += '    <p><img id="imges" src="'+v.link+'"></p>';
			        code += '	 <p>'+v.point+'</p>';
			        code += '			<button type="button" id="showItem" class="btn btn-danger">show</button>'
			       	code += '			<input type="hidden" id="showItemNo" value="'+ v.no +'">'
			        code += '  </div>';
			        code += '</div>';
				})
						code += '</div>'
					
				
				$('#res').append().html(code)
//				$('#res').append().html(result)
			},
				
			error:function(xhr){
				alert("상태 :" + xhr.status);
			},
			dataType : 'json'
			
		})
	}
	
	

	
	selectItemShow = function(itemNo){
		
		$.ajax({
			url : '/wcggame/OneShop.do',
			data : {"item_no" : itemNo },
			success : function(res){
				console.log("----"+res.link);
				
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
	
	
	
	
	
	
	
