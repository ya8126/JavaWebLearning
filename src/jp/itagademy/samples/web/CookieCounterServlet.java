package jp.itagademy.samples.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieCounterServlet
 */
@WebServlet("/cookieCounter")
public class CookieCounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int SECONDS_PER_YEAR = 365 * 24 * 60 * 60;
	private static final String COUNT_KEY = "count";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int count = 0;
		String domain = null, path = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals(COUNT_KEY)) {
					count = Integer.parseInt(c.getValue());
					domain = c.getDomain();
					path = c.getPath();
					break;
				}
			}
		}

		count++;
		Cookie cookie = new Cookie(COUNT_KEY, String.valueOf(count));
		cookie.setMaxAge(SECONDS_PER_YEAR);
		response.addCookie(cookie);

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<p>あなたの訪問ドメイン：" + domain  + "</p>");
		out.println("<p>あなたの訪問パス：" + path  + "</p>");
		out.println("<p>あなたの訪問回数：" + count + "回</p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// protected void doPost(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	// }

}
