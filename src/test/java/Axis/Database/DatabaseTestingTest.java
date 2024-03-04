package Axis.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTestingTest {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
	
	String dbURL = "jdbc:mysql://localhost:3306/manipal";
	String username = "root";
	String password = "root";
	// load the mysql jdbc driver file
	Class.forName("com.mysql.cj.jdbc.Driver");
	// creating a connection to the database
	Connection con = DriverManager.getConnection(dbURL,username,password);
	//creating the statement object
	Statement st = con.createStatement();
	String selectquery = "select * from employeedata;";
	//executing the sql query
	ResultSet rs = st.executeQuery(selectquery);
	// while loop to iterate through all data and results
	while(rs.next()) {
		
		System.out.println(rs.getString("ID"));
		System.out.println(rs.getString("FirstName"));
	}
	con.close();

	
	
	

	
	
	
	
	
	}	

}
