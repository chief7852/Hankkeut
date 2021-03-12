package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import character_2.service.copy.CharacterServiceImpl;
import character_2.service.copy.ICharacterService;
import common.service.IMemberService;
import common.service.MemberServiceImpl;
import friend.service.FriendServiceImpl;
import friend.service.IFriendService;
import preference.service.IPreferenceService;
import preference.service.preferenceServiceImpl;
import vo.CharVO;
import vo.FriendVO;
import vo.preferenceVO;
import web.IAction;

public class InsertFriendAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//System.out.println("InsertFriendAction ?");
		String friendId = req.getParameter("userId");
		//System.out.println("FID : " + friendId);
		
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userid");
		
		IMemberService service = MemberServiceImpl.getService();
		IFriendService fService = FriendServiceImpl.getService();
		IPreferenceService pService = preferenceServiceImpl.getService();
		ICharacterService cService = CharacterServiceImpl.getService();
		
		CharVO userChar = cService.selectChar(userId);
		//service.selectById(friendId);
		CharVO isMemId = cService.selectchetChar(friendId);
		
		//System.out.println("InsertFriend isMemId : " + isMemId);
		if(isMemId == null) {	// 존재하지 않는 회원
			return "/WaitingGame/main.jsp";
		} else {
			//System.out.println("InsertFriend : " + userId + ", " + friendId);
			FriendVO friendvo = fService.selectByfriend(userChar.getChar_nickname(), friendId);
			
			//System.out.println("InsertFriend friendvo : " + friendvo);
			if(friendvo != null) { // 이미 친추 된 회원
				return "/WaitingGame/main.jsp";
			} else {
				//System.out.println("friendvo == null?");
				preferenceVO prevo = pService.isFriendMess(isMemId.getMem_id());
				String cnt = prevo.getFriend_mess();
				//System.out.println("cnt : " + cnt);
				if(cnt.equals("1")) {
					//System.out.println("cnt == 1?");
					fService.insertTarget(userChar.getChar_nickname(), friendId);
				} 
			}
		}
			
		return "/WaitingGame/main.jsp";
	}

}
