package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class professordao implements professordaointerface{
    Scanner scanner = new Scanner(System.in);
    static final String DB_URL = "jdbc:mysql://localhost/CRSSchema";
    static final String USER = "root";
    static final String PASS = "Fk!@#%213479";

    public void getProf(int profid) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//                select rows where profid = profid and user id = profid
            String query = "SELECT * FROM prof LEFT JOIN user ON prof.profid = user.id WHERE prof.profid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, profid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("Professor ID: " + rs.getInt("profid"));
                System.out.println("Professor Name: " + rs.getString("name"));
                System.out.println("Professor Contact: " + rs.getString("contact"));
                System.out.println("Professor Email: " + rs.getString("email"));
                System.out.println("Professor Department: " + rs.getString("department"));
                System.out.println("Professor Courses: " + rs.getString("selectedcourses"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Integer> showFreeCourses() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            take the courses where prof id is null
            String query = "SELECT courseid,coursename,prereq,coursedept FROM courses WHERE courses.c_profid IS NULL";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
//            initialize a list of courses
            List<Integer> courses = new ArrayList<>();
            while (rs.next()) {
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


    public void selectCourse(List<Integer> courses, int profid, int courseid) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            if (!courses.contains(courseid)) {
                System.out.println("Course not free to select");
                return;
            }

//            make a set of courses and check if course exists in the set
            List<String[]> already_selected_courses = new ArrayList<>();

            String query = "SELECT selectedcourses FROM prof WHERE profid = ?";
            PreparedStatement pstmt2 = conn.prepareStatement(query);
            pstmt2.setInt(1, profid);
            ResultSet rs1 = pstmt2.executeQuery();
            boolean flag=true;
            while (rs1.next()) {
                String res=rs1.getString("selectedcourses");
                if (rs1.wasNull()){
                    res="";
                    flag=false;
                }
                for (String course : res.split(",")) {
                    already_selected_courses.add(course.split(","));
                }
            }
            String cid = Integer.toString(courseid);
            if (already_selected_courses.contains(cid)) {
                System.out.println("Course already selected!");
                return;
            }
            else{
                if (flag){
                    already_selected_courses.add(new String[]{cid});
                }
                else{
                    already_selected_courses.set(0, new String[]{cid});
                }


                StringBuilder selected_courses = new StringBuilder();
                for (String[] course : already_selected_courses) {
                    selected_courses.append(course[0]).append(",");
                }

                String update_query = "UPDATE prof SET selectedcourses = ? WHERE profid = ?";
                PreparedStatement pstmt3 = conn.prepareStatement(update_query);
                pstmt3.setString(1, selected_courses.toString());
                pstmt3.setInt(2, profid);
                pstmt3.executeUpdate();

                String update_query_course = "UPDATE courses SET c_profid = ? WHERE courseid = ?";
                PreparedStatement pstmt4 = conn.prepareStatement(update_query_course);
                pstmt4.setInt(1, profid);
                pstmt4.setInt(2, courseid);
                pstmt4.executeUpdate();

                System.out.println("Course selected successfully!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
