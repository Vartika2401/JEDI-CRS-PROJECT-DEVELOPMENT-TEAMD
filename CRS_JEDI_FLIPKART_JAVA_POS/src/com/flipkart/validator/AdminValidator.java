package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.validator;

import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.constant.SQLConstant;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminValidator {

    /**
     * Checks if a course with the given ID already exists in the database.
     * @param CourseID The ID of the course to be checked
     * @return True if the course already exists, false otherwise
     * @throws SQLException If there is an error accessing the database
     */
    public static boolean coursealreadyexists(int CourseID) throws SQLException {
        DBUtils db = new DBUtils();
        Connection conn = db.getConnection();
        PreparedStatement pstmt_check = conn.prepareStatement(SQLConstant.GET_COURSE_DETAILS);
        pstmt_check.setInt(1, CourseID);
        ResultSet rs = pstmt_check.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }
}
