package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.EventServiceImpl;
import board.service.IEventService;
import vo.EventBoardVO;
import web.IAction;

public class EventFormAction implements IAction {

	@Override
	public boolean isRedirect() {
		
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int boardNum =Integer.parseInt( req.getParameter("boardNum"));
		
		IEventService service = EventServiceImpl.getService();
		service.updateViews(boardNum);
		System.out.println(boardNum+"이벤트 보어드악션에 넘어온 번호");
		EventBoardVO eventboardvo = service.selectEvent(boardNum);
		System.out.println(eventboardvo+"이벤트 보어드 폼 악션");
		req.setAttribute("eventBoard", eventboardvo);
		
		return "/event/eventBoardForm.jsp";
	}

}
