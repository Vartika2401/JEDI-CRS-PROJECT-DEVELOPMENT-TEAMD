/**
 * 
 */
package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.client;
//package com.flipkart.client;

//import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.client.CRSProfessorMenu;
//import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.client.CRSStudentMenu;
//import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.client.CRSAdminMenu;


import java.sql.*;
import java.util.Scanner;

/**
 * 
 */
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
				System.out.println("Please enter your username:");
				String username = scanner.next();
				System.out.println("Please enter your password:");
				String password = scanner.next();
				System.out.println("Choose your role: \n 1.Admin \n 2.Student \n 3.Professor \n 4.Exit");
				System.out.print("\nEnter your choice: ");
				int role = scanner.nextInt();
				switch (role) {
					case 3:
						CRSProfessorMenu professorMenu = new CRSProfessorMenu();
						professorMenu.ProfessorMenu();
						break;
					case 2:
						CRSStudentMenu studentMenu = new CRSStudentMenu();
						studentMenu.StudentMenu();
						break;
					case 1:
						CRSAdminMenu adminMenu = new CRSAdminMenu();
						adminMenu.AdminMenu();
						break;
					default:
						System.out.println("Invalid input! Please Try Again");
				}
			case 2:
				try{
					Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

					Statement stmt = conn.createStatement();
					System.out.println("Hello");
					ResultSet rs = stmt.executeQuery(QUERY);
					// Extract data from result set
					while (rs.next()) {
						System.out.println("hell");
						// Retrieve by column name
						System.out.print("ID: " + rs.getInt("studentid"));
						System.out.print(", Age: " + rs.getInt("department"));
						System.out.print(", First: " + rs.getString("enrolledcourses"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		// TODO Auto-generated method stub

	}

}


// notifications, registration,
// serives :
// payments