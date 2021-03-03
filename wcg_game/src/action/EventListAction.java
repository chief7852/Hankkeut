package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.IEventDao;
import board.service.EventServiceImpl;
import board.service.IEventService;
import vo.EventBoardVO;
import web.IAction;

public class EventListAction implements IAction {

	@Override
	public boolean isRedirect() {
		
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("$$$$$gkdl");
		IEventService service = EventServiceImpl.getService();

		List<EventBoardVO> eventList =service.selectAll();
		System.out.println(eventList+"action에서 받나요 ?");
		req.setAttribute("eventlist", eventList);
		
		
		return "/event/eventList.jsp";
	}

}
