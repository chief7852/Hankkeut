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
	@Override
	public int isRoom(RoomVO vo) {
		int cnt = 0;
		try {
			cnt = (int) client.queryForObject("room.isRoom", vo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
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
	

}
