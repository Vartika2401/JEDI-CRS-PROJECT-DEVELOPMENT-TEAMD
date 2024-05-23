package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao.gradedao;

import java.util.List;

//package com.flipkart.business;
//
public class gradeMethods {
    private String courseID;
    private String courseName;
    private String grade;

    public List<Integer> getGrades(int studentID, List<Integer> courseids) {
        gradedao gradedao = new gradedao();
        return gradedao.getGrades(studentID, courseids);
    }
}
