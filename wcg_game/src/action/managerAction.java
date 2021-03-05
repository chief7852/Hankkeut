package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.service.IMemberService;
import common.service.MemberServiceImpl;
import vo.MemberVO;
import web.IAction;

public class managerAction implements IAction {

	@Override
	public boolean isRedirect() {
		
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IMemberService service = MemberServiceImpl.getService();
		MemberVO vo =(MemberVO) service.memRemoveList();
		
		req.setAttribute("list", vo);
		
		return "/admin/manager.jsp";
	}

}
