package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.bean;

public class EnrolledCourses {
    private String courseName;
    private int courseID;
    private String profName;
    private String department;
    private int grade;
    private String studentID;

    // Constructor
    public EnrolledCourses(String courseName, int courseID, String profName, String department, int grade, String studentID) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.profName = profName;
        this.department = department;
        this.grade = grade;
        this.studentID = studentID;
    }

    // Getters and Setters
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    // Method to view grade
    public void viewGrade() {
        System.out.println("Grade for course " + courseName + " (ID: " + courseID + "): " + grade);
    }
}