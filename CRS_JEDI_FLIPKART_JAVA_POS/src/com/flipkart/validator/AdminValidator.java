package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.validator;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.constant.SQLConstant;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class AdminValidator {
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

