package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;
//package com.flipkart.business;

import java.util.List;

public interface StudentInterface {
	
	public void getStudent(int studentid);
	public List<Integer> showcourses();
	public  void addcourse(List<Integer> courses, int studentid, int courseid);
	public List<Integer> showEnrolledCourses(int studentid);
	public void deletecourse(List<Integer> courses,int studentid,int courseid);
	public void viewGrade(int courseId, int studentId, String grade);
	public void viewEnrolledCourses(int studentId);
	public void studLogin(String emailId, String password);

}
