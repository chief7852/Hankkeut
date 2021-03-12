package room.service;

import java.sql.SQLException;
import java.util.List;

import com.sun.security.ntlm.Client;

import common.dao.IMemberDao;
import common.dao.MemberDaoImpl;
import manager.dao.IManagerDao;
import manager.dao.ManagerDaoImpl;
import room.dao.IRoomDao;
import room.dao.RoomDaoImpl;
import vo.ManagerVO;
import vo.MemberVO;
import vo.RoomVO;
import vo.noticeBoardVO;

public class RoomServiceImpl implements IRoomService {
	private static IRoomService service = null;

	private IRoomDao dao;

	private RoomServiceImpl() {
		dao = RoomDaoImpl.getDao();
	}

	public static IRoomService getService() {
		if (service == null)
			service = new RoomServiceImpl();
		return service;
	}

	@Override
	public int insertRoom(RoomVO vo) {
		return dao.insertRoom(vo);
	}

	@Override
	public List<RoomVO> selectAllRoom() {
		return dao.selectAllRoom();
	}

	@Override
	// 방 호스트 생성 유무
	public RoomVO isRoom(String hostIp) {
		return dao.isRoom(hostIp);
	}

	@Override
	public RoomVO roomEnter(int room_vo) {
		return dao.roomEnter(room_vo);
	}

	@Override
	public void deleteRoom(String nickname) {
		dao.deleteRoom(nickname);
	}

	@Override
	public int selectRoom(String nickname) {
		return dao.selectRoom(nickname);
	}

	@Override
	public String isPass(int room_vo) {
		return dao.isPass(room_vo);
	}

	@Override
	public int updateCnt(RoomVO roomvo) {
		return dao.updateCnt(roomvo);
	}


}
