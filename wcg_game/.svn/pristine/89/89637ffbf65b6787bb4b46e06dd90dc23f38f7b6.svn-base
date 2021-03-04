package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.EventServiceImpl;
import board.service.IEventService;
import vo.EventBoardVO;
import web.IAction;

public class EventInsertAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EventBoardVO vo = new EventBoardVO();
		
		vo.setE_board_title(req.getParameter("e_board_title"));
		vo.setE_board_img(req.getParameter("e_board_email"));
		vo.setE_board_contents(req.getParameter("i_board_contents"));
		
		IEventService service = EventServiceImpl.getService(); 
		int cnt=service.insertEvent(vo);
		
		
		return "/event/eventList.ddit";
	}

}
