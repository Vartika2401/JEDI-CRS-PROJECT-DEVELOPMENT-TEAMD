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
public class StudentNotFoundForApprovalException extends Exception{

    private String StudentId;

    public StudentNotFoundForApprovalException(String id) {
        StudentId = id;
    }

    /**
     * Getter function for professorId
     * @return
     */
    public String getUserId() {
        return StudentId;
    }


    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage() {
        return "StudentId: " + StudentId + " not registered!";
    }
}
