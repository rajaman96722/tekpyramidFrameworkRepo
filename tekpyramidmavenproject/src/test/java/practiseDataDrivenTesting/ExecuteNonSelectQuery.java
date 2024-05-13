package practiseDataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteNonSelectQuery {

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
	    int result = stat.executeUpdate("insert into project values('TY_02','kanhaiya','04/27/2023','Facbook','On Going','100');");
	  System.out.println(result);
	   //step 5: close the connection
	   conn.close();
	

	}

}
