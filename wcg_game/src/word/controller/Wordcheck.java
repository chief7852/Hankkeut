package word.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.service.IMemberService;
import common.service.MemberServiceImpl;
import word.service.IWordService;
import word.service.WordServiceImpl;


/**
 * Servlet implementation class IDcheck
 */
@WebServlet("/Word.do")
public class Wordcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Wordcheck() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. �겢�씪�씠�뼵�듃 �슂泥��떆 �쟾�넚�릺�뒗 媛믪쓣 由ы꽩
		// �엯�젰�븳 ID媛믪쓣 諛쏆븘�삩�떎
		String word = request.getParameter("word");
		
		//2. service媛앹껜瑜� �뼸�뒗�떎
		IWordService service = WordServiceImpl.getService();
		
		//3. service硫붿냼�뱶 �샇異� - 寃곌낵媛� 諛쏄린
		String result = service.selectWord(word); 
		
		//4. 寃곌낵媛믪쓣 request�뿉 ���옣
		request.setAttribute("idcheck",result);
		
		//5. view�럹�씠吏�濡� forward�븳�떎
		RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/view/member/idcheck.jsp");
		disp.forward(request, response);
		
		
	}

}
