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

public class Payment {
    private int studentID;
    private int amount;
    private String status;

    /**
     * Constructor
     * @param studentID The ID of the student making the payment
     * @param amount The amount of the payment
     * @param status The status of the payment
     */
    public Payment(int studentID, int amount, String status) {
        this.studentID = studentID;
        this.amount = amount;
        this.status = status;
    }

    /**
     * Gets the ID of the student making the payment
     * @return The student ID
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * Sets the ID of the student making the payment
     * @param studentID The new student ID
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * Gets the amount of the payment
     * @return The payment amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the payment
     * @param amount The new payment amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Gets the status of the payment
     * @return The payment status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the payment
     * @param status The new payment status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Generates and prints a confirmation status for the payment
     */
    public void generateConfirmationStatus() {
        System.out.println("Generating confirmation status for payment of amount: " + amount + " for student ID: " + studentID);
    }
}
