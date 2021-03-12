package kr.or.ddit.websocket.multichat;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import com.google.gson.Gson;

import kr.or.ddit.websocket.vo.MultiChatVO;

public class Timer implements Runnable{
	public volatile boolean running = true;
 
	private int timer = 0;
	private int order = 0;
	private String nownick = "";
	private List<MultiChatVO> Users =Collections.synchronizedList(new ArrayList<MultiChatVO>());
	public Timer(List<MultiChatVO> sessionUsers) {
		Users = sessionUsers;
	}


	
	public List<MultiChatVO> getUsers() {
		return Users;
	}



	public void setUsers(List<MultiChatVO> users) {
		Users = users;
	}

	public void terminate() {

	    running = false;

	}

	public void setRunning(boolean running) {
		this.running = running;
	}
	public void Thread_handle(){
		
	}

	public void run() {
		
		timer = 10;
		running= true;
		
			try {
				while(!Thread.currentThread().isInterrupted())
				{
				Iterator<MultiChatVO> iter = Users.iterator();
				while (iter.hasNext()) {
					MultiChatVO chVo = iter.next();
					chVo.getSession().getBasicRemote()
					 .sendText(buildJsonDataT(timer+""));
				}
				if(timer==0)
				{
					WebSocketMutiChat ws = new WebSocketMutiChat();
					// timer가 0 이되면 다음순서로
					ws.setOrder();
				
					timer = 11;
				}
				
				timer--;
				System.out.println(timer);
				Thread.sleep(1200);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				running=false;
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*
		 * Runnable timerR = new Timer(sessionUsers);
		 * 
		 * Thread timer = new Thread(timerR);
		 */
	
	
	

	// 타이머 끄기
	public void stopeed() {
        running= true;
        timer = 10;
    }
	public String buildJsonDataT(String time) {
		Gson gson = new Gson();
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put("timer", ""+time);
		String strJson = gson.toJson(jsonMap);
		// System.out.println("strJson = " + strJson);

		return strJson;
	}
	
	public String buildJsonDataOrder(String nick) {
		Gson gson = new Gson();
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put("noworder", ""+nick);
		String strJson = gson.toJson(jsonMap);
		// System.out.println("strJson = " + strJson);

		return strJson;
	}


}


