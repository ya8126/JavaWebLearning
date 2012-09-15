package jp.itagademy.samples.web.mvc.books;

public class Book {
	private String title;
	private Author author;
	private int price;
	private int quentity;
	
	public Book(String title, Author author, int price, int quentity) {
		this.author = author;
		this.price = price;
		this.title = title;
		this.quentity = quentity;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Author getAuthor() {
		return author;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getQuentity() {
		return quentity;
	}
	
}
