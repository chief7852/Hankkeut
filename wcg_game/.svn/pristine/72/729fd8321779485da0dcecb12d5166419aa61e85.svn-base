package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.service.IMemberService;
import common.service.MemberServiceImpl;
import friend.service.FriendServiceImpl;
import friend.service.IFriendService;
import vo.FriendVO;
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
		System.out.println("InsertFriendAction ?");
		String friendId = req.getParameter("userId");
		
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userid");
		
		IMemberService service = MemberServiceImpl.getService();
		IFriendService fService = FriendServiceImpl.getService();
		
		String isMemId = service.selectById(friendId);
		
		System.out.println("InsertFriend isMemId : " + isMemId);
		if(isMemId == null) {	// 존재하지 않는 회원
			return "/WaitingGame/main.jsp";
		} else {
			//System.out.println("InsertFriend : " + userId + ", " + friendId);
			FriendVO friendvo = fService.selectByfriend(userId, friendId);
			//System.out.println("InsertFriend friendvo : " + friendvo);
			if(friendvo != null) { // 이미 친추 된 회원
				return "/WaitingGame/main.jsp";
			} else {
				//System.out.println("friendvo == null?");
				fService.insertTarget(userId, friendId);
			}
		}
			
		return "/WaitingGame/main.jsp";
	}

}
