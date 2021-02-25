package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.INoticeService;
import board.service.NoticeServiceImpl;
import web.IAction;

public class BoardDeleteAction implements IAction {

	@Override
	public boolean isRedirect() {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		INoticeService service = NoticeServiceImpl.getService();
		
		service.deleteBoard(boardNum);
		return "/notice/boardList.ddit";
	}

}
