package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;

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

public interface studentregistratoninterface {

    public void registerstudent();
    public String getname(int studentID);
    public Boolean checkapproved(int studentID);
    public void changepassword();
    public String login(int studentID, String password);
}
