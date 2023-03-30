package src;

import java.util.HashMap;
import java.util.Scanner;

public class Menue {
	API myApi = new API();
	Scanner menueSc = new Scanner(System.in);

	public void showMenue() {
		boolean menueLoop = true;
		while (menueLoop) {
			HashMap<Integer, String> menuOptions = new HashMap<Integer, String>();
			menuOptions.put(1, "Initialize Database");
			menuOptions.put(2, "Search the name of the country to fetch universites");
			menuOptions.put(3, "List of countries");
			menuOptions.put(4, "Insert the Data");
			menuOptions.put(5, "Backup Database");
			menuOptions.put(6, "Remove Table");
			menuOptions.put(7, "Show all universites");
			menuOptions.put(8, "fetch Data");
			menuOptions.put(9, "Search by: ");
			menuOptions.put(10, "Dump data into file");
			menuOptions.put(11, "Retrive data From file");
			menuOptions.put(12, "Exit");

			int choice = 0;

			while (choice != 12) {
				System.out.println("==================UNIVERSITIES DATABASE==================");
				for (int i = 1; i <= 12; i++) {
					System.out.println(i + ". " + menuOptions.get(i));
				}
				System.out.println("=========================================================");
				System.out.print("Select option : ");
				choice = menueSc.nextInt();

				switch (choice) {
				case 1:
					break;
				case 2:
					myApi.CountrySearch();
					break;
				}
			}
		}
	}

}
