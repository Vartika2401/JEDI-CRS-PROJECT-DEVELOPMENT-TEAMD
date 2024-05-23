package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.bean;
//package com.flipkart.bean;

import java.util.HashMap;
import java.util.List;

public class result {
    private int studentID;
    private int semNumber;
    private int cgpa;
    private HashMap<String,Integer> sgpa;
    private List<Integer> regCourses;

    public result(int studentID, int semNumber, int cgpa, List<Integer> regCourses) {
        this.studentID = studentID;
        this.semNumber = semNumber;
        this.cgpa = cgpa;
        this.regCourses = regCourses;
        this.sgpa = new HashMap<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getSemNumber() {
        return semNumber;
    }

    public void setSemNumber(int semNumber) {
        this.semNumber = semNumber;
    }

    public int getCgpa() {
        return cgpa;
    }

    public void setCgpa(int cgpa) {
        this.cgpa = cgpa;
    }



    public HashMap<String, Integer> getSgpa() {
        return sgpa;
    }

    public void setSgpa(HashMap<String, Integer> sgpa) {
        this.sgpa = sgpa;
    }
    public List<Integer> getRegCourses() {
        return regCourses;
    }

    public void setRegCourses(List<Integer> regCourses) {
        this.regCourses = regCourses;
    }
}
