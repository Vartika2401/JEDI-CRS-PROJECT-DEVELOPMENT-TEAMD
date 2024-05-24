package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

/**
 * Author: Group-D
 * Vartika
 * Rohan Mitra
 * Rishabh Verma
 * Shivali Gupta
 * Srujana Sri
 * Asritha Dama
 * Prajwal Rayal
 **/

import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.constant.SQLConstant;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.utils.DBUtils;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.validator.StudentValidator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class studentdao implements studentdaointerface {
    Scanner scanner = new Scanner(System.in);
    DBUtils db = new DBUtils();
    Connection conn = db.getConnection();
    StudentValidator studentValidator = new StudentValidator();

    /**
     * Retrieves the details of a student based on their ID.
     * @param studentid The ID of the student
     */
    public void getStudent(int studentid) {
        try {
            studentValidator.studentExists(studentid);
            PreparedStatement pstmt = conn.prepareStatement(SQLConstant.GET_STUDENT);
            pstmt.setInt(1, studentid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.printf("Student ID: %d\nStudent Name: %s\nStudent Contact: %s\nStudent Email: %s\nStudent Department: %s\nStudent Courses: %s\n",
                        rs.getInt("studentid"), rs.getString("name"), rs.getString("contact"), rs.getString("email"), rs.getString("department"), rs.getString("enrolledcourses"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Shows the list of available courses.
     * @return A list of available course IDs
     */
    public List<Integer> showcourses() {
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQLConstant.SHOW_COURSES);
            ResultSet rs = pstmt.executeQuery();
            StudentValidator.courseexist(1);
            List<Integer> courses = new ArrayList<>();
            List<ArrayList> courseList = new ArrayList<>();

            while (rs.next()) {
                ArrayList<String> course = new ArrayList<>();
                course.add(Integer.toString(rs.getInt("profid")));
                course.add(Integer.toString(rs.getInt("courseid")));
                course.add(rs.getString("coursename"));
                course.add(rs.getString("prereq"));
                course.add(rs.getString("coursedept"));
                courseList.add(course);
                courses.add(rs.getInt("courseid"));
            }
            System.out.printf("%10s %10s %20s %20s %20s", "Professor ID", "Course ID", "Course Name", "Prerequisites", "Course Department");
            System.out.println();
            for (ArrayList<String> course : courseList) {
                System.out.printf("%10s %10s %20s %20s %20s", course.get(0), course.get(1), course.get(2), course.get(3), course.get(4));
                System.out.println();
            }
            return courses;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Shows the list of courses the student is enrolled in.
     * @param studentID The ID of the student
     * @return A list of enrolled course IDs
     */
    public List<Integer> showEnrolledCourses(int studentID) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQLConstant.SHOW_ENROLLED_COURSES);
            pstmt.setInt(1, studentID);
            ResultSet rs = pstmt.executeQuery();
            List<Integer> courses = new ArrayList<>();

            while (rs.next()) {
                String res = rs.getString("enrolledcourses");
                if (rs.wasNull()) {
                    return courses;
                }
                for (String course : res.split(",")) {
                    courses.add(Integer.parseInt(course));
                }
            }
            return courses;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Adds a course for the student.
     * @param courses The list of current courses
     * @param studentid The ID of the student
     * @param courseid The ID of the course to be added
     */
    public void addCourse(List<Integer> courses, int studentid, int courseid) {
        try {
            PreparedStatement pstmt1 = conn.prepareStatement(SQLConstant.GET_COURSE_DETAILS);
            pstmt1.setInt(1, courseid);
            ResultSet rs = pstmt1.executeQuery();
            if (!rs.next()) {
                System.out.println("Course does not exist!");
                return;
            }
            List<String[]> already_enrolled_courses = new ArrayList<>();
            PreparedStatement pstmt2 = conn.prepareStatement(SQLConstant.SHOW_ENROLLED_COURSES);
            pstmt2.setInt(1, studentid);
            ResultSet rs1 = pstmt2.executeQuery();
            boolean flag = true;
            while (rs1.next()) {
                String res = rs1.getString("enrolledcourses");
                if (rs1.wasNull()) {
                    res = "";
                    flag = false;
                }
                List<String> courses1 = List.of(res.split(","));
                for (String course : courses1) {
                    already_enrolled_courses.add(new String[]{course});
                }
            }
            String cid = Integer.toString(courseid);

            if (already_enrolled_courses.size() >= 6) {
                System.out.println("Sorry can't enroll for more courses!");
                return;
            }
            for (String[] course : already_enrolled_courses) {
                if (course[0].equals(cid)) {
                    System.out.println("Course already enrolled!");
                    return;
                }
            }
            if (flag) {
                already_enrolled_courses.add(new String[]{cid});
            } else {
                already_enrolled_courses.set(0, new String[]{cid});
            }

            StringBuilder enrolled_courses = new StringBuilder();
            for (String[] course : already_enrolled_courses) {
                enrolled_courses.append(course[0]).append(",");
            }
            PreparedStatement pstmt3 = conn.prepareStatement(SQLConstant.UPDATE_ENROLLED_COURSES);
            pstmt3.setString(1, enrolled_courses.toString());
            pstmt3.setInt(2, studentid);
            pstmt3.executeUpdate();
            addCoursetocoursecatalog(studentid, courseid);
            System.out.println("Course added successfully!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Deletes a course for the student.
     * @param courses The list of current courses
     * @param studentid The ID of the student
     * @param courseid The ID of the course to be deleted
     */
    public void deleteCourse(List<Integer> courses, int studentid, int courseid) {
        try {
            if (!courses.contains(courseid)) {
                System.out.println("Course not found in available courses!");
                return;
            }
            StringBuilder enrolled_courses = new StringBuilder();
            for (int course : courses) {
                if (course != courseid) {
                    enrolled_courses.append(course).append(",");
                }
            }
            PreparedStatement pstmt = conn.prepareStatement(SQLConstant.UPDATE_ENROLLED_COURSES);
            pstmt.setString(1, enrolled_courses.toString());
            pstmt.setInt(2, studentid);
            pstmt.executeUpdate();
            System.out.println("Course removed successfully!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Adds a student to the course catalog.
     * @param studentid The ID of the student
     * @param courseid The ID of the course
     */
    public void addCoursetocoursecatalog(int studentid, int courseid) {
        try {
            PreparedStatement pstmt1 = conn.prepareStatement(SQLConstant.GET_COURSE_DETAILS);
            pstmt1.setInt(1, courseid);
            ResultSet rs = pstmt1.executeQuery();
            if (!rs.next()) {
                System.out.println("Course does not exist!");
                return;
            }
            String add_student = rs.getString("enrolledstud");
            StringBuilder add_student1 = new StringBuilder();
            if (add_student == null) {
                add_student1.append(studentid);
            } else {
                add_student1.append(add_student).append(",").append(studentid);
            }
            System.out.println(add_student1);
            PreparedStatement pstmt3 = conn.prepareStatement(SQLConstant.UPDATE_COURSE_SET);
            pstmt3.setString(1, add_student1.toString());
            pstmt3.setInt(2, courseid);
            pstmt3.executeUpdate();
            System.out.println("Student added to enrolled students!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
