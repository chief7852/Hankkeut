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
	
	//캐릭터 이미지 링크 업데이트(착용시)
	public int updateIMGLink(String mem_id) throws SQLException;
	
	//전체목록출력
	public List<CharVO> selectAll();
	
	// 캐릭터 생성
	public int insertChar(CharVO vo);
	
	// 캐릭터 접속 여부
	public List<CharVO> isOn();
	
	// 게임 접속 시 상태값 on
	public int onChar(String memId);
	
	// 게임 접속 시 상태값 on
	public int offChar(String memId);
}
