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
	public String insertRoom(RoomVO vo) {
		String roomNo = "";
		try {
			roomNo = (String) client.insert("room.insertRoom", vo);
		} catch (SQLException e) {
			roomNo = "";
			e.printStackTrace();
		}
		return roomNo;
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
	

}
