package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;
//package com.flipkart.business;


import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao.professordao;


public class ProfessorMethod implements ProfessorInterface {

	@Override
	public void getProf(int profid) {
		professordao professordao = new professordao();
		professordao.getProf(profid);

	}

	    public void uploadGrade(int courseId, int studentId, String grade) {
	        System.out.println("Grade '" + grade + "' uploaded for student " + studentId + " in course " + courseId + ".");
	    }

	    public void viewEnrolledStudents(int courseId) {
	        System.out.println("Viewing students enrolled in course " + courseId + ".");
	    }

	    public void viewCourses() {
	        System.out.println("Enroled Courses");
	    }

	    public void profLogin(String emailId, String password) {
	        System.out.println("Professor with email '" + emailId + "' is attempting to log in.");
	    }

}
