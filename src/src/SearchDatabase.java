package src;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchDatabase {

	public void searchFromDatabase() {
		String url = "jdbc:sqlserver://" + "localhost:1433;" + "encrypt=true;" + "trustServerCertificate=true";
		Connection con = null;

		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);

			url += ";databaseName=" + UserAccess.databaseName;
			con = DriverManager.getConnection(url, UserAccess.user, UserAccess.pass);
			Statement st = (Statement) con.createStatement();

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter search criteria (name, country, or alpha_two_code):");
			String searchBy = sc.next();
			System.out.println("Enter search query:");
			String searchQuery = sc.next();

			String sql = "SELECT * FROM universities WHERE " + searchBy + " = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, searchQuery);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("Name");
				String country = rs.getString("Country");
				String state_province = rs.getString("State_Province");
				String domains = rs.getString("Domains");
				String web_pages = rs.getString("Web_Pages");
				String alpha_two_code = rs.getString("Alpha_Two_Code");
				System.out.println("=========================================================");
				System.out.println("ID: " + id);
				System.out.println("Name: " + name);
				System.out.println("Country: " + country);
				System.out.println("State/Province: " + state_province);
				System.out.println("Domains: " + domains);
				System.out.println("Web Pages: " + web_pages);
				System.out.println("Alpha Two Code: " + alpha_two_code);
				System.out.println("=========================================================");
			}

			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

}
