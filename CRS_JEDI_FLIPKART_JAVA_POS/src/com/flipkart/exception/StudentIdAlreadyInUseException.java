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

public class StudentIdAlreadyInUseException extends Exception{
    private String StudentId;


    /***
     * Setter function for ProfessorId
     * @param userId
     */

    public StudentIdAlreadyInUseException(String id) {
        StudentId = id;
    }

    /***
     * Getter function for ProfessorId
     * @param userId
     */

    public String getUserId() {
        return StudentId;
    }


    @Override
    public String getMessage() {
        return "userId: " + StudentId + " is already in use.";
    }

}