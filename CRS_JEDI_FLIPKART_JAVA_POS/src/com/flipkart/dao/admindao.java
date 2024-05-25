package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.bean.Admin;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.constant.SQLConstant;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.utils.DBUtils;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.validator.AdminValidator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class admindao implements admindaointerface {
    DBUtils db = new DBUtils();
    Connection conn = db.getConnection();

    /**
     * Approves the registration of a student.
     * @param studid The ID of the student
     * @param pass The password of the student
     */

    public void showunapprovedstudents(){
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQLConstant.GET_UNAPPROVED_STUDENTS);
            ResultSet rs = pstmt.executeQuery();
            List<ArrayList> studentList = new ArrayList<>();
            while (rs.next()) {
                ArrayList<String> student = new ArrayList<>();
                student.add(rs.getString("id"));
                student.add(rs.getString("name"));
                student.add(rs.getString("contact"));
                student.add(rs.getString("email"));
                studentList.add(student);
            }
            System.out.printf("%10s %20s %20s %20s ", "User ID", "Name", "Contact", "Email");
            System.out.println();
            for (ArrayList<String> student : studentList) {
                System.out.printf("%10s %20s %20s %20s", student.get(0), student.get(1), student.get(2), student.get(3));
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void approveregistration(int studid, String pass) {
        try {

            PreparedStatement pstmt = conn.prepareStatement(SQLConstant.GET_USER);
            pstmt.setInt(1, studid);
            pstmt.setString(2, pass);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                PreparedStatement pstmt1 = conn.prepareStatement(SQLConstant.APPROVE_REGISTRATION);
                pstmt1.setInt(1, studid);
                pstmt1.executeUpdate();
                System.out.println("Student with ID: " + studid + " has been approved");
            } else {
                System.out.println("Student with ID: " + studid + " not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Approves courses based on the number of enrolled students.
     */
    public void approvecourses() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQLConstant.GET_COURSE_APPROVAL);
            while (rs.next()) {
                int courseid = rs.getInt("courseid");
                String enrolled = rs.getString("enrolledstud");
                List<Integer> enrolledstudents = new ArrayList<>();

                if (!rs.wasNull()) {
                    String[] students = enrolled.split(",");
                    for (String student : students) {
                        enrolledstudents.add(Integer.parseInt(student));
                    }
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Adds a course to the catalog.
     * @param courseid The ID of the course
     * @param coursename The name of the course
     * @param prereq The prerequisites for the course
     * @param coursedept The department offering the course
     */
    public void add_course_to_Catalog(int courseid, String coursename, String prereq, String coursedept) {
        try {
            AdminValidator adminValidator = new AdminValidator();
            if (adminValidator.coursealreadyexists(courseid)) {
                System.out.println("Course already exists in catalog");
                return;
            }
            PreparedStatement pstmt = conn.prepareStatement(SQLConstant.ADD_COURSE);
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

    /**
     * Deletes a course from the catalog using the course ID.
     * @param courseid The ID of the course to be deleted
     */
    public void delete_course_input(int courseid) {
        try {
            PreparedStatement pstmt_check = conn.prepareStatement(SQLConstant.GET_COURSE_DETAILS);
            pstmt_check.setInt(1, courseid);
            ResultSet rs = pstmt_check.executeQuery();
            if (rs.next()) {
                String enrolled = rs.getString("enrolledstud");
                List<Integer> enrolledstudents = new ArrayList<>();

                if (!rs.wasNull()) {
                    String[] students = enrolled.split(",");
                    for (String student : students) {
                        enrolledstudents.add(Integer.parseInt(student));
                    }
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
                PreparedStatement pstmt = conn.prepareStatement(SQLConstant.DELETE_COURSE);
                pstmt.setInt(1, courseid);
                pstmt.executeUpdate();
                System.out.println("Course deleted from catalog");
                return;
            } else {
                System.out.println("Course does not exist in catalog");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Deletes courses from the catalog that have an incorrect student count.
     */
    public void delete_course_student_count_wrong() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQLConstant.GET_ENROLLED_STUDENTS);
            while (rs.next()) {
                List<Integer> enrolledstudents = new ArrayList<>();
                int courseid = rs.getInt("courseid");
                String enrolled = rs.getString("enrolledstud");

                try {
                    String[] students = enrolled.split(",");
                    for (String student : students) {
                        enrolledstudents.add(Integer.parseInt(student));
                    }
                } catch (Exception e) {
                    System.out.println("Course with ID: " + courseid + " has been deleted");
                    PreparedStatement pstmt = conn.prepareStatement(SQLConstant.DELETE_COURSE);
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
                        studentdao.deleteCourse(courses, student, courseid);
                    }
                } else {
                    System.out.println("Course with ID: " + courseid + " has more than 10 students");
                    System.out.println("Course ID: " + courseid);
                    System.out.println("Enrolled Students: " + enrolledstudents);
                }
                PreparedStatement pstmt = conn.prepareStatement(SQLConstant.DELETE_COURSE);
                pstmt.setInt(1, courseid);
                pstmt.executeUpdate();
                System.out.println("Course deleted from catalog");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Enables the add/drop period.
     */
    public void enable_add_drop() {
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQLConstant.ENABLE_ADD_DROP);
            pstmt.executeUpdate();
            System.out.println("Add Drop enabled");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Disables the add/drop period.
     */
    public void disable_add_drop() {
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQLConstant.DISABLE_ADD_DROP);
            pstmt.executeUpdate();
            System.out.println("Add Drop disabled");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Declares the result.
     */
    public void declare_result() {
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQLConstant.DECLARE_RESULT);
            pstmt.executeUpdate();
            System.out.println("Result declared");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Stops the declaration of results.
     */
    public void stop_result() {
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQLConstant.STOP_RESULT);
            pstmt.executeUpdate();
            System.out.println("Result stopped");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
