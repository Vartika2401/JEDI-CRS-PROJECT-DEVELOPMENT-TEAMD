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

import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao.userdao;

public class studentregistration implements studentregistratoninterface {

    /**
     * Registers a student using the user DAO.
     */
    public void registerstudent() {
        // TODO Auto-generated method stub
        userdao user = new userdao();
        user.registerstudent();
    }

    /**
     * Checks if a student is approved using the user DAO.
     * @param studentID The ID of the student
     * @return True if the student is approved, false otherwise
     */
    public Boolean checkapproved(int studentID) {
        userdao user = new userdao();
        return user.checkapproved(studentID);
    }

    /**
     * Gets the name of the student using the user DAO.
     * @param studentID The ID of the student
     * @return The name of the student
     */
    public String getname(int studentID) {
        userdao user = new userdao();
        return user.getname(studentID);
    }

    /**
     * Changes the password for a student using the user DAO.
     */
    public void changepassword() {
        // TODO Auto-generated method stub
        userdao user = new userdao();
        user.changepassword();
    }

    /**
     * Logs in a student using their ID and password with the user DAO.
     * @param studentID The ID of the student
     * @param password The password of the student
     * @return A string indicating the login status
     */
    public String login(int studentID, String password) {
        // TODO Auto-generated method stub
        userdao user = new userdao();
        return user.login(studentID, password);
    }
}
