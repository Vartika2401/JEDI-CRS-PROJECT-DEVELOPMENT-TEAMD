package com.flipkart.bean;


public class Admin {
	private String name;
	private int adminID;
	private String emailID;


	//    Constructor
	public Admin(String name, int adminID, String emailID) {
		this.name = name;
		this.adminID = adminID;
		this.emailID = emailID;
	}
	
//	Getter and Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

}
