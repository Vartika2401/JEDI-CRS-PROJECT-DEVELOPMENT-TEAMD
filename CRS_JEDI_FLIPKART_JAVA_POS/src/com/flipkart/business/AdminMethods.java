package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;

import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao.admindao;
//package com.flipkart.business;

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

public class AdminMethods implements AdminInterface {

    /**
     * Approves the registration of a student.
     * @param studid The ID of the student
     * @param password The password for the student's account
     */
    public void approveregistration(int studid, String password) {
        admindao adminDao = new admindao();
        adminDao.approveregistration(studid, password);
    }

    /**
     * Approves the courses.
     */
    public void approveCourses() {
        admindao adminDao = new admindao();
        adminDao.approvecourses();
    }

    /**
     * Adds a course to the catalog.
     * @param courseid The ID of the course
     * @param coursename The name of the course
     * @param prereq The prerequisites for the course
     * @param coursedept The department offering the course
     */
    public void addCoursesToCatalog(int courseid, String coursename, String prereq, String coursedept) {
        admindao adminDao = new admindao();
        adminDao.add_course_to_Catalog(courseid, coursename, prereq, coursedept);
    }

    /**
     * Removes a course from the catalog using the course ID.
     * @param courseid The ID of the course to be removed
     */
    public void removeCoursesFromCatalog_inp(int courseid) {
        admindao adminDao = new admindao();
        adminDao.delete_course_input(courseid);
    }

    /**
     * Removes courses from the catalog based on the count.
     */
    public void removeCoursesFromCatalog_count() {
        admindao adminDao = new admindao();
        adminDao.delete_course_student_count_wrong();
    }

    /**
     * Enables the add/drop period for courses.
     */
    public void enableAddDrop() {
        admindao adminDao = new admindao();
        adminDao.enable_add_drop();
    }

    /**
     * Declares the results for the courses.
     */
    public void declareResult() {
        admindao adminDao = new admindao();
        adminDao.declare_result();
    }

    /**
     * Disables the add/drop period for courses.
     */
    public void disableAddDrop() {
        admindao adminDao = new admindao();
        adminDao.disable_add_drop();
    }

    /**
     * Stops the declaration of results.
     */
    public void stopResult() {
        admindao adminDao = new admindao();
        adminDao.stop_result();
    }
}
