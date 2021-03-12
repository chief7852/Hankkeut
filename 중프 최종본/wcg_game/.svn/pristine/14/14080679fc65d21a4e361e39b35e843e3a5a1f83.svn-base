package friend.service;

import java.sql.SQLException;
import java.util.List;

import vo.FriendTargetVO;
import vo.FriendVO;
import vo.MemberVO;
import vo.noticeBoardVO;

public interface IFriendService {
	// 친구 창에 해당 유저가 존재하는지 유무
	public FriendVO selectByfriend(String memId, String friendId);
	
	// 친구창에 존재 하지 않는다면 해당 친구를 target 테이블에 저장
	public int insertTarget(String memId, String friendId);
	
	// friend_target 창에 데이터가 있는지 확인
	public List<FriendTargetVO> selectTarget(String memId);
	
	// 친구 수락 눌렀을 경우
	public int insertFriend(String memId, String friendId);
	public int insertFriend2(String memId, String friendId);
	
	// 친구 수락 상태 업데이트
	public int updateFriendStatue(String memId, String friendId);
	
	// 친구 수락 된 경우 타겟 데이터 삭제
	public int deleteTarget(String memId, String friendId);
	
	// 친구 전체 출력
	public List<FriendVO> selectFriend(String memId);
	
	// 친구 삭제
	public int deleteFriend(String meNickName, String nickName);
	
	// 친구 삭제2
	public int deleteFriend2(String nickName, String meNickName);
}
