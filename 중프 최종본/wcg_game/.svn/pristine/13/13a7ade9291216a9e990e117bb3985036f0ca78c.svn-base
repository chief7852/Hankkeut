package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.FreeServiceImpl;
import board.service.IFreeService;
import vo.CommentVO;

/**
 * Servlet implementation class FreeReplyUpdateReply
 */
@WebServlet("/FreeReplyUpdateReply")
public class FreeReplyUpdateReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  CommentVO vo = new CommentVO();
		  String bonum = request.getParameter("bonum");
		  System.out.println(bonum+"안녕하십니까?");
		  vo.setCo_contents(request.getParameter("cont"));
		  vo.setCo_no(Integer.parseInt(request.getParameter("renum")));
		  
		  IFreeService service = FreeServiceImpl.getService();
		 
		
		  
		  
		int update = service.updateReply(vo);
		
		request.setAttribute("boardStatus", update);
		System.out.println("여기까지 못오는듯");
		
		
		  RequestDispatcher rd = request.getRequestDispatcher("/freeboard/freeBoardForm.jsp");
		  rd.forward(request, response);
		 
		
	}

}
