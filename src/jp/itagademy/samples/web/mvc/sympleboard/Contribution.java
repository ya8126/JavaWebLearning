package jp.itagademy.samples.web.mvc.sympleboard;

import java.util.Date;

public class Contribution {
	private String name;
	private String comment;
	private Date date;

	public Contribution(String name, String comment, Date date) {
		this.name = name;
		this.comment = comment;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public String getComment() {
		return comment;
	}

	public Date getDate() {
		return date;
	}
}
