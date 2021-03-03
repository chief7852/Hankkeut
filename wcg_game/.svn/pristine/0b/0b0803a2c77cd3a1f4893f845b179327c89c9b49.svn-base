package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.INoticeService;
import board.service.NoticeServiceImpl;
import vo.noticeBoardVO;
import web.IAction;

public class BoardListAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 실제 처리할 내용은 이곳에 기술하고
		// 처리가 끝난 후에 보여줄 View페이지를 반환하면 된다.
		
		String ccPage = req.getParameter("page");
		if(ccPage == null) ccPage = "1";
		
		INoticeService service = NoticeServiceImpl.getService();
	
		//List<noticeBoardVO> boardList = service.selectAll();
		
		//req.setAttribute("board", boardList);
		
		// 페이징 처리
		;
		
		  int cPage = Integer.parseInt(ccPage); // 전체 글 갯수 가져오기 
		  int totalCnt = service.selectAllCnt();
		  
		  // 한 페이지에 출력할 글 갯수 - 3 
		  int perList = 10;
		  
		  // 한 화면에 출력할 페이지 수 - 2 
		  int perPage = 10;
		  
		  // 전체 페이지 수 구하기 - 7 
		  int totalPage = (int) Math.ceil(totalCnt / (double)
		  perList);
		  
		  // start와 end 값 구하기 1 => 1,2,3 | 2 => 4,5,6 | 3 => 7,8,9 // 7 => 19, 20 
		  int start = (cPage-1) * perList + 1; 
		  int end = start + perList - 1; 
		  if(end > totalCnt) end = totalCnt;
		  
		  // startPage와 endPage 구하기
		  int startPage = ((cPage - 1) / perPage * perPage) +1; 
		  int endPage = startPage + perPage - 1; 
		  if(endPage > totalPage) endPage = totalPage;
		  
		  // start-Page와 end-Page 
		  Map<String, Integer> map = new HashMap<String, Integer>(); 
		  map.put("start", start); 
		  map.put("end", end);
		  
		  List<noticeBoardVO> boardList = service.selectByPage(map);
		 
		
		  req.setAttribute("board", boardList);	// 게시판 데이터 값
		
		  req.setAttribute("tPage", totalPage); // 전체 페이지
		  req.setAttribute("sPage", startPage); // 시작 페이지 
		  req.setAttribute("ePage", endPage); // 마지막 페이지
		 		
		return "/board/boardList.jsp";
	}

}
