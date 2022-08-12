package com.vfislk.training;

import com.vfislk.exceptions.*;;

public class Student {
	public int calcTotal(int x,int y,int z) throws NegtiveValueExceptions, InvalidNumberExcception{
		if(x<0||y<0||z<0) {
			throw new NegtiveValueExceptions("Marks should be greater than zero");
		}
		if(x>100||y>100||z>100) {
			throw new InvalidNumberExcception("Marks should be less than zero");
		}
		return (x+y+z);
		
	}
public String getGrades(int[] marks) throws NegtiveValueExceptions   {
	int  sum=0;
	String grade=null;
	if(marks==null)
		return "Marks not intialized";
	for(int mark:marks) {
		if(mark<0||mark>100)
			throw new NegtiveValueExceptions();
			sum+=mark;	
	}
	double average=sum/marks.length;
	
	if(average>=90) {
		grade="A";
	}
	if(average>80 && average<90 ) {
		grade="B";
	}
	if(average>60 && average<80 ) {
		grade="C";
	}
	if(average>50 && average<60) {
		grade="D";
	}

	if(average<50 ) {
	grade="Fail";
	}
	return grade;
}
}
