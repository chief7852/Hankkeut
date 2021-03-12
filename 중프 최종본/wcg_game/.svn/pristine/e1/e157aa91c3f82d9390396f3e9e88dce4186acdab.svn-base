package character.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import character.dao.CharacterDaoImpl;
import character.service.CharacterServiceImpl;
import character.service.ICharacterService;
import common.dao.MemberDaoImpl;
import common.service.IMemberService;
import common.service.MemberServiceImpl;
import vo.CharVO;
import vo.MemberVO;

/**
 * Servlet implementation class loginMember
 */
@WebServlet("/SelectChar1.do")
public class SelectChar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String mem_id = request.getParameter("id");
		//System.out.println(mem_id);
		ICharacterService service = CharacterServiceImpl.getService();
		
		CharVO vo = service.selectChar(mem_id);
		
	
		  request.setAttribute("character", vo);
		  
		  
		  request.getRequestDispatcher("WEB-INF/view/character/characterJson2.jsp").forward(request, response);
		 
		
	}

}
