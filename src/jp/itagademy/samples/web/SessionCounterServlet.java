package jp.itagademy.samples.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowParametersServlet
 */
@WebServlet("/sessionCounter")
public class SessionCounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String COUNTER_KEY = "SESSION_COUNTER";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
//		Integer count = (Integer)session.getAttribute(COUNTER_KEY);
//		if (count == null){
//			count = 1;
//		}else{
//			count++;
//		}
		int count = 1;
		if (session.getAttribute(COUNTER_KEY) != null)
			count = (int)session.getAttribute(COUNTER_KEY) + 1;
			
		session.setAttribute(COUNTER_KEY, count);

		out.println("<!DOCTYPE html>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<title>session counter</title>");
		out.println("<p>ñKñ‚âÒêîÅF" + count + "âÒ</p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
