package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

public interface admindaointerface {
    public void approvecourses();
    public void add_course_to_Catalog(int courseid, String coursename, String prereq, String coursedept);
    public void delete_course_input(int courseid);
    public void delete_course_student_count_wrong();
}
