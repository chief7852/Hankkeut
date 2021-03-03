package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.FreeServiceImpl;
import board.service.IFreeService;
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
		System.out.println(boardNum+"전혀섭 지존짱");
		IFreeService service = FreeServiceImpl.getService();
		service.updateViews(boardNum);
		
		freeBoardVO boardVO = service.selectBoard(boardNum);
		System.out.println(boardVO+"wjsgudtjq");
		
		req.setAttribute("boardNum", boardVO);
		return "/freeboard/freeBoardForm.jsp";
	}
	
}
