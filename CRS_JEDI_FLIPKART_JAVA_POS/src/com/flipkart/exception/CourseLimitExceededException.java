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

public class CourseLimitExceededException extends Exception {

    private int num;

    /**
     * Constructor
     * @param num number of courses
     */
    public CourseLimitExceededException(int num )
    {
        this.num = num;
    }


    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage()
    {
        return "You have already registered for " + num + " courses";
    }
}