package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;
//package com.flipkart.business;


public interface ProfessorInterface {
	
	public void getProf(int profid);

    public void uploadGrade(int courseId, int studentId, String grade) ;

    public void viewEnrolledStudents(int courseId) ;

    public void viewCourses() ;

    public void profLogin(String emailId, String password) ;
	
}
