package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;

/**
 * Author: Group-D
 * Vartika
 * Rohan Mitra
 * Rishabh Verma
 * Shivali Gupta
 * Srujana Sri
 * Asritha Dama
 * Prajwal Rayal
 **/

public interface studentregistratoninterface {

    /**
     * Registers a student.
     */
    public void registerstudent();

    /**
     * Gets the name of the student.
     * @param studentID The ID of the student
     * @return The name of the student
     */
    public String getname(int studentID);

    /**
     * Checks if a student is approved.
     * @param studentID The ID of the student
     * @return True if the student is approved, false otherwise
     */
    public Boolean checkapproved(int studentID);

    /**
     * Changes the password for a student.
     */
    public void changepassword();

    /**
     * Logs in a student using their ID and password.
     * @param studentID The ID of the student
     * @param password The password of the student
     * @return A string indicating the login status
     */
    public String login(int studentID, String password);
}
