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
@WebServlet("/login")
public class CookieLoginServlet extends HttpServlet {
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

		out.println("<title>���O�C�����</title>");
		out.println("<h1>���O�C���G���[</h1>");
		out.println("<p>���O�C�����Ă�������</p>");
		out.println("<p><a href=\"login_form.html\">���O�C�����</a></p>");
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<meta charset=\"utf-8\">");

		String account = request.getParameter(ACCOUNT_KEY);
		String password = request.getParameter(PASSWORD_KEY);
		if (account == null || account.equals("") || password == null || password.equals("")){
			out.println("<title>���O�C�����</title>");
			out.println("<h1>���O�C���G���[</h1>");
			out.println("<p>�A�J�E���g�ƃp�X���[�h����͂��Ă�������</p>");
			out.println("<p><a href=\"login_form.html\">���O�C�����</a></p>");
			return;
		}
		
		if (!account.equals(password)){
			out.println("<title>���O�C�����</title>");
			out.println("<h1>���O�C���G���[</h1>");
			out.println("<p>�A�J�E���g�܂��̓p�X���[�h���Ⴂ�܂�</p>");
			out.println("<p><a href=\"login_form.html\">���O�C�����</a></p>");	
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute(ACCOUNT_KEY, account);
		
		out.println("<title>���O�C���������</title>");
		out.println("<h1>���O�C������</h1>");
		out.println("<p>���O�C�����܂���</p>");
		out.println("<p><a href=\"memberOnly\">�����p�y�[�W</a></p>");
	}

}
