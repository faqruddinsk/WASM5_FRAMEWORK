package Sql;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Database_mysql {
public static void main(String[] args) throws SQLException {
	
	Driver driverRef=new Driver();
	Connection con = null;
	try {
	//step no 1: register the driver  
	DriverManager.registerDriver(driverRef);
	
	//step 2: get the connection
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb","root", "root");
	
	//step 3: issue create statement
	Statement statement =con.createStatement();
	
	//step 4 :execute the query
	String query ="insert into customerinfo values('fazal',13,'karimnagar')";
	int result =statement.executeUpdate(query);
	if(result==1) {
		
		System.out.println("the data is inserted ");
			
		}
	else {
		System.out.println("data is not inserted");
	}
	}
	catch(Exception e) {}
	finally {
	//step 5: close the data base 
	con.close();
	}
	}
}

