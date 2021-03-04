package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import friend.service.FriendServiceImpl;
import friend.service.IFriendService;
import web.IAction;

public class AcceptFriendAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String friendId = req.getParameter("mem_id");
		HttpSession session = req.getSession();
		String memId = (String) session.getAttribute("userid");
		
		IFriendService service = FriendServiceImpl.getService();
		
		// Allow true 로 변경
		service.updateFriendStatue(memId, friendId);
		
		// friend db에 저장 
		// A 친구가 B 친구에게 걸었을 시 
		// B -> A
		service.insertFriend(memId, friendId);
		
		// freind db에 저장
		// A -> B
		service.insertFriend2(friendId, memId);
		
		// target 데이터 삭제
		service.deleteTarget(memId, friendId);
		
		return "/WaitingGame/main.jsp";
	}

}
