<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Insert title here</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="../home_js/sign_up_js.js"></script>
<script src="../home_js/login.js"></script>
<script type="text/javascript">


</script>
<style type="text/css">
	#chatArea {
		display: none;	
		border:2px solid blue;
		padding: 5px;   width : 430px;
		margin: 0px auto;
	}
	 #connectArea {
		border:2px solid green;	padding: 5px; width : 430px;
		margin: 0px auto;
	}
		 
</style>
</head>
<body>
	<div id="">
		<div id="chatArea">
		    <!-- 메시지 표시 영역 -->
		    <textarea id="messageTextArea" readonly="readonly" rows="10" cols="63"></textarea><br><br>
		    <!-- 송신 메시지 텍스트박스 -->
		    <input type="text" id="messageText" size="40"> <!-- onkeydown="sendMessage()" -->
		    <!-- 송신 버튼 -->
		    <input type="button" value="Send" id="btnSend">
		    <input type="button" value="접속종료" id="btnClose">
		    
	    </div>
	    <div id="connectArea">
	    	<!-- 접속자 입력 텍스트박스 -->
		    사용자ID : <input type="text" id="userId" size="20"><br>
		    사용자pass:<input type="text" id="userPass" size="20">
		    <!-- 접속 버튼 -->
		    <input type="button" value="접속하기" id="btnConnect" disabled="disabled">
		    <button type="submit" value="로그인하기" id="btnConnect2" >로그인하기</button>
		    
	    </div>
	    <div id="characters">
         <%-- <img src="images/spongebob.png" style="width:100px; height:100px"><br>
         <label><%=userId%></label> --%>
      </div>
    </div>
    
    
    <script type="text/javascript">
    webSocket.onopen = function(message) {
       messageTextArea.value += "Server connect...\n";
    };
    </script>
    <script type="text/javascript">
    	var webSocket = null; // 웹소켓 변수 선언
        var messageTextArea = document.getElementById("messageTextArea");
    	var messageText = document.getElementById("messageText");
    	var userText = document.getElementById("userId");
    	var userpass = document.getElementById("userPass");
    	var vhtml = "<div class='character'>";
        vhtml += "<img src='아토1.jpg' style='width:100px; height:100px'><br>";
        /* vhtml += "<label>" + user +"</label>"; */
    	function connectting(){
    		if(userText.value.trim()==""){
    			alert("접속자 ID를 입력하세요");
    			userText.focus();
    			return;
    		}
    		
    		
	        //웹소켓 초기화
	        webSocket = new WebSocket("ws://localhost:8032/wcggame/websocktMultiChat");
	        
	    	// 접속 성공하면 
	        webSocket.onopen = function onOpen(event){
	        	$('#characters').html(vhtml);
	        	document.getElementById("connectArea").style.display = "none";
	    		document.getElementById("chatArea").style.display = "block";
	        	webSocket.send(userText.value);
	        	
	        }
	        
	        //메시지가 오면 messageTextArea요소에 메시지를 추가한다.
	        webSocket.onmessage = function processMessge(message){
	            //Json 풀기
	            var jsonData = JSON.parse(message.data);
	            if(jsonData.message != null) {
	                messageTextArea.value += jsonData.message + "\n"
	                messageTextArea.scrollTop = 9999999;
	            };
	        }
	        
	        webSocket.onerror = function showErrorMsg(event) {
	        	alert("오류 : " + event.data);
			};
			
			webSocket.onclose = function(event){
				messageTextArea.value = "";
				messageText.value = "";
				userText.value = "";
				nick.value="";
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