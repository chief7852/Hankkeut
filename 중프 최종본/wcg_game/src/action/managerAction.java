package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.service.IMemberService;
import common.service.MemberServiceImpl;
import vo.EventBoardVO;
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
		List<MemberVO> vo = service.memRemoveList();
		
		
		req.setAttribute("list", vo);
		//System.out.println("어드민 영구 정지 "+vo);
		return "/admin/manager.jsp";
	}

}
