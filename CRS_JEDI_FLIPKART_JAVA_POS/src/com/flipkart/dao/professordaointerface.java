package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

import java.util.List;

public interface professordaointerface {
    public void getProf(int profid);
    public List<Integer> showFreeCourses();
    public void selectCourse(List<Integer> courses, int profid, int courseid);

}
