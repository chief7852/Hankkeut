package inventory.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.apache.commons.beanutils.BeanUtils;

import inventory.service.IInventoryService;
import inventory.service.InventoryServiceImpl;
import vo.InventoryVO;

@WebServlet("/insertInventory.do")
public class insertInventory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public insertInventory() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		InventoryVO inVO = new InventoryVO();
		
		try {
			BeanUtils.populate(inVO, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//2. 서비스 객체얻기
		IInventoryService service = InventoryServiceImpl.getService();
		/*
		 * System.out.println("000000000000000000000"+inVO.item_no);
		 * System.out.println("000000000000000000000"+inVO.char_nickname);
		 */
		
		
		//3. 서비스 매서드 호출
		String result = service.insertInventory(inVO);
		
		//4. 결과값을 request에 저장
		//request.setAttribute("",result)
		
		System.out.println("------->>"+result);
		request.setAttribute("result", result);
		
		//5.view페이지로 forward
		RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/view/inventory/InsertItemINInventory.jsp");
		disp.forward(request, response);
		
	}

}















