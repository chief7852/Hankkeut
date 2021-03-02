package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.service.IRoomService;
import room.service.RoomServiceImpl;
import vo.RoomVO;
import web.IAction;

public class waitingRoomFormAction implements IAction {

	@Override
	public boolean isRedirect() {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		System.out.println("대기실 Action 실행? ");
		
//		IRoomService service = RoomServiceImpl.getService();
//		List<RoomVO> roomList = service.selectAllRoom();
//		System.out.println("WaitingRoomFormAction roomList : " + roomList);
//		req.setAttribute("roomList", roomList);
		return "/game/gameRoom.jsp";
	}

}
