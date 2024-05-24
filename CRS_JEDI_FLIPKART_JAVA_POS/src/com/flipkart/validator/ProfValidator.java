package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.validator;

import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.constant.SQLConstant;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProfValidator {

    /**
     * Checks if a course has no assigned professor.
     * @param CourseID The ID of the course to be checked
     * @return True if the course has no professor, false otherwise
     * @throws SQLException If there is an error accessing the database
     */
    public static boolean coursehasnoprof(int CourseID) throws SQLException {
        DBUtils db = new DBUtils();
        Connection conn = db.getConnection();

        PreparedStatement pstmt_check = conn.prepareStatement(SQLConstant.CHECK_COURSE_PROF);
        pstmt_check.setInt(1, CourseID);
        if (pstmt_check.executeQuery().next()) {
            return false;
        }
        return true;
    }

    /**
     * Checks if there are no courses assigned.
     * @param courses The list of courses
     * @return True if there are no courses, false otherwise
     */
    public static boolean nocourse(List<Integer> courses) {
        return courses.size() == 0;
    }
}
