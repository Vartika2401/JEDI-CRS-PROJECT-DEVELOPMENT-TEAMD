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

public interface gradeInterface {
//    public String getCourseCod();
//
//    public void setCourseCode(String courseCode);
//
//    public String getCourseName();
//
//    public void setCourseName(String courseName);

    public List<Integer> getGrades(int studentID, List<Integer> courseids);

//    public void setGrade(String grade);

}
