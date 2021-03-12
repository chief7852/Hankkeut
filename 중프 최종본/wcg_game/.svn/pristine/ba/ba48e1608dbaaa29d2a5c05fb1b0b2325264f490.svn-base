package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import character_2.service.copy.CharacterServiceImpl;
import character_2.service.copy.ICharacterService;
import friend.service.FriendServiceImpl;
import friend.service.IFriendService;
import vo.CharVO;
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
		ICharacterService cService = CharacterServiceImpl.getService();
		CharVO charvo = cService.selectChar(memId);
		// Allow true 로 변경
		service.updateFriendStatue(charvo.getChar_nickname(), friendId);
		
		// friend db에 저장 
		// A 친구가 B 친구에게 걸었을 시 
		// B -> A
		service.insertFriend(charvo.getChar_nickname(), friendId);
		
		// freind db에 저장
		// A -> B
		service.insertFriend2(friendId, charvo.getChar_nickname());
		
		// target 데이터 삭제
		service.deleteTarget(charvo.getChar_nickname(), friendId);
		
		return "/WaitingGame/main.jsp";
	}

}
