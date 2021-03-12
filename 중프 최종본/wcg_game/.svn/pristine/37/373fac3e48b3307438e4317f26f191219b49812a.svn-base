package friend.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import friend.service.FriendServiceImpl;
import friend.service.IFriendService;

/**
 * Servlet implementation class FriendDelete
 */
@WebServlet("/friendDelete.do")
public class FriendDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("friendDelete.do");
		
		String nickName = request.getParameter("friend_id");
		String meNickName = request.getParameter("mem_id");
		IFriendService service = FriendServiceImpl.getService();
		
		int cnt = service.deleteFriend(meNickName, nickName);
		int cnt2 = service.deleteFriend2(nickName, meNickName);
		
		request.setAttribute("result1", cnt);
		request.setAttribute("result2", cnt2);
		
		request.setAttribute("result", "result");
		request.getRequestDispatcher("WEB-INF/view/character/deleteFriend.jsp").forward(request, response);
		//response.sendRedirect("/wcggame/WaitingGame/main.jsp");
		//request.getRequestDispatcher("WEB-INF/view/waitingGame/main.jsp").forward(request, response);
	}

}
