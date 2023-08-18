package member.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/login_form.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String mmid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		if( mmid != null && 
				mmid.equals("abc") && 
				mpwd != null &&
				mpwd.equals("123") ){
			//인증 성공
			session.setAttribute("mid", "abc");
		}
		//로그인 여부는 session.getAttribute("mid") 값이 없으면 로그인전
		String mid = (String)session.getAttribute("mid");
		if( mid == null ){ //로그인 안한상태
			response.sendRedirect("login_form.jsp");
			return;
		}else{ //로그인 한 상태
			response.sendRedirect("index.jsp");
		}

	}

}
