package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.FreeServiceImpl;
import board.service.IFreeService;
import board.service.INoticeService;
import board.service.NoticeServiceImpl;
import web.IAction;

public class FreeDeleteAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		IFreeService service = FreeServiceImpl.getService();
		
		service.deleteBoard(boardNum);
		return "/free/freeList.ddit";
	}

}
