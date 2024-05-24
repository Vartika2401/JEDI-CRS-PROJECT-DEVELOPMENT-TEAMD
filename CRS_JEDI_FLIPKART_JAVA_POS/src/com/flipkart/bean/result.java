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

import java.util.HashMap;
import java.util.List;

public class result {
    private int studentID;
    private int semNumber;
    private int cgpa;
    private HashMap<String, Integer> sgpa;
    private List<Integer> regCourses;

    /**
     * Constructor
     * @param studentID The unique identifier for the student
     * @param semNumber The semester number
     * @param cgpa The cumulative grade point average
     * @param regCourses The list of registered courses
     */
    public result(int studentID, int semNumber, int cgpa, List<Integer> regCourses) {
        this.studentID = studentID;
        this.semNumber = semNumber;
        this.cgpa = cgpa;
        this.regCourses = regCourses;
        this.sgpa = new HashMap<>();
    }

    /**
     * Gets the student ID
     * @return The student ID
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * Sets the student ID
     * @param studentID The new student ID
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * Gets the semester number
     * @return The semester number
     */
    public int getSemNumber() {
        return semNumber;
    }

    /**
     * Sets the semester number
     * @param semNumber The new semester number
     */
    public void setSemNumber(int semNumber) {
        this.semNumber = semNumber;
    }

    /**
     * Gets the cumulative grade point average (CGPA)
     * @return The CGPA
     */
    public int getCgpa() {
        return cgpa;
    }

    /**
     * Sets the cumulative grade point average (CGPA)
     * @param cgpa The new CGPA
     */
    public void setCgpa(int cgpa) {
        this.cgpa = cgpa;
    }

    /**
     * Gets the semester grade point averages (SGPA)
     * @return The SGPA as a hashmap with keys as course names and values as SGPA
     */
    public HashMap<String, Integer> getSgpa() {
        return sgpa;
    }

    /**
     * Sets the semester grade point averages (SGPA)
     * @param sgpa The new SGPA as a hashmap with keys as course names and values as SGPA
     */
    public void setSgpa(HashMap<String, Integer> sgpa) {
        this.sgpa = sgpa;
    }

    /**
     * Gets the list of registered courses
     * @return The list of registered courses
     */
    public List<Integer> getRegCourses() {
        return regCourses;
    }

    /**
     * Sets the list of registered courses
     * @param regCourses The new list of registered courses
     */
    public void setRegCourses(List<Integer> regCourses) {
        this.regCourses = regCourses;
    }
}
