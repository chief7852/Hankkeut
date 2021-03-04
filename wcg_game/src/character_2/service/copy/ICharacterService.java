package character_2.service.copy;

import java.sql.SQLException;
import java.util.List;

import vo.CharVO;
import vo.MemberVO;
import vo.noticeBoardVO;

public interface ICharacterService {

	// ĳ���� ������ �ҷ�����
	public CharVO selectChar(String mem_id);
	
	//캐릭터의 소지 포인트 업데이트
	public int updateBuyPoint(String mem_id,String item);
	
	//캐릭터 이미지 링크 업데이트(착용시)
	public int updateIMGLink(String mem_id);
	
	//전체목록출력
	public List<CharVO> selectAll();
	
	// 캐릭터 생성
	public int insertChar(CharVO vo);

}
