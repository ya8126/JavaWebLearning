package jp.itagademy.samples.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowParametersServlet
 */
@WebServlet("/showParameters")
public class ShowParametersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<title>show parameters</title>");
		out.println("<ul>");
		out.println("<li>name=" +  request.getParameter("name") + "</li>");
		out.println("<li>pass=" +  request.getParameter("pass") + "</li>");
		out.println("<li>plan=" +  request.getParameter("plan") + "</li>");
		out.println("<li>like=" +  Arrays.toString(request.getParameterValues("like")) + "</li>");
		out.println("<li>payment=" +  request.getParameter("payment") + "</li>");
		out.println("<li>comment=" +  request.getParameter("comment") + "</li>");
		out.println("<li>token=" +  request.getParameter("token") + "</li>");
		out.println("</ul>");
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
