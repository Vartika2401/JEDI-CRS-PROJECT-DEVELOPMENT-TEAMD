package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class professordao implements professordaointerface{
    Scanner scanner = new Scanner(System.in);
    DBUtils db = new DBUtils();
    Connection conn = db.getConnection();

    public void getProf(int profid) {
        try {
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

    public void showStudents(int profid){
        try {

            String query = "SELECT courseid FROM courses WHERE courses.c_profid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,profid);
            ResultSet rs = pstmt.executeQuery();

//            initialize a list of courses
            List<Integer> courses = new ArrayList<>();
            while (rs.next()) {
                courses.add(rs.getInt("courseid"));
            }
            if (courses.size()==0){
                System.out.println("Not teaching any courses!");
            }
            else{
                for (int cid : courses){
                    System.out.println("Students for course ID "+cid+" :-");
                    String query2 = "SELECT enrolledstud FROM courses WHERE courses.courseid = ?";
                    PreparedStatement pstmt2 = conn.prepareStatement(query2);
                    pstmt2.setInt(1,cid);
                    ResultSet rs2 = pstmt2.executeQuery();

//                    Get list of students for course
                    List<Integer> stud = new ArrayList<>();
                    while (rs2.next()) {
                        String res=rs2.getString("enrolledstud");
//                        System.out.println(res);
                        if (rs2.wasNull()){
                            System.out.println("    No students enrolled yet for this course");
                            break;
                        }
                        for (String id_string : res.split(",")) {
                            int studid = Integer.parseInt(id_string);
                            String query3 = "SELECT id,name,department FROM user LEFT JOIN student ON user.id=student.studentid WHERE user.id = ?";
                            PreparedStatement pstmt3 = conn.prepareStatement(query3);
                            pstmt3.setInt(1,studid);
                            ResultSet rs3 = pstmt3.executeQuery();
                            while (rs3.next()) {
                                System.out.print("  Student ID: " + rs3.getInt("id"));
                                System.out.print("  Name: " + rs3.getString("name"));
                                System.out.print("  Department: " + rs3.getString("department"));
                                System.out.println();
                            }
                        }
                        System.out.println();
                    }

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addGrade(int profid, int courseid, int sem) {
        try {

            String query = "SELECT COUNT(*) FROM courses WHERE courses.courseid=? and courses.c_profid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,courseid);
            pstmt.setInt(2,profid);
            ResultSet rs = pstmt.executeQuery();

            int  check=0;
            while (rs.next()) {
                check=rs.getInt("COUNT(*)");
            }
            if (check==0){
                System.out.println("Not teaching this course!");
            }

            else{
                String query2 = "SELECT enrolledstud FROM courses WHERE courses.courseid= ? and courses.c_profid = ?";
                PreparedStatement pstmt2 = conn.prepareStatement(query2);
                pstmt2.setInt(1,courseid);
                pstmt2.setInt(2,profid);
                ResultSet rs2 = pstmt2.executeQuery();


                List<Integer> stud = new ArrayList<>();
                while (rs2.next()) {
                    String res=rs2.getString("enrolledstud");
//                        System.out.println(res);
                    if (rs2.wasNull()){
                        System.out.println("No students enrolled yet for this course");
                        break;
                    }
                    System.out.println("Enter Grades for course ID "+courseid+" for each student :-");
                    Scanner scanner = new Scanner(System.in);
                    for (String id_string : res.split(",")) {
                        int studid = Integer.parseInt(id_string);
                        System.out.print("Enter Grade for student ID "+studid+" :-");
                        int grade = scanner.nextInt();

                        String update_query_grade = "INSERT INTO grades VALUES(?,?,?,?,?)";
                        PreparedStatement pstmt3 = conn.prepareStatement(update_query_grade);
                        pstmt3.setInt(1, studid);
                        pstmt3.setInt(2, profid);
                        pstmt3.setInt(3, courseid);
                        pstmt3.setInt(4, sem);
                        pstmt3.setInt(5, grade);
                        pstmt3.executeUpdate();
                    }
                    System.out.println();
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
