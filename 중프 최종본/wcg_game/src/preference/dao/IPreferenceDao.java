package preference.dao;

import java.sql.SQLException;

import vo.preferenceVO;

public interface IPreferenceDao {
	
	//autoready update
	public int updateautoready(String mem_id,String num) throws SQLException;
	
	// 친구추가 허용 유무
	public preferenceVO isFriendMess(String mem_id);
	
	// 캐릭터 등록 시 자동으로 환경 설정 데이터 등록
	public int insertPre(String mem_id);
	
	// 회원 탈퇴 시 데이터 삭제
	public int delPre(String mem_id);
}
