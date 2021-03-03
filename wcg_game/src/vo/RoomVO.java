package vo;

public class RoomVO {
	private int room_no;		// 방 번호
	private String room_pass;	// 방 비밀번호
	private int room_round;		// 방 라운드 수
	private String room_theme;	// 방 유형
	private String room_name;	// 방 제목
	private String nickname;	// (보류)
	private int allow_no;		// 방 허용 인원 수
	private String room_host;	// 방 호스트 ip
	
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	public String getRoom_pass() {
		return room_pass;
	}
	public void setRoom_pass(String room_pass) {
		this.room_pass = room_pass;
	}
	public int getRoom_round() {
		return room_round;
	}
	public void setRoom_round(int room_round) {
		this.room_round = room_round;
	}
	public String getRoom_theme() {
		return room_theme;
	}
	public void setRoom_theme(String room_theme) {
		this.room_theme = room_theme;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getAllow_no() {
		return allow_no;
	}
	public void setAllow_no(int allow_no) {
		//this.allow_no = allow_no;
		this.allow_no = 4;
	}
	public String getRoom_host() {
		return room_host;
	}
	public void setRoom_host(String room_host) {
		this.room_host = room_host;
	}
}                            
