package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.FreeServiceImpl;
import board.service.IFreeService;
import board.service.IInquiryService;
import board.service.InquiryServiceImpl;
import vo.InquiryBoardVO;
import vo.freeBoardVO;
import web.IAction;

public class inquiryInsertAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String userid = (String) session.getAttribute("userid");
		InquiryBoardVO vo = new InquiryBoardVO();
		
		vo.setI_board_title(req.getParameter("n_board_title"));
		vo.setI_board_contents(req.getParameter("n_board_contents"));
		vo.setI_board_pass(req.getParameter("n_board_pass"));
		//String admin = "admin";
		vo.setMem_id(userid);
		

		IInquiryService service = InquiryServiceImpl.getService();

		int cnt = service.insertBoard(vo);
		return "/inquiry/inquiryList.ddit";
	}

}
