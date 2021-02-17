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
		List<BoardVO> boards = serivce.selectAll();
		
		// 4. 결과값을 request에 저장
		request.setAttribute("board", boards);
		
		// 5. view페이지로 forward
		request.getRequestDispatcher("board/listAll.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 페이지별 리스트 가져오기
		// 1. 클라이언트 용청 시 전송 데이터 받기 - 페이지 번호
		int cPage = Integer.parseInt(request.getParameter("cPage"));
		System.out.println("cPage : " + cPage);
		// 2. service객체 생성
		IBoardService service = BoardServiceImpl.getService();
		
		// 전체 글 갯수 가져오기
		int totalCnt = service.listCount();
				
		// 한 페이지에 출력할 글 갯수 - 3
		int perList = 5;
		
		// 한 화면에 출력할 페이지 수 - 2
		int perPage = 3;
		
		// 전체 페이지 수 구하기 - 7
		int totalPage = (int) Math.ceil(totalCnt / (double) perList);
		
		// start와 end 값 구하기  1 => 1,2,3 | 2 => 4,5,6 | 3 => 7,8,9
		// 7 => 19, 20
		int start = (cPage-1) * perList + 1;
		int end = start + perList - 1;
		if(end > totalCnt) end = totalCnt;
		
		// startPage와 endPage 구하기
		int startPage = ((cPage - 1) / perPage * perPage) + 1;
		int endPage = startPage + perPage - 1;
		if(endPage > totalPage) endPage = totalPage;
		
		// start-Page와 end-Page
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		
		List<BoardVO> list = service.selectByPage(map);
		
		request.setAttribute("boardPage", list);	// 게시판 데이터 값
		request.setAttribute("tPage", totalPage);	// 전체 페이지
		request.setAttribute("sPage", startPage);	// 시작 페이지
		request.setAttribute("ePage", endPage);		// 마지막 페이지
		
		request.getRequestDispatcher("board/listPage.jsp").forward(request, response);;
	}

}
