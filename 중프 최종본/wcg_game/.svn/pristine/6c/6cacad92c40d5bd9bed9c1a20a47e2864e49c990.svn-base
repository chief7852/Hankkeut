package friend.dao;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.FriendTargetVO;
import vo.FriendVO;

public class FriendDaoImpl implements IFriendDao {
	
	private SqlMapClient client;
	private static IFriendDao dao;
	
	private FriendDaoImpl () {
		client = SqlMapClientFactory.getClient();
	}
	public static IFriendDao getDao() {
		if(dao == null) dao = new FriendDaoImpl();
		return dao;
	}
	// 친구 존재 유무
	@Override
	public FriendVO selectByfriend(String memId, String friendId) {
		Map<String, String> map = new HashMap<>();
		map.put("memId", memId);
		map.put("friendId", friendId);
		
		FriendVO friend = null;
		try {
			friend = (FriendVO) client.queryForObject("friend.selectByfriend", map);
		} catch (SQLException e) {
			friend = null;
			e.printStackTrace();
		}
		return friend;
	}
	
	// 친구 대기 방에 저장
	@Override
	public int insertTarget(String memId, String friendId) {
		Map<String, String> map = new HashMap<>();
		map.put("memId", memId);
		map.put("friendId", friendId);
		
		int cnt = 0;
		Object isInsert = null;
		
		try {
			isInsert = client.insert("friend.insertTarget", map);
			if(isInsert == null) cnt = 1;
			else cnt = 0;
		} catch (SQLException e) {
			cnt = 0;
			isInsert = null;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public List<FriendTargetVO> selectTarget(String memId) {
		List<FriendTargetVO> ftvo = null;
		
		try {
			ftvo = client.queryForList("friend.selectTarget", memId);
		} catch (SQLException e) {
			ftvo = null;
			e.printStackTrace();
		}
		
		return ftvo;
	}
	@Override
	public int insertFriend(String memId, String friendId) {
		Map<String, String> map = new HashMap<>();
		map.put("memId", memId);
		map.put("friendId", friendId);
		
		int cnt = 0; Object isInsert = null;
		try {
			isInsert = client.insert("friend.insertFriend", map);
			if(isInsert == null) cnt = 1;
			else cnt = 0;
		} catch (SQLException e) {
			cnt = 0; isInsert = null;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public int updateFriendStatue(String memId, String friendId) {
		Map<String, String> map = new HashMap<>();
		map.put("memId", memId);
		map.put("friendId", friendId);
		int cnt = 0;
		try {
			cnt = client.update("friend.updateFriendStatue", map);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public int deleteTarget(String memId, String friendId) {
		Map<String, String> map = new HashMap<>();
		map.put("memId", memId);
		map.put("friendId", friendId);
		int cnt = 0;
		try {
			cnt = client.update("friend.deleteTarget", map);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public List<FriendVO> selectFriend(String memId) {
		List<FriendVO> friendvo = null;
		try {
			friendvo = client.queryForList("friend.selectFriend", memId);
			System.out.println("impl " + friendvo.size());
		} catch (SQLException e) {
			friendvo = null;
			e.printStackTrace();
		}
		return friendvo;
	}
	@Override
	public int insertFriend2(String memId, String friendId) {
		Map<String, String> map = new HashMap<>();
		map.put("memId", memId);
		map.put("friendId", friendId);
		
		int cnt = 0; Object isInsert = null;
		try {
			isInsert = client.insert("friend.insertFriend2", map);
			if(isInsert == null) cnt = 1;
			else cnt = 0;
		} catch (SQLException e) {
			cnt = 0; isInsert = null;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public int deleteFriend(String meNickName, String nickName) {
		Map<String, String> map = new HashMap<>();
		map.put("memId", meNickName);
		map.put("friendId", nickName);
		int cnt = 0;
		try {
			cnt = client.delete("friend.deleteFriend", map);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public int deleteFriend2(String nickName, String meNickName) {
		Map<String, String> map = new HashMap<>();
		map.put("memId", meNickName);
		map.put("friendId", nickName);
		int cnt = 0;
		try {
			cnt = client.delete("friend.deleteFriend2", map);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	
	

}
