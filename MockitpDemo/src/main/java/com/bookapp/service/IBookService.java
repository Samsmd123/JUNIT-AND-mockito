package com.bookapp.service;

import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public interface IBookService {
	//list,null,exception,empty
	List<Book> getAll()throws BookNotFoundException;
	//List<Book> getByAuthor(String Author)throws BookNotFoundException;
	List<Book> getLessPrice(double price);
	Book getById(int bookId)throws BookNotFoundException ;//book,null,exception
	void addBook(Book book);

	String showMeassage(String name);	
	String greetMessage();//null,string
	 
}
