package com.flipkart.bean;

import java.util.*;

public class Course {

	private String courseName;
	private int courseID;
	private List<String> prereq;
	private String profID;
	private List<Integer> students; // Assuming a list of student IDs for simplicity

//    Constructor
	public Course(String courseName, int courseID, List<String> prereq, String profID) {
		this.courseName = courseName;
		this.courseID = courseID;
		this.prereq = prereq;
		this.profID = profID;
		this.students = new ArrayList<>();
	}

//    Getters and setters 
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public List<String> getPrereq() {
		return prereq;
	}

	public void setPrereq(List<String> prereq) {
		this.prereq = prereq;
	}

	public String getProfID() {
		return profID;
	}

	public void setProfID(String profID) {
		this.profID = profID;
	}

	// Methods
	public void addStudent(int studentID) {
		if (!students.contains(studentID)) {
			students.add(studentID);
			System.out.println("Student " + studentID + " added to course " + courseID + ".");
		} else {
			System.out.println("Student " + studentID + " is already enrolled in course " + courseID + ".");
		}
	}

	public void removeStudent(int studentID) {
		if (students.contains(studentID)) {
			students.remove(Integer.valueOf(studentID));
			System.out.println("Student " + studentID + " removed from course " + courseID + ".");
		} else {
			System.out.println("Student " + studentID + " is not enrolled in course " + courseID + ".");
		}
	}

	public void assignProf(String profID) {
		this.profID = profID;
		System.out.println("Professor " + profID + " assigned to course " + courseID + ".");
	}
}