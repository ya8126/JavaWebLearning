package jp.itagademy.samples.web.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import jp.itagademy.samples.web.mvc.books.Author;
import jp.itagademy.samples.web.mvc.books.Book;

/**
 * Application Lifecycle Listener implementation class PreparingBooksListner
 *
 */
@WebListener
public class PreparingBooksListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public PreparingBooksListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent e) {
    	
		List<Book> books = new ArrayList<>();
		
		Author akutagawa = new Author("���V��", "�H��");
		Author dazai = new Author("��", "����");
		
		books.add(new Book("������", akutagawa, 800, 3));
		books.add(new Book("�w偂̎�", akutagawa, 500, 5));
		books.add(new Book("�l�Ԏ��i", dazai, 1000, 1));
		
		ServletContext context = e.getServletContext();
		context.setAttribute("books", books);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent e) {
    	ServletContext context = e.getServletContext();
    	context.removeAttribute("books");
    }
	
}
