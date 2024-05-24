package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;
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

public interface paymentInterface {
    public Integer feeamount(Integer semno);
    public void onlinepayment(int paymentamount, int studentid, int semno);
    public void offlinepayment(int paymentamount, int studentid, int semno);
}
