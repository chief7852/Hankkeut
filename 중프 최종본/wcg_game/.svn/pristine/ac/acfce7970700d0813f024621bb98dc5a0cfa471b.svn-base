package inventory.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inventory.service.IInventoryService;
import inventory.service.InventoryServiceImpl;
import vo.ShopVO;

@WebServlet("/selectLink.do")
public class SelectLink extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectLink() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청시 글번호 가져오기
		request.setCharacterEncoding("utf-8");
		
		//닉네임 정보 가져오기
		String char_nickname = request.getParameter("char_nickname");
		//System.out.println("test500"+char_nickname);
		
		//service객체얻기
		IInventoryService service = InventoryServiceImpl.getService();
		
		//service매서드 호출
		List<ShopVO> list = service.selectIMG(char_nickname);
		 
		//결과갑 request에 저장
		request.setAttribute("list", list);
		
		//view페이지로 forward - selectLink.js로 포워딩!!(포워딩 까먹지 말고 하셈)
		request.getRequestDispatcher("WEB-INF/view/inventory/selectLink.jsp").forward(request, response);;
	
	
	}

}
