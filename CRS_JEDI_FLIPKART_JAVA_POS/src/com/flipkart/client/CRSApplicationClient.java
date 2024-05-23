/**
 * 
 */
package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.client;
//package com.flipkart.client;

import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.business.studentregistration;


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
				System.out.println("Enter your credentials to login");
				System.out.println("Enter your ID: ");
				Integer ID = scanner.nextInt();
				System.out.println("Enter your password: ");
				String password = scanner.next();
				studentregistration login = new studentregistration();
				String role = login.login(ID, password);
				System.out.println("Your role is " + role);
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
//				try{
//					Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//
//					Statement stmt = conn.createStatement();
//					System.out.println("Hello");
//					ResultSet rs = stmt.executeQuery(QUERY);
//					// Extract data from result set
//					while (rs.next()) {
//						System.out.println("hell");
//						// Retrieve by column name
//						System.out.print("ID: " + rs.getInt("studentid"));
//						System.out.print(", Age: " + rs.getInt("department"));
//						System.out.print(", First: " + rs.getString("enrolledcourses"));
//					}
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
			case 3:
				studentregistration change = new studentregistration();
				change.changepassword();
				break;

		}

		// TODO Auto-generated method stub

	}

}


// notifications, registration,
// serives :
// payments