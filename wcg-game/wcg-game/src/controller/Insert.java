package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardServiceImpl;
import service.IBoardService;
import vo.BoardVO;

/**
 * Servlet implementation class insert
 */
@WebServlet("/insert.do")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// �겢�씪�씠�뼵�듃 �뜲�씠�꽣 諛쏄린
		BoardVO vo = new BoardVO();
		
		vo.setSubject(request.getParameter("subject"));
		vo.setWriter(request.getParameter("writer"));
		vo.setMail(request.getParameter("mail"));
		vo.setPassword(request.getParameter("password"));
		vo.setContent(request.getParameter("content"));
		
		String wip = request.getRemoteAddr();	// 湲� �벖 �궗�엺 ip �뼸�뼱�샂
		vo.setWip(wip);
		
		// �꽌鍮꾩뒪 媛앹껜 �깮�꽦
		IBoardService service = BoardServiceImpl.getService();
		
		// �꽌鍮꾩뒪 硫붿냼�뱶 �샇異� - 硫붿냼�뱶 媛� ���옣
		int insertBoard = service.insertBoard(vo);
				
		// 寃곌낵媛� request�뿉 ���옣
		request.setAttribute("boardStatus", insertBoard);
		
		// reuqest ���옣 媛� �쟾�넚
		RequestDispatcher rd = request.getRequestDispatcher("board/result.jsp");
		rd.forward(request, response);
	}

}
