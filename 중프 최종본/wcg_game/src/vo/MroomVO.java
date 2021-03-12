package vo;

import javax.websocket.Session;

public class MroomVO {
	private int room_no;
	private String char_nickname;
	private Session session;
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	public String getChar_nickname() {
		return char_nickname;
	}
	public void setChar_nickname(String char_nickname) {
		this.char_nickname = char_nickname;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	
}                            
