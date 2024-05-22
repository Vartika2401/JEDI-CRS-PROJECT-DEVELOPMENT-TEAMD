package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name;
    private int studentID;
    private String emailID;
    private String department;
    private List<Integer> enrolledCourses;
    
//    Constructor
    public Student(String name, int id, String emailId, String department) {
        this.name = name;
        this.studentID = id;
        this.emailID = emailId;
        this.department = department;
        this.enrolledCourses = new ArrayList<Integer>();
    }
    
//    Getter and Setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public List<Integer> getEnrolledCourses() {
		return enrolledCourses;
	}
	public void setEnrolledCourses(List<Integer> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}

}
