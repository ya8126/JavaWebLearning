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

		out.println("<title>ログイン画面</title>");
		out.println("<h1>ログインエラー</h1>");
		out.println("<p>ログインしてください</p>");
		out.println("<p><a href=\"login_form.html\">ログイン画面</a></p>");
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
			out.println("<title>ログイン画面</title>");
			out.println("<h1>ログインエラー</h1>");
			out.println("<p>アカウントとパスワードを入力してください</p>");
			out.println("<p><a href=\"login_form.html\">ログイン画面</a></p>");
			return;
		}
		
		if (!account.equals(password)){
			out.println("<title>ログイン画面</title>");
			out.println("<h1>ログインエラー</h1>");
			out.println("<p>アカウントまたはパスワードが違います</p>");
			out.println("<p><a href=\"login_form.html\">ログイン画面</a></p>");	
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute(ACCOUNT_KEY, account);
		
		out.println("<title>ログイン成功画面</title>");
		out.println("<h1>ログイン成功</h1>");
		out.println("<p>ログインしました</p>");
		out.println("<p><a href=\"memberOnly\">会員専用ページ</a></p>");
	}

}
