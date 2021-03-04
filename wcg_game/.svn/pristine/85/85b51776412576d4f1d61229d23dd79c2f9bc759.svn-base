package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import friend.service.FriendServiceImpl;
import friend.service.IFriendService;
import vo.FriendTargetVO;
import web.IAction;

public class WaitFriendAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//System.out.println("WaitFriendAction?");
		
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userid");
		
		IFriendService service = FriendServiceImpl.getService();
		
		List<FriendTargetVO> ftvo = service.selectTarget(userId);
		if(ftvo == null) {
			return "/WaitingGame/main.jsp";
		} else {
			req.setAttribute("ftvo", ftvo);
		}
		return "/game/waitingRoom.jsp";
	}

}
