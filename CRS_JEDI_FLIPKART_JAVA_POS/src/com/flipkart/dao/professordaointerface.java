package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

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

public interface professordaointerface {

    /**
     * Retrieves the details of a professor based on their ID.
     * @param profid The ID of the professor
     */
    public void getProf(int profid);

    /**
     * Shows the list of courses that are available for selection.
     * @return A list of available course IDs
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
     * Shows the students enrolled in the courses taught by the professor.
     * @param profid The ID of the professor
     */
    public void showStudents(int profid);

    /**
     * Adds grades for students in a specific course taught by the professor.
     * @param profid The ID of the professor
     * @param courseid The ID of the course
     * @param sem The semester number
     */
    public void addGrade(int profid, int courseid, int sem);
}
