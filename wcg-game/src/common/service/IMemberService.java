package common.service;

import java.sql.SQLException;

import vo.MemberVO;

public interface IMemberService {
	
	// 아이디 체크
	public String selectById(String id);
	// 회원가입
	public String insertMember(MemberVO vo);

	// 탈퇴
	public int deleteMember(String mem_id);
	// 내정보 수정

}
