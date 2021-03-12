package action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import board.service.FreeServiceImpl;
import board.service.IFreeService;
import board.service.IInquiryService;
import board.service.InquiryServiceImpl;
import common.service.IMemberService;
import common.service.MemberServiceImpl;
import vo.InquiryBoardVO;
import vo.MemberVO;
import vo.freeBoardVO;
import web.IAction;

public class inquiryInsertAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		// 1. VO 객체를 생성한다.
				MemberVO memVo = new MemberVO();
				
				// 2. 서비스 객체를 생성한다.
				IMemberService service = MemberServiceImpl.getService();
				try {
					HttpSession session2 = req.getSession();
					String userid = (String) session2.getAttribute("userid");
					InquiryBoardVO vo = new InquiryBoardVO();
					
					vo.setI_board_title(req.getParameter("i_board_title"));
					vo.setI_board_contents(req.getParameter("i_board_contents"));
					vo.setI_board_type(req.getParameter("i_board_type"));
					vo.setMem_id(userid);
					IInquiryService service2 = InquiryServiceImpl.getService();
					int cnt = service2.insertBoard(vo);
					
					BeanUtils.populate(memVo , req.getParameterMap());
					MemberVO isMail = service.isMember(memVo);
					
					
					
					// Mail server 설정
					String host = "smtp.gmail.com";
					String user = "wjsgudtjq3743";		// 관리자 ID
					String password = "gpcjseo@2";	// 관리자 PW
					
					// 메일 받을 주소
					String to_email = req.getParameter("i_board_email");
					System.out.println("전형섭 040445" +to_email);
//					String to_email = memVo.getMem_mail();	// 유저 메일
//					System.out.println("memVo ? " + memVo.getMem_id());
					// SMTP 서버 정보를 설정
					Properties props = new Properties();
					props.put("mail.smtp.host", host);
					props.put("mail.smtp.port", 587);
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.starttls.enable", "true");
					
				
						
						Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
							protected PasswordAuthentication getPasswordAuthentication() {
								return new PasswordAuthentication(user, password);
							}
						});
						
						// email 전송
						try {
							MimeMessage msg = new MimeMessage(session);
							msg.setFrom(new InternetAddress(user, "한끝"));
							msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
							
							// 메일 제목
							String title =req.getParameter("i_board_title");
							msg.setSubject(title);
							// 메일 내용
							String content = req.getParameter("i_board_contents");
							msg.setText("문의종류:"+req.getParameter("type"));
							msg.setText(content);
							System.out.println(msg+"whyemail1111");
							Transport.send(msg);
							System.out.println("이메일 전송");
						} catch (Exception e) {
							e.printStackTrace();
						}
						
						
					
				} catch (IllegalAccessException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				return "/index.ddit";
			}
}

		
		
		
		
		
		
		
		
		
		
		
		
		
		//-----------------------------절취선----------------------
//		HttpSession session = req.getSession();
//		String userid = (String) session.getAttribute("userid");
//		InquiryBoardVO vo = new InquiryBoardVO();
//		
//		
//		
//		vo.setI_board_title(req.getParameter("i_board_title"));
//		vo.setI_board_contents(req.getParameter("i_board_contents"));
//		vo.setI_board_pass(req.getParameter("i_board_pass"));
//		//String admin = "admin";
//		vo.setMem_id(userid);
//		
//
//		IInquiryService service = InquiryServiceImpl.getService();
//		IMemberService memservice = MemberServiceImpl.getService();
//				String email= memservice.selectEmail(userid);
//		int cnt = service.insertBoard(vo);
//		return "/inquiry/inquiryList.ddit";

