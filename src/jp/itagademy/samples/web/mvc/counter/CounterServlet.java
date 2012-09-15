package jp.itagademy.samples.web.mvc.counter;

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
@WebServlet("/mvc/counter")
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		HttpSession session = request.getSession();
		ServletContext context = getServletContext();
		Counter counter = (Counter)context.getAttribute("counter");
		
		if (counter==null){
			counter = new Counter();
			context.setAttribute("counter", counter);
		}
		counter.inc();
		
		request.getRequestDispatcher("/WEB-INF/mvc/counter/result.jsp").forward(request, response);
	}
}