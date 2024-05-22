package com.flipkart.bean;

import java.util.*;

public class Professor extends User {
    private String department;
    private List<Integer> selectedCourses;

//    Constructor
    public Professor(int id, String name, String phone, String email, String password, String role, String department) {
        super(id, name, phone, email, password, role);
        this.department = department;
        this.selectedCourses = new ArrayList<Integer>();
    }

//    Getters and setters for department and selectedCourses
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Integer> getSelectedCourses() {
        return selectedCourses;
    }

    public void setSelectedCourses(List<Integer> selectedCourses) {
        this.selectedCourses = selectedCourses;
    }

//    Methods
    public void getProf() {
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getId());
        System.out.println("Email ID: " + getEmail());
        System.out.println("Department: " + department);
        System.out.println("Selected Courses: " + selectedCourses);
    }

    public void uploadGrade(int courseId, int studentId, String grade) {
        System.out.println("Grade '" + grade + "' uploaded for student " + studentId + " in course " + courseId + ".");
    }

    public void viewEnrolledStudents(int courseId) {
        System.out.println("Viewing students enrolled in course " + courseId + ".");
    }

    public void viewCourses() {
        System.out.println("Courses assigned: " + selectedCourses);
    }

    public void profLogin(String emailId, String password) {
        System.out.println("Professor with email '" + emailId + "' is attempting to log in.");
    }
}
