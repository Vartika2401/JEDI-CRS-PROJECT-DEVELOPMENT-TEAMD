/**
 * 
 */
package com.flipkart.client;

import java.util.Scanner;


/**
 * 
 */
public class CRSStudentMenu {
	
	    public void StudentMenu() {
	        Scanner scanner = new Scanner(System.in);
	        int choice;
	 
	        do {
	            System.out.println("\nWelcome Student!\n");
	            System.out.println("1. My Profile");
	            System.out.println("2. Course Registration");
	            System.out.println("3. Grades");
	            System.out.println("4. Fees");
	            System.out.println("5. Log Out");
	            System.out.print("\nEnter your choice: ");
	 
	            choice = scanner.nextInt();
	 
	            switch (choice) {
	                case 1:
	                    System.out.println("My Profile (Not implemented yet)");
	                    break;
	                case 2:
	                	System.out.println("1. Add Course");
	    	            System.out.println("2. Remove Course");
	    	            System.out.print("\nEnter your choice: ");
	    	            int coursech = scanner.nextInt();
						System.out.println("Enter Student ID: ");
						int StudentID = scanner.nextInt();
	    	            if (coursech==1) {
	    	            	addCourse(StudentID);
	    	            }
	    	            else if (coursech==2) {
	    	            	removeCourse(StudentID);
	    	            }
	    	            else {
	    	            	System.out.println("Invalid Choice! Please try again.");
	    	            }
						break;
	                case 3:
	                    System.out.println("Grades (Not implemented yet)");
	                    break;
	                case 4:
	                    System.out.println("Fees (Not implemented yet)");
	                    break;
	                case 5:
	                    System.out.println("Logging Out...");
	                    break;

	            }
	        } while (choice != 5);
	 
	        scanner.close();
	    }

		public void addCourse(int studentID) {
			System.out.println("Adding Course...");
		}
		public void removeCourse(int studentID) {
			System.out.println("Removing Course...");
		}

}
