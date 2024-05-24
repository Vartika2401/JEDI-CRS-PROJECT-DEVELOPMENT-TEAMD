/**
 * 
 */
package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.client;
//package com.flipkart.client;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.dao.studentdaointerface;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business.StudentMethod;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business.paymentMethods;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business.gradeMethods;

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
							List<Integer> enrolledCourses = studentMethod.showEnrolledCourses(studentID);
							if (enrolledCourses.size()==0){
								System.out.println("No courses enrolled yet!");
								break;
							}
							System.out.println("Already Enrolled Courses: ");
							System.out.println(enrolledCourses);
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
						List<Integer> courseids = studentMethod.showEnrolledCourses(studentID);
						gradeMethods gradeMethods = new gradeMethods();
						List<Integer> grades = gradeMethods.getGrades(studentID, courseids);
						if (grades.size()==0){
							System.out.println("Grades not uploaded yet");
							break;
						}
						System.out.println("Your Grades are: ");
						int sum = 0;
						for (int i = 0; i < grades.size(); i++) {
							System.out.println("Course ID: " + courseids.get(i) + " Grade: " + grades.get(i));
							sum += grades.get(i);
						}
						System.out.println("SGPA :" + sum / grades.size());
//						find the sum of grades

	                    break;
	                case 4:
						System.out.println("Enter the semester number you want to pay fee for: ");
						int semno = scanner.nextInt();
	                    System.out.println("Fetching your fees amount...");
						paymentMethods paymentMethods = new paymentMethods();
						int feeamount = paymentMethods.feeamount(semno);
						System.out.println("Your fee amount is: " + feeamount);
						System.out.println("Choose the way to pay: ");
						System.out.println("1. Online Payment");
						System.out.println("2. Offline Payment");
						int paymentChoice = scanner.nextInt();
						if (paymentChoice == 1) {
							paymentMethods.onlinepayment(feeamount, studentID, semno);

						}
						else if (paymentChoice == 2) {
							paymentMethods.offlinepayment(feeamount,studentID,semno);
						}
						else {
							System.out.println("Invalid Choice! Please try again.");
						}
	                    break;
	                case 5:
						System.out.println("Logging Out...");
						CRSApplicationClient crsApplicationClient = new CRSApplicationClient();
						crsApplicationClient.main(null);
						break;
					default:
						System.out.println("Invalid choice");
						break;

	            }
	        } while (choice != 5);
	 
	        scanner.close();
	    }



}
