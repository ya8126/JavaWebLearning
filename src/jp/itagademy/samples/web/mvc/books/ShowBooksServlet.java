package jp.itagademy.samples.web.mvc.books;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowBooksServlet
 */
@WebServlet("/mvc/books/")
public class ShowBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> books = new ArrayList<>();
		
		Author akutagawa = new Author("ó¥îVâÓ<script>alert('Ç‚Ç†ÅAÇ⁄Ç≠ó¥îVâÓÅI')</script>", "äHêÏ");
		Author dazai = new Author("é°", "ëæç…");
		
		books.add(new Book("óÖê∂ñÂ", akutagawa, 800, 3));
		books.add(new Book("íwÂÅÇÃéÖ", akutagawa, 500, 5));
		books.add(new Book("êlä‘é∏äi", dazai, 1000, 0));	
		
		request.setAttribute("books", books);
		
		request.getRequestDispatcher("/WEB-INF/mvc/books/index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
