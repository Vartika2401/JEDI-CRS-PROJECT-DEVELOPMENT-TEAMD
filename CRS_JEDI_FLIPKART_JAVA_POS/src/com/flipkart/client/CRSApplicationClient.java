/**
 * 
 */
package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.client;
//package com.flipkart.client;

import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business.studentregistration;
import java.time.LocalDate;
import java.time.LocalTime;
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
public class CRSApplicationClient {
	static final String DB_URL = "jdbc:mysql://localhost/CRSSchema";
	static final String USER = "root";
	static final String PASS = "mahi_7781";
	static final String QUERY = "SELECT * FROM student";

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		System.out.println("Welcome to CRS application client");
		System.out.println("Please enter your choice: \n 1.Login \n 2.Student Registration \n 3.Change Password \n 4.Exit");
		System.out.print("\nEnter your choice: ");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
			switch (choice) {
				case 1:
					System.out.println("Enter your credentials to login");
					System.out.println("Enter your ID: ");
					Integer ID = scanner.nextInt();
					System.out.println("Enter your password: ");
					String password = scanner.next();
					studentregistration login = new studentregistration();
					String role = login.login(ID, password);

					LocalDate localDate=LocalDate.now();
					LocalTime localTime=LocalTime.now();

					System.out.println(role+" logged in on "+ localDate + " at "+localTime);

					if (role.equals("student")) {
						CRSStudentMenu studentMenu = new CRSStudentMenu();
						studentMenu.StudentMenu(ID);
					} else if (role.equals("prof")) {
						CRSProfessorMenu professorMenu = new CRSProfessorMenu();
						professorMenu.ProfessorMenu(ID);
					} else if (role.equals("admin")) {
						CRSAdminMenu adminMenu = new CRSAdminMenu();
						adminMenu.AdminMenu();
					}
					break;
				case 2:
					studentregistration register = new studentregistration();
					register.registerstudent();
					break;

				case 3:
					studentregistration change = new studentregistration();
					change.changepassword();
					break;

				case 4:
					System.out.println("Hope you have a nice day");
					break;

				default:
					System.out.println("Invalid choice");
					break;
			}


		// TODO Auto-generated method stub

	}

}


// notifications, registration,
// serives :
// payments