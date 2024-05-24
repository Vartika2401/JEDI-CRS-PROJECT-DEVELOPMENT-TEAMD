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

public class CourseNotAvailableException extends Exception{

    private String courseCode;

    /**
     * Constructor
     * @param courseCode
     */
    public CourseNotAvailableException(String courseCode)
    {
        this.courseCode = courseCode;
    }


    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage() {
        return  "Seats are not available in : " + courseCode;
    }


}