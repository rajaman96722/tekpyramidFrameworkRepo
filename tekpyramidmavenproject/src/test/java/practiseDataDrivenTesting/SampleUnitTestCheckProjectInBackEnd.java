package practiseDataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class SampleUnitTestCheckProjectInBackEnd {

	
		@Test
		public void projectCheckTest() throws SQLException {
			
			String expectedProjectName="vtiger";
			boolean flag=false;
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
		   while(resultset.next()){
			   String actProjectname=resultset.getString(3);
			   if(expectedProjectName.equals(actProjectname)) {
				   flag=true;
				   System.out.println(expectedProjectName +" is available==pass");
			   }
		   }
		   if(flag==false) {
			   System.out.println(expectedProjectName + "is not available==fail");
			   
		   }
		   //step 5: close the connection
		   conn.close();
		
			
			
		}

	}


