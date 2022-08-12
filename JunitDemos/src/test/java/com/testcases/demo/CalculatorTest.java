package com.testcases.demo;

import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
 import com.vfislk.training.Calculator;
class CalculatorTest {
	Calculator calculator;
	@BeforeAll
	public static void init() {
		System.out.println("Called before all testcases");
	}
	
	@BeforeEach
	public void setup() {
		 calculator=new Calculator();
		System.out.println("Called before each testcases");
	}
	
	@Test
	public void testAdd() {
		System.out.println("testing-------");
		int actual=calculator.sum(11, 10);
		assertEquals(21,actual);
	}
	@Test
	public void testProduct() {
		System.out.println("testing product");
		int actual=calculator.product(4, 2);
		assertEquals(8,actual);
	}
	
	@AfterEach
	public  void teardown() {
		calculator=null;
		System.out.println("Called after each testcases");
	}
	@AfterAll
	public static void cleanup() {
		System.out.println("Called after  all testcases");
	}
}
