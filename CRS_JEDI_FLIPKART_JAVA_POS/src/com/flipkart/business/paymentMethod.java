//package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;
package com.flipkart.business;

public class paymentMethod {
    private int studentID;
    private int amount;
    private String status;

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
