package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.constant.SQLConstant;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.utils.DBUtils;

import java.sql.*;
import java.util.Scanner;

public class userdao implements userdaointerface {
    DBUtils db = new DBUtils();
    Connection conn = db.getConnection();
    Scanner scanner = new Scanner(System.in);

    @Override
    public int registerstudent() {
        try {
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(SQLConstant.USER_COUNT);
            Integer sid = null;
            while (rs.next()) {
                sid = rs.getInt("count(*)") + 1;
            }
            System.out.println("Enter your name");
            String name = scanner.next();
            System.out.println("Enter your contact");
            String conc = scanner.next();
            System.out.println("Enter your email");
            String email = scanner.next();
            System.out.println("Enter your password");
            String pass = scanner.next();
            System.out.println("Enter your department");
            String department = scanner.next();
//            String stu_query = "INSERT INTO student (studentid, department) VALUES (?,?)";
            PreparedStatement pstmt = conn.prepareStatement(SQLConstant.ADD_STUDENT_IN_STUDENT);
            pstmt.setInt(1, sid);
            pstmt.setString(2, department);
//            String user_query = "INSERT INTO user (id,name,contact,email,password) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt1 = conn.prepareStatement(SQLConstant.ADD_STUDENT_IN_USER);
            pstmt1.setInt(1, sid);
            pstmt1.setString(2, name);
            pstmt1.setString(3, conc);
            pstmt1.setString(4, email);
            pstmt1.setString(5, pass);

//            String user_query_role = "INSERT INTO user_roles (userid,role) VALUES (?, ?)";
            PreparedStatement pstmt2 = conn.prepareStatement(SQLConstant.ADD_STUDENT_IN_USER_ROLES);
            pstmt2.setInt(1, sid);
            pstmt2.setString(2, "student");

            pstmt.executeUpdate();
            pstmt1.executeUpdate();
            pstmt2.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public void changepassword() {
        try {

            Statement stmt = conn.createStatement();
            System.out.println("Enter your Student ID");
            Integer id = scanner.nextInt();
            System.out.println("Enter your current password");
            String pass = scanner.next();
            PreparedStatement pstmt = conn.prepareStatement(SQLConstant.CHECK_PASSWORD);
            pstmt.setInt(1, id);
            pstmt.setString(2, pass);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Enter your new password");
                String newpass = scanner.next();
                PreparedStatement pstmt1 = conn.prepareStatement(SQLConstant.UPDATE_PASSWORD);
                pstmt1.setString(1, newpass);
                pstmt1.setInt(2, id);
                pstmt1.executeUpdate();
                System.out.println("Password changed successfully");
            } else {
                System.out.println("Invalid Student ID or Password");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public  String login(int studentID, String password) {
        try {

            Statement stmt = conn.createStatement();
            Integer id = studentID;
            PreparedStatement pstmt = conn.prepareStatement(SQLConstant.CHECK_PASSWORD);
            pstmt.setInt(1, id);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Login Successful");
                PreparedStatement pstmt1 = conn.prepareStatement(SQLConstant.GET_USER_ROLE_NAME);
                pstmt1.setInt(1, id);
                System.out.println();
                ResultSet rs1 = pstmt1.executeQuery();
                rs1.next();
                String name= rs1.getString("name");
                System.out.println("Welcome "+name);
                return rs1.getString("role");
            } else {
                System.out.println("Invalid ID or Password");
                return "Invalid Student ID or Password";
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
