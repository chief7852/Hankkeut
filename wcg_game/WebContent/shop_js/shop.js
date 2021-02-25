	
	readItem = function(){
		
		$.ajax({
			url:'/wcggame/ListAllShop.do',
	//		data:'LIST',	//넘겨줄값?? ##이 없으면 안써도됨
			success:function(res){
				
				
				code = '<div class="container">';
				code += ' <h2>SHOP</h2>                                         ';
				$.each(res, function(i, v){
					code += '  <table class="table">                                              ';
					code += '    </thead>                                                         ';
					code += '    <tbody>                                                          ';
					code += '      <tr>                                                           ';
					code += '        <td></td>                                             ';
					code += '        <td></td>                                    ';
					code += '        <td></td>                                    ';
					code += '      </tr>                                                          ';
					code += '      <tr class="success">                                           ';
					code += '        <td><img id="imges" src="'+v.link+'"></td>                                             ';
					code += '      </tr>                                                          ';
					code += '      <tr class="danger">                                            ';
					code += '        <td>'+v.category+'</td>                                              ';
					code += '      </tr>                                                          ';
					code += '      <tr class="info">                                              ';
					code += '        <td>'+v.name+'</td>                                                ';
					code += '      </tr>                                                          ';
					code += '      <tr class="warning">                                           ';
					code += '        <td> '+v.point+'</td>                                             ';
					code += '      </tr>                                                          ';
					code += '      <tr class="active">                                            ';
					code += '        <td><button type="button"></td>                                              ';
					code += '      </tr>                                                          ';
					code += '    </tbody>                                                         ';
					code += '  </table>                                                           ';
				})
						code += '</div>';
					
				
				$('#res').append().html(code)
			},
				
			error:function(xhr){
				alert("상태 :" + xhr.status);
			},
			dataType : 'json'
			
		})
	}
	
	
	
