package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class admindao implements admindaointerface{
    static final String DB_URL = "jdbc:mysql://localhost/CRSSchema";
    static final String USER = "root";
    static final String PASS = "mahi_7781";
    public void approvecourses() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String course_id = "select courseid from courses where approvalstatus= 0";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(course_id);
            while (rs.next()) {
                List<Integer> enrolledstudents = new ArrayList<>();
                int courseid = rs.getInt("courseid");
//                split rs.getString("enrolledstudents") and add to enrolledstudents
                String enrolled = rs.getString("enrolledstud");
                String[] students = enrolled.split(",");
                for (String student : students) {
                    enrolledstudents.add(Integer.parseInt(student));
                }
                System.out.println("Course ID: " + courseid);
                System.out.println("Enrolled Students: " + enrolledstudents);
                if (enrolledstudents.size() >= 3 && enrolledstudents.size() <= 10) {
                    String update_query = "UPDATE course SET approvalstatus = 1 WHERE courseid = ?";
                    PreparedStatement pstmt = conn.prepareStatement(update_query);
                    pstmt.setInt(1, courseid);
                    pstmt.executeUpdate();
                    System.out.println("Course with ID: " + courseid + " has been approved");
                } else {
                    if (enrolledstudents.size() < 3) {
                        System.out.println("Course with ID: " + courseid + " has less than 3 students");
                    } else {
                        System.out.println("Course with ID: " + courseid + " has more than 10 students");
                    }
                }
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
