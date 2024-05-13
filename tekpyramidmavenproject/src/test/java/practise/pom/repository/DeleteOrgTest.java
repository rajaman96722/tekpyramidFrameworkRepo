package practise.pom.repository;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;
import com.tekpyramid.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.tekpyramid.crm.objectrepositoryutility.HomePage;
import com.tekpyramid.crm.objectrepositoryutility.LoginPage;
import com.tekpyramid.crm.objectrepositoryutility.OrganizationInfoPage;
import com.tekpyramid.crm.objectrepositoryutility.OrganizationPage;

public class DeleteOrgTest {
	public static void main(String[] args) throws InterruptedException, IOException {
		/* create object*/
		FileUtility flib =  new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
	//read common data from properties file	
	String BROWSER	=flib.getDataFromPropertiesFile("browser");
	String URL	=	flib.getDataFromPropertiesFile("url");
	String USERNAME	=	flib.getDataFromPropertiesFile("username");
	String PASSWORD	=	flib.getDataFromPropertiesFile("password");
		
		//read testScript data from excel file
	    String orgName = eLib.getDataFromExcel("org", 10, 2) + jLib.getRandonNumber();
	  
	    
	  // launching the browser
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
		//step 1: login to app
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get(URL);
		
	    LoginPage lp= new LoginPage(driver);
	    lp.loginToapp("admin", "admin");
		
		//step2 : navigate to organization module
	    HomePage hp = new HomePage(driver);
	    hp.getOrgLink().click();
	   
		
		//step3 : click on create organization button
	    OrganizationPage cnp = new OrganizationPage(driver);
	    cnp.getCreateNewOrgBtn().click();
		
		//step4 : enter all the details and create new organization
	    CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
	    cnop.createOrg(orgName);
		
		//verify Header msg expected result
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		 String actOrgName = oip.getHeaderMsg().getText();
		 if(actOrgName.contains(orgName)) {
			 System.out.println(orgName +"name is verfied==pass");
		 }else {
			 System.out.println(orgName +"name is notverfied==fail");
		 }
		
		 //verify Header orgName info Expected Result
	   // go back Organization page 
		
		    hp.getOrgLink().click();
		   
		// search for organization
		   
		    cnp.getSearchEdt().sendKeys(orgName);
		    wLib.select(cnp.getSearchDD(), "Organization Name");
		    cnp.getSearchBtn().click();
		    //in dynamic webtable select and dele org
		    driver.findElement(By.xpath("(//a[text()='"+orgName+"'])[2]/../..//a[text()='del']")).click();
		    
		 //handle the pop up
		    wLib.switchtoAlertAndAccept(driver);


          //logout 
	       hp.logout();


	}
}


