/**
 * 
 */
package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.client;
//package com.flipkart.client;

import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business.ProfessorMethod;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business.StudentMethod;

import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class CRSProfessorMenu {
	
	    public void ProfessorMenu(int profID) {
	        Scanner scanner = new Scanner(System.in);
	        int choice;
	 
	        do {
	            System.out.println("\nWelcome Professor!\n");
	            System.out.println("1. My Profile");
	            System.out.println("2. Course Selection");
	            System.out.println("3. Students");
	            System.out.println("4. Log Out");
	            System.out.print("\nEnter your choice: ");
				ProfessorMethod professorMethod = new ProfessorMethod();
	            choice = scanner.nextInt();
	 
	            switch (choice) {
	                case 1:
	                    professorMethod.getProf(profID);
	                    break;
	                case 2:
						List<Integer> courses = professorMethod.showFreeCourses();
						System.out.println("\nEnter Course ID to teach: ");
						int CourseID = scanner.nextInt();
						professorMethod.selectCourse(courses, profID, CourseID);

	                    break;
	                case 3:
	                    viewStudentOptions();
	                    break;
	                case 4:
	                    System.out.println("Logging Out...");
	                    break;
	            }
	        } while (choice != 4);
	 
	        scanner.close();
	    }
	 
	    public static void viewCourseOptions() {
	        System.out.println("View Assigned Courses / Course Details (Not implemented yet)");
	        
	    }
	 
	    public static void viewStudentOptions() {
	        System.out.println("View Enrolled Students / Upload Grades (Not implemented yet)");
	        
	    }

}
