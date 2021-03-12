<%@page import="vo.preferenceVO"%>
<%@page import="preference.service.preferenceServiceImpl"%>
<%@page import="preference.service.IPreferenceService"%>
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
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/chet.css">

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
   grid-template-columns: auto auto auto auto;
}

#content .user {
   box-sizing: border-box;
   border: 1px solid lightgrey;
}

#readyBtn {
   box-sizing: border-box;
   text-align: center;
   margin: auto;
}

#chatting {
   box-sizing: border-box;
   height: 185px;
}

#btnClose {
   width: 100%;
   height: 100%;
}

.thumbnail {
   text-align: center;
}

#btnSend {
   display: none;
}

#records {
   height: 80px;
   border-top: 1px solid lightgrey;
   text-align: left;
}

#records ul {
   list-style-type: none;
   padding-left: 0px;
   white-space: nowrap;
   overflow-x: visible;
   overflow-y: hidden;
}

#records ul li {
   float : left;
   font-size: 27px;
   font-weight: bold;
   border-left: 1px solid lightgrey;
   padding: 13px;
}

</style>
</head>
<body style="text-align: center; height: 100vh; width: 100vw; background-image: url('../img/mainBackground2.jpg');">
   <%
   //방번호
   System.out.println("gameRoom.jsp hostRoomInfo??");
   RoomVO roomVo = (RoomVO) request.getAttribute("hostRoomInfo");
   System.out.println("gameRoom.jsp hostRoomInfo : " + roomVo.getRoom_no());
   //유저이름
   HttpSession sessions = request.getSession();
   String userId = (String) sessions.getAttribute("userid");
   //닉네임
   ICharacterService service = CharacterServiceImpl.getService();
   CharVO vo = service.selectChar(userId);
   String nick = vo.getChar_nickname();
   //환경설정
   IPreferenceService serv = preferenceServiceImpl.getService();
   preferenceVO pvo = serv.isFriendMess(userId);
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
   <!-- none -->
   <div id="recommendWord" style="display: none">
      <h1>제 시 어</h1>
   </div>
   <div id="answer" style="display: none">
      <div id="answerBox">
         <div id="bgBox">
            <div class="jb-image">
               <img alt="" src="../img/answerBox_640.png">
            </div>
            <div class="jb-text">
               <h2>제 시 어</h2>
            </div>
         </div>
         <div id="progressBar">
            <div id="myProgress">
               <div id="roundTime">라운드시간</div>
            </div>
            <!-- <div id="myProgress">
               <div id="totalTime">전체시간</div>
            </div> -->
            <div id="next"></div>
         </div>
         <div id="noworder"></div>
      </div>
      <div id="roundCnt">
         <div id="roundBox">
            <div class="round-img">
               <img alt="" src="../img/round_640.PNG">
            </div>
            <div class="round-text">
               <h2>1</h2>
            </div>
         </div>
      </div>
   </div>

   <div id="records" class="horizontal-scrollable" style="display: none">
      <ul>
         
      </ul>
   </div>
   <!-- none -->
   <div id="mainView">
      <div id="content" class="characters"></div>
      <div id="readyBtn">
         <div class="ready">
            <input type="button" value="ready">
         </div>
      </div>

      <div id="chatting">
         <textarea rows="6" cols="230" id="messageTextArea"
            readonly="readonly"></textarea>
         <input type="text" id="messageText" name="chatInput"
            class="form-control"> <input type="button" value="Send"
            id="btnSend">
      </div>

   </div>
   <script type="text/javascript">
   
       var webSocket = null; // 웹소켓 변수 선언
        var messageTextArea = document.getElementById("messageTextArea");
       var messageText = document.getElementById("messageText");
      
       
       (function connectting(){
          myid = '<%=nick%>';
          nick = '<%=nick%>'+','+'<%=roomVo.getRoom_no()%>'+','+'<%=roomVo.getRoom_round()%>'+','+'<%=pvo.getAutoready()%>';
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
               console.log(message)
               var jsonData = JSON.parse(message.data);
                var jsonData2 = JSON.parse(message.data);
                var jsonTimer = JSON.parse(message.data);
          
               // json "img"풀기
                  console.log(jsonData2.imgg);
                  console.log(jsonData2.id);
                  
                  
                  /* switch(jsonData.type)
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
                  } */
               //이미지 들고오기
              
              var image = "";
               image += "<div class='thumbnail' id="+jsonData2.id+" display:inline-block><img src="+jsonData2.imgg+">"+jsonData2.id+
                        "<div style='color:#red' class="+jsonData2.id+"></div></div>"; 
               
               if(jsonData2.imgg!=null){
               $('.characters').append(image);    
               if('<%=pvo.getAutoready()%>' == '1') {
                  $('.' + myid).text('ready')
               }
            }
            if (jsonTimer.timer != -1) {
               $('#roundTime').html(jsonTimer.timer)
               if (jsonTimer.timer == 0) {
                  $('#next').html('시간초과');
                  setTimeout(function() {
                     $('#next').html('');
                  }, 2000);

               }
            }

            if (jsonData.round != null) {
               $('.round-text').html("<h2>" + jsonData.round + "</h2>")
            }
            if (jsonData.noworder != null) {
               $('#noworder').html(jsonData.noworder);
            }
            if (jsonTimer.maintimer != -1) {
               $('#totalTime').html(jsonTimer.maintimer);
            }
            if (jsonData.answerSub != null) {
               $('.jb-text').html("<h2>" + jsonData.answerSub + "</h2>");
            }
            if(jsonData.answer != null){
               $('#records ul').prepend("<li>"+jsonData.answer+"</li>").css({
                  "display": "inline-block",
                  "font-size": "27px",
                  "font-weight": "bold",
                  "border-left": "1px solid lightgrey",
                  "padding": "13px"
               })
            } 
            if (jsonData.mainword != null) {
               $('#recommendWord').html(
                     "<h1>" + jsonData.mainword + "</h1>");
            }
            //나갔을때 이미지 삭제
            if (jsonData.ready != null) {
               if (jsonData.ready == '(ready취소)') {
                  $('.' + jsonData.username).empty();
               } else {
                  $('.' + jsonData.username).text('ready')
               }
            }
            console.log(jsonData.username);
            // 게임시작시
            if (jsonData.message == "System : 게임시작하겠습니다") {
               $('#recommendWord').css('display', 'block');
               $('#answer').css('display', 'block');
               $('#records').css('display', 'block');
               $('.thumbnail img').css({
                  'width' : '200px',
                  'height' : '150px'
               });
               $('#content').css('height', '200px');
               $('#readyBtn').css('display', 'none');
               /* $.ajax({
                  url: "/wcggame/startRoom.do",
                  method: "post",
                  success : function(res){
                     $('#mainView').html(res);
                  },
                  error: function(xhr) {
                     alert("서버 상태 : " + xhr.status);
                  },
                  dataType: 'html'
               }); */
            }
            if (jsonData.message == "System : 게임종료") {
               <%
                  ICharacterService servup = CharacterServiceImpl.getService();
                  servup.allUp(nick);
               %>
               $('#recommendWord').attr('style', 'display:none');
               $('#answer').attr('style', 'display:none');
               $('#records').attr('style', 'display:none');
               alert("게임 종료되었습니다!! 메인 로비로 이동하겠습니다!")
   
               closing();
            }

            if ('' + jsonData.message + ''.slice(0, 15) == "System : remove") {
               console.log(jsonData.message.substring(15))
               $("#" + jsonData.message.substring(15) + "").remove();
            }
            if (jsonData.message != null) {
               messageTextArea.value += jsonData.message + "\n"
               messageTextArea.scrollTop = 9999999;
            }
         }

         webSocket.onerror = function showErrorMsg(event) {
            alert("오류 : " + event.data);
         }

         webSocket.onclose = function(event) {
            messageTextArea.value = "";
            messageText.value = "";

            nick = "";

         }
      }())

      //메시지 보내기
      function sendMessage() {
         if (messageText.value.trim() == "") {
            messageText.focus();
            return;
         }
         webSocket.send(messageText.value);
         messageText.value = "";
      }
      $(function() {
         $('#btnClose').on('click', function() {
            $('.characters').empty();
            webSocket.close();
            
            location.href = "../WaitingGame/main.jsp";
         })
      })
      function closing() {
         $('.characters').empty();
         webSocket.close();
         location.href = "../WaitingGame/main.jsp";

      }

      // 이벤트 설정
      function addEvent() {

         document.getElementById("btnSend").addEventListener("click",
               sendMessage, false);
         document.getElementById("btnClose").addEventListener("click",
               closing, false);
      }
      window.addEventListener("load", addEvent, false);

      window.onbeforeunload = function() {
         
         <%
            service.offChar(userId);
         %>
         closing();
      }
   </script>
   <script type="text/javascript">
      $(function() {
         $('.ready').on('click', function() {
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