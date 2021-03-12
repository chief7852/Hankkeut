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
import java.util.concurrent.atomic.AtomicBoolean;

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
import kr.or.ddit.websocket.vo.MultiChatVO2;
import room.service.IRoomService;
import room.service.RoomServiceImpl;
import vo.CharVO;

import vo.RoomVO;
import word.service.IWordService;
import word.service.WordServiceImpl;

@ServerEndpoint("/websocktMultiChat")
public class WebSocketMutiChat {

	// 유저 집합 리스트 // 접속된 클라이언트 session관리 리스트

	static List<RoomVO> room = Collections.synchronizedList(new ArrayList<RoomVO>());
	static List<MultiChatVO> sessionUsers = Collections.synchronizedList(new ArrayList<MultiChatVO>());
	static List<CharVO> users = Collections.synchronizedList(new ArrayList<CharVO>());
	// 이미 사용한 문자
	static List<String> remember = Collections.synchronizedList(new ArrayList<String>());
	static int ready = 0;
	// 강퇴리스트(보류)
	static List<MultiChatVO> black = Collections.synchronizedList(new ArrayList<MultiChatVO>());
	// 유저 인원
	static int usermax = 1;
	static String titleword = "";
	static String mainword = "";
	// 라운드
	static int maxround = 10;
	static int round =1;
	// 타이머
	static String host = "hostname";
	static boolean start = false;
	// 타이머 onoff용
	private final AtomicBoolean running = new AtomicBoolean(false);
	// 문자의 끝
	static char endpoint = '/';
	public static int order = 0;
	static Runnable timerR = new Timer(sessionUsers);
	static Thread timer = new Thread(timerR);
	
	public void setOrder() {
		order++;
		if (sessionUsers.size() - 1 < order) {
			order = 0;
		}
		round++; 
		if(round > maxround) {
			start = false;
			try {
				sendToAll("System", "게임종료");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				timer.interrupt();
			}finally{
				try {
					sendToAll("System", "게임종료");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				timer.interrupt();
			}
		} 
	}
	
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
		System.out.println(sessionUsers.size());
		/*
		 * 여기에 charater를 저장해놓아야하는데=================
		 */

		System.out.println(userSession.getId() + "접속\n");

	}

