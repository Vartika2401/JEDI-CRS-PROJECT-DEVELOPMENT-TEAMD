package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;
//package com.flipkart.business;


public interface paymentInterface {
    public int getStudentID();

    public void setStudentID(int studentID);

    public int getAmount();

    public void setAmount(int amount);

    public String getStatus();

    public void setStatus(String status);

    public void generateConfirmationStatus();
}
