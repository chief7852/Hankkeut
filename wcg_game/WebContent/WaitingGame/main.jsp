<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<link href="https://fonts.googleapis.com/css2?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="../css/gameCSS.css">
	<script src="../shop_js/shop.js"></script>
	<script src="../character_js/character.js"></script>
	<style>
		#myChShow{
			background : white;
		}
		#point{
			background : white;
		}
	</style>	
</head>
<script>
check = "";
$(function(){
	//selectMyCharacter("issac");	//내 캐릭터 불러오기
	var userInfo = $('#id').val();
	console.log("user : "+userInfo)
	
	selectMyCharacter(userInfo);
	
		//게임 배경음악
   		$('#backmusicon').on('click',function(){
   			check = 'on';
   			 $('#aa').css('visibility',	'visible');
   			playbackmusic = new Audio('../multichat/backMusic.mp3');
   			playbackmusic.autoplay = true;
   			playbackmusic.loop = true;
   			 //$('#result5').html(playbackmusic);
   		})	
   		
   		$('#backmusoff').on('click',function(){
   			check = 'off';
   			 $('#aa').css('visibility',	'hidden');
   			playbackmusic.autoplay = false;
   			playbackmusic.pause();
   		})
   		//게임테마
   		$('#teameblack').on('click',function(){
   			var element = document.body;
   		   element.classList.toggle("dark-mode");
   		})
   		
   		//게임 효과음
   		$('#effectsoundON').on('click',function(){
   			$('#bb').css('visibility',	'visible');
   			playeffectsound = new Audio('../sound/effect.mp3');
   			playeffectsound.autoplay = true;
   			playbackmusic.loop = true;
   			$('#result6').html(playeffectsound);
   			
   			function play() { 
   			    var audio = document.getElementById('audio_play'); 
   			    if (audio.paused) { 
   			        audio.play(); 
   			    }else{ 
   			        audio.pause(); 
   			        audio.currentTime = 0 
   			    } 
   			} 
   			
   		})
   		
   		$('#effectsoundOFF').on('click',function(){
   			$('#bb').css('visibility',	'hidden');
   		})
   		
   		$('#shopmove').on('click',function(){
   			$('#result').load("../shop/main/jsp")
   		})

		
   	
   	
   	
})

</script>
<body>

<%
	String userId = (String) session.getAttribute("userid");
%>
<input id="id" type="hidden" name="<%=userId%>" value="<%=userId%>">

<div id="view">
  <jsp:include page="header.jsp"></jsp:include>
  <jsp:include page="WatitngView.jsp"></jsp:include>
  <jsp:include page="modalTemp.jsp"></jsp:include>
  <jsp:include page="content.jsp"></jsp:include>
</div>
  
  
  
  

<div id="result5"></div>
  
  
  
</body>
</html>		