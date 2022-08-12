package com.bookapp.testcases;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;
@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)

class OrderDetailsTest {
	
@Mock
IBookService bookservice;
	
	@InjectMocks
	OrderDetails details;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}
	Book book1,book2,book3,book4,book5,book6,book7;
List<Book> bookList=null;
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
		details=null;
		
	}

	
@Test
void getByAuthor() throws BookNotFoundException {
	Mockito.when(bookservice.getAll()).thenReturn(bookList);
	String author="katty";
	List<Book> actualBooks=details.findBytAuthor(author);
	List<Book> expectedBooks=Arrays.asList(book3,book1,book4);
	assertEquals(expectedBooks,actualBooks);
}

@Test
@DisplayName("Testing by author -throw Exception")
void testGetByAuthorException() throws BookNotFoundException{
	String author="SAMREEN";
	Mockito.when(bookservice.getAll()).thenThrow(new BookNotFoundException());
	assertThrows(BookNotFoundException.class,()->{
		details.findBytAuthor(author);
	});
}


@Test
@DisplayName("Testing by author -empty list")
void testGetByAuthorEmpty() throws BookNotFoundException{
	String author="SAMREEN";
	List<Book> emptyList=new ArrayList<>();
	Mockito.when(bookservice.getAll()).thenReturn(emptyList);
	assertThrows(BookNotFoundException.class,()->{
		details.findBytAuthor(author);
	});
}
@Test
@DisplayName("Testing by author -null")
void testGetByAuthorNull() throws BookNotFoundException{
	String author="SAMREEN";
	Mockito.when(bookservice.getAll()).thenReturn(null);
	List<Book> actualBooks=details.findBytAuthor(author);
	assertNull(actualBooks);
		
	
}


	@Test
	void showMessage() {
		Mockito.when(bookservice.greetMessage()).thenReturn("Great Day");
		String actual=details.showMeassage("Priya");
		assertEquals("Great Day Priya",actual);
		String nactual =details.showMeassage("Prachi");
		assertEquals("Great Day Prachi",nactual);
	}
	
	@Test
	void testAnShowMessage() {
		Mockito.when(bookservice.greetMessage()).thenReturn("Great Day");
		String actual=details.showMeassage("Raj");
		
		assertEquals("Wrong user",actual);
		String nactual=details.showMeassage("heelen");
		assertEquals("Wrong user",nactual);
	}
	//@Test
	//void testAddBook() {
		//fail("Not yet implemented");
	}


