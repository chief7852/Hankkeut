package room.dao;

import java.util.List;

import vo.ManagerVO;
import vo.RoomVO;

public interface IRoomDao {
	// 방 생성
	public String insertRoom(RoomVO vo);
	
	// 방 호출
	public List<RoomVO> selectAllRoom();
	// 방 비밀번호 유무
}
