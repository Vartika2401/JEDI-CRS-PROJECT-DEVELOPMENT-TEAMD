package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class gradedao {
    static final String DB_URL = "jdbc:mysql://localhost/CRSSchema";
    static final String USER = "root";
    static final String PASS = "Fk!@#%213479";
    public List<Integer> getGrades(int studentID, List<Integer> courseids) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            select all the rows where studennt id = student id and course id = course id
            List<Integer> grades = new ArrayList<>();
            for (int courseid : courseids) {
                String query = "SELECT * from grades WHERE studentid=? and courseid=?";
                PreparedStatement pstmt = conn.prepareStatement(query);
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
