package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.FreeServiceImpl;
import board.service.IFreeService;
import vo.CommentVO;
import web.IAction;

public class FreeReplyListAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session= req.getSession();
		String userid = (String) session.getAttribute("userid");
		CommentVO vo = new CommentVO();
		String board_no =  req.getParameter("board_no");
		System.out.println(board_no);
		
		vo.setMem_id(userid);
		IFreeService service = FreeServiceImpl.getService();
		List<CommentVO> commentvo = service.listReply(board_no);
		
		
		req.setAttribute("reply", commentvo);
		return "/freeboard/freeReplyForm.jsp";
	}

}
