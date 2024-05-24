package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

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
public interface paymentdaointerface {

    /**
     * Retrieves the fee amount for a given semester.
     * @param semid The semester ID
     * @return The fee amount for the specified semester
     */
    public Integer getfeeAmount(Integer semid);

    /**
     * Processes an online payment for a student.
     * @param amount The amount to be paid
     * @param studentid The ID of the student making the payment
     * @param semno The semester number for which the payment is made
     */
    public void onlinepayment(Integer amount, Integer studentid, Integer semno);

    /**
     * Processes an offline payment for a student.
     * @param amount The amount to be paid
     * @param studentid The ID of the student making the payment
     * @param semno The semester number for which the payment is made
     */
    public void offlinepayment(Integer amount, Integer studentid, Integer semno);
}
