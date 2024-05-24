package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.exception;
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
public class CourseNotDeletedException extends Exception {

    private String courseCode;

    public CourseNotDeletedException(String courseCode)
    {
        this.courseCode = courseCode;
    }

    /**
     * Getter function for course code
     * @return
     */
    public String getCourseCode()
    {
        return courseCode;
    }

    /**
     * Message thrown by exception
     */
    @Override
    public String getMessage()
    {
        return "Course with courseCode: " + courseCode + " can't be deleted.";
    }
}