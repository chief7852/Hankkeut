package room.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.service.IRoomService;
import room.service.RoomServiceImpl;
import vo.RoomVO;

/**
 * Servlet implementation class PwCheck
 */
@WebServlet("/pwCheck.do")
public class PwCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int roomNo = Integer.parseInt(request.getParameter("room_vo"));
		//String check = req.getParameter("check");
		
		IRoomService service = RoomServiceImpl.getService();
		RoomVO roomvo = (RoomVO) service.roomEnter(roomNo);

		request.setAttribute("hostRoomInfo", roomvo);
		
		request.getRequestDispatcher("WEB-INF/view/game/pwCheck.jsp").forward(request, response);
	}

}
