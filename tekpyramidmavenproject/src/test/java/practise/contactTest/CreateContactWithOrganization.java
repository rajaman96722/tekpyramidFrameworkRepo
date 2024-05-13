package practise.contactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

public class CreateContactWithOrganization {

	public static void main(String[] args) throws IOException, InterruptedException {
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
	    Row row =  sh.getRow(7);
	    String orgName = row.getCell(2).toString() + random;
	    String contactLastName = row.getCell(3).toString() + random;
	    
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
		
		//step2 : navigate to organization module
		driver.findElement(By.linkText("Organizations")).click();
		//step3 : click on create organization button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//step4 : enter all the details and create new organization
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		//verify Header msg expected result
		String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 if(headerInfo.contains(orgName)) {
			 System.out.println(orgName+"is created==pass");
		 }
		 else {
			 System.out.println(orgName+"is not created==fail");
		 }
		 
		//step 5: navigate to contact module
		
			driver.findElement(By.linkText("Contacts")).click();
			//step6 : click on create contact button
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			//step7 : enter all the details and create new contact
			driver.findElement(By.name("lastname")).sendKeys(contactLastName);
			driver.findElement(By.xpath("//td[text()='Organization Name 			']/..//img[@alt='Select']")).click();
			//switch to child window
			Set<String> set=driver.getWindowHandles();
		    Iterator<String> it=set.iterator();
		    while(it.hasNext()) {
		    	String windowID = it.next();
		    	driver.switchTo().window(windowID);
		   String actUrl 	=driver.getCurrentUrl();
		   if(actUrl.contains("module=Accounts")) {
			   break;
		   }
		    }
			driver.findElement(By.name("search_text")).sendKeys(orgName);
			driver.findElement(By.name("search")).click();
			driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
			
			//switch the parent window
			Set<String> set1=driver.getWindowHandles();
		    Iterator<String> it1=set.iterator();
		    while(it1.hasNext()) {
		    	String windowID = it1.next();
		    	driver.switchTo().window(windowID);
		   String actUrl 	=driver.getCurrentUrl();
		   if(actUrl.contains("module=Contacts")) {
			   break;
		   }
		    }
		    driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			//verify header phone number info expected result
		     headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			 if(headerInfo.contains(contactLastName)) {
				 System.out.println(contactLastName+"is created==pass");
			 }
			 else {
				 System.out.println(contactLastName+"is not created==fail");
			 }
			 
		
		// verify Header orgName info Expected Result
	       String actualArgNameInfo	= driver.findElement(By.id("mouseArea_Organization Name")).getText();
	       System.out.println(actualArgNameInfo);
	       if(actualArgNameInfo.trim().equals(orgName)) {
				 System.out.println(orgName+"is created==pass");
				
			 }
			 else {
				System.out.println(orgName+"is not created==fail");
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
