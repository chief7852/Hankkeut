package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.FreeServiceImpl;
import board.service.IFreeService;
import vo.CommentVO;
import web.IAction;

public class FreeReplyInsertAction implements IAction {

	@Override
	public boolean isRedirect() {
		
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		CommentVO vo = new CommentVO();
		vo.setCo_contents(req.getParameter("f_reply_contents"));
		vo.setBoard_no(req.getParameter("board_no"));
		vo.setCo_date(req.getParameter("co_date"));
		
		
		vo.setMem_id(req.getParameter("mem_id"));
		
		IFreeService service = FreeServiceImpl.getService();
		
		int cnt =service.insertReply(vo);
		
		
		return "/free/freeForm.ddit";
	}

}
