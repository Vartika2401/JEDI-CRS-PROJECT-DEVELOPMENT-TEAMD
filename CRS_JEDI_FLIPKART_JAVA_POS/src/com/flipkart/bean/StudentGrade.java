package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.bean;

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

public class StudentGrade {

	private String courseID;
	private String courseName;
	private String grade;

	/**
	 * Constructor
	 * @param courseID The unique identifier for the course
	 * @param courseName The name of the course
	 * @param grade The grade received in the course
	 */
	public StudentGrade(String courseID, String courseName, String grade) {
		this.courseID = courseID;
		this.courseName = courseName;
		this.grade = grade;
	}

	/**
	 * Gets the course ID
	 * @return The course ID
	 */
	public String getCourseID() {
		return courseID;
	}

	/**
	 * Sets the course ID
	 * @param courseID The new course ID
	 */
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	/**
	 * Gets the course name
	 * @return The course name
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * Sets the course name
	 * @param courseName The new course name
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * Gets the grade received in the course
	 * @return The grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * Sets the grade received in the course
	 * @param grade The new grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
