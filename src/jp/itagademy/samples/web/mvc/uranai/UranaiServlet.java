package jp.itagademy.samples.web.mvc.uranai;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowParametersServlet
 */
@WebServlet("/mvc/uranai")
public class UranaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.getRequestDispatcher("/WEB-INF/mvc/uranai/uranaiInit.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String bloodType = request.getParameter("bloodtype");
		
		if (bloodType == null || bloodType.equals("")){
			request.setAttribute("error", "ŒŒ‰tŒ^‚ª‘I‘ð‚³‚ê‚Ä‚¢‚Ü‚¹‚ñ");
			request.getRequestDispatcher("/WEB-INF/mvc/uranai/uranaiInit.jsp").forward(request, response);
			return;
		}
		
		Unsei unsei = new Unsei(bloodType);
		request.setAttribute("unsei", unsei);
		request.getRequestDispatcher("/WEB-INF/mvc/uranai/result.jsp").forward(request, response);
	}

}
