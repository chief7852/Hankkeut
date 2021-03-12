package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.FreeServiceImpl;
import board.service.IFreeService;
import web.IAction;

public class FreeDeleteReplyAction implements IAction {

	@Override
	public boolean isRedirect() {
		
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int conum = Integer.parseInt(req.getParameter("renum"));
		System.out.println("renum"+conum);
		IFreeService service = FreeServiceImpl.getService();
		
		int delete=service.deleteReply(conum);
		req.setAttribute("boardStatus", delete);
		System.out.println("삭제좀하자 " +delete);
		return "/freeboard/result.jsp";
	}

}
