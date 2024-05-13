package practiseDataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

public class CreateProjectAndVerifyDataInDBWithGui {

	public static void main(String[] args) throws SQLException {
		//create project in Gui using selenium code
		Random ran = new Random();
		int ranNo = ran.nextInt(1000);
		
		String projectName = "Instagram_31"+ranNo;
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get("http://106.51.90.215:8084/");
		
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();

		
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.name("createdBy")).sendKeys("kanhaiya");
		 Select sel = new Select(driver.findElement(By.name("status")));
		 sel.selectByIndex(0);
		 driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		 
		 //verify the project in Db
		// step1: load/register the database driver
		 //verify the project in backend[DB] using jdbc
		 boolean flag = false;
					Driver driverRef = new Driver();
					DriverManager.registerDriver(driverRef);
					//step2: connect to database
				    Connection conn	=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
				    System.out.println("====Done====");
			    	//step3: create sql statements
				   Statement stat =conn.createStatement();
				   //step4 : execute select query and get result
				   ResultSet resultset = stat.executeQuery("select * from project");
				   while(resultset.next()){
					   String actProjectname=resultset.getString(4);
					   System.out.println(actProjectname);
					   if(projectName.equals(actProjectname)) {
						   flag=true;
						   System.out.println(projectName +" is available db==pass");
						   break;
						   
					   }
				   }
				   if(flag==false) {
					   System.out.println(projectName + "is not available db==fail");
					   
					   
				   }
				   //step 5: close the connection
			
				
					
					
				}

		 
}
		
		







