package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao;

/**
 * Author: Group-D
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

        /**
         * Retrieves the details of a student based on their ID.
         * @param studentid The ID of the student
         */
        public void getStudent(int studentid);

        /**
         * Shows the list of available courses.
         * @return A list of available course IDs
         */
        public List<Integer> showcourses();

        /**
         * Adds a course for the student.
         * @param courses The list of current courses
         * @param studentid The ID of the student
         * @param courseid The ID of the course to be added
         */
        public void addCourse(List<Integer> courses, int studentid, int courseid);

        /**
         * Shows the list of courses the student is enrolled in.
         * @param studentid The ID of the student
         * @return A list of enrolled course IDs
         */
        public List<Integer> showEnrolledCourses(int studentid);

        /**
         * Deletes a course for the student.
         * @param courses The list of current courses
         * @param studentid The ID of the student
         * @param courseid The ID of the course to be deleted
         */
        public void deleteCourse(List<Integer> courses, int studentid, int courseid);
}
