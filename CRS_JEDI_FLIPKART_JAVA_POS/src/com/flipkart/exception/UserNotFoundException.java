package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.exception;


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
