package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;
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
public interface paymentdaointerface {
    public Integer getfeeAmount(Integer semid);
    public void onlinepayment(Integer amount,Integer studentid, Integer semno);
    public void offlinepayment(Integer amount,Integer studentid, Integer semno);
}
