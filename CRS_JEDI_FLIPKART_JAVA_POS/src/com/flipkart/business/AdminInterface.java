package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business;

public interface AdminInterface {
    public void approveCourses();
    public void addCoursesToCatalog(int courseid, String coursename, String prereq, String coursedept);
    public void removeCoursesFromCatalog_inp(int courseid);
    public void removeCoursesFromCatalog_count();
}
