package kr.or.ddit.websocket.multichat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import com.google.gson.Gson;

import kr.or.ddit.websocket.vo.MultiChatVO;

public class Timer2 implements Runnable{
	private int timer = 0;
	private final AtomicBoolean running = new AtomicBoolean(false);
	private List<MultiChatVO> Users =Collections.synchronizedList(new ArrayList<MultiChatVO>());
	
	public Timer2(List<MultiChatVO> sessionUsers, int timer) {
		Users = sessionUsers;
		this.timer = timer;
	}





	public void run() {
		int basetimer = timer;
		
		running.set(true);
		while(running.get())
		{
			try {
				Iterator<MultiChatVO> iter = Users.iterator();
				while (iter.hasNext()) {
					MultiChatVO chVo = iter.next();
					chVo.getSession().getBasicRemote()
					 .sendText(buildJsonDataT(timer));
				}
				if(timer==0)
				{
					timer = basetimer+1;
				}
				timer--;
				System.out.println(timer);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	

	// 타이머 끄기
	public void stop() {
        running.set(false);
       
    }
	public String buildJsonDataT(int time) {
		Gson gson = new Gson();
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put("maintimer", ""+time);
		String strJson = gson.toJson(jsonMap);
		// System.out.println("strJson = " + strJson);

		return strJson;
	}



}


