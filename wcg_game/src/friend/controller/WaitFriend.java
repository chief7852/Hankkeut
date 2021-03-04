package friend.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import friend.service.FriendServiceImpl;
import friend.service.IFriendService;
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
		
		IFriendService service = FriendServiceImpl.getService();
		
		List<FriendTargetVO> ftvo = service.selectTarget(userId);
		if(ftvo != null) {
			request.setAttribute("ftvo", ftvo);
			request.getRequestDispatcher("WEB-INF/view/game/waitFriend.jsp").forward(request, response);
		}
	}
}
