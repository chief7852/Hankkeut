package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.service.IMemberService;
import common.service.MemberServiceImpl;
import manager.service.IManagerService;
import manager.service.ManagerServiceImpl;
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
		// 愿�由ъ옄 濡쒓렇�씤�씤吏� �씪諛섑쉶�썝 濡쒓렇�씤�씠吏� �쑀臾� �솗�씤�쓣 �쐞�빐 �뙆�씪誘명꽣 媛믪쓣 諛쏆븘�샂
		String userId = req.getParameter("mem_id");
		String pass = req.getParameter("mem_pass");
		System.out.println("LoginAction UserId : " + userId);
		System.out.println("LoginAction pass : " + pass);
		// �꽭�뀡 媛앹껜 �깮�꽦
		HttpSession session = req.getSession();
		
		// �븘�씠�뵒�굹 鍮꾨�踰덊샇媛� �엯�젰 �릺�뼱 �엳吏� �븡�쓣 寃쎌슦
		if(userId == null || userId == "" || pass == null || pass == "") {
			return "/wcggame/home_sign/login.html";
		}
		// �쉶�썝 媛앹껜 �깮�꽦
		MemberVO memVo = new MemberVO();
		IMemberService service = MemberServiceImpl.getService();
		
		// 留ㅻ땲�� 媛앹껜 �깮�꽦
		ManagerVO managerVo = new ManagerVO();
		IManagerService manService = ManagerServiceImpl.getService();
		
		String user = "";
		try {
			if(userId.equals("admin")) {	// �젒�냽�옄媛� 愿�由ъ옄�씤媛�
				managerVo.setManager_id(userId);
				managerVo.setManager_pass(pass);
				
				user = manService.comparison(managerVo);
				if(user == null) {
					req.setAttribute("error", false);
					return "/home_sign/login.html";
				}
			} else {	// �쉶�썝�씤媛�
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
		
		// �꽭�뀡�뿉 濡쒓렇�씤 �젙蹂� ���옣
		session.setAttribute("userid", user);
		return "/index.ddit";
	}

}
