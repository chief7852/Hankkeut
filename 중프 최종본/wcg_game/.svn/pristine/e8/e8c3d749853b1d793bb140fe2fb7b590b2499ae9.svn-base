package character_2.controller.copy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import character_2.service.copy.CharacterServiceImpl;
import character_2.service.copy.ICharacterService;
import vo.CharVO;

/**
 * Servlet implementation class loginMember
 */
@WebServlet("/SelectChar.do")
public class SelectChar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String mem_id = request.getParameter("id");
		System.out.println("-----selectChar"+mem_id);
		
		ICharacterService service = CharacterServiceImpl.getService();
		
		CharVO vo = service.selectChar(mem_id);
		
	
		request.setAttribute("character", vo);
		  
		  
		request.getRequestDispatcher("WEB-INF/view/character/characterJson.jsp").forward(request, response);
		 
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
