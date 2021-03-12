package friend.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import character_2.service.copy.CharacterServiceImpl;
import character_2.service.copy.ICharacterService;
import friend.service.FriendServiceImpl;
import friend.service.IFriendService;
import vo.CharVO;
import vo.FriendTargetVO;

/**
 * Servlet implementation class WaitFriend
 */
@WebServlet("/waitFriend.do")
public class WaitFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//System.out.println("WaitFriendAction?");
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userid");
		
		ICharacterService cService = CharacterServiceImpl.getService();
		CharVO charvo = cService.selectChar(userId);
		
		IFriendService service = FriendServiceImpl.getService();
		
		
		List<FriendTargetVO> ftvo = service.selectTarget(charvo.getChar_nickname());
		if(ftvo != null) {
			request.setAttribute("ftvo", ftvo);
			request.getRequestDispatcher("WEB-INF/view/game/waitFriend.jsp").forward(request, response);
		}
	}
}
