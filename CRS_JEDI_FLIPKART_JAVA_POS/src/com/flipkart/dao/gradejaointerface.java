package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

import java.util.List;

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
public interface gradejaointerface {

    /**
     * Retrieves the grade for a student in a specific course.
     * @param studentID The ID of the student
     * @param courseID The ID of the course
     */
    public List<Integer> getGrades(int studentID, List<Integer> courseID);
}
