package room.dao;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.ManagerVO;
import vo.MemberVO;
import vo.RoomVO;
import vo.noticeBoardVO;

public class RoomDaoImpl implements IRoomDao {
	
	private SqlMapClient client;
	private static IRoomDao dao;
	
	private RoomDaoImpl () {
		client = SqlMapClientFactory.getClient();
	}
	public static IRoomDao getDao() {
		if(dao == null) dao = new RoomDaoImpl();
		return dao;
	}
	@Override
	public int insertRoom(RoomVO vo) {
		int cnt = 0;
		Object room = null;
		try {
			room = client.insert("room.insertRoom", vo);
			if(room == null) cnt = 1;
		} catch (SQLException e) {
			room = null;
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public List<RoomVO> selectAllRoom() {
		List<RoomVO> roomList = null;
		try {
			roomList = client.queryForList("room.selectAllRoom");
		} catch (SQLException e) {
			roomList = null;
			e.printStackTrace();
		}
		return roomList;
	}
	// 생성 했을 때의 방 정보를 위해 host 값을 넘겨 받음
	@Override
	public RoomVO isRoom(String hostIP) {
		RoomVO hostRoomInfo = null;
		try {
			hostRoomInfo = (RoomVO) client.queryForObject("room.isHostRoom", hostIP);
		} catch (SQLException e) {
			hostRoomInfo = null;
			e.printStackTrace();
		}
		return hostRoomInfo;
	}
	
	// 리스트에 있는 방에 접속 할 시 필요한 정보를 받음
	@Override
	public RoomVO roomEnter(int room_vo) {
		RoomVO roomVo = null;
		try {
			roomVo = (RoomVO) client.queryForObject("room.roomEnter", room_vo);
		} catch (SQLException e) {
			roomVo = null;
			e.printStackTrace();
		}
		return roomVo;
	}
	@Override
	public void deleteRoom(String nickname) {
		Object room = null;
		try {
			room = client.delete("room.deleteRoom", nickname);
			
		} catch (SQLException e) {
			room = null;
			e.printStackTrace();
		}
	}
	@Override
	public int selectRoom(String nickname) {
		int cnt = 0;
		
		try {
			cnt = (int) client.insert("room.selectRoom", nickname);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public String isPass(int room_vo) {
		String roomPass = "";
		try {
			roomPass = (String) client.queryForObject("room.isRoomPass", room_vo);
		} catch (SQLException e) {
			roomPass = "";
			e.printStackTrace();
		}
		return roomPass;
	}
	@Override
	public int updateCnt(RoomVO roomvo) {
		int cnt = 0;
		try {
			cnt = client.update("room.updateCnt", roomvo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	

}
