package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.IAction;

public class inquiryInsertForm implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String userid = (String) session.getAttribute("userid");
		System.out.println(userid+"omg");
		try {
			if(userid==null) {
				req.setAttribute("error", false);
				return "/home_sign/login.html";
			}else {
			
				req.setAttribute("error", false);
				return "/inquiry/inquiryInsertForm2.ddit";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "/free/freeInsertForm2.ddit";
	}

}
