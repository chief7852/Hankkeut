package word.dao;

import java.sql.SQLException;
import java.util.List;

import vo.MemberVO;
import vo.noticeBoardVO;

public interface IWordDao {
	
	// 문자체크
	public String selectWord(String word) throws SQLException;
	
	
	

	
	
}
