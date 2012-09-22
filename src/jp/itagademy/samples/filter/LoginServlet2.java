package jp.itagademy.samples.filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet2
 */
@WebServlet("/filter/login")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/filter/login_form.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		String pass = request.getParameter("pass");
		
		if (account != null && pass != null && account.trim().length() != 0 && account.equals(pass)){
			HttpSession session = request.getSession();
			session.setAttribute("account", account);
			request.getRequestDispatcher("/WEB-INF/filter/login_ok.jsp").forward(request, response);
		}else{
			request.setAttribute("error", "アカウントまたはパスワードが正しくありません");
			request.getRequestDispatcher("/WEB-INF/filter/login_form.jsp").forward(request, response);
		}
	}
}
