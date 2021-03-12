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
		req.setCharacterEncoding("UTF-8");
		// 1. VO ��ü�� �����Ѵ�.
		MemberVO memVo = new MemberVO();
		
		// 2. ���� ��ü�� �����Ѵ�.
		IMemberService service = MemberServiceImpl.getService();
		try {
			BeanUtils.populate(memVo , req.getParameterMap());
			MemberVO isMail = service.isMember(memVo);
			
			if(isMail == null) {  // ��ȸ��
				return "/index.ddit";
			}
			// Mail server ����
			String host = "smtp.gmail.com";
			String user = "kid03196";		// ������ ID
			String password = "wjdtjr4568";	// ������ PW
			
			// ���� ���� �ּ�
			String to_email = memVo.getMem_mail();	// ���� ����
			// SMTP ���� ������ ����
			Properties props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", 587);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			
			if(memVo.getMem_id() != null) { // ��й�ȣ ã��
				// ���� ��ȣ ������
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
				
				// DB�� ���� ���� �ӽ� ��й�ȣ�� �����ϱ� ���� VO ��ü�� ����
				memVo.setMem_pass(AuthenticationKey);
				int cnt = service.updatePass(memVo);
				
				Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, password);
					}
				});
				
				// email ����
				try {
					MimeMessage msg = new MimeMessage(session);
					msg.setFrom(new InternetAddress(user, "한끝"));
					msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
					
					// ���� ����
					msg.setSubject("한끝 비밀번호 찾기 입니다.");
					// ���� ����
					msg.setText("유저 임시 비밀번호는 [" + temp + "] 입니다.");
					
					Transport.send(msg);
				} catch (Exception e) {
					e.printStackTrace();
				}
				HttpSession saveKey = req.getSession();
				saveKey.setAttribute("AuthenticationKey", AuthenticationKey);
				
			} else {	// ���̵� ã��
				
				Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, password);
					}
				});
				
				// email ����
				try {
					MimeMessage msg = new MimeMessage(session);
					msg.setFrom(new InternetAddress(user, "한끝"));
					msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
					
					// ���� ����
					msg.setSubject("한끝 아이디 찾기 입니다.");
					// ���� ����
					msg.setText("유저의 ID는 [" + isMail.getMem_id() + "] 입니다.");
					
					Transport.send(msg);
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
