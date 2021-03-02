
package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.FreeServiceImpl;
import board.service.IFreeService;
import vo.freeBoardVO;
import web.IAction;

public class FreeInsertAction implements IAction {

	@Override
	public boolean isRedirect() { // TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		freeBoardVO vo = new freeBoardVO();
		vo.setF_board_title(req.getParameter("n_board_title"));
		vo.setF_board_contents(req.getParameter("n_board_contents"));
		String admin = "admin";
		vo.setMem_id(admin);
		

		IFreeService service = FreeServiceImpl.getService();

		int cnt = service.insertBoard(vo);
		return "/free/freeList.ddit";
	}

}
