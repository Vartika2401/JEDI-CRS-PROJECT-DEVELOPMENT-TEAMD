package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

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

public interface userdaointerface {

    /**
     * Registers a new student in the system.
     * @return 0 if registration is successful
     */
    public int registerstudent();

    /**
     * Checks if a student's registration is approved.
     * @param studentID The ID of the student
     * @return True if the student's registration is approved, false otherwise
     */
    public Boolean checkapproved(int studentID);

    /**
     * Retrieves the name of a student based on their ID.
     * @param studentID The ID of the student
     * @return The name of the student
     */
    public String getname(int studentID);

    /**
     * Logs in a student using their ID and password.
     * @param studentID The ID of the student
     * @param password The password of the student
     * @return The role of the user if login is successful, "null" otherwise
     */
    public String login(int studentID, String password);

    /**
     * Changes the password for a student.
     */
    public void changepassword();
}
