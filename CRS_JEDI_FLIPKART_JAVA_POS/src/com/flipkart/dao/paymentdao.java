package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.constant.SQLConstant;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.utils.DBUtils;

import java.sql.*;
import java.util.Scanner;

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

public class paymentdao {
    Scanner scanner = new Scanner(System.in);
    DBUtils db = new DBUtils();
    Connection conn = db.getConnection();
    public Integer getfeeAmount(Integer semid){
        try {
//                select rows where studentid = studentid and user id = studentid
//            String query = "SELECT * from fees_requirement WHERE semno=?";
            PreparedStatement pstmt = conn.prepareStatement(SQLConstant.GET_FEES);
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
//                select rows where studentid = studentid and user id = studentid
//            String query = "INSERT INTO payments(studentid,semno,paymentamount,paymentmode) VALUES(?,?,?,'online')";
            PreparedStatement pstmt = conn.prepareStatement(SQLConstant.INSERT_PAYMENT_ONLINE);
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
//            String query = "INSERT INTO payments(studentid,semno,paymentamount,paymentmode) VALUES(?,?,?,'offline')";
            PreparedStatement pstmt = conn.prepareStatement(SQLConstant.INSERT_PAYMENT_OFFLINE);
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
