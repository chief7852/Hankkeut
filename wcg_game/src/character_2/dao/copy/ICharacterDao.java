package character_2.dao.copy;

import java.sql.SQLException;
import java.util.List;

import vo.CharVO;
import vo.MemberVO;
import vo.noticeBoardVO;

public interface ICharacterDao {
	
	public CharVO selectChar(String mem_id) throws SQLException;
	
	//캐릭터의 소지 포인트 업데이트
	public int updateBuyPoint(String mem_id,String item) throws SQLException;
	
}
