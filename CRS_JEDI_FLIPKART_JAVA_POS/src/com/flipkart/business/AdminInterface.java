package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;
/**
 * @author Group-D
 * Vartika
 * Rohan Mitra
 * Rishabh Verma
 * Shivali Gupta
 * Srujana Sri
 * Asritha Dama
 * Prajwal Rayal
 **/
public interface AdminInterface {
    public void showunapprovedstudents();
    public void  approveregistration(int studid,String password);
    /**
     * Approves the courses.
     */
    public void approveCourses();

    /**
     * Adds a course to the catalog.
     * @param courseid The ID of the course
     * @param coursename The name of the course
     * @param prereq The prerequisites for the course
     * @param coursedept The department offering the course
     */
    public void addCoursesToCatalog(int courseid, String coursename, String prereq, String coursedept);

    /**
     * Removes a course from the catalog using the course ID.
     * @param courseid The ID of the course to be removed
     */
    public void removeCoursesFromCatalog_inp(int courseid);

    /**
     * Removes courses from the catalog based on the count.
     */
    public void removeCoursesFromCatalog_count();

    /**
     * Enables the add/drop period for courses.
     */
    public void enableAddDrop();

    /**
     * Declares the results for the courses.
     */
    public void declareResult();

    /**
     * Disables the add/drop period for courses.
     */
    public void disableAddDrop();

    /**
     * Stops the declaration of results.
     */
    public void stopResult();
}
