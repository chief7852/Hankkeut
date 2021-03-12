package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.service.IMemberService;
import common.service.MemberServiceImpl;
import vo.MemberVO;
import web.IAction;

public class managerDeleteAction implements IAction {

	@Override
	public boolean isRedirect() {
		
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memid=req.getParameter("mem_id");
		IMemberService service = MemberServiceImpl.getService();
		service.deleteMember2(memid);
		return "/admin/manager.ddit";
	}

}
