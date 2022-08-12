package com.testcases.trail;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.vfislk.exceptions.*;
import com.vfislk.training.Calculator;
import com.vfislk.training.Student;

class StudentTest {
	Student student;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Called before all testcases");
	}
	@AfterAll
	public static void cleanup() {
		System.out.println("Called after  all testcases");
	}
	
	@BeforeEach
	void setUp() throws Exception {
		student=new Student();
	}

	@AfterEach
	void tearDown() throws Exception {
		student=null;
	}

	@Test @DisplayName("Testing calcTotal")
	void testCalcTotal() throws NegtiveValueExceptions, InvalidNumberExcception {
		assertEquals(182,student.calcTotal(80, 90, 12));
	}
	
	@Test @DisplayName("Testing Neagtive Value")
	void testNegTotal() {
		assertThrows(NegtiveValueExceptions.class,()-> student.calcTotal(-90,80,76));
	}
	@Test @DisplayName("Testing marks greater than 100")
	void testMarksGreaterTotal() {
		assertThrows(InvalidNumberExcception.class,()-> student.calcTotal(90,120,176));
	}
	@Test
	@DisplayName("Testing grade A")
	void testGetGradeA() throws  InvalidNumberExcception,NegtiveValueExceptions{
		int[] marks= {98,96,92};
		
		assertEquals("A",student.getGrades(marks));
	}
	@Test
	@DisplayName("Testing grade B")

	void testGetGradeB() throws  InvalidNumberExcception,NegtiveValueExceptions{
		int[] marks= {82,81,92};
		
		assertEquals("B",student.getGrades(marks));
	}
	
	@Test
	@DisplayName("Testing grade c")
	
	void testGetGradeC() throws  InvalidNumberExcception, NegtiveValueExceptions{
		int[] marks= {78,76,65};
		
		assertEquals("C",student.getGrades(marks));
	}
	
	@Test
	@DisplayName("Testing grade D")
	void testGetGradeD() throws  InvalidNumberExcception,NegtiveValueExceptions{
		int[] marks= {54,58,51};
		
		assertEquals("D",student.getGrades(marks));
	}
	
	@Test
	@DisplayName("Testing Fail")
	@Tag("Fail")
	void testFail() throws  InvalidNumberExcception,NegtiveValueExceptions{
		int[] marks= {4,18,34};
	
		assertEquals("Fail",student.getGrades(marks),"Should be fail");
	}
	@Test @DisplayName("Testing Neagtive Value")
	
	void testNegativeTotal() {
		
		assertThrows(NegtiveValueExceptions.class,()-> student.calcTotal(-90, 43, 90));
	}
	@Test @DisplayName("Testing Null check")
	void testNullValue() throws InvalidNumberExcception, NegtiveValueExceptions {
		int[] marks=null;
		assertNull(student.getGrades(marks)); 
	}
}
