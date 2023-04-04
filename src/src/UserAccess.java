package src;

import java.util.Scanner;

public class UserAccess {
	static String user = "sa";
	static String pass = "root";
	static String databaseName = "Universities";

	Menue myMenue = new Menue();

	public void userAccess() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("==================Login to Database==================");
		boolean accessGranted = false;
		while (!accessGranted) {
			System.out.print("Enter Database name: ");
			String databaseInput = sc.next();
			System.out.print("Enter user name: ");
			String userInput = sc.next();
			System.out.print("Enter password: ");
			String passInput = sc.next();
			System.out.println("=========================================================");

			// Check if the entered credentials match the expected values
			if (databaseInput.equals(databaseName) && userInput.equals(user)
					&& passInput.equals(pass)) {
				System.out.println("Access granted...:)");
				myMenue.showMenue();
			} else {
				System.out.println("Access denied....:0");
			}
		}

	}

}
