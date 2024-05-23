/**
 * 
 */
package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.client;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business.AdminMethods;
//package com.flipkart.client;


import java.util.Scanner;

/**
 * 
 */
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

            switch (choice) {
                case 1:
                    AdminMethods adminMethods = new AdminMethods();
                    adminMethods.approveCourses();
                    break;
                case 2:
//                    approveCourses();
                    break;
                case 3:
//                    addCoursesToCatalog();
                    break;
                case 4:
//                    removeCoursesFromCatalog();
                    break;
                case 5:
//                    enableAddDrop();
                    break;
                case 6:
//                    declareResult();
                    break;
                case 7:
//                    exit();
                    break;

            }
        } while (choice != 7);

        scanner.close();
    }



}

