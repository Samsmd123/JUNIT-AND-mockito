package com.testcases.demo.check;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.vfislk.training.User;

class UserTest {
User user;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		user=new User();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Testing greet")
	@Tag("greet")
	void testGreet() {
	System.out.println("TESTING GREET");
	String username="sammy";
	assertEquals("Welcome sammy",user.greet(username));
	}
	@Test
	@DisplayName("Testing list of fruits")
	void displayFruits() {
		List<String> fruits=Arrays.asList("apple","cherry","orange");
		assertEquals(fruits,user.showFruits());	
	}
	
	@Test
	@DisplayName("Testing list of fruits length")
	void displayLength() {
		List<String> fruits=user.showFruits();
		assertEquals(3,fruits.size());	
	}
}
