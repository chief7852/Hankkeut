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
}
