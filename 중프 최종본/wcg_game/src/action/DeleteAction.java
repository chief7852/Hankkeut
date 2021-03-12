package action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import character_2.service.copy.CharacterServiceImpl;
import character_2.service.copy.ICharacterService;
import common.service.IMemberService;
import common.service.MemberServiceImpl;
import preference.service.IPreferenceService;
import preference.service.preferenceServiceImpl;
import vo.MemberVO;
import web.IAction;

public class DeleteAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		MemberVO memvo = new MemberVO();
		IMemberService service = MemberServiceImpl.getService();
		ICharacterService cService = CharacterServiceImpl.getService();
		IPreferenceService pService = preferenceServiceImpl.getService();
		
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
			cService.delChar(userId);
			pService.delPre(userId);
			session.invalidate();
		}
		return "/index.ddit";
	}

}
