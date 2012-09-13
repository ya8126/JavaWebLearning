package jp.itagademy.samples.web.mvc.sympleboard;

import java.io.IOException;
import java.util.Date;

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
		ContributionList contributionList = (ContributionList)context.getAttribute("contributionlist");

		if (contributionList == null){
			contributionList = new ContributionList();
			context.setAttribute("contributionlist", contributionList);
		}

		request.setCharacterEncoding("utf-8");

		String name = request.getParameter("name");
		String comment = request.getParameter("comment");

		if (comment != null && !comment.equals("")){
			if (name == null || name.equals("")){
				name = "–¼–³‚µ‚³‚ñ";
			}
			contributionList.addContribution(name, comment, new Date());
		}

		request.getRequestDispatcher("/WEB-INF/mvc/sympleboard/result.jsp").forward(request, response);
	}
}
