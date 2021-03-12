package friend.service;

import java.sql.SQLException;
import java.util.List;

import common.dao.IMemberDao;
import common.dao.MemberDaoImpl;
import friend.dao.FriendDaoImpl;
import friend.dao.IFriendDao;
import vo.FriendTargetVO;
import vo.FriendVO;
import vo.MemberVO;
import vo.noticeBoardVO;

public class FriendServiceImpl implements IFriendService {
	private static IFriendService service = null;

	private IFriendDao dao;

	private FriendServiceImpl() {
		dao = FriendDaoImpl.getDao();
	}

	public static IFriendService getService() {
		if (service == null)
			service = new FriendServiceImpl();
		return service;
	}

	@Override
	public FriendVO selectByfriend(String memId, String friendId) {
		return dao.selectByfriend(memId, friendId);
	}

	@Override
	public int insertTarget(String memId, String friendId) {
		return dao.insertTarget(memId, friendId);
	}

	@Override
	public List<FriendTargetVO> selectTarget(String memId) {
		return dao.selectTarget(memId);
	}

	@Override
	public int insertFriend(String memId, String friendId) {
		return dao.insertFriend(memId, friendId);
	}

	@Override
	public int updateFriendStatue(String memId, String friendId) {
		return dao.updateFriendStatue(memId, friendId);
	}

	@Override
	public int deleteTarget(String memId, String friendId) {
		return dao.deleteTarget(memId, friendId);
	}

	@Override
	public List<FriendVO> selectFriend(String memId) {
		return dao.selectFriend(memId);
	}

	@Override
	public int insertFriend2(String memId, String friendId) {
		return dao.insertFriend2(memId, friendId);
	}

	@Override
	public int deleteFriend(String meNickName, String nickName) {
		return dao.deleteFriend(meNickName, nickName);
	}

	@Override
	public int deleteFriend2(String nickName, String meNickName) {
		return dao.deleteFriend2(nickName, meNickName);
	}

	

}
