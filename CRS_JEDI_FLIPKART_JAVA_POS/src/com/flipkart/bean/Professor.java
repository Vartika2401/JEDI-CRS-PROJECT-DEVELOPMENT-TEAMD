package com.flipkart.bean;

import java.util.*;

public class Professor extends User {
    private String department;
    private List<Integer> selectedCourses;

//    Constructor
    public Professor(int id, String name, String phone, String email, String password, String role, String department) {
        super(id, name, phone, email, password, role);
        this.department = department;
        this.selectedCourses = new ArrayList<Integer>();
    }

//    Getters and setters for department and selectedCourses
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Integer> getSelectedCourses() {
        return selectedCourses;
    }

    public void setSelectedCourses(List<Integer> selectedCourses) {
        this.selectedCourses = selectedCourses;
    }

}
