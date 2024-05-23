/**
 * 
 */
package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.client;
//package com.flipkart.client;

import java.util.Scanner;

/**
 * 
 */
public class CRSProfessorMenu {
	
	    public void ProfessorMenu() {
	        Scanner scanner = new Scanner(System.in);
	        int choice;
	 
	        do {
	            System.out.println("\nWelcome Professor!\n");
	            System.out.println("1. My Profile");
	            System.out.println("2. Courses");
	            System.out.println("3. Students");
	            System.out.println("4. Log Out");
	            System.out.print("\nEnter your choice: ");
	 
	            choice = scanner.nextInt();
	 
	            switch (choice) {
	                case 1:
	                    viewOrUpdateProfile();
	                    break;
	                case 2:
	                    viewCourseOptions();
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
	 
	    // Placeholder methods 
	    public static void viewOrUpdateProfile() {
	        System.out.println("View/Update Profile (Not implemented yet)");
	        
	    }
	 
	    public static void viewCourseOptions() {
	        System.out.println("View Assigned Courses / Course Details (Not implemented yet)");
	        
	    }
	 
	    public static void viewStudentOptions() {
	        System.out.println("View Enrolled Students / Upload Grades (Not implemented yet)");
	        
	    }

}
