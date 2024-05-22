package com.flipkart.bean;

public class StudentGrade {
	
	private String courseID;
	private String courseName;
	private String grade;
	
//	Constructor
	public StudentGrade(String courseID, String courseName, String grade) {
		this.courseID = courseID;
		this.courseName = courseName;
		this.grade = grade;
	}
	
//	Getter and Setter
	public String getCourseCode() {
		return courseID;
	}
	
	public void setCourseCode(String courseCode) {
		this.courseID = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	

}