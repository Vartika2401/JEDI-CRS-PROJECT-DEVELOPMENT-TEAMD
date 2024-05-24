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

public interface gradeInterface {

    /**
     * Gets the grades for a student in the specified courses.
     * @param studentID The ID of the student
     * @param courseIDs The list of course IDs for which grades are needed
     * @return A list of grades for the specified courses
     */
    public List<Integer> getGrades(int studentID, List<Integer> courseIDs);
}
