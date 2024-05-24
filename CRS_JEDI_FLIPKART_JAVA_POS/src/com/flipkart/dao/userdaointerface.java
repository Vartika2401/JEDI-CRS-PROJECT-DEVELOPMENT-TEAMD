package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;
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
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.bean.Student;
public interface userdaointerface {
    public int registerstudent();
    public String login(int studentID, String password);
    public void changepassword();
}
