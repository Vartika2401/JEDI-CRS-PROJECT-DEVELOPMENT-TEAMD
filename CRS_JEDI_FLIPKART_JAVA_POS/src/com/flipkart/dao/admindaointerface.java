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
public interface admindaointerface {
    public void approvecourses();
    public void add_course_to_Catalog(int courseid, String coursename, String prereq, String coursedept);
    public void delete_course_input(int courseid);
    public void delete_course_student_count_wrong();
}
