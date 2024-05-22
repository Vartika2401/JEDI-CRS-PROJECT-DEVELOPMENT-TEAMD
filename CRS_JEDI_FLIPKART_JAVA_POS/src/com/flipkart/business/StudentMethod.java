package com.flipkart.business;

public class StudentMethod {
	public void getStudent() {
        System.out.println("This is the student object");
    }

    public void uploadGrade(int courseId, int studentId, String grade) {
        System.out.println("Grade '" + grade + "' uploaded for student " + studentId + " in course " + courseId + ".");
    }

    public void viewEnrolledStudents(int courseId) {
        System.out.println("Viewing students enrolled in course " + courseId + ".");
    }

    public void viewCourses() {
        System.out.println("The enrolled courses list");
    }

    public void profLogin(String emailId, String password) {
        System.out.println("Professor with email '" + emailId + "' is attempting to log in.");
    }
}
