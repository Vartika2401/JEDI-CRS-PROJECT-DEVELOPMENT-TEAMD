package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;
//package com.flipkart.business;


public interface paymentInterface {
    public Integer feeamount(Integer semno);
    public void onlinepayment(int paymentamount, int studentid, int semno);
    public void offlinepayment(int paymentamount, int studentid, int semno);
}
