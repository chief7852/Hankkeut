/**
 * 
 */

		

test = function(roomnum, myid, nick){
	
  	var webSocket = null; // 웹소켓 변수 선언
        var messageTextArea = document.getElementById("messageTextArea");
    	var messageText = document.getElementById("messageText");
		
    	
    	(function connectting(){
    		
    		
	        //웹소켓 초기화
	        // WebSocket 오브젝트 생성 (자동으로 접속 시작한다. - onopen 함수 호출)
	        webSocket = new WebSocket("ws://192.168.0.97:8084/wcggame/websocktMultiChat");
	        
	    	// 접속 성공하면 
	        webSocket.onopen = function onOpen(event){
	        	/* document.getElementById("connectArea").style.display = "none";
	    		document.getElementById("chatArea").style.display = "block"; */
	        	webSocket.send(nick);
	        }
	        
			$('.ready').on('click', function(){
				webSocket.send('/ready');
			})
	        //메시지가 오면 messageTextArea요소에 메시지를 추가한다.
	        webSocket.onmessage = function processMessge(message){
	            //Json 풀기
	            var jsonData = JSON.parse(message.data);
	             var jsonData2 = JSON.parse(message.data);
	            
	            // json "img"풀기
	            	console.log(''+jsonData2.imgg);
	            	console.log(''+jsonData2.id);
	            	
	            //이미지 들고오기
	           var image = "";
	            image += "<div class='thumbnail "+jsonData2.id+"'  display:inline-block><img src="+jsonData2.imgg+">"+jsonData2.id+"<div id="+jsonData2.id+"></div></div>"; 
	            console.log(""+jsonData2.id+"2")
	            if(jsonData2.imgg!=null){
	            $('.characters').append(image);	            	
	            }
	            
				if(jsonData.ready!=null){
	            if(jsonData.ready=='(ready취소)'){
	            	$('#'+jsonData.username).empty();
	            }else{	            		
	            	$('#'+jsonData.username).text('ready')
	            }
	            }
	            
	           //나갔을때 이미지 삭제
				if(jsonData.remove!=null){
					console.log(jsonData.remove.substring(0, 6))
	             if(jsonData.remove.substring(0, 6)=="remove"){
	            	console.log(jsonData.remove.substring(7)) 
					$('.'+jsonData.remove.substring(7)).remove();	            	
	             
				}
				}
	            if(jsonData.message != null) {
	                messageTextArea.value += jsonData.message + "\n"
	                messageTextArea.scrollTop = 9999999;
	            }
	            //임시(게임시작)================================================
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
	        }
	        
	        webSocket.onerror = function showErrorMsg(event) {
	        	alert("오류 : " + event.data);
			}
			
			webSocket.onclose = function(event){
				messageTextArea.value = "";
				messageText.value = "";
				/* userText.value = ""; */
				nick="";
				//document.getElementById("connectArea").style.display = "block";
	    		//document.getElementById("chatArea").style.display = "none";
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
            	
            	location.href="../WaitingGame/main.jsp";
        	})
        })
        function closing(){
        	$('.characters').empty();
			webSocket.send(nick);
        	
        }
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

				// 이벤트 설정
        function addEvent(){           
            
						document.getElementById("btnSend").addEventListener("click", sendMessage, false);
						document.getElementById("btnClose").addEventListener("click", closing, false);
        }
        window.addEventListener("load", addEvent, false);

        window.onbeforeunload = function(){
        	closing();
        }
}
chk = $(function(){
  			
  			
  			ready = 0;
  			$('#ready').on('click', function(){
  				if(ready = 0){
  					ready++;
  				$('.characters').append("<div class='tracking-in-contract-bck'>READY</div>");
  				}else{
  					ready--;
  					$('tracking-in-contract-bck').remove();
  				}
  				
  			})
  		})