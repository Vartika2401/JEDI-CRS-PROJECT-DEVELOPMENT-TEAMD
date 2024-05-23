package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

import java.sql.*;
import java.util.Scanner;



public class paymentdao {
    Scanner scanner = new Scanner(System.in);
    static final String DB_URL = "jdbc:mysql://localhost/CRSSchema";
    static final String USER = "root";
    static final String PASS = "Fk!@#%213479";
    public Integer getfeeAmount(Integer semid){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//                select rows where studentid = studentid and user id = studentid
            String query = "SELECT * from fees_requirement WHERE semno=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, semid);
            ResultSet rs = pstmt.executeQuery();
            Integer amount = 0;
            while (rs.next()) {
                amount = rs.getInt("feeamount");
            }
            return amount;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void onlinepayment(Integer amount,Integer studentid, Integer semno){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//                select rows where studentid = studentid and user id = studentid
            String query = "INSERT INTO payments(studentid,semno,paymentamount,paymentmode) VALUES(?,?,?,'online')";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, studentid);
            pstmt.setInt(2, semno);
            pstmt.setInt(3, amount);
            pstmt.executeUpdate();
            System.out.println("Payment Successful");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void offlinepayment(Integer amount,Integer studentid, Integer semno) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "INSERT INTO payments(studentid,semno,paymentamount,paymentmode) VALUES(?,?,?,'offline')";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, studentid);
            pstmt.setInt(2, semno);
            pstmt.setInt(3, amount);
            pstmt.executeUpdate();
            System.out.println("Payment Successful");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
