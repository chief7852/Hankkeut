package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.FreeServiceImpl;
import board.service.IFreeService;
import board.service.INoticeService;
import board.service.NoticeServiceImpl;
import vo.freeBoardVO;
import vo.noticeBoardVO;
import web.IAction;

public class FreeUpdateAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		freeBoardVO vo = new freeBoardVO();
		vo.setF_board_no(Integer.parseInt(req.getParameter("n_board_num")));
		vo.setF_board_title(req.getParameter("n_board_title"));
		vo.setF_board_contents(req.getParameter("n_board_contents"));
		
		
		
		IFreeService service = FreeServiceImpl.getService();
		service.updateBoard(vo);
		
		
		
		return "/free/freeList.ddit";
	}

}
