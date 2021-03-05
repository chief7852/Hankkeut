package action;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import character_2.service.copy.CharacterServiceImpl;
import character_2.service.copy.ICharacterService;
import vo.CharVO;
import web.IAction;

public class IsLoginAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 되어 있는가
//		IMemberService memService = MemberServiceImpl.getService();
//		List<MemberVO> memList = memService.guestList();
		req.setCharacterEncoding("utf-8");
		
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userid");
		if(userId == "" || userId == null) {	// 비회원
			
			ICharacterService charService = CharacterServiceImpl.getService();
			List<CharVO> charList = charService.isOn();
			
			Random r = new Random();
			int i = (int)(r.nextInt(charList.size()) + 1);
			
			CharVO charvo = null;
			for(int j=0; j<charList.size(); j++) {
				if(j == (i-1)) {
					charvo = charList.get(j);
					break;
				}
			}
			session.setAttribute("userid", charvo.getMem_id());
		}
		return "/login/isNickName.ddit";
	}

}
