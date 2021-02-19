package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class MemberListAction implements IAction{

	@Override
	public boolean isRedirect() {
		
		return false;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �떎�젣 泥섎━�븷 �궡�슜�� �씠怨녹뿉 湲곗닠�븯怨�
		// 泥섎━媛� �걹�궃 �썑�뿉 蹂댁뿬以� View�럹�씠吏�瑜� 諛섑솚�븯硫� �맂�떎.
		
		
		
		return "/member/memberList.jsp";
	}

}
