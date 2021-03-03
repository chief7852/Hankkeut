package shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.service.IShopService;
import shop.service.ShopServiceImpl;
import vo.ShopVO;

/**
 * Servlet implementation class ListAllShop
 */
@WebServlet("/selectChoice.do")
public class selectChoice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public selectChoice() {
        super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.요청시 글번호 가져오기
		request.setCharacterEncoding("utf-8");
		
		//2. service객체얻기
		IShopService service = ShopServiceImpl.getService();
				
		//3. service 매서드 호출
		List<ShopVO> cho = service.selectAll();
		
		//4.결과값 request에 저장
		request.setAttribute("cho", cho);
		
		//5. view페이지로 forward - result.jsp
		request.getRequestDispatcher("WEB-INF/view/shop/selectChoice.jsp").forward(request, response); 
	}
	

}































