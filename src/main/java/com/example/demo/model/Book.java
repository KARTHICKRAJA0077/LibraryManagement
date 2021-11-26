package com.example.demo.model;


//@Component
public class Book {

	String bookName;
	String authorName;
	String availibility;
	
	public Book(String bookName, String authorName, String availibility) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
		this.availibility = availibility;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAvailibility() {
		return availibility;
	}
	public void setAvailibility(String availibility) {
		this.availibility = availibility;
	}
	@Override
	public String toString() {
		return "Books [bookName=" + bookName + ", authorName=" + authorName + ", availibility=" + availibility + "]";
	}

}
