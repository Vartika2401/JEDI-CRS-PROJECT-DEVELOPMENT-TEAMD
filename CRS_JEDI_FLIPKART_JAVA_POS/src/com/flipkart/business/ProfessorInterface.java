package com.flipkart.business;

public interface ProfessorInterface {
	
	public void getProf();

    public void uploadGrade(int courseId, int studentId, String grade) ;

    public void viewEnrolledStudents(int courseId) ;

    public void viewCourses() ;

    public void profLogin(String emailId, String password) ;
	
}
