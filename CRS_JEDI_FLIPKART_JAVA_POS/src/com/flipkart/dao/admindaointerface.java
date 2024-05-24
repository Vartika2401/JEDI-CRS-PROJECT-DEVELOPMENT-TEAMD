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

public interface admindaointerface {

    /**
     * Approves the registration of a student.
     * @param studid The ID of the student
     * @param password The password of the student
     */
    public void approveregistration(int studid, String password);

    /**
     * Approves courses based on the number of enrolled students.
     */
    public void approvecourses();

    /**
     * Adds a course to the catalog.
     * @param courseid The ID of the course
     * @param coursename The name of the course
     * @param prereq The prerequisites for the course
     * @param coursedept The department offering the course
     */
    public void add_course_to_Catalog(int courseid, String coursename, String prereq, String coursedept);

    /**
     * Deletes a course from the catalog using the course ID.
     * @param courseid The ID of the course to be deleted
     */
    public void delete_course_input(int courseid);

    /**
     * Deletes courses from the catalog that have an incorrect student count.
     */
    public void delete_course_student_count_wrong();

    /**
     * Enables the add/drop period.
     */
    public void enable_add_drop();

    /**
     * Declares the result.
     */
    public void declare_result();

    /**
     * Disables the add/drop period.
     */
    public void disable_add_drop();

    /**
     * Stops the declaration of results.
     */
    public void stop_result();
}
