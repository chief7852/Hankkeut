package backmusic.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backmusic.service.BackmusicServiceImpl;
import backmusic.service.IBackmusicService;
import vo.BackMusicVO;

@WebServlet("/selectAllMusic.do")
public class selectAllMusic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public selectAllMusic() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//요청시 글번호 가져오기
	request.setCharacterEncoding("utf-8");
		
	// service 객체 얻기
	IBackmusicService service = BackmusicServiceImpl.getService();	
	
	// service 매서드 호출
	List<BackMusicVO> list = service.selectAll();
		
	//결과값 request에 저장
	request.setAttribute("list", list);	
	
	// view 페이지로 forward - result.jsp
	request.getRequestDispatcher("WEB-INF/view/backmusic/listAllMusic.jsp").forward(request, response);
	
	}

}
