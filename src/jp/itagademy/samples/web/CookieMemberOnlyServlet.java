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
@WebServlet("/memberOnly")
public class CookieMemberOnlyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ACCOUNT_KEY = "account";
	private static final String PASSWORD_KEY = "password";
	private static final String DIRECT_KEY = "direct";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<title>�����p���</title>");
		
		HttpSession session = request.getSession(false);
		String account = null;
		if (session != null){
			account = (String) session.getAttribute(ACCOUNT_KEY);
		}
		if (account == null){
			out.println("<h1>���O�C���G���[</h1>");
			out.println("<p>��Ƀ��O�C�����Ă�������</p>");
			out.println("<p><a href=\"login_form.html\">���O�C�����</a></p>");
			return;
		}
		
		out.println("<h1>�����p���</h1>");
		out.println("<p>�悤�����@" + account + "����</p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
