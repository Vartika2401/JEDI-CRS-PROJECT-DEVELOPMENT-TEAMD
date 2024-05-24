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
import java.util.List;

public interface professordaointerface {
    public void getProf(int profid);
    public List<Integer> showFreeCourses();
    public void selectCourse(List<Integer> courses, int profid, int courseid);
    public void showStudents(int profid);
    public void addGrade(int profid, int courseid, int sem);
}
