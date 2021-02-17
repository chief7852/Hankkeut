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
		// 클라이언트 데이터 받기
		BoardVO vo = new BoardVO();
		
		vo.setSubject(request.getParameter("subject"));
		vo.setWriter(request.getParameter("writer"));
		vo.setMail(request.getParameter("mail"));
		vo.setPassword(request.getParameter("password"));
		vo.setContent(request.getParameter("content"));
		
		String wip = request.getRemoteAddr();	// 글 쓴 사람 ip 얻어옴
		vo.setWip(wip);
		
		// 서비스 객체 생성
		IBoardService service = BoardServiceImpl.getService();
		
		// 서비스 메소드 호출 - 메소드 값 저장
		int insertBoard = service.insertBoard(vo);
				
		// 결과값 request에 저장
		request.setAttribute("boardStatus", insertBoard);
		
		// reuqest 저장 값 전송
		RequestDispatcher rd = request.getRequestDispatcher("board/result.jsp");
		rd.forward(request, response);
	}

}
