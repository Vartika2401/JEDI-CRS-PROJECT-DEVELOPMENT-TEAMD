package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;
//package com.flipkart.business;
/**
 * @author Group-D
 * Vartika
 * Rohan Mitra
 * Rishabh Verma
 * Shivali Gupta
 * Srujana Sri
 * Asritha Dama
 * Prajwal Rayal
 **/

import java.util.List;

public interface ProfessorInterface {
	
	public void getProf(int profid);

    public List<Integer> showFreeCourses();

    public  void selectCourse(List<Integer> courses, int profid, int courseid);

    public void showStudents(int profid) ;

    public void addGrade(int profId, int courseId, int sem) ;
	
}
