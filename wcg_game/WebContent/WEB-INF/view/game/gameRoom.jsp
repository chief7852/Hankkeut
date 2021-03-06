<%@page import="vo.CharVO"%>
<%@page import="character_2.service.copy.CharacterServiceImpl"%>
<%@page import="character_2.service.copy.ICharacterService"%>
<%@page import="vo.RoomVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script>
	function gameStart() {
		location.href="<%=request.getContextPath()%>/game/gameStart.ddit";
	};
</script>
<title>게임 방</title>
<style>
	nav {
		border-bottom: 1px solid grey;
		height: 100px;
		text-align: center;
		box-sizing: border-box;
	}
	#header div {
		display: inline-block;
		border: 1px solid red;
		text-align: center;
		box-sizing: border-box;
	}
	#roomNo {
		width: 250px;
	}
	#title {
		width: 690px;
	}
	#theme {
		width: 250px;
	}
	#getAllow {
		width: 250px;
	}
	#content {
		box-sizing: border-box;
		border-bottom: 1px solid grey;
		height: 450px;
		display: grid;
		grid-template-columns : auto auto auto auto;
	}
	#content .user {
		box-sizing: border-box;
		border: 1px solid lightgrey;
	}
	#readyBtn {
		box-sizing: border-box;
		text-align: center;
	
		margin : auto;
	}
	#chatting {
		box-sizing: border-box;
		height: 185px;
	}
	#btnClose{
		width: 100%;
		height: 100%;
	}
	.thumbnail{
		text-align: center;
	}
	#btnSend{
	display: none;
	}
</style>
</head>
<body>
<%
	System.out.println("gameRoom.jsp hostRoomInfo??");
	RoomVO roomVo = (RoomVO) request.getAttribute("hostRoomInfo");
	System.out.println("gameRoom.jsp hostRoomInfo : " + roomVo.getRoom_no());
	HttpSession sessions = request.getSession();
	String userId = (String) sessions.getAttribute("userid");
	ICharacterService service = CharacterServiceImpl.getService();
	CharVO vo = service.selectChar(userId);
	String nick = vo.getChar_nickname();
%>
<nav id="header">
	<div id="roomNo">
		<h1><%=roomVo.getRoom_no()%></h1>
	</div>
	<div id="title">
		<h1><%=roomVo.getRoom_name()%></h1>
	</div>
	<div id="theme">
		<h1><%=roomVo.getRoom_theme()%></h1>
	</div>
	<div id="getAllow">
		<h1><%=roomVo.getAllow_no()%></h1>
	</div>
	<div id="out">
		<input type="button" value="나가기" id="btnClose">
	</div>
</nav>
<div id="mainView">
	<div id="content" class="characters">

	</div>
	<div id="readyBtn">
		<div class="ready"><input type="button" value="ready" 
				></div>
	</div>
	
	<div id="chatting">
		<textarea rows="6" cols="230" id="messageTextArea" readonly="readonly"></textarea>
		<input type="text" id="messageText" name="chatInput" class="form-control">
		<input type="button" value="Send" id="btnSend">
	</div>
	
</div>
	<script type="text/javascript">
	
    	var webSocket = null; // 웹소켓 변수 선언
        var messageTextArea = document.getElementById("messageTextArea");
    	var messageText = document.getElementById("messageText");
		
    	
    	(function connectting(){
    		myid = '<%=nick%>';
    		nick = '<%=nick%>'+','+'<%=roomVo.getRoom_no()%>';
    		roomnum = <%=roomVo.getRoom_no()%>;
	        //웹소켓 초기화
	        // WebSocket 오브젝트 생성 (자동으로 접속 시작한다. - onopen 함수 호출)
	        webSocket = new WebSocket("ws://192.168.0.97:8084/wcggame/websocktMultiChat");
	        
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
	            if(jsonData.message.slice(0, 15)=="System : remove"){
	            	console.log(jsonData.message.substring(15)) 
					$("#"+jsonData.message.substring(15)+"").remove();	            	
	            }
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
				messageText.value = "";
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
    </script>
	<script type="text/javascript">
	$(function(){
			$('.ready').on('click', function(){
				webSocket.send('/ready');
			})
		})	
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