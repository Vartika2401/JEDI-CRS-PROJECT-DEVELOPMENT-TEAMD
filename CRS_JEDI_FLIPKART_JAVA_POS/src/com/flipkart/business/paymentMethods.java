package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao.paymentdao;
//package com.flipkart.business;

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
public class paymentMethods {

    /**
     * Gets the fee amount for a given semester number.
     * @param semno The semester number
     * @return The fee amount for the specified semester
     */
    public Integer feeamount(Integer semno){
        paymentdao paymentdao = new paymentdao();
        Integer amount = paymentdao.getfeeAmount(semno);
        return amount;
    }

    /**
     * Processes an online payment for a student.
     * @param paymentamount The amount to be paid
     * @param studentid The ID of the student making the payment
     * @param semno The semester number for which the payment is made
     */
    public void onlinepayment(int paymentamount, int studentid, int semno){
        paymentdao paymentdao = new paymentdao();
        paymentdao.onlinepayment(paymentamount, studentid, semno);

    }

    /**
     * Processes an offline payment for a student.
     * @param paymentamount The amount to be paid
     * @param studentid The ID of the student making the payment
     * @param semno The semester number for which the payment is made
     */
    public void offlinepayment(int paymentamount, int studentid, int semno){
        paymentdao paymentdao = new paymentdao();
        paymentdao.offlinepayment(paymentamount,studentid,semno);
    }
}
