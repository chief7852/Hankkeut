/**
 * 
 */
readPage = function(cPage) {
	console.log("cPageJS : " + cPage);
	// 게시판 페이지 처리
	$.ajax({
		url: '/wcggame/board/boardList.ddit',
		type: 'post',
		data : {'cPage' : cPage},
		success : function(res) {
			alert(res);
			// 페이지 번호 출력하기
			/*pager = `<ul class="pul pagination pager">`;
			for(i=res.sPage; i<=res.ePage; i++) {
				if(cPage == i) {
					pager += `<li class="active"><a class="paging" href="#">${i}</a></li>`;
				} else {
					pager += `<li><a class="paging" href="#">${i}</a></li>`;
				}
			}*/
			
		},
		error : function(xhr) {
			alert("상태 : " + xhr.status);
		},
		dataType: 'html'
	});
}