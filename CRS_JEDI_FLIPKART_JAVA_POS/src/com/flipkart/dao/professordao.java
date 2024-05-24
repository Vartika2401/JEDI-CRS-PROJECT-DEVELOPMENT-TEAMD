package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.constant.SQLConstant;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.utils.DBUtils;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.validator.AdminValidator;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.validator.ProfValidator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class professordao implements professordaointerface{
    Scanner scanner = new Scanner(System.in);
    DBUtils db = new DBUtils();
    Connection conn = db.getConnection();
    ProfValidator profValidator = new ProfValidator();

    public void getProf(int profid) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQLConstant.GET_PROF);
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
            PreparedStatement pstmt = conn.prepareStatement(SQLConstant.SHOW_FREE_COURSES);
            ResultSet rs = pstmt.executeQuery();
//            initialize a list of courses
            List<Integer> courses = new ArrayList<>();
            List<ArrayList> courseList = new ArrayList<>();
            while (rs.next()) {
                ArrayList<String> course = new ArrayList<>();
                course.add(Integer.toString(rs.getInt("courseid")));
                course.add(rs.getString("coursename"));
                course.add(rs.getString("prereq"));
                course.add(rs.getString("coursedept"));
                courseList.add(course);
                courses.add(rs.getInt("courseid"));
            }
            System.out.printf("%10s %20s %20s %20s", "Course ID", "Course Name", "Prerequisites", "Course Department");
            System.out.println();
            for (ArrayList<String> course : courseList) {
                System.out.printf("%10s %20s %20s %20s", course.get(0), course.get(1), course.get(2), course.get(3));
                System.out.println();
            }
            return courses;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void selectCourse(List<Integer> courses, int profid, int courseid) {
        try {

//            if (!courses.contains(courseid)) {
//                System.out.println("Course not free to select");
//                return;
//            }
            if (!profValidator.coursehasnoprof(courseid)) {
                System.out.println("Course not free to select");
                return;
            }

//            make a set of courses and check if course exists in the set
            List<String[]> already_selected_courses = new ArrayList<>();

            PreparedStatement pstmt2 = conn.prepareStatement(SQLConstant.SELECT_COURSE);
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

                PreparedStatement pstmt3 = conn.prepareStatement(SQLConstant.UPDATE_PROF_COURSE);
                pstmt3.setString(1, selected_courses.toString());
                pstmt3.setInt(2, profid);
                pstmt3.executeUpdate();

                PreparedStatement pstmt4 = conn.prepareStatement(SQLConstant.UPDATE_CPROF);
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

            PreparedStatement pstmt = conn.prepareStatement(SQLConstant.GET_COURSE_ID_FROM_PROF);
            pstmt.setInt(1,profid);
            ResultSet rs = pstmt.executeQuery();

//            initialize a list of courses
            List<Integer> courses = new ArrayList<>();
            while (rs.next()) {
                courses.add(rs.getInt("courseid"));
            }

            if (profValidator.nocourse(courses)){
                System.out.println("No courses assigned to this professor!");
            }
            else{
                for (int cid : courses){
                    System.out.println("Students for course ID "+cid+" :-");
<<<<<<< Updated upstream
                    System.out.println();
                    System.out.printf("%10s %20s %20s", "Student ID", "Name", "Department");
//                    String query2 = "SELECT enrolledstud FROM courses WHERE courses.courseid = ?";
=======
>>>>>>> Stashed changes
                    PreparedStatement pstmt2 = conn.prepareStatement(SQLConstant.ENROLLED_STUDENTS_IN_A_COURSE);
                    pstmt2.setInt(1,cid);
                    ResultSet rs2 = pstmt2.executeQuery();

//                    Get list of students for course
                    List<Integer> stud = new ArrayList<>();
                    while (rs2.next()) {
                        String res = rs2.getString("enrolledstud");
//                        System.out.println(res);
                        if (rs2.wasNull()) {
                            System.out.println("    No students enrolled yet for this course");
                            break;
                        }
                        System.out.println();
                        for (String id_string : res.split(",")) {
                            int studid = Integer.parseInt(id_string);
                            PreparedStatement pstmt3 = conn.prepareStatement(SQLConstant.GET_ID_NAME);
                            pstmt3.setInt(1, studid);
                            ResultSet rs3 = pstmt3.executeQuery();
                            List<ArrayList> studentList = new ArrayList<>();
                            while (rs3.next()) {
                                ArrayList<String> student = new ArrayList<>();
                                student.add(Integer.toString(rs3.getInt("id")));
                                student.add(rs3.getString("name"));
                                student.add(rs3.getString("department"));
                                studentList.add(student);
                            }


                            for (ArrayList<String> student : studentList) {
                                System.out.printf("%10s %20s %20s", student.get(0), student.get(1), student.get(2));
                            }
                            System.out.println();
                        }
                    }
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addGrade(int profid, int courseid, int sem) {
        try {

            PreparedStatement pstmt = conn.prepareStatement(SQLConstant.GET_COURSE_COUNT);
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
                PreparedStatement pstmt2 = conn.prepareStatement(SQLConstant.ENROLLED_STUDENTS_BY_PROF);
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
                    System.out.println("Grades submitted successfully");
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
