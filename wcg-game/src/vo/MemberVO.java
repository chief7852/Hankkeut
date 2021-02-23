package vo;

public class MemberVO {
	private String mem_id     ;    //회원아이디
	private String mem_pass   ;    //회원비밀번호
	private String gender     ;    //성별
	private String mem_bir    ;    //생년월일
	private String mem_mail   ;    //이메일주소
	private String mem_add1  ;    //주소1
	private String mem_add2   ;    //주소2
	private String zip_code   ;    //우편번호
	private String mem_hp     ;    //휴대폰번호
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pass() {
		return mem_pass;
	}
	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMem_bir() {
		return mem_bir;
	}
	public void setMem_bir(String mem_bir) {
		this.mem_bir = mem_bir;
	}
	public String getMem_mail() {
		return mem_mail;
	}
	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}
	public String getMem_add1() {
		return mem_add1;
	}
	public void setMem_add1(String mem_addr1) {
		this.mem_add1 = mem_addr1;
	}
	public String getMem_add2() {
		return mem_add2;
	}
	public void setMem_add2(String mem_add2) {
		this.mem_add2 = mem_add2;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getMem_hp() {
		return mem_hp;
	}
	public void setMem_hp(String mem_hp) {
		this.mem_hp = mem_hp;
	}
	
	
}
