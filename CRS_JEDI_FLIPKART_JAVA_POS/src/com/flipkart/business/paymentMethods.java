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
    public Integer feeamount(Integer semno){
        paymentdao paymentdao = new paymentdao();
        Integer amount = paymentdao.getfeeAmount(semno);
        return amount;
    }

    public void onlinepayment(int paymentamount, int studentid, int semno){
        paymentdao paymentdao = new paymentdao();
        paymentdao.onlinepayment(paymentamount, studentid, semno);

    }

    public void offlinepayment(int paymentamount, int studentid, int semno){
        paymentdao paymentdao = new paymentdao();
        paymentdao.offlinepayment(paymentamount,studentid,semno);
    }
}
