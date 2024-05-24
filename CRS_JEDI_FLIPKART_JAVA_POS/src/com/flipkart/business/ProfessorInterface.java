package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;
//package com.flipkart.business;

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

import java.util.List;

public interface ProfessorInterface {

    /**
     * Retrieves the professor's details based on the professor ID.
     * @param profid The ID of the professor
     */
    public void getProf(int profid);

    /**
     * Shows the list of courses that are free (available).
     * @return A list of free course IDs
     */
    public List<Integer> showFreeCourses();

    /**
     * Selects a course for the professor.
     * @param courses The list of courses to be selected
     * @param profid The ID of the professor
     * @param courseid The ID of the course to be selected
     */
    public void selectCourse(List<Integer> courses, int profid, int courseid);

    /**
     * Shows the students enrolled in the professor's courses.
     * @param profid The ID of the professor
     */
    public void showStudents(int profid);

    /**
     * Adds a grade for a student in a specific course and semester.
     * @param profId The ID of the professor
     * @param courseId The ID of the course
     * @param sem The semester number
     */
    public void addGrade(int profId, int courseId, int sem);
}
