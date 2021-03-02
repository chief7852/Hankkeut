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
<<<<<<< HEAD
		/*
		 * // 콜백 응답에서 state 파라미터의 값을 가져옴 String state = req.getParameter("state");
		 * 
		 * HttpSession session = req.getSession(); // 세션 또는 별도의 저장 공간에서 상태 토큰을 가져옴
		 * String storedState = (String) session.getAttribute("state"); if(
		 * !state.equals(storedState)) { session.invalidate(); return
		 * "/login/naverlogin.ddit"; } else { //String access_token = String toten =
		 * (String) session.getAttribute("state"); } return "/login/callback.jsp";
		 */
=======
		req.setCharacterEncoding("UTF-8");
		System.out.println("???");
		// 세션 호출
		HttpSession session = req.getSession();
		
		// 세션 값 읽어오기
		String userId = (String) session.getAttribute("userid");
		req.setAttribute("userid", userId);
>>>>>>> d2cc2fc (1. 인벤토리 소스 수정)
		return "/index.jsp";
	}

}
