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

@WebServlet("/OneShop.do")
public class OneShop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OneShop() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String item_no = request.getParameter("item_no");
		int no = Integer.parseInt(item_no);	//
		
		//System.out.println(no); 
		IShopService service = ShopServiceImpl.getService();
		
		ShopVO vo = service.selectOne(no);
	//	System.out.println(vo.item_link);	//
		request.setAttribute("vo", vo);
		
		request.getRequestDispatcher("WEB-INF/view/shop/listOne.jsp").forward(request, response);
		
	}

}
