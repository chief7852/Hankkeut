listAllMusic = function(){
	
	$.ajax({
		url : '/wcggame/selectAllMusic.do',
		method : 'post',
		success : function(res){
			code = '<div>'
			$.each(res, function(i, v){
				code += '<h2>'+v.backmusic_no+'</h2>'
				code += '<h2>'+v.backmusicname+'</h2>'
				code += '<h2>'+v.room_num+'</h2>'
				code += '<h2>'+v.backmusicfile+'</h2>'
			})
			code += '</div>'
			$('#sampletest').append().html(code);
		},
		error:function(xhr){
			
		},
		dataType : 'json'
	})
	
}