package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;
//package com.flipkart.business;

import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao.professordao;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao.studentdao;

import java.util.List;
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

public class ProfessorMethod implements ProfessorInterface {

	@Override
	public void getProf(int profid) {
		professordao professordao = new professordao();
		professordao.getProf(profid);

	}

	public List<Integer> showFreeCourses() {
		professordao professordao = new professordao();
		return professordao.showFreeCourses();
	}

	public  void selectCourse(List<Integer> courses, int profid, int courseid){
		professordao profesordao = new professordao();
		profesordao.selectCourse(courses, profid, courseid);
	}

	public void showStudents(int profid) {
		professordao profesordao = new professordao();
		profesordao.showStudents(profid);
	}

	public void addGrade(int profid, int courseid, int sem) {
		professordao profesordao = new professordao();
		profesordao.addGrade(profid, courseid, sem);
	}


}
