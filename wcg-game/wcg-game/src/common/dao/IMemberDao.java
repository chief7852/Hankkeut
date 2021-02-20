package common.dao;

import java.sql.SQLException;
import java.util.List;

import vo.MemberVO;

public interface IMemberDao {
	//회원가입
	public String insertMember(MemberVO vo) throws SQLException;
	//탈퇴
	public int deleteMember(String mem_id) throws SQLException;
	//내정보 수정
	
}
