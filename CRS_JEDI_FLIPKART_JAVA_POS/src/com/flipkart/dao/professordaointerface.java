package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

import java.util.List;

public interface professordaointerface {
    public void getProf(int profid);
    public List<Integer> showcourses();
    public void addCourse(List<Integer> courses, int studentid, int courseid);
    public List<Integer> showEnrolledCourses(int studentid);
    public void deleteCourse(List<Integer> courses,int studentid, int courseid);
}
