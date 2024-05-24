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
public class UserIdAlreadyInUseException extends Exception{
    private String userId;


    /***
     * Setter function for UserId
     * @param userId
     */

    public UserIdAlreadyInUseException(String id) {
        userId = id;
    }

    /***
     * Getter function for UserId
     * @param userId
     */

    public String getUserId() {
        return userId;
    }


    @Override
    public String getMessage() {
        return "userId: " + userId + " is already in use.";
    }

}