package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;
//package com.flipkart.business;

public interface StudentInterface {
	
	public void getStudent();
	public void viewGrade(int courseId, int studentId, String grade);
	public void viewEnrolledCourses(int studentId);
	public void studLogin(String emailId, String password);

}