	/**
	 *  * 웹 소켓으로부터 메시지가 오면 호출한다.  * @param message 메시지  * @param userSession
	 *  * @throws IOException  
	 */
	@SuppressWarnings({ "static-access", "unlikely-arg-type" })
	@OnMessage // 같은 방에 있는 사람들에게만 메세지를 보낸다.
	public void handleMessage(String message, Session userSession) throws IOException, InterruptedException {

		String username = (String) userSession.getUserProperties().get("username");
		// 세션 프로퍼티에 username이 없으면 username을 선언하고 해당 세션으로 메시지를 보낸다.(json 형식이다.)
		// 최초 메시지는 username설정
		if(message.equals("//next")) {
			
			
			/*
			 * IWordService service = WordServiceImpl.getInstance(); mainword =
			 * service.selectRand();
			 */
			 
				 timer.interrupt(); 				 
				 timer = new Thread(timerR);
				 timer.start(); 
			 
		}else {
		if (start == false) {
			if (message.equals("/ready")) {
				int roomnum = 0;
				int ready = 0;
				int summem = 0;
				Iterator<MultiChatVO> iter = sessionUsers.iterator();
				while (iter.hasNext()) {
					MultiChatVO mvo = iter.next();

					if (mvo.getSession().equals(userSession)) {
						roomnum = mvo.getRoomnum();
						if (mvo.isReady() == true) {
							mvo.setReady(false);
							message = "(ready취소)";
						} else {
							mvo.setReady(true);
							message = "(ready)";
						}
					}
				}
				iter = sessionUsers.iterator();
				while (iter.hasNext()) {
					MultiChatVO mvo = iter.next();
					if (mvo.getRoomnum() == roomnum) {
						summem++;
						if (mvo.isReady() == true) {
							ready++;
						}
					}
				}
				if (ready == summem) {
					iter = sessionUsers.iterator();
					IWordService service = WordServiceImpl.getInstance();
					
					mainword = service.selectRand();
					
					while (iter.hasNext()) {
						MultiChatVO vo = iter.next();

						vo.getSession().getBasicRemote().sendText(buildJsonData("System", "게임시작하겠습니다"));
						
						start = true;
						System.out.println("제시어" + mainword);
						endpoint = mainword.charAt(mainword.length() - 1);
						System.out.println(endpoint);
						remember.add(mainword);
						vo.getSession().getBasicRemote().sendText(buildJsonDataMain(mainword));
						vo.getSession().getBasicRemote().sendText(buildJsonDataAnsSub(endpoint));

					}
					// 생성자 Thread(Runnable target)
					/*
					 * IRoomService service = RoomServiceImpl.getService(); RoomVO rvo =
					 * service.roomEnter(summem);
					 * 
					 * Runnable maintimerR = new Timer2(sessionUsers,rvo.getRoom_time());
					 * 
					 * Thread maintimer = new Thread(maintimerR); // 생성자 Thread(Runnable target)
					 * 
					 */

					timer.start();
					/* maintimer.start(); */
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
						maxround = Integer.parseInt(data[2]);
						if(Integer.parseInt(data[3])==1) {							
							chatVo.setReady(true);
							
						}
						System.out.println("maxround = "+maxround);
						///////////////// if(message==null) {message = "guest";} // 캐릭터를 service로
						// 요청해서 db에서 가져온다

						/////////////////

						userSession.getUserProperties().put("username", data[0]);
						sendToAll(username,"(ready)");
						userSession.getBasicRemote().sendText(buildJsonData("System", data[0] + "님 연결 성공!!"));
						// 현재 인원의 정보를 보내주기
						Iterator<MultiChatVO> iterator = sessionUsers.iterator();

						ICharacterService service = CharacterServiceImpl.getService();
						CharVO charvo = service.selectchetChar(data[0]);

						users.add(charvo);

						///////////////////////////////
						// 접속중인 인원 전원을 출력하기
						System.out.println("현재 접속중인원");
						while (iterator.hasNext()) {
							MultiChatVO chvo = iterator.next();
							if (chvo.getRoomnum() == Integer.parseInt(data[1])) {
								for (CharVO vo : users) {

									chatVo.getSession().getBasicRemote()
											.sendText(buildJsonData(username, vo.getChar_nickname(), vo.getBase_img()));

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
		} // start
			// ==false====================================================================
		else if (start == true) {
			// 접속 session id로 구분해서 순서 맞춰서 출력  (1)
			if (order != Integer.parseInt(userSession.getId())) {
				userSession.getBasicRemote().sendText(buildJsonData("System", "당신의 차례가 아닙니다"));
			} else {//(2)
				// 끝단어인지 체크
				
				System.out.println(endpoint);
				if (message.charAt(0) != endpoint) {
					
					Iterator<MultiChatVO> iterator = sessionUsers.iterator();
					while (iterator.hasNext()) {
						MultiChatVO chVo = iterator.next();
						chVo.getSession().getBasicRemote().sendText(buildJsonData("System", message + "는 맞지않은문자입니다(x)"));

					}
				}else {
					
				
					
				
				IWordService service = WordServiceImpl.getInstance();
				String result = service.selectWord(message);
				Iterator<MultiChatVO> iterator = sessionUsers.iterator();

				/*
				 * 이전 끝 문자와 지금 시작문자가 동일한지 판단 마지막으로 입력한 문자의 끝을 잘라서 저장 및
				 * 출력============================================================
				 */

				// 이미 사용한 문자인지 아닌지 판단하는 로직
				boolean overlap = true;
				Iterator<String> over = remember.iterator();
				while (over.hasNext()) {
					String temp = over.next();
					if (temp.equals(result)) {
						overlap = false;
					}
				}
				// -------------------------------------------------

				// db에 없는 글자이면 없는 문자라고 통보
				if (result == null) {

					while (iterator.hasNext()) {
						MultiChatVO chVo = iterator.next();
						chVo.getSession().getBasicRemote().sendText(buildJsonData("System", message + "는 없는문자입니다(x)"));

					}
					sendToAll(username, message);
				} else { //(3) db에 있을때 중복사용이면 중복되었다고 안내 아닐경우 사용기억에 넣고 정답출력
					if (overlap == true) {
						remember.add(result);
						Iterator<MultiChatVO> piter = sessionUsers.iterator();
						while(piter.hasNext()) {
							MultiChatVO pvo = piter.next();
							if(pvo.getSession().equals(Integer.toString(order)))
							{
								
								System.out.println("포인트"+pvo.getPoint());
							}
						}
						order++;
						if (sessionUsers.size() - 1 < order) {
							order = 0;
						}
						endpoint = message.charAt(message.length() - 1);
						
						
						piter = sessionUsers.iterator();
						while(piter.hasNext()) {
							MultiChatVO pvo = piter.next();
							pvo.getSession().getBasicRemote().sendText(buildJsonDataAns(message));
							pvo.getSession().getBasicRemote().sendText(buildJsonDataAnsSub(endpoint));
							pvo.getSession().getBasicRemote().sendText(buildJsonDataround(round));
						}
						mainword = message;
						sendToAll(username, message+"(o)");

						// 타이머 쓰레드 종료하고
						timer.interrupt();

						// 새로운 타이머 쓰레드를 객체화시켜서 불러낸다
						timer = new Thread(timerR);
						timer.start();

					} else {//(4)
						while (iterator.hasNext()) {
							MultiChatVO chVo = iterator.next();
							chVo.getSession().getBasicRemote()
									.sendText(buildJsonData("System", message + "는 이미 사용한 문자입니다(x)"));

							}
						}//(4)
					}//(3)
				}
			}//(2)
		}//(1)
		}
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
				// db데이터삭제
				IRoomService service = RoomServiceImpl.getService();

				service.deleteRoom(delName);

				romnum = chatVo.getRoomnum();
				// sessionUsers.remove(chatVo);
				chatIter.remove();
			}
		}
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
		// 방이름이 같은 사람만 추가
		Iterator<MultiChatVO> chat = sessionUsers.iterator();
		while (chat.hasNext()) {
			MultiChatVO vo = chat.next();
			if (vo.getRoomnum() == romnum)
				sendToAll("System", "remove" + delName);

		}

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
		if (message.equals("(ready취소)") || message.equals("(ready)")) {
			jsonMap.put("ready", message);
			jsonMap.put("username", username);
		} else {
			jsonMap.put("message", username + " : " + message);
		}
		String strJson = gson.toJson(jsonMap);
		System.out.println("strJson = " + strJson);

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

	public String buildJsonDataT(int time) {
		Gson gson = new Gson();
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put("timer", "" + time);
		String strJson = gson.toJson(jsonMap);
		// System.out.println("strJson = " + strJson);

		return strJson;
	}

	public String buildJsonDataAns(String message) {
		Gson gson = new Gson();
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put("answer", "" + message);
		String strJson = gson.toJson(jsonMap);
		// System.out.println("strJson = " + strJson);

		return strJson;
	}
	
	public String buildJsonDataAnsSub(char endpoint) {
		Gson gson = new Gson();
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put("answerSub", "" + endpoint);
		String strJson = gson.toJson(jsonMap);
		// System.out.println("strJson = " + strJson);

		return strJson;
	}
	
	public String buildJsonDataMain(String mainword) {
		Gson gson = new Gson();
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put("mainword", "" + mainword);
		String strJson = gson.toJson(jsonMap);
		// System.out.println("strJson = " + strJson);

		return strJson;
	}
	
	public String buildJsonDataround(int round) {
		Gson gson = new Gson();
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put("round", "" + round);
		String strJson = gson.toJson(jsonMap);
		// System.out.println("strJson = " + strJson);

		return strJson;
	}
}