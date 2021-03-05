package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.service.IRoomService;
import room.service.RoomServiceImpl;
import vo.RoomVO;
import web.IAction;

public class RoomFormAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		int roomNo = Integer.parseInt(req.getParameter("roomNo"));
		String check = req.getParameter("check");
		
		IRoomService service = RoomServiceImpl.getService();
		RoomVO roomvo = (RoomVO) service.roomEnter(roomNo);
		
		req.setAttribute("hostRoomInfo", roomvo);
		req.setAttribute("check", check);
		
		return "/game/gameRoom.jsp";
	}

}
