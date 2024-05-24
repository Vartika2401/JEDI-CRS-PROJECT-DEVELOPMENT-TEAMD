package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

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

import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.constant.SQLConstant;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class gradedao implements gradejaointerface{
    DBUtils db = new DBUtils();
    Connection conn = db.getConnection();

    /**
     * Retrieves the grades for a student in the specified courses.
     * @param studentID The ID of the student
     * @param courseids The list of course IDs for which grades are needed
     * @return A list of grades for the specified courses
     */
    public List<Integer> getGrades(int studentID, List<Integer> courseids) {
        try {
            List<Integer> grades = new ArrayList<>();
            for (int courseid : courseids) {
                PreparedStatement pstmt = conn.prepareStatement(SQLConstant.GET_STUDENT_GRADES);
                pstmt.setInt(1, studentID);
                pstmt.setInt(2, courseid);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    grades.add(rs.getInt("grade"));
                }
            }
            return grades;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
