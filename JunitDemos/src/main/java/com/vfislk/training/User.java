package com.vfislk.training;

import java.util.Arrays;
import java.util.List;

public class User {
	public String greet(String userName) {
	return "Welcome "+userName;
		
	}
	
	public List<String> showFruits(){
		return Arrays.asList("banana","apple","cherry","orange");
	}
	

}
