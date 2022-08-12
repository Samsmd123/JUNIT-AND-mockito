package com.bookapp.testcases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;
@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)

class OrderTest {
	@Mock
	IBookService bookservice;
	
	@InjectMocks
	OrderDetails details;

	
	Book book1,book2,book3,book4,book5,book6,book7;
	List<Book> bookList=null;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		book1=new Book(1,"java","katty",900);
		book2=new Book(2,"The 5 am","Robin",900);
		book3=new Book(3,"Spring","katty",900);
		book4=new Book(4,"leadership","katty",900);
		book5=new Book(5,"The illusion","Dr joaesphMurphy",900);
		book6=new Book(6,"monk","Robin",900);
		book7=new Book(7,"jsp","katthy",900);
		bookList=Arrays.asList( book1,book2,book3,book4,book5,book6,book7);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	@DisplayName("Testing book -returns book instance")
	void testBookById()throws BookNotFoundException {
		//when(bookservice.getById(1)).thenReturn(book1);
		doReturn(book1).when(bookservice).getById(1);
		
		String actual=details.orderBook(1);
		assertEquals("Book orderd",actual);
	}
	
	@Test
	@DisplayName("Testing book -returns null")
	void testBookByIdNull()throws BookNotFoundException {
		doReturn(null).when(bookservice).getById(10);
		
		String actual=details.orderBook(10);
		assertEquals("Out of Stock",actual);
	}
	@Test
	@DisplayName("TEsting book -throws exception")
	void testBookByIdException()throws BookNotFoundException {
		
		doThrow(new BookNotFoundException("Invalid id")).when(bookservice).getById(10);
		
		String actual=details.orderBook(1);
		assertEquals("Technical issue",actual);
	}
	
	@Test @DisplayName(" testing add book")
	void testAddBook()throws BookNotFoundException{
		doNothing().when(bookservice).addBook(book1);
		String actual=details.addBook(book1);
		assertEquals("book added",actual);
	}
	
	
	
	//@Test @DisplayName(" testing add book--null")
	//void testAddBookNull()throws BookNotFoundException{
	
		//String actual=details.addBook(null);
		//assertEquals("book not added",actual);
	//}
	}

	


