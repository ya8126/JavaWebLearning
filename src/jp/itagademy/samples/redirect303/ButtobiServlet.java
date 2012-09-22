package jp.itagademy.samples.redirect303;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import sun.misc.Regexp;

/**
 * Servlet implementation class ButtobiServlet
 */
@WebServlet("/redirect303/buttobi")
public class ButtobiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ButtobiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int rand = new Random().nextInt(3);
		String location = null;

		switch (rand) {
		case 0:
			location = "http://www.yahoo.co.jp/";
			break;
		case 1:
			location = "http://www.google.co.jp/";
			break;
		case 2:
			location = request.getContextPath() + "/hello_world.jsp";
			break;
		}
		
		response.setStatus(303);
		response.setHeader("Location", location);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
