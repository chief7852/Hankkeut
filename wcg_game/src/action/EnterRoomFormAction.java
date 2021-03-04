package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.service.IRoomService;
import room.service.RoomServiceImpl;
import vo.RoomVO;
import web.IAction;

public class EnterRoomFormAction implements IAction {

	@Override
	public boolean isRedirect() {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int roomNo = Integer.parseInt(req.getParameter("room_vo"));
		
		IRoomService service = RoomServiceImpl.getService();
		
		RoomVO roomvo = service.roomEnter(roomNo);
		System.out.println("roomVo : " + roomvo.getRoom_no());
		req.setAttribute("roomVo", roomvo);
		
		return "/game/gameRoom.jsp";
	}

}
