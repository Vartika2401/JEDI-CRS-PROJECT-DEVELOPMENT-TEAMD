package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.validator;

import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.constant.SQLConstant;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentValidator {

    /**
     * Checks if a student exists in the database.
     * @param studentID The ID of the student to be checked
     * @return True if the student exists, false otherwise
     */
    public static boolean studentExists(int studentID) {
        try {
            DBUtils db = new DBUtils();
            Connection conn = db.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQLConstant.GET_STUDENT);
            pstmt.setInt(1, studentID);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Checks if a course exists in the database.
     * @param CourseID The ID of the course to be checked
     * @return True if the course exists, false otherwise
     */
    public static boolean courseexist(int CourseID) {
        try {
            DBUtils db = new DBUtils();
            Connection conn = db.getConnection();
            PreparedStatement pstmt_check = conn.prepareStatement(SQLConstant.GET_COURSE_DETAILS);
            pstmt_check.setInt(1, CourseID);
            ResultSet rs = pstmt_check.executeQuery();
            return rs.next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
