package character_2.controller.copy;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import character_2.service.copy.CharacterServiceImpl;
import character_2.service.copy.ICharacterService;
import vo.CharVO;

@WebServlet("/SelectAllch.do")
public class SelectAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectAll() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청시 글번호 가져오기
		request.setCharacterEncoding("utf-8");
		
		//service객체얻기
		ICharacterService service = CharacterServiceImpl.getService();
		
		//service매서드 호출
		List<CharVO> list = service.selectAll();
		
		//결과값 request에 저장
		request.setAttribute("list", list);
		
		//view페이지로 포워딩 - listAllChar.jsp
		request.getRequestDispatcher("WEB-INF/view/character/listAll.jsp").forward(request, response); 
		
		
		
		
		
	}

}
