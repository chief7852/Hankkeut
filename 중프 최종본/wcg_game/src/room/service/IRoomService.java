package room.service;

import java.sql.SQLException;
import java.util.List;

import vo.ManagerVO;
import vo.MemberVO;
import vo.RoomVO;
import vo.noticeBoardVO;

public interface IRoomService {
	// 방 생성
	public int insertRoom(RoomVO vo);
	// 방 호출
	public List<RoomVO> selectAllRoom();
	
	// 방 호스트 생성 유무
	public RoomVO isRoom(String hostIp);  
	
	// 방 정보
	public RoomVO roomEnter(int room_vo);
	
	// 방 없애기
	public void deleteRoom(String nickname);
	
	// 닉네임으로 방찾기
	public int selectRoom(String nickname);
	
	// 방 비밀번호 유무
	public String isPass(int room_vo);
	
	// 로비에서 접속 시 방 인원 수 업데이트
	public int updateCnt(RoomVO roomvo);
	
}
