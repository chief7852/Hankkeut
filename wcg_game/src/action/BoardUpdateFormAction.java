package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.INoticeService;
import board.service.NoticeServiceImpl;
import vo.noticeBoardVO;
import web.IAction;

public class BoardUpdateFormAction implements IAction {

	@Override
	public boolean isRedirect() {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		INoticeService service = NoticeServiceImpl.getService();
		
		int boardNum = Integer.parseInt(req.getParameter("boardNum")); 
		
		noticeBoardVO boardVo = service.selectBoard(boardNum);
		
		req.setAttribute("boardVo", boardVo);
		
		return "/board/boardUpdateForm.jsp";
	}

}
