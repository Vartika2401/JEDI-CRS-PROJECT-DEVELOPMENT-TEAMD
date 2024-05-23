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
	            System.out.println("3. View Students");
	            System.out.println("4. Submit Grades");
				System.out.println("5. Log Out");
	            System.out.print("\nEnter your choice: ");
				ProfessorMethod professorMethod = new ProfessorMethod();
	            choice = scanner.nextInt();
				int CourseID;
				switch (choice) {
	                case 1:
	                    professorMethod.getProf(profID);
	                    break;
	                case 2:
						List<Integer> courses = professorMethod.showFreeCourses();
						System.out.println("\nEnter Course ID to teach: ");
						CourseID = scanner.nextInt();
						professorMethod.selectCourse(courses, profID, CourseID);
	                    break;
	                case 3:
	                    professorMethod.showStudents(profID);
	                    break;
					case 4:
						System.out.println("\nEnter Course ID to submit grades: ");
						CourseID = scanner.nextInt();
						System.out.println("\nEnter Semester: ");
						int sem = scanner.nextInt();
						professorMethod.addGrade(profID,CourseID,sem);
						break;
	                case 5:
	                    System.out.println("Logging Out...");
	                    break;
	            }
	        } while (choice != 5);
	 
	        scanner.close();
	    }

}
