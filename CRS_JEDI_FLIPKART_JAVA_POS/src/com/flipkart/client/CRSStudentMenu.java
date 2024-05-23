/**
 * 
 */
package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.client;
//package com.flipkart.client;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao.studentdaointerface;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business.StudentMethod;

import java.util.List;
import java.util.Scanner;


/**
 * 
 */
public class CRSStudentMenu {
	
	    public void StudentMenu(int studentID) {
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
				StudentMethod studentMethod = new StudentMethod();
	            choice = scanner.nextInt();
	 
	            switch (choice) {
					case 1:
						studentMethod.getStudent(studentID);
	                    break;
					case 2:
						List<Integer> courses = studentMethod.showcourses();
	                	System.out.println("1. Add Course");
	    	            System.out.println("2. Remove Course");
	    	            System.out.print("\nEnter your choice: ");
	    	            int coursech = scanner.nextInt();
	    	            if (coursech==1) {
							System.out.println("Enter Course ID: ");
							int CourseID = scanner.nextInt();
							studentMethod.addcourse(courses, studentID, CourseID);
//	    	            	addCourse(courses, StudentID, CourseID);
	    	            }
	    	            else if (coursech==2) {
							System.out.println("Already Enrolled Courses: ");
							List<Integer> enrolledCourses = studentMethod.showEnrolledCourses(studentID);
							System.out.println("Enter Course ID to remove: ");
							int CourseID = scanner.nextInt();
							if (enrolledCourses.contains(CourseID)) {
								studentMethod.deletecourse(enrolledCourses, studentID, CourseID);
							}
							else {
								System.out.println("Course not found in enrolled courses.");
							}

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



}
