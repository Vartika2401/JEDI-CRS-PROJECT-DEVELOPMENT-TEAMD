package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

import java.sql.*;
import java.util.Scanner;

public class userdao implements userdaointerface {
    static final String DB_URL = "jdbc:mysql://localhost/CRSSchema";
    static final String USER = "root";
    static final String PASS = "Fk!@#%213479";
    Scanner scanner = new Scanner(System.in);

    @Override
    public int registerstudent() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String student_id = "select count(*) from user";

            Statement stmt = conn.createStatement();
            System.out.println("Hello");
            ResultSet rs = stmt.executeQuery(student_id);
            System.out.println(rs);
            // Extract data from result set
            Integer sid = null;
            while (rs.next()) {
                sid = rs.getInt("count(*)") + 1;
                System.out.println(sid);
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
            String stu_query = "INSERT INTO student (studentid, department) VALUES (?,?)";
            PreparedStatement pstmt = conn.prepareStatement(stu_query);
            pstmt.setInt(1, sid);
            pstmt.setString(2, department);
            String user_query = "INSERT INTO user (id,name,contact,email,password) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt1 = conn.prepareStatement(user_query);
            pstmt1.setInt(1, sid);
            pstmt1.setString(2, name);
            pstmt1.setString(3, conc);
            pstmt1.setString(4, email);
            pstmt1.setString(5, pass);

            String user_query_role = "INSERT INTO user_roles (userid,role) VALUES (?, ?)";
            PreparedStatement pstmt2 = conn.prepareStatement(user_query_role);
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
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            Statement stmt = conn.createStatement();
            System.out.println("Enter your Student ID");
            Integer id = scanner.nextInt();
            System.out.println("Enter your current password");
            String pass = scanner.next();
//          check if this id and password exists in the database
            String check_query = "SELECT * FROM user WHERE id = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(check_query);
            pstmt.setInt(1, id);
            pstmt.setString(2, pass);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Enter your new password");
                String newpass = scanner.next();
                String update_query = "UPDATE user SET password = ? WHERE id = ?";
                PreparedStatement pstmt1 = conn.prepareStatement(update_query);
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
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            Statement stmt = conn.createStatement();
            Integer id = studentID;
            String check_query = "SELECT * FROM user WHERE id = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(check_query);
            pstmt.setInt(1, id);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Login Successful");
                String role_query = "SELECT * FROM user_roles WHERE userid = ?";
                PreparedStatement pstmt1 = conn.prepareStatement(role_query);
                pstmt1.setInt(1, id);
                if (pstmt1.execute()) {
                    System.out.println("Role fetched");
                }
                ResultSet rs1 = pstmt1.executeQuery();
                rs1.next();
                return rs1.getString("role");
            } else {
                System.out.println("Invalid Student ID or Password");
                return "Invalid Student ID or Password";
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
