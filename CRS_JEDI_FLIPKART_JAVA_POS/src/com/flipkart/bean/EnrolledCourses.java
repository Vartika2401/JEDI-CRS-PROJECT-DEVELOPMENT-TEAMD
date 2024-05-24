package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.bean;

/**
 * @author Group-D
 * Vartika
 * Rohan Mitra
 * Rishabh Verma
 * Shivali Gupta
 * Srujana Sri
 * Asritha Dama
 * Prajwal Rayal
 **/

public class EnrolledCourses {
    private String courseName;
    private int courseID;
    private String profName;
    private String department;
    private int grade;
    private String studentID;

    /**
     * Constructor
     * @param courseName The name of the course
     * @param courseID The unique identifier for the course
     * @param profName The name of the professor teaching the course
     * @param department The department offering the course
     * @param grade The grade received in the course
     * @param studentID The ID of the student enrolled in the course
     */
    public EnrolledCourses(String courseName, int courseID, String profName, String department, int grade, String studentID) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.profName = profName;
        this.department = department;
        this.grade = grade;
        this.studentID = studentID;
    }

    /**
     * Gets the name of the course
     * @return The course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the name of the course
     * @param courseName The new course name
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Gets the unique identifier of the course
     * @return The course ID
     */
    public int getCourseID() {
        return courseID;
    }

    /**
     * Sets the unique identifier of the course
     * @param courseID The new course ID
     */
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    /**
     * Gets the name of the professor teaching the course
     * @return The professor's name
     */
    public String getProfName() {
        return profName;
    }

    /**
     * Sets the name of the professor teaching the course
     * @param profName The new professor's name
     */
    public void setProfName(String profName) {
        this.profName = profName;
    }

    /**
     * Gets the department offering the course
     * @return The department name
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the department offering the course
     * @param department The new department name
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Gets the grade received in the course
     * @return The grade
     */
    public int getGrade() {
        return grade;
    }

    /**
     * Sets the grade received in the course
     * @param grade The new grade
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * Gets the ID of the student enrolled in the course
     * @return The student ID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * Sets the ID of the student enrolled in the course
     * @param studentID The new student ID
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * Prints the grade for the course
     */
    public void viewGrade() {
        System.out.println("Grade for course " + courseName + " (ID: " + courseID + "): " + grade);
    }
}
