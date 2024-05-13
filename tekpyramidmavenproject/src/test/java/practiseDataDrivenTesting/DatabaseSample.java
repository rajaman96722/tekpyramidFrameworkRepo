package practiseDataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseSample {

	public static void main(String[] args) throws SQLException {
		// step1: load/register the database driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		//step2: connect to database
	    Connection conn	=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	    System.out.println("====Done====");
    	//step3: create sql statements
	   Statement stat =conn.createStatement();
	   //step4 : execute select query and get result
	   ResultSet resultset = stat.executeQuery("select * from project");
	   System.out.println(resultset);
	   while(resultset.next()){
		   System.out.println(resultset.getString(1) + "\t" + resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4 ));
	   }
	   //step 5: close the connection
	   conn.close();


	
	
		

	}
}

