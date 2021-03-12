package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.EventServiceImpl;
import board.service.IEventService;
import web.IAction;

public class EventDeleteAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int boardNum = Integer.parseInt(req.getParameter("boardNum").trim());
		
		System.out.println("딜리트 악션 "+boardNum);
		IEventService service = EventServiceImpl.getService();
		service.deleteEvent(boardNum);
		
		return "/event/eventList.ddit";
	}

}
