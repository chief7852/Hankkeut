package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.INoticeService;
import board.service.NoticeServiceImpl;
import vo.noticeBoardVO;
import web.IAction;

public class BoardInsertAction implements IAction{

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		noticeBoardVO vo = new noticeBoardVO();
		vo.setN_board_title(req.getParameter("n_board_title"));
		vo.setN_board_contents(req.getParameter("n_board_contents"));
		String admin = "admin";
		vo.setManager_id(admin);
		
		INoticeService service = NoticeServiceImpl.getService();
		
		int cnt = service.insertBoard(vo);
		
		return "/notice/boardList.ddit";
	}

}
