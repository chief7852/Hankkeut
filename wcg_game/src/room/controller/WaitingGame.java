package room.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.service.IRoomService;
import room.service.RoomServiceImpl;
import vo.RoomVO;

/**
 * Servlet implementation class WaitingGame
 */
@WebServlet("/waitingGame.do")
public class WaitingGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		IRoomService service = RoomServiceImpl.getService();
		
		List<RoomVO> roomList =  service.selectAllRoom();
		request.setAttribute("roomList", roomList);
		
		request.getRequestDispatcher("WEB-INF/view/game/waitingRoom.jsp").forward(request, response);
	}

}
