package kr.or.ddit.websocket.multichat;

import java.io.IOException;
import java.io.StringWriter;
import java.net.Inet4Address;
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
import room.service.IRoomService;
import room.service.RoomServiceImpl;
import vo.CharVO;

import vo.RoomVO;

@ServerEndpoint("/websocktMultiChat")
public class WebSocketMutiChat {

	// 유저 집합 리스트 // 접속된 클라이언트 session관리 리스트

	static List<RoomVO> room = Collections.synchronizedList(new ArrayList<RoomVO>());
	static List<MultiChatVO> sessionUsers = Collections.synchronizedList(new ArrayList<MultiChatVO>());
	static List<CharVO> users = Collections.synchronizedList(new ArrayList<CharVO>());
	static int ready = 0;
	// 강퇴리스트(보류)
	static List<MultiChatVO> black = Collections.synchronizedList(new ArrayList<MultiChatVO>());

	static String host = "hostname";
	// 여기에는 charVO를 저장하는 리스트를 또한 만들어줘야겠다==========

	/**
	 *  * 웹 소켓이 접속되면 유저리스트에 세션을 넣는다.  * @param userSession 웹 소켓 세션  
	 */
	@OnOpen
	public void handleOpen(Session userSession) {
		MultiChatVO chatVo = new MultiChatVO(null, userSession);

		// 클라이언트가 접속하면 WebSocket세션을 리스트에 저장한다
		Iterator<MultiChatVO> bcheck = black.iterator();
		while (bcheck.hasNext()) {
			if (bcheck.next().getSession().equals(userSession)) {
				userSession.removeMessageHandler(null);
			}
		}
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
	@OnMessage // 같은 방에 있는 사람들에게만 메세지를 보낸다.
	public void handleMessage(String message, Session userSession) throws IOException {

		String username = (String) userSession.getUserProperties().get("username");
		// 세션 프로퍼티에 username이 없으면 username을 선언하고 해당 세션으로 메시지를 보낸다.(json 형식이다.)
		// 최초 메시지는 username설정
		if(message.equals("/ready")) {
			int roomnum = 0;
			int ready =0;
			int summem = 0;
			Iterator<MultiChatVO> iter = sessionUsers.iterator();
			while(iter.hasNext()) {
				MultiChatVO mvo = iter.next();
				
				if(mvo.getSession().equals(userSession)){
					roomnum = mvo.getRoomnum();
					if(mvo.isReady()==true)
					{
						mvo.setReady(false);
						message="(ready취소)";
						System.out.println(message);
					}else if(mvo.isReady()==false)
					{
						mvo.setReady(true);
						message="(ready)";
						System.out.println(message);
					}
				}
			}
			iter = sessionUsers.iterator();
			while(iter.hasNext()) {
				MultiChatVO mvo = iter.next();
				if(mvo.getRoomnum()==roomnum) {
					summem++;
					if(mvo.isReady()==true) {
						ready++;
					}
				}
			}
			if(ready == summem) {
				iter = sessionUsers.iterator();
				while(iter.hasNext()) {
					MultiChatVO vo = iter.next();
					if(vo.getRoomnum()==roomnum) {
						vo.getSession().getBasicRemote()
						.sendText(buildJsonData("System",  "게임시작하겠습니다"));						
					}
				}
				return;
			}
		}
		if (username == null) {
			/*
			 * if(message.equals("")) { message="guest"; } //만약 guest가 아닌 중복된 아이디가 접근하려하면
			 * 벤처리한다.
			 */
			if (message.equals("")) {
				message = "guest";
			}
			for (MultiChatVO chatVo : sessionUsers) {
				// session을 얻으면 chatVo에 이름을 넣어주면서 입장했다 는 문자를 출력해준다
				if (userSession.equals(chatVo.getSession())) {
					String[] data = message.split(",");
					chatVo.setName(data[0]);
					chatVo.setRoomnum(Integer.parseInt(data[1]));

					///////////////// if(message==null) {message = "guest";} // 캐릭터를 service로
					// 요청해서 db에서 가져온다

					/////////////////

					userSession.getUserProperties().put("username", data[0]);
					userSession.getBasicRemote().sendText(buildJsonData("System", data[0] + "님 연결 성공!!"));
					// 현재 인원의 정보를 보내주기
					Iterator<MultiChatVO> iterator = sessionUsers.iterator();

					ICharacterService service = CharacterServiceImpl.getService();
					CharVO charvo = service.selectchetChar(data[0]);

					users.add(charvo);

					///////////////////////////////
					// 접속중인 인원 전원을 출력하기
					System.out.println("현재 접속중인원");
					System.out.println(username);
					
					while (iterator.hasNext()) {
						MultiChatVO chvo = iterator.next();
						if (chvo.getRoomnum() == Integer.parseInt(data[1])) {
							for (CharVO vo : users) {
								
									chatVo.getSession().getBasicRemote()
											.sendText(buildJsonData(username, vo.getChar_nickname(), vo.getBase_img()));
									System.out.println(vo.getBase_img());
							}
						}
						break;
					}

					/////////////////////////////
					iterator = sessionUsers.iterator();
					while (iterator.hasNext()) {
						MultiChatVO chVo = iterator.next();
						if (!chVo.getSession().equals(chatVo.getSession())
								&& chVo.getRoomnum() == Integer.parseInt(data[1])) {
							chVo.getSession().getBasicRemote()
									.sendText(buildJsonData("System", data[0] + "님이 입장했습니다."));
							chVo.getSession().getBasicRemote()
									.sendText(buildJsonData(username, data[0], charvo.getBase_img()));
						}

					} // while문 끝
					return;
				}
			} // for문 끝
		}
		System.out.println(message);
		sendToAll(username, message);
	}

	public void sendToAll(String username, String message) throws IOException {
		// username이 있으면 전체에게 메시지를 보낸다.
		Iterator<MultiChatVO> iterator = sessionUsers.iterator();
		while (iterator.hasNext()) {
			iterator.next().getSession().getBasicRemote().sendText(buildJsonData(username, message));
		}
	}

	public void sendToAll2(String username, String message, CharVO vo) throws IOException {
		// username이 있으면 전체에게 이미지링크를 보낸다.

		Iterator<MultiChatVO> iterator = sessionUsers.iterator();
		while (iterator.hasNext()) {
			iterator.next().getSession().getBasicRemote().sendText(buildJsonData(username, message, vo.getBase_img()));
		}
	}

	public void sendToAllremove(String username, String message, String remove) throws IOException {
		

		Iterator<MultiChatVO> iterator = sessionUsers.iterator();
		while (iterator.hasNext()) {
			MultiChatVO vo = iterator.next();
			if (iterator.next() != null) {
				iterator.next().getSession().getBasicRemote().sendText(buildJsonData(username, message, remove));
			}
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
		int romnum = 0;
		// 접속종료시 케릭터 session 삭제
		Iterator<MultiChatVO> chatIter = sessionUsers.iterator();
		while (chatIter.hasNext()) {
			MultiChatVO chatVo = chatIter.next();
			if (userSession.equals(chatVo.getSession())) {
				delName = chatVo.getName();
				romnum = chatVo.getRoomnum();
				// sessionUsers.remove(chatVo);
				
			}
		}
		System.out.println(romnum);
			
		Iterator<RoomVO> roomIter = room.iterator();
		while (roomIter.hasNext()) {
			RoomVO roomvo = roomIter.next();
			if (roomvo.getRoom_host().equals(delName)) {
				roomIter.remove();
			}
		}
		// 캐릭터 collection 이미지 삭제
		Iterator<CharVO> userChar = users.iterator();
		while (userChar.hasNext()) {
			CharVO vo = userChar.next();
			if (vo.getChar_nickname().equals(delName)) {
				userChar.remove();
			}
		}
		chatIter = sessionUsers.iterator();
		while (chatIter.hasNext()) {
			MultiChatVO chatVo = chatIter.next();
			if (userSession.equals(chatVo.getSession())) {
					chatIter.remove();
			}
		}
		//모든인원에게 이미지삭제
		chatIter = sessionUsers.iterator();
		while(chatIter.hasNext()) {
			MultiChatVO chatVo = chatIter.next();
			if(chatVo.getRoomnum()==romnum)
			{
				chatIter.next().getSession().getBasicRemote().sendText(buildJsonData(delName));
			}
		}
		//db데이터삭제
		IRoomService service = RoomServiceImpl.getService();
		
		service.deleteRoom(delName);
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
		if(message.equals("(ready취소)")||message.equals("(ready)"))
		{
			jsonMap.put("ready", message);
			jsonMap.put("username", username);
		}else {
			jsonMap.put("message", username + " : " + message);			
		}
		String strJson = gson.toJson(jsonMap);
		System.out.println("strJson = " + strJson);

		return strJson;
	}

	public String buildJsonData(String username) {
		Gson gson = new Gson();
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put("remove", "remove"+":"+username);
		String strJson = gson.toJson(jsonMap);
		System.out.println("remove = " + strJson);

		return strJson;
	}
	
	public String buildJsonData(String username, String message, String img) {
		Gson gson = new Gson();
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put("imgg", img);
		String strJson = gson.toJson(jsonMap);
		System.out.println("imgg = " + strJson);

		jsonMap.put("id", message);
		strJson = gson.toJson(jsonMap);
		System.out.println("id = " + strJson);
		return strJson;
	}
}