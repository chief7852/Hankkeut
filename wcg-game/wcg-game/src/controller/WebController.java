package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		/*
		 * URL ==> http://서버이름또는IP주소:포트번호/컨텍스트이름/폴더명/문서명 ==>
		 * http://localhost:80/servletTest/member/memberList.ddit
		 * 
		 * URI ==> /servletTest/member/memberList.ddit
		 * 
		 * ContextPath ==> /servletTest
		 * 
		 * 원하는 요청URI ==> /member/memberList.ddit
		 * 
		 */

		// 1. 사용자의 요청 정보 가져오기
		String uri = req.getRequestURI(); // 전체요청 URI

		// 원하는 요청URI
		uri = uri.substring(req.getContextPath().length());
		
		String viewPage = null;
		
		IAction action = null;
		
		action = URIActionMapper.getAction(uri);
		
		if(action == null) {	// 실행할 URI 가 없으면 404에러 처리
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}else {
			// 실행 부분 ==> 작업 처리 후 view페이지를 받는다
			viewPage = action.process(req, resp);
			
			if(viewPage != null) {
				if(action.isRedirect()) {
					resp.sendRedirect(req.getContextPath()+ viewPage);
				}else {
					req.getRequestDispatcher("/WEB-INF/view" + viewPage).forward(req, resp);
				}
			}
		}	// if문 끝
	}

}
