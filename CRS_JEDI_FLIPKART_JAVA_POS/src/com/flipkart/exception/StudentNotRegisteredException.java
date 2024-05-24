package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.exception;

public class StudentNotRegisteredException extends Exception{
    private String studentName;

    public StudentNotRegisteredException(String studentName)
    {
        this.studentName=studentName;
    }

    /**
     * getter function for studentName
     * @return
     */
    public String getStudentName()
    {
        return studentName;
    }

}
