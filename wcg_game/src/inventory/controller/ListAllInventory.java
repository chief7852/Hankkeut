package inventory.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inventory.service.IInventoryService;
import inventory.service.InventoryServiceImpl;
import vo.InventoryVO;

@WebServlet("/ListAllInventory.do")
public class ListAllInventory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListAllInventory() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//요청시 글번호 가져오기
	request.setCharacterEncoding("utf-8");	
	//닉네임 정보 가져오기
	String char_nickname = request.getParameter("char_nickname");
	
	//service 객체얻기
	IInventoryService service = InventoryServiceImpl.getService();
	
	//service매서드호출
	List<InventoryVO> list = service.seletAll(char_nickname);
	
		
	request.setAttribute("list",list);
	
	//view페이지로 forward - listAllInven.jsp로 포워딩
	request.getRequestDispatcher("WEB-INF/view/inventory/listAll.jsp").forward(request, response);
	
		
	}

}
