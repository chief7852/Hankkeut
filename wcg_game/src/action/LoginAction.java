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
import manager.service.IManagerService;
import manager.service.ManagerServiceImpl;
import vo.CharVO;
import vo.ManagerVO;
import vo.MemberVO;
import web.IAction;

public class LoginAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		// 관리자 로그인인지 일반회원 로그인이지 유무 확인을 위해 파라미터 값을 받아옴
		
		String userId = req.getParameter("mem_id");
		String pass = req.getParameter("mem_pass");
		// 세션 객체 생성
		HttpSession session = req.getSession();
		
		// 아이디나 비밀번호가 입력 되어 있지 않을 경우
		if(userId == null || userId == "" || pass == null || pass == "") {
			return "/home_sign/login.html";
		}
		// 회원 객체 생성
		MemberVO memVo = new MemberVO();
		IMemberService service = MemberServiceImpl.getService();
		
		// 매니저 객체 생성
		ManagerVO managerVo = new ManagerVO();
		IManagerService manService = ManagerServiceImpl.getService();
		
		String user = "";
		try {
			if(userId.equals("admin")) {	// 접속자가 관리자인가
				managerVo.setManager_id(userId);
				managerVo.setManager_pass(pass);
				
				user = manService.comparison(managerVo);
				if(user == null) {
					req.setAttribute("error", false);
					return "/home_sign/login.html";
				}
			} else {	// 회원인가
				memVo.setMem_id(userId);
				memVo.setMem_pass(pass);
				
				user = service.loginMember(memVo);
				
				if(user == null) {
					req.setAttribute("error", false);
					return "/home_sign/login.html";
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 세션에 로그인 정보 저장
		session.setAttribute("userid", user);
		
		ICharacterService charService = CharacterServiceImpl.getService();
		CharVO charvo =  charService.selectChar(user);
		if(charvo == null) {	// 신생 유저
			session.setAttribute("isChar", false);
		} else {
			session.setAttribute("isChar", true);
		}
		
		return "/index.ddit";
	}

}
