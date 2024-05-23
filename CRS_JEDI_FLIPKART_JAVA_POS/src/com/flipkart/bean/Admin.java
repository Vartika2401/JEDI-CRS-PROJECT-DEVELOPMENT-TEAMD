package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.bean;
//package com.flipkart.bean;


public class Admin extends User {
    // Constructor
	   public Admin(int id, String name, String phone, String email, String password, String role, String department) {
	        super(id, name, phone, email, password, role);
	   }
    // Additional Admin-specific methods can be added here if needed

}
