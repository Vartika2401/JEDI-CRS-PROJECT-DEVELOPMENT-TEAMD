package com.flipkart.bean;

import java.util.*;

public class Professor {
	private String name;
    private int id;
    private String emailId;
    private String department;
    private List<Integer> selectedCourses;
    
//    Constructor
    public Professor(String name, int id, String emailId, String department) {
        this.name = name;
        this.id = id;
        this.emailId = emailId;
        this.department = department;
        this.selectedCourses = new ArrayList<Integer>();
    }

//    Getters and setters 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

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
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Email ID: " + emailId);
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
