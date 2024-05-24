package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao.studentdao;

import java.util.List;
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


public class StudentMethod implements StudentInterface {

    /**
     * Retrieves the student's details based on the student ID.
     * @param studentid The ID of the student
     */
    @Override
    public void getStudent(int studentid) {
        studentdao studentdao = new studentdao();
        studentdao.getStudent(studentid);

    }

    /**
     * Shows the list of available courses.
     * @return A list of available course IDs
     */
    public List<Integer> showcourses() {
        studentdao studentdao = new studentdao();
        return studentdao.showcourses();
    }

    /**
     * Adds a course for the student.
     * @param courses The list of current courses
     * @param studentid The ID of the student
     * @param courseid The ID of the course to be added
     */
    public  void addcourse(List<Integer> courses, int studentid, int courseid){
        studentdao studentdao = new studentdao();
        studentdao.addCourse(courses, studentid, courseid);
    }

    /**
     * Shows the list of courses the student is enrolled in.
     * @param studentid The ID of the student
     * @return A list of enrolled course IDs
     */
    public List<Integer> showEnrolledCourses(int studentid){
        studentdao studentdao = new studentdao();
        return studentdao.showEnrolledCourses(studentid);
    }

    /**
     * Deletes a course for the student.
     * @param courses The list of current courses
     * @param studentid The ID of the student
     * @param courseid The ID of the course to be deleted
     */
    public void deletecourse(List<Integer> courses,int studentid,int courseid){
        studentdao studentdao = new studentdao();
        studentdao.deleteCourse(courses, studentid, courseid);
    }

    /**
     * Views the grade for a specific course.
     * @param courseId The ID of the course
     * @param studentId The ID of the student
     * @param grade The grade to be viewed
     */
    public void viewGrade(int courseId, int studentId, String grade) {
        System.out.println("Grade " + grade + " for student " + studentId + " in course " + courseId + ".");
    }

    /**
     * Views the courses the student is enrolled in.
     * @param studentId The ID of the student
     */
    public void viewEnrolledCourses(int studentId) {
        System.out.println("The enrolled courses list");
    }

    /**
     * Logs in a student with the provided email and password.
     * @param emailId The email ID of the student
     * @param password The password of the student
     */
    public void studLogin(String emailId, String password) {
        System.out.println("Student with email '" + emailId + "' is attempting to log in.");
    }
}
