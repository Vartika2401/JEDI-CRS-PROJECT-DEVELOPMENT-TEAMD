package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

public interface paymentdaointerface {
    public Integer getfeeAmount(Integer semid);
    public void onlinepayment(Integer amount,Integer studentid, Integer semno);
    public void offlinepayment(Integer amount,Integer studentid, Integer semno);
}
