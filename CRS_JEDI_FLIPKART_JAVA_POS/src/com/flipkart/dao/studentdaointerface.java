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

public interface studentdaointerface {

        public void getStudent(int studentid);
        public List<Integer> showcourses();
        public void addCourse(List<Integer> courses, int studentid, int courseid);
        public List<Integer> showEnrolledCourses(int studentid);
        public void deleteCourse(List<Integer> courses,int studentid, int courseid);
//        public void registercourse(int studentid);
}
