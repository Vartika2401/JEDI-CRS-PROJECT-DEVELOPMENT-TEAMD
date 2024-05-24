package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao.admindao;
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
public class AdminMethods implements AdminInterface {
    public void  approveregistration(int studid,String password){
        admindao adminDao = new admindao();
        adminDao.approveregistration(studid,password);
    }

    public void approveCourses() {
        admindao adminDao = new admindao();
        adminDao.approvecourses();
    }
    public void addCoursesToCatalog(int courseid, String coursename, String prereq, String coursedept) {
        admindao adminDao = new admindao();
        adminDao.add_course_to_Catalog(courseid, coursename, prereq, coursedept);
    }
    public void removeCoursesFromCatalog_inp(int courseid) {
        admindao adminDao = new admindao();
        adminDao.delete_course_input(courseid);
    }
    public void removeCoursesFromCatalog_count() {
        admindao adminDao = new admindao();
        adminDao.delete_course_student_count_wrong();
    }
    public void enableAddDrop() {
        admindao adminDao = new admindao();
        adminDao.enable_add_drop();
    }
    public void declareResult() {
        admindao adminDao = new admindao();
        adminDao.declare_result();
    }
    public void disableAddDrop() {
        admindao adminDao = new admindao();
        adminDao.disable_add_drop();
    }
    public void stopResult() {
        admindao adminDao = new admindao();
        adminDao.stop_result();
    }

}
