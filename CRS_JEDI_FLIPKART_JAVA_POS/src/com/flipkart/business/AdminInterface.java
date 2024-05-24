package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;
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
public interface AdminInterface {
    public void  approveregistration(int studid);
    public void approveCourses();
    public void addCoursesToCatalog(int courseid, String coursename, String prereq, String coursedept);
    public void removeCoursesFromCatalog_inp(int courseid);
    public void removeCoursesFromCatalog_count();
}
