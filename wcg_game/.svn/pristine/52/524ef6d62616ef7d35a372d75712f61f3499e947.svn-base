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
import vo.FriendVO;

/**
 * Servlet implementation class FriendList
 */
@WebServlet("/friendList.do")
public class FriendList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		System.out.println("Servlet???");
		HttpSession session = request.getSession();

		String userId = (String) session.getAttribute("userid");
//		System.out.println("userId : " + userId);
		IFriendService service = FriendServiceImpl.getService();
		
		List<FriendVO> friendvo = service.selectFriend(userId);
//		System.out.println("friendvo : " + friendvo);
		
		request.setAttribute("friendvo", friendvo);
		request.getRequestDispatcher("WEB-INF/view/game/friendList.jsp").forward(request, response);
		
	}

}
