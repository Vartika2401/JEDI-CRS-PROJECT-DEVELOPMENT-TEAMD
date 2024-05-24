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

public class ProfessorIdAlreadyInUseException extends Exception{
    private String ProfessorId;


    /***
     * Setter function for ProfessorId
     * @param userId
     */

    public ProfessorIdAlreadyInUseException(String id) {
        ProfessorId = id;
    }

    /***
     * Getter function for ProfessorId
     * @param userId
     */

    public String getUserId() {
        return ProfessorId;
    }


    @Override
    public String getMessage() {
        return "userId: " + ProfessorId + " is already in use.";
    }

}