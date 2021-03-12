package common.service;

import java.sql.SQLException;
import java.util.List;

import vo.MemberVO;
import vo.noticeBoardVO;

public interface IMemberService {
	// 아이디 체크
	public String selectById(String id);
	
	//회원가입
	public String insertMember(MemberVO vo);

	//탈퇴
	public int deleteMember(MemberVO vo);
	
	//로그인
	public String loginMember(MemberVO vo);
	
	// 이메일 유무
	public MemberVO isMember(MemberVO vo);
	// 비밀번호 번경
	public int updatePass(MemberVO vo);
	
	
	//이메일 가져오기 
	public String selectEmail(String memid);
	
	// 비밀번호 존재
	public int isPassWord(MemberVO vo);
	
	// 비밀번호 변경
	public int updatePW(MemberVO vo);
	
	// 주소 변경
	public int updateAddr(MemberVO vo);
	
	// 전화번호 변경
	public int updateTel(MemberVO vo);
	
	// 비회원 리스트 출력
	public List<MemberVO> guestList();
	
	//영구정지할 회원 목록 
	public List<MemberVO> memRemoveList();
	
	//영구 정지할 회원 삭제 
	public int deleteMember2(String memid);
	
}
