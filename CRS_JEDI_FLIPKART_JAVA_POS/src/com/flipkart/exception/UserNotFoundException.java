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
public class UserNotFoundException extends Exception {

    private String userId;

    /***
     * Setter function for UserId
     * @param userId
     */
    public UserNotFoundException(String id) {
        userId = id;
    }

    /**
     * Message thrown by exception
     */

    public String getMessage() {
        return "User with userId: " + userId + " not found.";
    }


}
