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
public class CourseAlreadyRegisteredException extends Exception{

    private String courseCode;

    /**
     * Constructor
     * @param courseCode
     */
    public CourseAlreadyRegisteredException(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Getter method
     * @return course code
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage() {
        return "You have already registered for " + courseCode;
    }
}