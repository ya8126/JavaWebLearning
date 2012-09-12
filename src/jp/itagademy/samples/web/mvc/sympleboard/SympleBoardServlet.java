package jp.itagademy.samples.web.mvc.sympleboard;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowParametersServlet
 */
@WebServlet("/mvc/sympleBoard")
public class SympleBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doPost(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		Comments comments = (Comments)context.getAttribute("comments");
		
		if (comments == null){
			comments = new Comments();
			context.setAttribute("comments", comments);			
		}
		
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String comment = request.getParameter("comment");
		
		if (comment != null && !comment.equals("")){
			if (name == null || name.equals("")){
				name = "–¼–³‚µ‚³‚ñ";
			}
			comments.addComments(name, comment);
		}
			
		request.getRequestDispatcher("/WEB-INF/mvc/sympleboard/result.jsp").forward(request, response);
	}
}
