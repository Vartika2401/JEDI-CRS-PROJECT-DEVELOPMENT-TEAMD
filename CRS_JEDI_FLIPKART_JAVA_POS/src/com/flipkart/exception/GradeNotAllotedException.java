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

public class GradeNotAllotedException extends Exception{

    private String studentId;

    /**
     * Constructor
     * @param studentId2
     */
    public GradeNotAllotedException(String studentId2)
    {
        this.studentId=studentId2;
    }

    /**
     * Getter function for studentId
     * @return
     */
    public String getStudentId()
    {
        return studentId;
    }

    /**
     * Message returned when exception is thrown
     */

    public String getMessage()
    {
        return "Student with id: " + studentId + "hasn't been alloted a grade yet";
    }
}