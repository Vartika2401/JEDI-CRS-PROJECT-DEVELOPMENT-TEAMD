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

import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao.userdao;

public class studentregistration  implements  studentregistratoninterface{
    public void registerstudent() {
        // TODO Auto-generated method stub
        userdao user = new userdao();
        user.registerstudent();
    }

    public Boolean checkapproved(int studentID){
        userdao user = new userdao();
        return user.checkapproved(studentID);
    }

    public String getname(int studentID){
        userdao user = new userdao();
        return user.getname(studentID);
    }

    public void changepassword() {
        // TODO Auto-generated method stub
        userdao user = new userdao();
        user.changepassword();
    }
    public String login(int studentID, String password) {
        // TODO Auto-generated method stub
        userdao user = new userdao();
        return user.login(studentID, password);
    }
}
