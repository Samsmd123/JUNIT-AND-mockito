package com.bookapp.testcases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
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

import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exception.Course;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)

class CourseTest {
	@Mock
	Course mcourse;
	@Spy
Course course;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		course=new Course();
	}

	@AfterEach
	void tearDown() throws Exception {
		course=null;
	}

	@Test @DisplayName(" testing showCourses")
	void testShowCourses() {
		List<String> courseList=Arrays.asList("java","spring","testing","angular");
		
		assertEquals(courseList,course.showCourses());
		
		
	}

	@Test @DisplayName(" testing showCoursesusing Mock")
	void testShowCoursesMock() {
		when(mcourse.showCourses()).thenReturn(Arrays.asList("java","spring"));
		List<String> courseList=Arrays.asList("java","spring");
		
		assertEquals(courseList,mcourse.showCourses());
		
		
	}

}
