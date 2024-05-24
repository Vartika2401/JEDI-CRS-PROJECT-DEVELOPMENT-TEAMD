package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.validator;

import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.constant.SQLConstant;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProfValidator {
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

    public static boolean nocourse(List<Integer> students) {
        return students.size() == 0;
    }
}
