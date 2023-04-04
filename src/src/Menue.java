package src;

import java.util.HashMap;
import java.util.Scanner;

public class Menue {
	API myApi = new API();
	JDBC myJdbc = new JDBC();
	SearchDatabase mySearch = new SearchDatabase();
	Scanner sc = new Scanner(System.in);

	public void showMenue() {
		boolean menue = true;
		while (menue) {
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
			menuOptions.put(10, "Save data into file");
			menuOptions.put(11, "Retrive data From file");
			menuOptions.put(12, "Exit");

			int option = 0;

			while (option != 12) {
				System.out.println("==================Universities Database==================");
				for (int i = 1; i <= 12; i++) {
					System.out.println(i + ". " + menuOptions.get(i));
				}
				System.out.println("=========================================================");
				System.out.print("Select option : ");
				option = sc.nextInt();

				switch (option) {
				case 1:
					myJdbc.initializeDataBase();
					break;
				case 2:
					myApi.CountrySearch();
					break;
				case 3:
					myApi.listOfCountry();
					break;
				case 4:
					myJdbc.insertData();
					break;
				case 5:
					myJdbc.backupDatabase();
					break;
				case 6:
					myJdbc.removeTable();
					break;
				case 7:
					myApi.showAllUni();
					break;
				case 8:
					
					while (true) {
						System.out.println("[1] From Database");
						System.out.println("[2] From API");
						int select = sc.nextInt();
						if (select == 1) {
							myJdbc.fetchDataFromDatabase();
							break;
						} else if (select == 2) {
							myApi.fetchDataFromApi();
							break;
						} else {
							break;
						}
					}
					break;
				case 9:
					mySearch.searchFromDatabase();
					break;
				case 10:
					myApi.saveToFile();
					break;
				case 11:
					
					break;
				case 12:
					System.out.println("Bye....(:");
					System.exit(0);
					break;
				}
			}
		}
	}

}
