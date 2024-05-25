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
            System.out.println("1. Approve User Registration");
            System.out.println("2. Approve Courses");
            System.out.println("3. Add Courses To Catalog");
            System.out.println("4. Remove Courses From Catalog");
            System.out.println("5. Enable Add/Drop");
            System.out.println("6. Disable Add/Drop");
            System.out.println("7. Declare Result");
            System.out.println("8. Stop Result");
            System.out.println("9. Exit");
            System.out.print("\nEnter your choice: ");

            choice = scanner.nextInt();
            AdminMethods adminMethods = new AdminMethods();
            switch (choice) {
                case 1:
                    System.out.println("ALL UNAPPROVED USERS:");
                    adminMethods.showunapprovedstudents();
                    System.out.println("Approving User Registration");
                    System.out.println("Enter user ID to approve: ");
                    int studentID = scanner.nextInt();
                    System.out.println("Enter user password: ");
                    String password = scanner.next();
                    adminMethods.approveregistration(studentID, password);
                    break;
                case 2:
                    adminMethods.approveCourses();
                    break;
                case 3:
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
                case 4:
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
                case 5:
                    adminMethods.enableAddDrop();
                    break;
//                    enableAddDrop();
                case 6:
                    adminMethods.disableAddDrop();
                    break;
                case 7:
                    adminMethods.declareResult();
                    break;
//                    declareResult();
                case 8:
                    adminMethods.stopResult();
                    break;
                case 9:
                  System.out.println("Logging Out...");
                  System.out.println();
                  CRSApplicationClient.main(null);
                  break;
                default:
                    System.out.println("Invalid Choice");
                    System.out.println();
                    break;
            }
        } while (choice != 9);

        scanner.close();
    }



}

