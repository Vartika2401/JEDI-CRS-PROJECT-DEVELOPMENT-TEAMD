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
public class CourseNotFoundException extends Exception{

    private String courseCode;

    public CourseNotFoundException(String courseCode)
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
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage()
    {
        return "Course with courseCode: " + courseCode + " not found.";
    }
}