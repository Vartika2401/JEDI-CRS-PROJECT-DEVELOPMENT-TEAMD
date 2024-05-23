package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao.admindao;
//package com.flipkart.business;

public class AdminMethods implements AdminInterface {
    public void approveCourses() {
        admindao adminDao = new admindao();
        adminDao.approvecourses();
    }
}
