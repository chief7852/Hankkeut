package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.INoticeService;
import board.service.NoticeServiceImpl;
import vo.noticeBoardVO;
import web.IAction;

public class BoardFormAction implements IAction{

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		
		INoticeService service = NoticeServiceImpl.getService();
		service.updateViews(boardNum);
		
		noticeBoardVO boardVo =  service.selectBoard(boardNum);
		
		req.setAttribute("boardVo", boardVo);
		
		return "/board/boardForm.jsp";
	}

}
