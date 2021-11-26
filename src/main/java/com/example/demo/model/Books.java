package com.example.demo.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Books {
	
	@Autowired
	ArrayList<Book> books;//= new ArrayList<Book>();

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Books [books=" + books + "]";
	}
	
	
	

}
