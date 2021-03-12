<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
	
	<!-- 
	form의 name의 목적 : 자바스크립트에서 접근이 용이하게 하기 위해서 사용
	-->
	
	<form action="" name="frm">
	<div align="center">
	<strong>Ramen Timer</strong><br><br>
	
	<select id="selid" name="myChoice">
		<option value="180">원하는 시간을 선택해주십시오(기본:3분)</option>
		<option value="300">5분</option>
		<option value="180">3분</option>
		<option value="150">2분 30초</option>
		<option value="120">2분</option>
		<option value="60">1분</option>
		<option value="30">30초</option>
	</select>
	
	<input type="button" value="GO!" onclick="noodle()">
	<br><br>
	
	<span id="countdown">time selected</span>
	<br><br>
	
	<input type="button" value="Close" onclick='window.close()'>
	
	</div>
	
	</form>
	<script type="text/javascript">
	var count = 0;
	var time = 0;
	var choice = 0;
	
	function noodle() {
		
		clearInterval(time);	// 타이머 우선 초기화 시켜주기(time initialize)
	/* 
	 
	 	ID로 가져오기
		// select의 value를 가져오기 : value
		var val = document.getElementById("selid").value;
		alert(val);	// 확인용
		// select의 index값을 가져오기 : selectedIndex
		var indexNum = document.getElementById("selid").selectedIndex;
		alert(indexNum);	// 확인용
	 */
	 
	 
	// 	name으로 index 찾기
	 	choice = document.frm.myChoice.selectedIndex;
	//	alert(choice);
	 
	 	// 찾은 index로 value찾기
	 	count = parseInt(document.frm.myChoice.options[choice].value);
//		alert(count); 
		
		// 타이머 함수 1초씩 호출하는 함수 만들기
		time = setInterval("myTimer()",1000);
		
	}
	function myTimer() {
		count = count - 1; // 타이머 선택 숫자에서 -1씩 감산함(갱신되기 때문)
		
		document.getElementById("countdown").innerHTML
			= "완료까지 <b>" + count +"</b>초 남았습니다.";
		if(count == 0) { 
			clearInterval(time);	// 시간 초기화
			alert("시간이 완료되었습니다.")
		}
	}
	
	//우클릭 사용금지
	document.oncontextmenu = function() {
		alert("마우스의 우클릭은 사용할 수 없습니다.")
		return false;
	}
	</script>
	
	</body>
	</html>