/**
 * 
 */
package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.client;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.client.CRSProfessorMenu;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.client.CRSStudentMenu;
import CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.client.CRSAdminMenu;



import java.util.Scanner;

/**
 * 
 */
public class CRSApplicationClient {

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
					case 2:
						CRSStudentMenu studentMenu = new CRSStudentMenu();
						studentMenu.StudentMenu();
					case 1:
						CRSAdminMenu adminMenu = new CRSAdminMenu();
						adminMenu.AdminMenu();


				}
		}

		// TODO Auto-generated method stub

	}

}
