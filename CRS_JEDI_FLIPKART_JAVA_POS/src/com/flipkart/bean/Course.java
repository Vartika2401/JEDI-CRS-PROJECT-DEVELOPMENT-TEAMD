package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.bean;
//package com.flipkart.bean;


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

import java.util.*;

public class Course {

	private String courseName;
	private int courseID;
	private List<String> prereq;
	private String profID;
	private List<Integer> students; // Assuming a list of student IDs for simplicity

	/**
	 * Constructor
	 * @param courseName The name of the course
	 * @param courseID The unique identifier for the course
	 * @param prereq The list of prerequisites for the course
	 * @param profID The ID of the professor assigned to the course
	 */
	public Course(String courseName, int courseID, List<String> prereq, String profID) {
		this.courseName = courseName;
		this.courseID = courseID;
		this.prereq = prereq;
		this.profID = profID;
		this.students = new ArrayList<>();
	}

	/**
	 * Gets the name of the course
	 * @return The name of the course
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * Sets the name of the course
	 * @param courseName The new name of the course
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
	 * Gets the list of prerequisites for the course
	 * @return The list of prerequisites
	 */
	public List<String> getPrereq() {
		return prereq;
	}

	/**
	 * Sets the list of prerequisites for the course
	 * @param prereq The new list of prerequisites
	 */
	public void setPrereq(List<String> prereq) {
		this.prereq = prereq;
	}

	/**
	 * Gets the ID of the professor assigned to the course
	 * @return The professor's ID
	 */
	public String getProfID() {
		return profID;
	}

	/**
	 * Sets the ID of the professor assigned to the course
	 * @param profID The new professor's ID
	 */
	public void setProfID(String profID) {
		this.profID = profID;
	}

	/**
	 * Adds a student to the course
	 * @param studentID The ID of the student to be added
	 */
	public void addStudent(int studentID) {
		if (!students.contains(studentID)) {
			students.add(studentID);
			System.out.println("Student " + studentID + " added to course " + courseID + ".");
		} else {
			System.out.println("Student " + studentID + " is already enrolled in course " + courseID + ".");
		}
	}

	/**
	 * Removes a student from the course
	 * @param studentID The ID of the student to be removed
	 */
	public void removeStudent(int studentID) {
		if (students.contains(studentID)) {
			students.remove(Integer.valueOf(studentID));
			System.out.println("Student " + studentID + " removed from course " + courseID + ".");
		} else {
			System.out.println("Student " + studentID + " is not enrolled in course " + courseID + ".");
		}
	}

	/**
	 * Assigns a professor to the course
	 * @param profID The ID of the professor to be assigned
	 */
	public void assignProf(String profID) {
		this.profID = profID;
		System.out.println("Professor " + profID + " assigned to course " + courseID + ".");
	}
}
