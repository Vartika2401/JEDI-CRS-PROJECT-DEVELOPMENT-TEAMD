package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.exception;

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