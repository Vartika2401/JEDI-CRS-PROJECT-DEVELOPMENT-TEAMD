package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.constant.SQLConstant;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.utils.DBUtils;

import java.sql.*;
import java.util.Scanner;

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

public class paymentdao implements paymentdaointerface{
    Scanner scanner = new Scanner(System.in);
    DBUtils db = new DBUtils();
    Connection conn = db.getConnection();

    /**
     * Retrieves the fee amount for a given semester.
     * @param semid The semester ID
     * @return The fee amount for the specified semester
     */
    public Integer getfeeAmount(Integer semid) {
        try {
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

    /**
     * Processes an online payment for a student.
     * @param amount The amount to be paid
     * @param studentid The ID of the student making the payment
     * @param semno The semester number for which the payment is made
     */
    public void onlinepayment(Integer amount, Integer studentid, Integer semno) {
        try {
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

    /**
     * Processes an offline payment for a student.
     * @param amount The amount to be paid
     * @param studentid The ID of the student making the payment
     * @param semno The semester number for which the payment is made
     */
    public void offlinepayment(Integer amount, Integer studentid, Integer semno) {
        try {
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
