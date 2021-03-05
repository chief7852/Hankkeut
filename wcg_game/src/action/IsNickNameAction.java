package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import character_2.service.copy.CharacterServiceImpl;
import character_2.service.copy.ICharacterService;
import vo.CharVO;
import web.IAction;

public class IsNickNameAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userid");
		
		ICharacterService service = CharacterServiceImpl.getService();
		CharVO charvo = service.selectChar(userId);
		if(charvo == null) {
			service.onChar(userId);
			return "/WaitingGame/createNickName.jsp";
		}
		service.onChar(userId);
		return "/WaitingGame/main.jsp";
	}

}
