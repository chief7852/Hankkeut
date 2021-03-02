package kr.or.ddit.websocket.multichat;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;

import character.service.CharacterServiceImpl;
import character.service.ICharacterService;
import kr.or.ddit.websocket.vo.MultiChatVO;
import vo.CharVO;

@ServerEndpoint("/websocktMultiChat")
public class WebSocketMutiChat {

	// 유저 집합 리스트 // 접속된 클라이언트 session관리 리스트
	static List<MultiChatVO> sessionUsers = Collections.synchronizedList(new ArrayList<MultiChatVO>());
	static List<CharVO> users =Collections.synchronizedList(new ArrayList<CharVO>());
	// 여기에는 charVO를 저장하는 리스트를 또한 만들어줘야겠다==========
	
	/**
	 *  * 웹 소켓이 접속되면 유저리스트에 세션을 넣는다.  * @param userSession 웹 소켓 세션  
	 */
	@OnOpen
	public void handleOpen(Session userSession) {
		MultiChatVO chatVo = new MultiChatVO(null, userSession);
		// 클라이언트가 접속하면 WebSocket세션을 리스트에 저장한다
		sessionUsers.add(chatVo);
		/*
		 * 여기에 charater를 저장해놓아야하는데=================
		 */
		
		System.out.println(userSession.getId() + "접속\n");
		
	}

	
	/**
	 *  * 웹 소켓으로부터 메시지가 오면 호출한다.  * @param message 메시지  * @param userSession
	 *  * @throws IOException  
	 */
	@OnMessage
	public void handleMessage(String message, Session userSession) throws IOException {


		String username = (String) userSession.getUserProperties().get("username");
		// 세션 프로퍼티에 username이 없으면 username을 선언하고 해당 세션으로 메시지를 보낸다.(json 형식이다.)
		// 최초 메시지는 username설정
		if (username == null) {
			if(message.equals(""))
			{
				message="guest";
			}
			//만약 guest가 아닌 중복된 아이디가 접근하려하면 벤처리한다.
			
			for (MultiChatVO chatVo : sessionUsers) {
				// session을 얻으면 chatVo에 이름을 넣어주면서 입장했다 는 문자를 출력해준다
				if (userSession.equals(chatVo.getSession())) {
					chatVo.setName(message);
					  ///////////////// if(message==null) {message = "guest";} // 캐릭터를 service로
					  //요청해서 db에서 가져온다
					
					 
					/////////////////
					
					userSession.getUserProperties().put("username", message);
					userSession.getBasicRemote().sendText(buildJsonData("System", message + "님 연결 성공!!"));
					//현재 인원의 정보를 보내주기
					Iterator<MultiChatVO> iterator = sessionUsers.iterator();					
					
						
					ICharacterService service = CharacterServiceImpl.getService();
					CharVO charvo = service.selectchetChar(message); 
					users.add(charvo); 
					
					sendToAll2(username, message , charvo);
					
					///////////////////////////////
					// 접속중인 인원 전원을 출력해봐야겠다====================
					System.out.println("현재 접속중인원");
					for (MultiChatVO vo : sessionUsers) {
						if (!vo.getSession().equals(chatVo.getSession())) {
							vo.getSession().getBasicRemote()
									.sendText(buildJsonData("id", message ,vo.getBase_img()));
						}
					}
					/////////////////////////////
					iterator = sessionUsers.iterator();	
					while (iterator.hasNext()) {
						MultiChatVO chVo = iterator.next();
						if (!chVo.getSession().equals(chatVo.getSession())) {
							chVo.getSession().getBasicRemote()
									.sendText(buildJsonData("System", message + "님이 입장했습니다."));
						}
						
					}// while문 끝
					return;
				}
			} // for문 끝
		}

		sendToAll(username, message);
	}

	public void sendToAll(String username, String message) throws IOException {
		// username이 있으면 전체에게 메시지를 보낸다.
		Iterator<MultiChatVO> iterator = sessionUsers.iterator();
		while (iterator.hasNext()) {
			iterator.next().getSession().getBasicRemote().sendText(buildJsonData(username, message));
		}
	}
	
	public void sendToAll2(String username, String message,CharVO vo) throws IOException {
		// username이 있으면 전체에게 이미지링크를 보낸다.

		Iterator<MultiChatVO> iterator = sessionUsers.iterator();
		while (iterator.hasNext()) {
			iterator.next().getSession().getBasicRemote().sendText(buildJsonData(username,message,vo.getBase_img()));
		}
	}

	/**
	 *  * 웹소켓을 닫으면 해당 유저를 유저리스트에서 뺀다.  * @param userSession  
	 * 
	 * @throws IOException
	 */
	@OnClose
	public void handleClose(Session userSession) throws IOException {
		System.out.println(userSession.getId() + "접속 종료...");
		String delName = null;
		Iterator<MultiChatVO> chatIter = sessionUsers.iterator();
		while (chatIter.hasNext()) {
			MultiChatVO chatVo = chatIter.next();
			if (userSession.equals(chatVo.getSession())) {
				delName = chatVo.getName();
				// sessionUsers.remove(chatVo);
				chatIter.remove();
			}
		}

		sendToAll("System", delName + "님이 퇴장했습니다.");

	}

	/**
	 * 웹 소켓이 에러가 나면 호출되는 이벤트
	 * 
	 * @param t
	 */
	@OnError
	public void handleError(Throwable t) {
		t.printStackTrace();
	}

	/**
	 *  * json타입의 메시지 만들기  * @param username  * @param message  * @return  
	 */
	public String buildJsonData(String username, String message) {
		Gson gson = new Gson();
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put("message", username + " : " + message);
		String strJson = gson.toJson(jsonMap);
		 System.out.println("strJson = " + strJson);

		return strJson;
	}
	
	public String buildJsonData(String username,String message ,String img) {
		Gson gson = new Gson();
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put("id", img);
		String strJson = gson.toJson(jsonMap);
		 System.out.println("id = " + strJson);

		return strJson;
	}
}