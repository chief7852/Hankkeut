package common.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.dao.MemberDaoImpl;
import common.service.IMemberService;
import common.service.MemberServiceImpl;
import vo.MemberVO;

/**
 * Servlet implementation class loginMember
 */
@WebServlet("/loginMember.do")
public class LoginMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberVO vo = new MemberVO();
		vo.setMem_id(request.getParameter("id"));
		vo.setMem_pass(request.getParameter("pass"));
		
		IMemberService service = MemberServiceImpl.getService();
		
		
		
		String result = service.loginMember(vo);
		
		  request.setAttribute("logincheck", result);
		  
		  
		  request.getRequestDispatcher("WEB-INF/view/member/logincheck.jsp").forward(
		  request, response);
		 
		
	}

}
