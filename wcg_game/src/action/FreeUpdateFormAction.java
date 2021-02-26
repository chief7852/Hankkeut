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

public class FreeUpdateFormAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IFreeService service = FreeServiceImpl.getService();
		
		int boardNum = Integer.parseInt(req.getParameter("boardNum")); 
		
		freeBoardVO boardVo = service.selectBoard(boardNum);
		
		req.setAttribute("boardVo", boardVo);
		
		return "/freeboard/freeUpdateForm.jsp";
		
	}

}
