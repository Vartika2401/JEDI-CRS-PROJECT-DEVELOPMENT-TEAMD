package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.bean;
//package com.flipkart.bean;

/**
 * Author: Group-D
 * Vartika
 * Rohan Mitra
 * Rishabh Verma
 * Shivali Gupta
 * Srujana Sri
 * Asritha Dama
 * Prajwal Rayal
 **/

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private String department;
    private List<Integer> enrolledCourses;

    /**
     * Constructor
     * @param id The unique identifier for the student
     * @param name The name of the student
     * @param phone The phone number of the student
     * @param email The email address of the student
     * @param password The password for the student's account
     * @param role The role of the student
     * @param department The department the student belongs to
     */
    public Student(int id, String name, String phone, String email, String password, String role, String department) {
        super(id, name, phone, email, password, role);
        this.department = department;
        this.enrolledCourses = new ArrayList<Integer>();
    }

    /**
     * Gets the department of the student
     * @return The department of the student
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the department of the student
     * @param department The new department of the student
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Gets the list of courses the student is enrolled in
     * @return The list of enrolled courses
     */
    public List<Integer> getEnrolledCourses() {
        return enrolledCourses;
    }

    /**
     * Sets the list of courses the student is enrolled in
     * @param enrolledCourses The new list of enrolled courses
     */
    public void setEnrolledCourses(List<Integer> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    /**
     * Prints the details of the student
     */
    public void getStudent() {
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getId());
        System.out.println("Email ID: " + getEmail());
        System.out.println("Department: " + department);
        System.out.println("Selected Courses: " + enrolledCourses);
    }

    /**
     * Uploads the grade for a student in a course
     * @param courseId The ID of the course
     * @param studentId The ID of the student
     * @param grade The grade to be uploaded
     */
    public void uploadGrade(int courseId, int studentId, String grade) {
        System.out.println("Grade '" + grade + "' uploaded for student " + studentId + " in course " + courseId + ".");
    }

    /**
     * Views the students enrolled in a specific course
     * @param courseId The ID of the course
     */
    public void viewEnrolledStudents(int courseId) {
        System.out.println("Viewing students enrolled in course " + courseId + ".");
    }

    /**
     * Views the courses assigned to the student
     */
    public void viewCourses() {
        System.out.println("Courses assigned: " + enrolledCourses);
    }

    /**
     * Logs in a professor with the provided email and password
     * @param emailId The email ID of the professor
     * @param password The password of the professor
     */
    public void profLogin(String emailId, String password) {
        System.out.println("Professor with email '" + emailId + "' is attempting to log in.");
    }
}
