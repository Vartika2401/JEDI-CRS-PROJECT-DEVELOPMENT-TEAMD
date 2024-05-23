package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao.studentdao;

import java.util.List;
//package com.flipkart.business;

public class StudentMethod implements StudentInterface {

    @Override
    public void getStudent(int studentid) {
        studentdao studentdao = new studentdao();
        studentdao.getStudent(studentid);

    }
    public List<Integer> showcourses() {
        studentdao studentdao = new studentdao();
        return studentdao.showcourses();
    }
    public  void addcourse(List<Integer> courses, int studentid, int courseid){
        studentdao studentdao = new studentdao();
        studentdao.addCourse(courses, studentid, courseid);
    }

    public void viewGrade(int courseId, int studentId, String grade) {
        System.out.println("Grade " + grade + " for student " + studentId + " in course " + courseId + ".");
    }


    public void viewEnrolledCourses(int studentId) {
        System.out.println("The enrolled courses list");
    }

    public void studLogin(String emailId, String password) {
        System.out.println("Student with email '" + emailId + "' is attempting to log in.");
    }
}
