package Axis.DatabaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTesting {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		{
			String dbURL = "jdbc:mysql://localhost:3306/manipal";
			String username = "root";
			String password = "root";
			// Load MySQL JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Creating connection to the database
			Connection con = DriverManager.getConnection(dbURL, username, password);
			// Creating statement object
			Statement st = con.createStatement();
			String selectquery = "SELECT * FROM employeedata;";
			// Executing the SQL Query and store the results in ResultSet
			ResultSet rs = st.executeQuery(selectquery);
			// While loop to iterate through all data and print results
			while (rs.next()) {
				System.out.println(rs.getString("ID"));
				System.out.println(rs.getString("FirstName"));
			}
			// Closing DB Connection
			con.close();
		}
	}

}
