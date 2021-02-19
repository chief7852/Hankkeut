package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.IAction;



public class WebController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		/*
		 * URL ==> http://�꽌踰꾩씠由꾨삉�뒗IP二쇱냼:�룷�듃踰덊샇/而⑦뀓�뒪�듃�씠由�/�뤃�뜑紐�/臾몄꽌紐� ==>
		 * http://localhost:80/servletTest/member/memberList.ddit
		 * 
		 * URI ==> /servletTest/member/memberList.ddit
		 * 
		 * ContextPath ==> /servletTest
		 * 
		 * �썝�븯�뒗 �슂泥쵻RI ==> /member/memberList.ddit
		 * 
		 */

		// 1. �궗�슜�옄�쓽 �슂泥� �젙蹂� 媛��졇�삤湲�
		String uri = req.getRequestURI(); // �쟾泥댁슂泥� URI

		// �썝�븯�뒗 �슂泥쵻RI
		uri = uri.substring(req.getContextPath().length());
		
		String viewPage = null;
		
		IAction action = null;
		
		
		
		if(action == null) {	// �떎�뻾�븷 URI 媛� �뾾�쑝硫� 404�뿉�윭 泥섎━
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}else {
			// �떎�뻾 遺�遺� ==> �옉�뾽 泥섎━ �썑 view�럹�씠吏�瑜� 諛쏅뒗�떎
			viewPage = action.process(req, resp);
			
			if(viewPage != null) {
				if(action.isRedirect()) {
					resp.sendRedirect(req.getContextPath()+ viewPage);
				}else {
					req.getRequestDispatcher("/WEB-INF/view" + viewPage).forward(req, resp);
				}
			}
		}	// if臾� �걹
	}

}
