package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;
//package com.flipkart.business;

/**
 * Author: Group-D
 * Vartika
 * Rohan Mitra
 * Rishabh Verma
 * Shivali Gupta
 * Srujana Sri
 * Asritha Dama
 * Prajwal Rayal
 **/

public interface paymentInterface {

    /**
     * Gets the fee amount for a given semester number.
     * @param semno The semester number
     * @return The fee amount for the specified semester
     */
    public Integer feeAmount(Integer semno);

    /**
     * Processes an online payment for a student.
     * @param paymentAmount The amount to be paid
     * @param studentID The ID of the student making the payment
     * @param semno The semester number for which the payment is made
     */
    public void onlinePayment(int paymentAmount, int studentID, int semno);

    /**
     * Processes an offline payment for a student.
     * @param paymentAmount The amount to be paid
     * @param studentID The ID of the student making the payment
     * @param semno The semester number for which the payment is made
     */
    public void offlinePayment(int paymentAmount, int studentID, int semno);
}
