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

@WebServlet("/UpdateBuyPoint.do")
public class UpdateBuyPoint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateBuyPoint() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	request.setCharacterEncoding("UTF-8");
	
	String mem_id = request.getParameter("id");
	
	String item = request.getParameter("num");
	
	System.out.println("빨간머리"+item);
	
	System.out.println("---------------"+mem_id);
	
	ICharacterService service = CharacterServiceImpl.getService();
	
	int result = service.updateBuyPoint(mem_id,item);
	
	request.setAttribute("chvo", result);
	
	request.getRequestDispatcher("WEB-INF/view/character/updateBuyPoint.jsp").forward(request, response);
		
		
		
	
	}

}


