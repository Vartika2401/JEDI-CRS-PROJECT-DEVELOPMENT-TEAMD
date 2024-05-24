package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.constant;

public class SQLConstant {
    public static final String GET_COURSE_APPROVAL = "select * from course where approval_status = 0";
    public static final String UPDATE_APPROVAL_STATUS = "UPDATE courses SET approvalstatus = 1 WHERE courseid = ?";
}
