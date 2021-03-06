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
 * Servlet implementation class EnterRoom
 */
@WebServlet("/enterRoom.do")
public class EnterRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
//		System.out.println("EnterRoom.servlet 입장");
		
		int roomNo = Integer.parseInt(request.getParameter("room_vo"));
		
//		System.out.println("EnterRoom roomNo : " + roomNo);
		IRoomService service = RoomServiceImpl.getService();
		RoomVO roomvo = (RoomVO) service.roomEnter(roomNo);
		
		System.out.println("EnterRoom RoomVO : " + roomvo.getRoom_no() + ", " + roomvo.getRoom_host());
		request.setAttribute("hostRoomInfo", roomvo);
		
		//response.sendRedirect(request.getContextPath() + "game/gameRoom.jsp");
		//request.getRequestDispatcher("WEB-INF/view/game/gameRoom.jsp").forward(request, response);
		request.getRequestDispatcher("WEB-INF/view/game/gameRoom.jsp").forward(request, response);
	}

}
