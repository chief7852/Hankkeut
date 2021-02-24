package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.INoticeService;
import board.service.NoticeServiceImpl;
import vo.noticeBoardVO;
import web.IAction;

public class BoardListAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 실제 처리할 내용은 이곳에 기술하고
		// 처리가 끝난 후에 보여줄 View페이지를 반환하면 된다.
		
		INoticeService service = NoticeServiceImpl.getService();
		
		List<noticeBoardVO> boardList = service.selectAll();
		
		req.setAttribute("board", boardList);
		return "/board/boardList.jsp";
	}

}
