package jp.itagademy.samples.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowParametersServlet
 */
@WebServlet("/panashiLogin")
public class PanashiLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int SECONDS_PER_YEAR = 365 * 24 * 60 * 60;
	private static final String ACCOUNT_KEY = "account";
	private static final String PASSWORD_KEY  = "password";
	private static final String PANASHI_KEY = "panashi";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String account = "", password = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null){
			for(Cookie c:cookies){
				if (c.getName().equals(ACCOUNT_KEY))
					account = c.getValue();
				if (c.getName().equals(PASSWORD_KEY))
					password = c.getValue();
			}
		}

		if (!(account.equals("") || password.equals(""))){
			HttpSession session = request.getSession();
			session.setAttribute(ACCOUNT_KEY, account);
			session.setAttribute(PASSWORD_KEY, password);
			request.getRequestDispatcher("panashiMemberOnly").forward(request, response);
			return;
		}

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<meta charset=\"utf-8\">");

		out.println("<title>ぱなし機能付きログイン画面</title>");
		out.println("<form action=\"panashiLogin\" method=\"post\" >");
		out.println("<p>アカウント<input type=\"text\" name=\"" + ACCOUNT_KEY + "\"></p>");
		out.println("<p>パスワード<input type=\"password\" name=\"" + PASSWORD_KEY + "\"></p>");
		out.println("<p>ずっとログイン<input type=\"checkbox\" name=\"" + PANASHI_KEY + "\" value=\"p\"></p>");
		out.println("<p><input type=\"submit\" value=\"ログイン\"></p>");

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
			out.println("<title>ぱなし機能付きログインログイン画面</title>");
			out.println("<p>ログインエラー</p>");
			out.println("<p>アカウントとパスワードを入力してください</p>");
			out.println("<p><a href=\"panashiLogin\">ログイン画面</a></p>");
			return;
		}

		HttpSession session = request.getSession();
		session.setAttribute(ACCOUNT_KEY, account);
		session.setAttribute(PASSWORD_KEY, password);

		String panashi = request.getParameter(PANASHI_KEY);
		int maxage = 0;
		if (panashi != null && panashi.equals("p")){
			maxage = SECONDS_PER_YEAR;
		}

		Cookie cookie = new Cookie(ACCOUNT_KEY, account);
		cookie.setMaxAge(maxage);
		response.addCookie(cookie);
		cookie = new Cookie(PASSWORD_KEY, password);
		cookie.setMaxAge(maxage);
		response.addCookie(cookie);


		out.println("<title>ぱなし機能付きログイン成功画面</title>");
		out.println("<p>ログインしました</p>");
		out.println("<p><a href=\"panashiMemberOnly\">会員専用ページ</a></p>");
	}

}
