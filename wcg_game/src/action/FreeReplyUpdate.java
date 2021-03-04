package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.FreeServiceImpl;
import board.service.IFreeService;
import vo.CommentVO;
import vo.freeBoardVO;
import web.IAction;

public class FreeReplyUpdate implements IAction {

	@Override
	public boolean isRedirect() {
		
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CommentVO vo = new CommentVO();
		
		vo.setCo_contents(req.getParameter("cont"));
		vo.setCo_no(Integer.parseInt(req.getParameter("renum")));
		
		IFreeService sevice = FreeServiceImpl.getService();
	
		
		
		return null;
	}

}
