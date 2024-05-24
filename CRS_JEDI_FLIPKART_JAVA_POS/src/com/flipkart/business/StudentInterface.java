package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;
//package com.flipkart.business;
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

import java.util.List;

public interface StudentInterface {
	/**
	 * Retrieves the student's details based on the student ID.
	 * @param studentid The ID of the student
	 */
	public void getStudent(int studentid);

	/**
	 * Shows the list of available courses.
	 * @return A list of available course IDs
	 */
	public List<Integer> showcourses();

	/**
	 * Adds a course for the student.
	 * @param courses The list of current courses
	 * @param studentid The ID of the student
	 * @param courseid The ID of the course to be added
	 */
	public  void addcourse(List<Integer> courses, int studentid, int courseid);

	/**
	 * Shows the list of courses the student is enrolled in.
	 * @param studentid The ID of the student
	 * @return A list of enrolled course IDs
	 */
	public List<Integer> showEnrolledCourses(int studentid);

	/**
	 * Deletes a course for the student.
	 * @param courses The list of current courses
	 * @param studentid The ID of the student
	 * @param courseid The ID of the course to be deleted
	 */
	public void deletecourse(List<Integer> courses,int studentid,int courseid);

	/**
	 * Views the grade for a specific course.
	 * @param courseId The ID of the course
	 * @param studentId The ID of the student
	 * @param grade The grade to be viewed
	 */
	public void viewGrade(int courseId, int studentId, String grade);

	/**
	 * Views the courses the student is enrolled in.
	 * @param studentId The ID of the student
	 */
	public void viewEnrolledCourses(int studentId);

	/**
	 * Logs in a student with the provided email and password.
	 * @param emailId The email ID of the student
	 * @param password The password of the student
	 */
	public void studLogin(String emailId, String password);

}
