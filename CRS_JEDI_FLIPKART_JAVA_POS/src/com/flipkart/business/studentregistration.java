package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;

import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao.userdao;

public class studentregistration  implements  studentregistratoninterface{
    public void registerstudent() {
        // TODO Auto-generated method stub
        userdao user = new userdao();
        user.registerstudent();
        System.out.println("Student Registered");
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
