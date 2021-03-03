package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.IAction;

public class MainFormAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		System.out.println("???");
		// 세션 호출
		HttpSession session = req.getSession();
		
		// 세션 값 읽어오기
		String userId = (String) session.getAttribute("userid");
		req.setAttribute("userid", userId);
		return "/index.jsp";
	}

}
