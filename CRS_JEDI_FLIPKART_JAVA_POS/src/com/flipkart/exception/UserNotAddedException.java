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
public class UserNotAddedException extends Exception{
    private String userId;

    public UserNotAddedException(String id) {
        userId = id;
    }

    /**
     * Getter function for UserId
     * @return
     */
    public String getUserId() {
        return userId;
    }


    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage() {
        return "UserId: " + userId + " not added!";
    }
}