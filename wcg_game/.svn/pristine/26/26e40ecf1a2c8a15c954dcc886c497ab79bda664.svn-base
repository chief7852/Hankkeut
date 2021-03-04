package character_2.controller.copy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import character_2.service.copy.CharacterServiceImpl;
import character_2.service.copy.ICharacterService;

@WebServlet("/UpdateIMGLink.do")
public class UpdateIMGLink extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateIMGLink() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String mem_id = request.getParameter("mem_id");
		System.out.println("mem_id"+mem_id);
		ICharacterService service = CharacterServiceImpl.getService();
		
		int result = service.updateIMGLink(mem_id);
		
		request.setAttribute("CHVO", result);
		
		//updateLINK로 포둬딩
		request.getRequestDispatcher("WEB-INF/view/character/updateLINK.jsp").forward(request, response);
	}

}
