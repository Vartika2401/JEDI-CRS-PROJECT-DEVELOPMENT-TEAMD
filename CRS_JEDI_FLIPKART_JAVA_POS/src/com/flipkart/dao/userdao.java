package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

import java.sql.*;
import java.util.Scanner;

public class userdao implements userdaointerface {
    static final String DB_URL = "jdbc:mysql://localhost/CRSSchema";
    static final String USER = "root";
    static final String PASS = "mahi_7781";
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
            pstmt.setInt(1,sid);
            pstmt.setString(2, department);
            String user_query = "INSERT INTO user (id,name,contact,email,password) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt1 = conn.prepareStatement(user_query);
            pstmt1.setInt(1,sid);
            pstmt1.setString(2, name);
            pstmt1.setString(3, conc);
            pstmt1.setString(4, email);
            pstmt1.setString(5, pass);

            String user_query_role = "INSERT INTO user_roles (userid,role) VALUES (?, ?)";
            PreparedStatement pstmt2 = conn.prepareStatement(user_query_role);
            pstmt2.setInt(1,sid);
            pstmt2.setString(2, "student");

            pstmt.executeUpdate();
            pstmt1.executeUpdate();
            pstmt2.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
