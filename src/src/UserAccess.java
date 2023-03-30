package src;

import java.util.Scanner;

public class UserAccess {
	static String user;
	static String pass;
	static String databaseName;

	Menue menue = new Menue();

	public void giveUserAccess() {
		String expectedUser = "sa";
		String expectedPass = "root";
		String expectedDatabase = "university";

		Scanner accessSc = new Scanner(System.in);
		System.out.println("==================LOGIN TO THE DATABASE==================");
		boolean accessGranted = false;
		while (!accessGranted) {
			System.out.print("Enter your Database name: ");
			String databaseInput = accessSc.next();
			System.out.print("Enter your user name: ");
			String userInput = accessSc.next();
			System.out.print("Enter your password: ");
			String passInput = accessSc.next();
			System.out.println("=========================================================");

			// Check if the entered credentials match the expected values
			if (databaseInput.equals(expectedDatabase) && userInput.equals(expectedUser)
					&& passInput.equals(expectedPass)) {
				databaseName = databaseInput;
				user = userInput;
				pass = passInput;
				System.out.println("Access granted");
				menue.showMenue();
			} else {
				System.out.println("Access denied");
			}
		}

	}

}
