package action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.Inet4Address;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import room.service.IRoomService;
import room.service.RoomServiceImpl;
import vo.RoomVO;
import web.IAction;

public class waitingRoomFormAction implements IAction {

	@Override
	public boolean isRedirect() {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//String ip = req.getRemoteAddr();	// 접속한 IP주소
		String ip = Inet4Address.getLocalHost().getHostAddress();
		
		IRoomService service = RoomServiceImpl.getService();
		RoomVO roomvo = new RoomVO();
		roomvo.setRoom_host(ip);
		try {
			BeanUtils.populate(roomvo, req.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		int cnt = service.isRoom(roomvo);
		// 중복 확인 다시 해야함
		if(cnt >= 1) {	// 해당 방장 ip를 가진 룸이 존재 하지 않을 경우 방 생성
			return "/WaitingGame/main.jsp";
		}
		//System.out.println("WaitingRoomFormAction roomList : " + roomList);
		
		// 방 생성
		service.insertRoom(roomvo);
		
		// 생성 된 방 roomID 호출
		
//		int roomNo = roomvo.getRoom_no();
//		//System.out.println("roomNO ++ " roo);
//		RoomVO roomVo = service.roomEnter(roomNo);
//		req.setAttribute("roomVo", roomVo);
		return "/game/gameRoom.ddit";
		
		
	}

}
