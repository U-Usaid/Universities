package src;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.google.gson.Gson;

public class API {
	static University uni[];

	public void CountrySearch() {
		// find the university by entering the name of the country.
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the country: ");
		String countryIn = sc.nextLine();
		String apiUrl = "http://universities.hipolabs.com/search?country=" + countryIn;
		try {
			URL url = new URL(apiUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			StringBuilder json = new StringBuilder();

			while ((output = br.readLine()) != null) {
				json.append(output);
			}

			conn.disconnect();

			Gson gson = new Gson();
			uni = gson.fromJson(json.toString(), University[].class);
			System.out.println("=============================================================================");
			for (int i = 0; i < uni.length; i++) {
				University myUni = uni[i];
				System.out.println((i + 1) + ":\t" + myUni.state_province + " - " + myUni.country + " - " + myUni.name
						+ " - " + myUni.alpha_two_code);
				for (int j = 0; j < myUni.domains.length; j++) {
					System.out.println("\tDomain " + (j + 1) + ": " + myUni.domains[j]);
				}

				for (int m = 0; m < myUni.web_pages.length; m++) {
					System.out.println("\tWeb page " + (m) + ": " + myUni.web_pages[m]);

				}
				System.out.println("=============================================================================");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listOfCountry() {
		String apiUrl = "http://universities.hipolabs.com/search?country=";
		try {
			URL url = new URL(apiUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			StringBuilder json = new StringBuilder();

			while ((output = br.readLine()) != null) {
				json.append(output);
			}

			conn.disconnect();

			Gson gson = new Gson();
			uni = gson.fromJson(json.toString(), University[].class);
			 Set<String> countries = new HashSet<>();
	            int counter = 1;
	            for (University myuni : uni) {
	                if (countries.add(myuni.country)) {
	                    System.out.println(counter + ". " + myuni.country);
	                    counter++;
	                }
	            }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void showAllUni() {
		System.out.println("=============================================================================");
		for (int i = 0; i < uni.length; i++) {
			University myUni = uni[i];
			System.out.println((i + 1) + ":\t" + myUni.state_province + " - " + myUni.country + " - " + myUni.name
					+ " - " + myUni.alpha_two_code);
			for (int j = 0; j < myUni.domains.length; j++) {
				System.out.println("\tDomain " + (j + 1) + ": " + myUni.domains[j]);
			}

			for (int m = 0; m < myUni.web_pages.length; m++) {
				System.out.println("\tWeb page " + (m) + ": " + myUni.web_pages[m]);

			}
			System.out.println("=============================================================================");
		}

	}
	
	
	public void fetchDataFromApi() {
		String apiUrl = "http://universities.hipolabs.com/search?country=";
		try {
			URL url = new URL(apiUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			StringBuilder json = new StringBuilder();

			while ((output = br.readLine()) != null) {
				json.append(output);
			}
			conn.disconnect();
			Gson gson = new Gson();
			uni = gson.fromJson(json.toString(), University[].class);
			System.out.println("=============================================================================");
			for (int i = 0; i < uni.length; i++) {
				University myUni = uni[i];
				System.out.println((i + 1) + ":\t" + myUni.state_province + " - " + myUni.country + " - " + myUni.name
						+ " - " + myUni.alpha_two_code);
				for (int j = 0; j < myUni.domains.length; j++) {
					System.out.println("\tDomain " + (j + 1) + ": " + myUni.domains[j]);
				}

				for (int m = 0; m < myUni.web_pages.length; m++) {
					System.out.println("\tWeb page " + (m) + ": " + myUni.web_pages[m]);

				}
				System.out.println("=============================================================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void saveToFile() {
		try {
			FileWriter writer = new FileWriter("Data.txt", true);
			writer.write("=============================================================================\n");
			for (int i = 0; i < uni.length; i++) {
				University myUni = uni[i];
				writer.write((i + 1) + ":\t" + myUni.state_province + " - " + myUni.country + " - " + myUni.name + " - "
						+ myUni.alpha_two_code + "\n");
				for (int j = 0; j < myUni.domains.length; j++) {
					writer.write("\tDomain " + (j + 1) + ": " + myUni.domains[j] + "\n");
				}

				for (int m = 0; m < myUni.web_pages.length; m++) {
					writer.write("\tWeb page " + (m) + ": " + myUni.web_pages[m] + "\n");
				}
				writer.write("=============================================================================\n");
			}
			writer.close();
			System.out.println("Data Saved...:)");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
