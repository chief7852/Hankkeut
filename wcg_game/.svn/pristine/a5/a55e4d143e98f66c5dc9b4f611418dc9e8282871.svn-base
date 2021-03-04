package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.FreeServiceImpl;
import board.service.IFreeService;
import vo.CommentVO;
import vo.freeBoardVO;
import web.IAction;

public class FreeFormAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		System.out.println(boardNum+"전형섭123");
		IFreeService service = FreeServiceImpl.getService();
		service.updateViews(boardNum);
		
		freeBoardVO boardVO = service.selectBoard(boardNum);
//		List<CommentVO> commentVO = service.listReply(boardNum);
		System.out.println(boardVO+"wjsgudtjq");
		//System.out.println(commentVO +"jhscommentvo");
		
		req.setAttribute("boardNum", boardVO);
		//req.setAttribute("listReply", commentVO);
		return "/freeboard/freeBoardForm.jsp";
	}
	
}
