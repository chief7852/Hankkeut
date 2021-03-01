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

public class MyPageAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String curPass = req.getParameter("cur_pass");
		String cPass = req.getParameter("change_pass");
		String newPass= req.getParameter("new_pass");
		
		MemberVO memvo = new MemberVO();
		IMemberService service = MemberServiceImpl.getService();
		HttpSession session = req.getSession();	// 세션 객체 불러옴
		String userId = (String) session.getAttribute("userid");
		
		memvo.setMem_id(userId);
		try {
			BeanUtils.populate(memvo, req.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		if(userId != null) {
			// 비밀번호 수정
			if(memvo.getMem_pass() != null) {
				if(service.isPassWord(memvo) == 1) {	// 현재 비밀번호가 존재함
					if(newPass.equals(cPass)) {	// 새 비밀번호와 비밀번호 확인 데이터가 일치하면
						memvo.setMem_pass(cPass);
						service.updatePW(memvo);
					}
				}
			}
			// 주소 수정
			if(memvo.getMem_add1() != null || memvo.getMem_add2() != null || memvo.getZip_code() != null) {
				service.updateAddr(memvo);
			}
			 // 전화번호 수정
			if(memvo.getMem_hp() != null) {
				service.updateTel(memvo);
			}
		}
		
		//HttpSession session = req.getSession();	// 세션 객체 불러옴
		
		// 저장 되어 있던 세션 정보 삭제
		// 강제 로그아웃
		//session.invalidate();
		
		return "/home_main/main.html";
	}

}
