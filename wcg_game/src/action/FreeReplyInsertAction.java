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
		req.setCharacterEncoding("utf-8");
		
		CommentVO vo = new CommentVO();
		String board_no = req.getParameter("board_no");
		vo.setBoard_no(board_no);
		vo.setCo_contents(req.getParameter("f_reply_contents"));
		
		
		
		
		IFreeService service = FreeServiceImpl.getService();
		
		int cnt =service.insertReply(vo);
		
		
		return "/free/freeForm.ddit?boardNum="+board_no;
	}

}
