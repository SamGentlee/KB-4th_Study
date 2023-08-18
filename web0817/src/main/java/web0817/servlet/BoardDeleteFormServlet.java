package web0817.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web0817.dao.BoardDao;
import web0817.dao.BoardDaoImpl;
import web0817.dto.BoardDto;
/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/board/delete_form")
public class BoardDeleteFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sno = request.getParameter("no");
		int no = Integer.parseInt(sno);
		String url = "/board_delete_form.jsp";
		BoardDao dao = new BoardDaoImpl();
		try {
			BoardDto dto = dao.findById(no);
			request.setAttribute("dto", dto);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "/board_error.jsp";
			request.setAttribute("err_msg", e.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
