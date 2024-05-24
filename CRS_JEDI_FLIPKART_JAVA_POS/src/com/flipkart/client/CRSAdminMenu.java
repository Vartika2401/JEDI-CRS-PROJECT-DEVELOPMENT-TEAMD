/**
 * 
 */
package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.client;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business.AdminMethods;
//package com.flipkart.client;


import java.util.Scanner;

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
public class CRSAdminMenu {

    public void AdminMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nWelcome Admin!\n");
            System.out.println("Choose your action:");
            System.out.println("1. Approve Courses");
            System.out.println("2. Add Courses To Catalog");
            System.out.println("3. Remove Courses From Catalog");
            System.out.println("4. Enable Add/Drop");
            System.out.println("5. Declare Result");
            System.out.println("6. Exit");
            System.out.print("\nEnter your choice: ");

            choice = scanner.nextInt();
            AdminMethods adminMethods = new AdminMethods();
            switch (choice) {
                case 1:
                    adminMethods.approveCourses();
                    break;
                case 2:
                    System.out.println("Enter course details to add to catalog");
                    System.out.print("Enter course ID: ");
                    int courseid = scanner.nextInt();
                    System.out.print("Enter course name: ");
                    String coursename = scanner.next();
                    System.out.print("Enter prerequisites: ");
                    String prereq = scanner.next();
                    System.out.print("Enter course department: ");
                    String coursedept = scanner.next();
                    adminMethods.addCoursesToCatalog(courseid, coursename, prereq, coursedept);
                    break;
                case 3:
                    System.out.println("How do you want to remove courses from catalog?");
                    System.out.println("1. By course ID");
                    System.out.println("2. By student count");
                    System.out.print("\nEnter your choice: ");
                    int removeChoice = scanner.nextInt();
                    if (removeChoice == 1) {
                        System.out.print("Enter course ID to remove: ");
                        int courseID = scanner.nextInt();
                        adminMethods.removeCoursesFromCatalog_inp(courseID);
                    } else if (removeChoice == 2) {
                        adminMethods.removeCoursesFromCatalog_count();
                    }
                    break;
                case 4:
//                    enableAddDrop();
                    break;
                case 5:
//                    declareResult();
                    break;
                case 6:
                  System.out.println("Logging Out...");
                  CRSApplicationClient crsApplicationClient = new CRSApplicationClient();
                  crsApplicationClient.main(null);
                  break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        } while (choice != 6);

        scanner.close();
    }



}

