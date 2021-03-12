/**
 * 
 */
test2 = function(){
	 // WebSocket 오브젝트 생성 (자동으로 접속 시작한다. - onopen 함수 호출)
	        webSocket = new WebSocket("ws://localhost:8084/wcggame/websocktMultiChat2");
	        
	    	// 접속 성공하면 
	        webSocket.onopen = function onOpen(event){
	        	$('#characters').html(vhtml);
	        	document.getElementById("connectArea").style.display = "none";
	    		document.getElementById("chatArea").style.display = "block";
	        	webSocket.send(nick);
	        	
	        }
	        
	        //메시지가 오면 messageTextArea요소에 메시지를 추가한다.
	        webSocket.onmessage = function processMessge(message){
	        	console.log(message);
	            //Json 풀기
	            var jsonData = JSON.parse(message.data);
	             var jsonData2 = JSON.parse(message.data);  
	             var jsonTimer = JSON.parse(message.data);
	             
	             if(jsonTimer.timer != -1){
	            	 $('#roundTime').html(jsonTimer.timer)
	             }
	            // json "img"풀기
	            console.log(jsonData);
	            console.log(jsonData2);
	              if(jsonData2.img != null){
	            	console.log(jsonData2);
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
        
  }    

		

test = function(roomnum, myid, nick){
	
    	var webSocket = null; // 웹소켓 변수 선언
        var messageTextArea = document.getElementById("messageTextArea");
    	var messageText = document.getElementById("messageText");
		
    	
    	(function connectting(){
    		
	        //웹소켓 초기화
	        // WebSocket 오브젝트 생성 (자동으로 접속 시작한다. - onopen 함수 호출)
	        webSocket = new WebSocket("ws://192.168.0.105:8084/wcggame/websocktMultiChat");
	        
	    	// 접속 성공하면 
	        webSocket.onopen = function onOpen(event){
	        	/* document.getElementById("connectArea").style.display = "none";
	    		document.getElementById("chatArea").style.display = "block"; */
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
	            	
	            	if(jsonData.timer != null){
	            	 $('#roundTime').html(jsonTimer.timer)
	             }
	            	switch(jsonData.type)
		            {
		            case "id" : 
		            	break;
		            case "imgg":$('.characters').append(image);
		            	break;
		            case "message":
		            	if(jsonData.message=="System : 게임시작하겠습니다"){
			            	$.ajax({
			    				url: "/wcggame/startRoom.do",
			    				method: "post",
			    				success : function(res){
			    					$('#mainView').html(res);
			    				},
			    				error: function(xhr) {
			    					alert("서버 상태 : " + xhr.status);
			    				},
			    				dataType: 'html'
			    			});
			            }
		            	break;
		            case "remove":
		            	$("#"+jsonData.remove+"").remove();	
		            	break;
		            case "ready":if(jsonData.ready=='(ready취소)'){
		            				$('.'+jsonData.username).empty();
		            			}else{	            		
		            				$('.'+jsonData.username).text('ready');
		           				 }
		            	break;
		            case "username":
		            	break;
		            case "timer" : 
		            	 console.log(jsonTimer.timer);
		            }
	            //이미지 들고오기
	           var image = "";
	            image += "<div class='thumbnail' id="+jsonData2.id+" display:inline-block><img src="+jsonData2.imgg+">"+jsonData2.id+
	            			"<div style='color:#red' class="+jsonData2.id+"></div></div>"; 
	            if(jsonData2.imgg!=null){
	            $('.characters').append(image);	            	
	            }
	           //나갔을때 이미지 삭제
	            if(jsonData.ready!=null){
		            if(jsonData.ready=='(ready취소)'){
		            	$('.'+jsonData.username).empty();
		            }else{	            		
		            	$('.'+jsonData.username).text('ready')
		            }
		            }
	            	console.log(jsonData.username);
	            if(jsonData.message=="System : 게임시작하겠습니다"){
	            	$.ajax({
	    				url: "/wcggame/startRoom.do",
	    				method: "post",
	    				success : function(res){
	    					$('#mainView').html(res);
	    				},
	    				error: function(xhr) {
	    					alert("서버 상태 : " + xhr.status);
	    				},
	    				dataType: 'html'
	    			});
	            }
	            /*if(jsonData.message.slice(0, 15)=="System : remove"){
	            	console.log(jsonData.message.substring(15)) 
					$("#"+jsonData.message.substring(15)+"").remove();	            	
	            }*/
	            if(jsonData.message != null) {
	                messageTextArea.value += jsonData.message + "\n"
	                messageTextArea.scrollTop = 9999999;
	            }
	        }
	        
	        webSocket.onerror = function showErrorMsg(event) {
	        	alert("오류 : " + event.data);
			}
			
			webSocket.onclose = function(event){
				messageTextArea.value = "";
				
				userText.value = "";
				nick="";

			}
    	}())
    
        
        //메시지 보내기
        function sendMessage(){
        	if(messageText.value.trim()==""){
        		messageText.focus();
    			return;
    		}
            webSocket.send(messageText.value);
            messageText.value = "";
        }
        $(function(){
        	$('#btnClose').on('click', function(){
        		$('.characters').empty();
            	webSocket.close();
            	location.href="../WaitingGame/main.jsp";
        	})
        })
        function closing(){
        	$('.characters').empty();
        	webSocket.close();
        }
        
				// 이벤트 설정
        function addEvent(){           
            
						document.getElementById("btnSend").addEventListener("click", sendMessage, false);
						document.getElementById("btnClose").addEventListener("click", closing, false);
        }
        window.addEventListener("load", addEvent, false);

        window.onbeforeunload = function(){
        	closing();
        }
  	$(function(){
			$('.ready').on('click', function(){
				webSocket.send('/ready');
			})
		})	
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
}
