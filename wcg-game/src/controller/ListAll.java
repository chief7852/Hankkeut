package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardServiceImpl;
import service.IBoardService;
import vo.BoardVO;
import vo.noticeBoardVO;

/**
 * Servlet implementation class ListAll
 */
@WebServlet("/List.do")
public class ListAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 전체목록 가져오기
		
		// 1. 클라이언트 용청 시 전송 데이터 받기
		
		// 2. service객체 생성
		IBoardService serivce = BoardServiceImpl.getService();
		
		// 3. service메소드 호출 - 결과값 받기
		List<noticeBoardVO> boards = serivce.selectAll();
		
		// 4. 결과값을 request에 저장
		request.setAttribute("board", boards);
		
		// 5. view페이지로 forward
		request.getRequestDispatcher("board/listAll.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
