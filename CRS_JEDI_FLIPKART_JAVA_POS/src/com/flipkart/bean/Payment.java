package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.bean;
//package com.flipkart.bean;

public class Payment {
    private int studentID;
    private int amount;
    private String status;

    // Constructor
    public Payment(int studentID, int amount, String status) {
        this.studentID = studentID;
        this.amount = amount;
        this.status = status;
    }

    // Getters and Setters
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void generateConfirmationStatus() {
        
        System.out.println("Generating confirmation status for payment of amount: " + amount + " for student ID: " + studentID);
    }
}

