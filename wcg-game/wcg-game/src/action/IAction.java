package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAction {
	// �씠 IAction�씤�꽣�럹�씠�뒪瑜� implements�븳 �겢�옒�뒪�뿉�꽌 View(jsp臾몄꽌)瑜� 
	// 寃곗젙�븯怨�, �빐�떦 View濡� redirect�븷 寃껋씤吏�, forward瑜� �븷 寃껋씤吏�瑜�
	// 寃곗젙�븯�뒗 硫붿꽌�뱶 �꽑�뼵	
	//   諛섑솚媛믪씠 true�씠硫� ==> redirect
	// 	 諛섑솚媛믪씠 false�씠硫� ==> forward
	public boolean isRedirect();
	
	
	// �씠 IAction�씤�꽣�럹�씠�뒪瑜� implements�븳 �겢�옒�뒪�쓽 process()硫붿꽌�뱶瑜�
	// �샇異쒗빐�꽌 URI瑜� 湲곗��쑝濡�  1媛쒖쓽 �슂泥� 泥섎━瑜� �쐞�엫�븯怨� view�럹�씠吏�瑜� 
	// 諛섑솚�븯�뒗 硫붿꽌�뱶
	public String process(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException;
	
}
