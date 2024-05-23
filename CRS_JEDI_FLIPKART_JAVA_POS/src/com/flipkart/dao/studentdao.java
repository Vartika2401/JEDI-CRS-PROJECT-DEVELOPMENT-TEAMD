package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class studentdao implements studentdaointerface {
    Scanner scanner = new Scanner(System.in);
    static final String DB_URL = "jdbc:mysql://localhost/CRSSchema";
    static final String USER = "root";
    static final String PASS = "Fk!@#%213479";

    public void getStudent(int studentid) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//                select rows where studentid = studentid and user id = studentid
            String query = "SELECT * FROM student LEFT JOIN user ON student.studentid = user.id WHERE student.studentid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, studentid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("Student ID: " + rs.getInt("studentid"));
                System.out.println("Student Name: " + rs.getString("name"));
                System.out.println("Student Contact: " + rs.getString("contact"));
                System.out.println("Student Email: " + rs.getString("email"));
                System.out.println("Student Department: " + rs.getString("department"));
                System.out.println("Student Courses: " + rs.getString("enrolledcourses"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Integer> showcourses() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//                select rows where studentid = studentid and user id = studentid
//            take the courses where prof id is not null and get the prof name from prof table
            String query = "SELECT profid,courseid,coursename,prereq,coursedept FROM prof LEFT JOIN courses ON courses.c_profid = prof.profid WHERE courses.c_profid IS NOT NULL";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
//            initialize a list of courses
            List<Integer> courses = new ArrayList<>();
            while (rs.next()) {
                System.out.print("Professor ID: " + rs.getInt("profid"));
                System.out.print("  Course ID: " + rs.getInt("courseid"));
                courses.add(rs.getInt("courseid"));
                System.out.print("  Course Name: " + rs.getString("coursename"));
                System.out.print("  Prerequisites: " + rs.getString("prereq"));
                System.out.print("  Course Department: " + rs.getString("coursedept"));
                System.out.println();

            }
            return courses;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Integer> showEnrolledCourses(int studentID) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//                select rows where studentid = studentid and user id = studentid
//            take the courses where prof id is not null and get the prof name from prof table
            String query= "SELECT enrolledcourses FROM student WHERE studentid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, studentID);
            ResultSet rs = pstmt.executeQuery();
//            initialize a list of courses
            List<Integer> courses = new ArrayList<>();
            while (rs.next()) {
                System.out.print("Enrolled Courses: " + rs.getString("enrolledcourses"));
                for (String course : rs.getString("enrolledcourses").split(",")) {
                    courses.add(Integer.parseInt(course));
                }
            }
            return courses;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addCourse(List<Integer> courses, int studentid, int courseid) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String check_if_course_exists = "SELECT * FROM courses WHERE courseid = ?";
            PreparedStatement pstmt1 = conn.prepareStatement(check_if_course_exists);
            pstmt1.setInt(1, courseid);
            ResultSet rs = pstmt1.executeQuery();
            if (!rs.next()) {
                System.out.println("Course does not exist!");
                return;
            }
//            make a set of courses and check if course exists in the set
            List<String[]> already_enrolled_courses = new ArrayList<>();
            String query = "SELECT enrolledcourses FROM student WHERE studentid = ?";
            PreparedStatement pstmt2 = conn.prepareStatement(query);
            pstmt2.setInt(1, studentid);
            ResultSet rs1 = pstmt2.executeQuery();
            boolean flag=true;
            while (rs1.next()) {
                String res=rs1.getString("enrolledcourses");
                if (rs1.wasNull()){
                    res="";
                    flag=false;
                }
                for (String course : res.split(",")) {
                    already_enrolled_courses.add(course.split(","));
                }
            }
            String cid = Integer.toString(courseid);

//            print the already enrolled courses
            for (String[] course : already_enrolled_courses) {
                System.out.println(course[0]);
            }
            if (already_enrolled_courses.contains(cid)) {
                System.out.println("Course already enrolled!");
                return;
            }
            else{
                if (flag){
                    already_enrolled_courses.add(new String[]{cid});
                }
                else{
                    already_enrolled_courses.set(0, new String[]{cid});
                }

//                make this already enrolled query a string with ",'
                StringBuilder enrolled_courses = new StringBuilder();
                for (String[] course : already_enrolled_courses) {
                    enrolled_courses.append(course[0]).append(",");
                }
                String update_query = "UPDATE student SET enrolledcourses = ? WHERE studentid = ?";
                PreparedStatement pstmt3 = conn.prepareStatement(update_query);
                pstmt3.setString(1, enrolled_courses.toString());
                pstmt3.setInt(2, studentid);
                pstmt3.executeUpdate();
                System.out.println("Course added successfully!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCourse(List<Integer> courses, int studentid,int courseid) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            if (!courses.contains(courseid)) {
                System.out.println("Course not found in available courses!");
                return;
            }
//            make a string of all the course ids
            StringBuilder enrolled_courses = new StringBuilder();
            System.out.println("Course id to remove: "+courseid);
            for (int course : courses) {
//                System.out.println(course);

                if (course != courseid) {
                    enrolled_courses.append(course).append(",");
                }
            }


            String deletecourse = "UPDATE student SET enrolledcourses = ? WHERE studentid = ?";
            PreparedStatement pstmt = conn.prepareStatement(deletecourse);
            pstmt.setString(1, enrolled_courses.toString());
            pstmt.setInt(2, studentid);
            pstmt.executeUpdate();
            System.out.println("Course removed successfully!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}