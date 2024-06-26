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
public class ProfessorNotAddedException extends Exception{
    private String professorId;

    public ProfessorNotAddedException(String id) {
        professorId = id;
    }

    /**
     * Getter function for professorId
     * @return
     */
    public String getUserId() {
        return this.professorId;
    }


    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage() {
        return "professorId: " + professorId + " not added!";
    }
}