package common.dao;

import java.sql.SQLException;
import java.util.List;

import vo.MemberVO;
import vo.noticeBoardVO;

public interface IMemberDao {
	
	// 아이디 체크
	public String selectById(String id) throws SQLException;
	//회원가입
	public String insertMember(MemberVO vo) throws SQLException;
	//탈퇴
	public int deleteMember(String mem_id) throws SQLException;
	//로그인
	public String loginMember(MemberVO vo) throws SQLException;
	
	
	
	
	

	
	
}
