/**
 * 
 */
timer = function(){
	
	var count = 10;
	var time = 0;
	var choice = 0;
	
	time = setInterval("myTimer()",1000);
	
	function myTimer() {
		count = count - 1; // 타이머 선택 숫자에서 -1씩 감산함(갱신되기 때문)
		
		document.getElementById("countdown").innerHTML
			= "완료까지 <b>" + count +"</b>초 남았습니다.";
		if(count == 0) { 
			clearInterval(time);	// 시간 초기화
			alert("시간이 완료되었습니다.")
		}
	}
}