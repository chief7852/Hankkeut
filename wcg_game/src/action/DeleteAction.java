package action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import common.service.IMemberService;
import common.service.MemberServiceImpl;
import vo.MemberVO;
import web.IAction;

public class DeleteAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		MemberVO memvo = new MemberVO();
		IMemberService service = MemberServiceImpl.getService();
		HttpSession session = req.getSession();
		
		String userId = (String) session.getAttribute("userid");
		memvo.setMem_id(userId);
		try {
			BeanUtils.populate(memvo, req.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(userId != null) {
			service.deleteMember(memvo);
			session.invalidate();
			session.setAttribute("reloadPage", true);
		}
		return "/index.ddit";
	}

}
