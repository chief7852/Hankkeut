package common.service;

import vo.MemberVO;

public interface IMemberService {
	// 회원가입
	public String insertMember(MemberVO vo);

	// 탈퇴
	public int deleteMember(String mem_id);
	// 내정보 수정

}
