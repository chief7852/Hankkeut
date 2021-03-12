package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.FreeServiceImpl;
import board.service.IFreeService;
import vo.CommentVO;
import vo.freeBoardVO;
import web.IAction;

public class FreeReplyUpdate implements IAction {

	@Override
	public boolean isRedirect() {
		
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		  CommentVO vo = new CommentVO();
		  String bonum = req.getParameter("bonum");
		  System.out.println(bonum+"안녕하십니까?");
		  vo.setCo_contents(req.getParameter("cont"));
		  vo.setCo_no(Integer.parseInt(req.getParameter("renum")));
		  
		  IFreeService service = FreeServiceImpl.getService();
		 
		
		int update = service.updateReply(vo);
		
		req.setAttribute("boardStatus", update);
		System.out.println("여기까지 못오는듯");
		
		
		/*
		 * RequestDispatcher rd = req.getRequestDispatcher("/free/freeForm.ddit?bonum");
		 * rd.forward(req, resp);
		 */
		 
	
		
		
		return "/freeboard/result.jsp";
	}

}
