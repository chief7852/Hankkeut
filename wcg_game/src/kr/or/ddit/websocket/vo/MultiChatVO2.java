package kr.or.ddit.websocket.vo;

import javax.websocket.Session;

public class MultiChatVO2 {
	private String name;
	private Session session;
	private int num;
	
	public MultiChatVO2(String name, Session session , int num) {
		super();
		this.name = name;
		this.session = session;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
}
