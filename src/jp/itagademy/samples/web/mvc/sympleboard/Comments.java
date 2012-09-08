package jp.itagademy.samples.web.mvc.sympleboard;

import java.util.ArrayList;
import java.util.List;

public class Comments {
	public class Comment{
		private String name;
		private String comment;
	
		public Comment(String name, String comment) {
			this.name = name;
			this.comment = comment;
		}
	
		public String getName() {
			return name;
		}
	
		public String getComment() {
			return comment;
		}
	}
	
	private List<Comment> comments = new ArrayList<>();

	public List<Comment> getComments() {
		return comments;
	}
	
	public void addComments(String name, String comment){
		comments.add(new Comment(name, comment));
	}

}
