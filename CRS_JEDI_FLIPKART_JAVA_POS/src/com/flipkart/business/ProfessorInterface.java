package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;
//package com.flipkart.business;


import java.util.List;

public interface ProfessorInterface {
	
	public void getProf(int profid);

    public List<Integer> showFreeCourses();

    public  void selectCourse(List<Integer> courses, int profid, int courseid);

    public void showStudents(int profid) ;

    public void uploadGrade(int courseId, int studentId, String grade) ;




	
}
