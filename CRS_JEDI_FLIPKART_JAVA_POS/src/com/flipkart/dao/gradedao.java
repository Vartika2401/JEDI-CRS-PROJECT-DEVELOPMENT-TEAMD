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
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.constant.SQLConstant;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class gradedao {
    DBUtils db = new DBUtils();
    Connection conn = db.getConnection();
    public List<Integer> getGrades(int studentID, List<Integer> courseids) {
        try {
//            select all the rows where studennt id = student id and course id = course id
            List<Integer> grades = new ArrayList<>();
            for (int courseid : courseids) {
//                String query = "SELECT * from grades WHERE studentid=? and courseid=?";
                PreparedStatement pstmt = conn.prepareStatement(SQLConstant.GET_STUDENT_GRADES);
                pstmt.setInt(1, studentID);
                pstmt.setInt(2, courseid);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    grades.add(rs.getInt("grade"));
                }
                return grades;
            }
            return grades;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
