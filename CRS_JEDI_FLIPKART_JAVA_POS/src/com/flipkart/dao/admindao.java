package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.constant.SQLConstant;

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
//            String course_id = "select courseid,enrolledstud from courses where approvalstatus= 0";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQLConstant.GET_COURSE_APPROVAL);
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
                    PreparedStatement pstmt = conn.prepareStatement(SQLConstant.UPDATE_APPROVAL_STATUS);
                    pstmt.setInt(1, courseid);
                    pstmt.executeUpdate();
                    System.out.println("Course with ID: " + courseid + " has been approved");
                } else {
                    if (enrolledstudents.size() < 3) {
                        System.out.println("Course with ID: " + courseid + " has less than 3 students");
//                        remove this course from student's catalog
                        studentdao studentdao = new studentdao();

                    } else {
                        System.out.println("Course with ID: " + courseid + " has more than 10 students");
                    }
                    studentdao studentdao = new studentdao();
                    for (int student : enrolledstudents) {
                        List<Integer> courses = studentdao.showEnrolledCourses(student);
                        studentdao.deleteCourse(courses, student, courseid);
                    }
                }
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void add_course_to_Catalog(int courseid, String coursename, String prereq, String coursedept) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            check if course already exists
            String check_query = "SELECT * FROM courses WHERE courseid = ?";
            PreparedStatement pstmt_check = conn.prepareStatement(check_query);
            pstmt_check.setInt(1, courseid);
            ResultSet rs = pstmt_check.executeQuery();
            if (rs.next()) {
                System.out.println("Course already exists in catalog");
                return;
            }
            String query = "INSERT INTO courses(courseid,coursename,prereq,coursedept,approvalstatus) VALUES(?,?,?,?,0)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, courseid);
            pstmt.setString(2, coursename);
            pstmt.setString(3, prereq);
            pstmt.setString(4, coursedept);
            pstmt.executeUpdate();
            System.out.println("Course added to catalog");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete_course_input(int courseid) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            check if course already exists
            String check_query = "SELECT * FROM courses WHERE courseid = ?";
            PreparedStatement pstmt_check = conn.prepareStatement(check_query);
            pstmt_check.setInt(1, courseid);
            ResultSet rs = pstmt_check.executeQuery();
            if (rs.next()) {
                List<Integer> enrolledstudents = new ArrayList<>();//                split rs.getString("enrolledstudents") and add to enrolledstudents
                String enrolled = rs.getString("enrolledstud");
                String[] students = enrolled.split(",");
                for (String student : students) {
                    enrolledstudents.add(Integer.parseInt(student));
                }
                if (enrolledstudents.size() == 0) {
                    System.out.println("Course with ID: " + courseid + " has been deleted");
                } else {
                    studentdao studentdao = new studentdao();
                    for (int student : enrolledstudents) {
                        List<Integer> courses = studentdao.showEnrolledCourses(student);
                        studentdao.deleteCourse(courses, student, courseid);
                    }
                }
                String query = "DELETE FROM courses WHERE courseid = ?";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, courseid);
                pstmt.executeUpdate();
                System.out.println("Course deleted from catalog");
                return;
            }
            else{
                System.out.println("Course does not exist in catalog");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete_course_student_count_wrong() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String course_id = "select courseid,enrolledstud from courses where approvalstatus= 0";
//            drop course from student table
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(course_id);
            while (rs.next()) {
                List<Integer> enrolledstudents = new ArrayList<>();
                int courseid = rs.getInt("courseid");
//                split rs.getString("enrolledstudents") and add to enrolledstudents
                String enrolled = rs.getString("enrolledstud");

                try {
                    String[] students = enrolled.split(",");
                    for (String student : students) {
                        enrolledstudents.add(Integer.parseInt(student));
                }}
                catch (Exception e){
                    System.out.println("Course with ID: " + courseid + " has been deleted");
                    String query = "DELETE FROM courses WHERE courseid = ?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setInt(1, courseid);
                    pstmt.executeUpdate();
                    System.out.println("Course deleted from catalog");
                    continue;
                }
                    if (enrolledstudents.size() < 3) {
                        System.out.println("Course with ID: " + courseid + " has less than 3 students");
                        System.out.println("Course ID: " + courseid);
                        System.out.println("Enrolled Students: " + enrolledstudents);
                        studentdao studentdao = new studentdao();
                        for (int student : enrolledstudents) {
                            List<Integer> courses = studentdao.showEnrolledCourses(student);
                            studentdao.deleteCourse(courses,student, courseid);
                        }

                    } else {
                        System.out.println("Course with ID: " + courseid + " has more than 10 students");
                        System.out.println("Course ID: " + courseid);
                        System.out.println("Enrolled Students: " + enrolledstudents);
                    }
                String query = "DELETE FROM courses WHERE courseid = ?";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, courseid);
                pstmt.executeUpdate();
                System.out.println("Course deleted from catalog");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
