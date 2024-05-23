package com.flipkart.business;

public class StudentMethod {
	public void getStudent() {
        System.out.println("This is the student object");
    }

    public void viewGrade(int courseId, int studentId, String grade) {
        System.out.println("Grade " + grade + " for student " + studentId + " in course " + courseId + ".");
    }


    public void viewEnrolledCourses(int studentId) {
        System.out.println("The enrolled courses list");
    }

    public void studLogin(String emailId, String password) {
        System.out.println("Student with email '" + emailId + "' is attempting to log in.");
    }
}
