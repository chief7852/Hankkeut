package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import character_2.service.copy.CharacterServiceImpl;
import character_2.service.copy.ICharacterService;
import preference.service.IPreferenceService;
import preference.service.preferenceServiceImpl;
import vo.CharVO;
import web.IAction;

public class NickNameInsertAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		System.out.println("NickNameInsertAction");
		String charImg = req.getParameter("charImg");
		String nickName = req.getParameter("char_nickname");
		//System.out.println("NickName : " + charImg);
		
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userid");
		
		CharVO charvo = new CharVO();
		charvo.setMem_id(userId);
		charvo.setBase_img(charImg);
		
		ICharacterService service = CharacterServiceImpl.getService();
		
		IPreferenceService pService = preferenceServiceImpl.getService();
		CharVO isNick = service.selectchetChar(nickName);
		try {
			BeanUtils.populate(charvo, req.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		if(isNick == null) {
			service.insertChar(charvo);
			pService.insertPre(userId);
			service.onChar(userId);
		} else {
			return "/login/NickForm.ddit";
		}
		
		
		return "/WaitingGame/main.jsp";
	}

}
