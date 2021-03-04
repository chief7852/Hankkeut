package action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import room.service.IRoomService;
import room.service.RoomServiceImpl;
import vo.RoomVO;
import web.IAction;

public class GameRoomFormAction implements IAction {

	@Override
	public boolean isRedirect() {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String hostIp = (String) req.getAttribute("hostIP");
		System.out.println("GameRoomFormAction hostIp : " + hostIp);
		IRoomService service = RoomServiceImpl.getService();
		
		//service.isRoom(vo)
		return "/game/insertRoomInfo.jsp";
	}

}
