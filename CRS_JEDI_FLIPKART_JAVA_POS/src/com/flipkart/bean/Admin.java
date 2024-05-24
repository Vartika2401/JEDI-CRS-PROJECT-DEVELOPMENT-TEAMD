package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.bean;
//package com.flipkart.bean;

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

public class Admin extends User {
	/**
	 * Constructor
	 * @param id The unique identifier for the admin
	 * @param name The name of the admin
	 * @param phone The phone number of the admin
	 * @param email The email address of the admin
	 * @param password The password for the admin's account
	 * @param role The role of the admin
	 * @param department The department the admin belongs to
	 */
	public Admin(int id, String name, String phone, String email, String password, String role, String department) {
		super(id, name, phone, email, password, role);
	}

	// Additional Admin-specific methods can be added here if needed
}
