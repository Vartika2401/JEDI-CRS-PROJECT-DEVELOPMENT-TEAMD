/**
 * 
 */
package com.flipkart.client;


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
            System.out.println("1. Login");
            System.out.println("2. Approve Courses");
            System.out.println("3. Add Courses To Catalog");
            System.out.println("4. Remove Courses From Catalog");
            System.out.println("5. Enable Add/Drop");
            System.out.println("6. Declare Result");
            System.out.println("7. Exit");
            System.out.print("\nEnter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    approveCourses();
                    break;
                case 3:
                    addCoursesToCatalog();
                    break;
                case 4:
                    removeCoursesFromCatalog();
                    break;
                case 5:
                    enableAddDrop();
                    break;
                case 6:
                    declareResult();
                    break;
                case 7:
                    exit();
                    break;

            }
        } while (choice != 7);

        scanner.close();
    }

    // Placeholder methods
    public static void login(){
        System.out.println("Logging In...");
    }
    public static void approveCourses(){
        System.out.println("Approving Courses...");
    }
    public static void addCoursesToCatalog(){
        System.out.println("Adding Courses to Catalog...");
    }
    public static void removeCoursesFromCatalog(){
        System.out.println("Removing Courses From Catalog...");
    }
    public static void enableAddDrop(){
        System.out.println("Enable Add/Drop...");
    }
    public static void declareResult(){
        System.out.println("Declare Result...");
    }
    public static void exit(){
        System.out.println("Exiting...");
    }

}

