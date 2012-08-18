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
public class MemberOnlyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ACCOUNT_KEY = "account";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<title>会員専用画面</title>");
		
		HttpSession session = request.getSession(false);
		String account = null;
		if (session != null){
			account = (String) session.getAttribute(ACCOUNT_KEY);
		}
		if (account == null){
			out.println("<h1>ログインエラー</h1>");
			out.println("<p>先にログインしてください</p>");
			out.println("<p><a href=\"login_form.html\">ログイン画面</a></p>");
			return;
		}
		
		out.println("<h1>会員専用画面</h1>");
		out.println("<p>ようこそ　" + account + "さん</p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
