package room.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import character_2.service.copy.CharacterServiceImpl;
import character_2.service.copy.ICharacterService;
import room.service.IRoomService;
import room.service.RoomServiceImpl;
import vo.CharVO;
import vo.RoomVO;

/**
 * Servlet implementation class InsertRoom
 */
@WebServlet("/insertRoom.do")
public class InsertRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		IRoomService service = RoomServiceImpl.getService();
		ICharacterService service2 = CharacterServiceImpl.getService();
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userid");
		System.out.println("==============================================");
		System.out.println(userId);
		CharVO charvo = service2.selectChar(userId);
		
		RoomVO roomvo = new RoomVO();
		System.out.println(charvo.getChar_nickname());
		roomvo.setNickname(charvo.getChar_nickname());
		try {
			BeanUtils.populate(roomvo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//service.insertRoom(roomvo);
		//int result = service.insertRoom(roomvo);
		//request.setAttribute("result", result);
		
		//request.getRequestDispatcher("WEB-INF/view/game/RoomState.jsp").forward(request, response);
		request.getRequestDispatcher("/room/waitingRoom.ddit").forward(request, response);
		
	}

}
