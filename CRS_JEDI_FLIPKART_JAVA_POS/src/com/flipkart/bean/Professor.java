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

import java.util.*;

public class Professor extends User {
    private String department;
    private List<Integer> selectedCourses;

    /**
     * Constructor
     * @param id The unique identifier for the professor
     * @param name The name of the professor
     * @param phone The phone number of the professor
     * @param email The email address of the professor
     * @param password The password for the professor's account
     * @param role The role of the professor
     * @param department The department the professor belongs to
     */
    public Professor(int id, String name, String phone, String email, String password, String role, String department) {
        super(id, name, phone, email, password, role);
        this.department = department;
        this.selectedCourses = new ArrayList<Integer>();
    }

    /**
     * Gets the department of the professor
     * @return The department of the professor
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the department of the professor
     * @param department The new department of the professor
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Gets the list of selected courses for the professor
     * @return The list of selected courses
     */
    public List<Integer> getSelectedCourses() {
        return selectedCourses;
    }

    /**
     * Sets the list of selected courses for the professor
     * @param selectedCourses The new list of selected courses
     */
    public void setSelectedCourses(List<Integer> selectedCourses) {
        this.selectedCourses = selectedCourses;
    }
}
