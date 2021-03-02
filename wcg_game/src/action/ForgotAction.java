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

import common.service.IMemberService;
import common.service.MemberServiceImpl;
import vo.MemberVO;
import web.IAction;

public class ForgotAction implements IAction {

	@Override
	public boolean isRedirect() {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. VO 객체를 생성한다.
		MemberVO memVo = new MemberVO();
		
		// 2. 서비스 객체를 생성한다.
		IMemberService service = MemberServiceImpl.getService();
		try {
			BeanUtils.populate(memVo , req.getParameterMap());
			MemberVO isMail = service.isMember(memVo);
			
			if(isMail == null) {  // 비회원
				return "/index.ddit";
			}
			// Mail server 설정
			String host = "smtp.gmail.com";
			String user = "kid03196";		// 관리자 ID
			String password = "";	// 관리자 PW
			
			// 메일 받을 주소
			String to_email = memVo.getMem_mail();	// 유저 메일
			System.out.println("memVo ? " + memVo.getMem_id());
			// SMTP 서버 정보를 설정
			Properties props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", 587);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			
			if(memVo.getMem_id() != null) { // 비밀번호 찾기
				// 인증 번호 생성기
				StringBuffer temp = new StringBuffer();
				Random rnd = new Random();
				for(int i=0; i<10; i++) {
					int rIndex = rnd.nextInt(3);
					switch (rIndex) {
					case 0:	// a-z
						temp.append((char)((int)(rnd.nextInt(26)) + 97));
						break;
					case 1:	// A-Z
						temp.append((char)((int)(rnd.nextInt(26)) + 65));
						break;
					case 2:	// 0-9
						temp.append((rnd.nextInt(10)));
						break;
					}
				}
				String AuthenticationKey = temp.toString();
				System.out.println(AuthenticationKey);
				
				// DB에 난수 값인 임시 비밀번호를 저장하기 위해 VO 객체에 저장
				memVo.setMem_pass(AuthenticationKey);
				int cnt = service.updatePass(memVo);
				
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
					msg.setSubject("안녕하세요 한끝 회원 ID 찾기 메일입니다.");
					// 메일 내용
					msg.setText("임시 비밀번호는 [ " + temp + " ] 입니다.");
					
					Transport.send(msg);
					System.out.println("이메일 전송");
				} catch (Exception e) {
					e.printStackTrace();
				}
				HttpSession saveKey = req.getSession();
				saveKey.setAttribute("AuthenticationKey", AuthenticationKey);
				
			} else {	// 아이디 찾기
				
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
					msg.setSubject("안녕하세요 한끝 임시 비밀번호 메일입니다.");
					// 메일 내용
					msg.setText("회원님의 ID는 [ " + isMail.getMem_id() + " ] 입니다.");
					
					Transport.send(msg);
					System.out.println("이메일 전송");
				} catch (Exception e) {
					e.printStackTrace();
				}
				HttpSession saveKey = req.getSession();
				saveKey.setAttribute("userID", isMail.getMem_id());
				
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "/login/login.ddit";
	}

}
