package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private String department;
    private List<Integer> enrolledCourses;

//    Constructor
    public Student(int id, String name, String phone, String email, String password, String role, String department) {
        super(id, name, phone, email, password, role);
        this.department = department;
        this.enrolledCourses = new ArrayList<Integer>();
    }

//    Getter and Setter for department and enrolledCourses
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Integer> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Integer> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

//  	Methods
    public void getStudent() {
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getId());
        System.out.println("Email ID: " + getEmail());
        System.out.println("Department: " + department);
        System.out.println("Selected Courses: " + enrolledCourses);
    }

    public void uploadGrade(int courseId, int studentId, String grade) {
        System.out.println("Grade '" + grade + "' uploaded for student " + studentId + " in course " + courseId + ".");
    }

    public void viewEnrolledStudents(int courseId) {
        System.out.println("Viewing students enrolled in course " + courseId + ".");
    }

    public void viewCourses() {
        System.out.println("Courses assigned: " + enrolledCourses);
    }

    public void profLogin(String emailId, String password) {
        System.out.println("Professor with email '" + emailId + "' is attempting to log in.");
    }
}
