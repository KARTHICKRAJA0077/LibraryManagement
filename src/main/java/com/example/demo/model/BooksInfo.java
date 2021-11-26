package com.example.demo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;


public class BooksInfo {
	
	@Autowired
	Books books;//= new Books();
	
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//	Collection<Map<String, Object>> rows = jdbc.queryForList("SELECT QUERY");
	
	public Books findAll() {
		ArrayList<Book> booksList = new ArrayList<Book>();
		booksList.add(new Book("Desert", "stephan", "Available"));
		booksList.add(new Book("sea", "dreke", "Not Available"));
		booksList.add(new Book("wind", "eren", "Available"));
		booksList.add(new Book("sun", "ester", "Available"));
		booksList.add(new Book("moon", "nolan", "Not Available"));
		books.setBooks(booksList);
		return books;
	}
	
	public Books findFromDB() {
		ArrayList<Book> booksList = new ArrayList<Book>();
		try{  
			Class.forName("org.h2.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:h2:mem:testdatabase","sa","password");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from books");  
			while(rs.next())  {
			System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			booksList.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3)));}
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
			 
			//return null;
		books.setBooks(booksList);
		return books;
	}

	public void insertToDb(Book book) {
		try{  
			Class.forName("org.h2.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:h2:mem:testdatabase","sa","password");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement(); 
			String sql = "Insert into books values(\'"+book.getBookName()+"\',\'"+book.getAuthorName()+"\',\'"+book.getAvailibility()+"\')";
			int rs=stmt.executeUpdate(sql);  
			//while(rs.next())  {
			//System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			//booksList.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3)));}
			con.close();  
			}catch(Exception e){ System.out.println(e);}
		
	}
	
}
