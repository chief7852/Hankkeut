package preference.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import preference.service.IPreferenceService;
import preference.service.preferenceServiceImpl;

@WebServlet("/updateready.do")
public class Updateautoready extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    public Updateautoready() {
        super();
    }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   request.setCharacterEncoding("utf-8");
   
   String mem_id = request.getParameter("mem_id");
   String num = request.getParameter("num");
   
   IPreferenceService service = preferenceServiceImpl.getService();
   
   int result = service.updateautoready(mem_id,num);
   
   request.setAttribute("IDVO", result);
   
   //updateAutoready�� ������
   request.getRequestDispatcher("WEB-INF/view/preference/updateAutoready.jsp").forward(request, response);
   
   
   }

}