package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

import java.util.List;

public interface studentdaointerface {

        public void getStudent(int studentid);
        public List<Integer> showcourses();
        public void addCourse(List<Integer> courses, int studentid, int courseid);
//        public void registercourse(int studentid);
}
