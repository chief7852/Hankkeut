package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAction {
	// 이 IAtion인터페이스를 implements한 클래스에서 View(jsp문서)를 
	// 결정하고, 해당 View로 redirect할 것인지, forward를 할 것인지를
	// 결정하는 메소드 선언
	// 반환값이 true ==> redirect
	// 반환값이 false ==> forward
	public boolean isRedirect();
	
	// 이 IAction인터페이스를 implements한 클래스의 process()메소드를
	// 호출해서 URI를 기준으로 1개의 요청 처리를 위임하고 
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
}
