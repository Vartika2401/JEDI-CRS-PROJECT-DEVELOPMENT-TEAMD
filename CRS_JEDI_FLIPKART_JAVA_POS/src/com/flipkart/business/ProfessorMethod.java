package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;
//package com.flipkart.business;

import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao.professordao;
import java.util.List;

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

public class ProfessorMethod implements ProfessorInterface {

	/**
	 * Retrieves the professor's details based on the professor ID.
	 * @param profid The ID of the professor
	 */
	@Override
	public void getProf(int profid) {
		professordao professordao = new professordao();
		professordao.getProf(profid);
	}

	/**
	 * Shows the list of courses that are free (available).
	 * @return A list of free course IDs
	 */
	public List<Integer> showFreeCourses() {
		professordao professordao = new professordao();
		return professordao.showFreeCourses();
	}

	/**
	 * Selects a course for the professor.
	 * @param courses The list of courses to be selected
	 * @param profid The ID of the professor
	 * @param courseid The ID of the course to be selected
	 */
	public void selectCourse(List<Integer> courses, int profid, int courseid) {
		professordao professordao = new professordao();
		professordao.selectCourse(courses, profid, courseid);
	}

	/**
	 * Shows the students enrolled in the professor's courses.
	 * @param profid The ID of the professor
	 */
	public void showStudents(int profid) {
		professordao professordao = new professordao();
		professordao.showStudents(profid);
	}

	/**
	 * Adds a grade for a student in a specific course and semester.
	 * @param profid The ID of the professor
	 * @param courseid The ID of the course
	 * @param sem The semester number
	 */
	public void addGrade(int profid, int courseid, int sem) {
		professordao professordao = new professordao();
		professordao.addGrade(profid, courseid, sem);
	}
}
