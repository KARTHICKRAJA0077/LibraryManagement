package com.example.demo.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.model.Books;
import com.example.demo.model.BooksInfo;

@RestController
public class LibraryController {
	
	@Autowired
	Books books; //= new Books();
	
	@Autowired
	BooksInfo booksInfo;// = new BooksInfo();
	
	@RequestMapping("/book/{bookName}")
	public Book getBookInfo(@PathVariable String bookName) {
		if(!books.getBooks().isEmpty()) {
			Iterator<Book> iter = books.getBooks().iterator();//books.getBooks.iterator();
			while(iter.hasNext()) {
				Book book = iter.next();
				if(book.getBookName().equalsIgnoreCase(bookName))
					return book;
			}
		}
		
		return null;
	}
	
	@RequestMapping("/books")
	public Books getBooksInfo() {
		System.out.println("came here");
		books = booksInfo.findFromDB();
		//books = booksInfo.findAll();
		return books;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/insertBook")
	public void postBooksInfo(@RequestBody Book book) {
		//Book book= new Book("Desert", "stephan", "Available");
		booksInfo.insertToDb(book);
	}

}
