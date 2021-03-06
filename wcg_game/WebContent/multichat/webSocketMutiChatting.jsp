<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="../home_js/sign_up_js.js"></script>
<script src="../home_js/login.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css2?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://static-hid.gslb.toastoven.net/css/members/hangame_join.css?v=494f495ee8f6ef563e71d9dc5af9b6811707b319">
<link rel="stylesheet" href="../css/h_signCSS.css">
<link rel="stylesheet" href="../css/chet.css">

<script type="text/javascript">


</script>
<style type="text/css">
#chatArea {
	display: none;
	height: 60%;
	width: 70%;
}

#connectArea {
	border: 2px solid green;
	padding: 5px;
	width: 430px;
	margin: 0px auto;
}

#messageTextArea {
	left: 50%;
	margin: 100px;
	
	 
}
.thumbnail{
	width: 20%;
	display: inline-block;
	text-align: center;
	margin: 10px;
	
}
.divgroup{
	margin : 30px;
}
#messageText{
	left: 50%;
	margin: 100px;
	
}

</style>
</head>
<body>
	<div class="divgroup">

		<div id="chatArea" >
			<input type="button" value="접속종료" id="btnClose">
		<div id="characters" ></div>
			<!-- 메시지 표시 영역 -->
			<textarea id="messageTextArea" class="form-control"
				readonly="readonly" rows="10" cols="63"></textarea>
			<br>
			<br>
			<!-- 송신 메시지 텍스트박스 -->
			<input type="text" id="messageText" size="40">
			<!-- onkeydown="sendMessage()" -->
			
			<!-- 송신 버튼 -->
			<input type="button" value="Send" id="btnSend">
			
			
			<input type="button" class="slideUpBtn" id="ready" value="ready">

		</div>
		<div id="connectArea" >
			<!-- 접속자 입력 텍스트박스 -->
			사용자ID : <input type="text" id="userId" size="20"><br>
			사용자pass:<input type="text" id="userPass" size="20">
			<!-- 접속 버튼 -->
			<input type="button" value="접속하기" id="btnConnect">
			<button type="submit" value="로그인하기" id="btnConnect2">로그인하기</button>

		</div>
			

	</div>


	<script type="text/javascript">
    webSocket.onopen = function(message) {
       messageTextArea.value += "Server connect...\n";
    };
    doc
    </script>
	<script type="text/javascript">
  		$(function(){
  			ready = 0;
  			$('#ready').on('click', function(){
  				if(ready = 0){
  					ready++;
  				$('#characters').append("<div class='tracking-in-contract-bck'>READY</div>");
  				}else{
  					ready--;
  					$('tracking-in-contract-bck').remove();
  				}
  				
  			})
  		})
    </script>
	<script type="text/javascript">
    	var webSocket = null; // 웹소켓 변수 선언
        var messageTextArea = document.getElementById("messageTextArea");
    	var messageText = document.getElementById("messageText");
    	var userText = document.getElementById("userId");
    	var userpass = document.getElementById("userPass");
    	
    	function connectting(){
    		if(userText.value.trim()==""){
    			alert("접속자 ID를 입력하세요");
    			userText.focus();
    			return;
    		}
    		
    		
	        //웹소켓 초기화
	        // WebSocket 오브젝트 생성 (자동으로 접속 시작한다. - onopen 함수 호출)
	        webSocket = new WebSocket("ws://localhost:8084/wcggame/websocktMultiChat");
	        
	    	// 접속 성공하면 
	        webSocket.onopen = function onOpen(event){
	        	document.getElementById("connectArea").style.display = "none";
	    		document.getElementById("chatArea").style.display = "block";
	        	webSocket.send(nick);
	        	
	        }
	        
	        //메시지가 오면 messageTextArea요소에 메시지를 추가한다.
	        webSocket.onmessage = function processMessge(message){
	            //Json 풀기
	            var jsonData = JSON.parse(message.data);
	             var jsonData2 = JSON.parse(message.data);
	            
	            // json "img"풀기
	            	console.log(jsonData2.imgg);
	            	console.log(jsonData2.id);
	            //이미지 들고오기
	           var image = "";
	            image += "<div class='thumbnail' id="+jsonData2.id+" display:inline-block><img src="+jsonData2.imgg+">"+jsonData2.id+"</div>"; 
	            if(jsonData2.imgg!=null){
	            $('#characters').append(image);	            	
	            }
	           //나갔을때 이미지 삭제
	            
	            if(jsonData.message.slice(0, 15)=="System : remove"){
	            	console.log(jsonData.message.substring(15)) 
					$("#"+jsonData.message.substring(15)+"").remove();	            	
	            }
	            if(jsonData.message != null) {
	                messageTextArea.value += jsonData.message + "\n"
	                messageTextArea.scrollTop = 9999999;
	            };
	        }
	        
	        webSocket.onerror = function showErrorMsg(event) {
	        	alert("오류 : " + event.data);
			}
			
			webSocket.onclose = function(event){
				messageTextArea.value = "";
				messageText.value = "";
				userText.value = "";
				nick="";
				document.getElementById("connectArea").style.display = "block";
	    		document.getElementById("chatArea").style.display = "none";
			}
    	}
    
        
        //메시지 보내기
        function sendMessage(){
        	if(messageText.value.trim()==""){
        		messageText.focus();
    			return;
    		}
            webSocket.send(messageText.value);
            messageText.value = "";
        }
        
        function closing(){
        	$('#characters').empty();
        	webSocket.close();
        }
        
				// 이벤트 설정
        function addEvent(){           
            document.getElementById("btnConnect").addEventListener("click",connectting, false);
						document.getElementById("btnSend").addEventListener("click", sendMessage, false);
						document.getElementById("btnClose").addEventListener("click", closing, false);
        }
        window.addEventListener("load", addEvent, false);

        window.onbeforeunload = function(){
        	closing();
        }
    </script>
	<script src="../home_js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript">
$(function() {
				var messageText = document.getElementById("messageText");
			$('#messageText').keydown(function(key) {
				if (key.keyCode == 13) {
					webSocket.send(messageText.value);
					messageText.value = "";
				}
			});
			$('#btn-submit').click(function() {
				webSocket.send(messageText.value);
				messageText.value = "";
			});

		})
	</script>
</body>
</html>