package practise.contactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		FileInputStream  fis = new FileInputStream("C:\\Users\\AMAN RAJ\\Desktop\\Data\\commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER=pObj.getProperty("browser");
		String URL=pObj.getProperty("url");
		String USERNAME=pObj.getProperty("username");
		String PASSWORD=pObj.getProperty("password");
		//System.out.println(BROWSER);
		//System.out.println(URL);
		//System.out.println(USERNAME);
		//System.out.println(PASSWORD);
		//generate the random number
		Random rnd = new Random();
		int random=rnd.nextInt(1000);
		
		//read the test script data from excel sheet
		FileInputStream fis1 = new FileInputStream("C:\\Users\\AMAN RAJ\\Desktop\\Data\\Book1.xlsx");
	    Workbook wb	=WorkbookFactory.create(fis1);
	     Sheet  sh = wb.getSheet("contact");
	    Row row =  sh.getRow(1);
	    String lastName = row.getCell(2).toString() + random;
	    
	    wb.close();
		WebDriver driver = null;
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")){
		    driver = new FirefoxDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
			
		}
		//step 1: login is done
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//step2 : navigate to contact module
		driver.findElement(By.linkText("Contacts")).click();
		//step3 : click on create contact button
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		//step4 : enter all the details and create new contact
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//verify Header contact info expected result
		//step5:logout from application
		 String actlastNam=driver.findElement(By.id("dtlview_Last Name")).getText();
		 if(actlastNam.contains(lastName)) {
			 System.out.println(lastName+"is created==pass");
		 }
		 else {
			 System.out.println(lastName+"is not created==fail");
		 }
		 
	//WebElement signOut=driver.findElement(By.xpath("//td[@class='small']//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		Thread.sleep(5000);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		
		//act.moveToElement(signOut).perform();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		//driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();


	}

	}


