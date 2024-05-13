package practice.testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tekpyramid.crm.basetest.BaseClass;

public class SimpleReportTest extends BaseClass{
	public ExtentReports report = new ExtentReports();
	@BeforeSuite
	public void configBS() {
		//spark report config
		ExtentSparkReporter 
		 spark = new ExtentSparkReporter("./AdvancePeport/report.html");
		spark.config().setDocumentTitle("CRM Test suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		//add Env information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Window-10");
		report.setSystemInfo("BROWSWE", "CHROME-100");
	}
	@AfterSuite
	public void configAs() {
		report.flush();
	}
	
	@Test
	public void createContactTest() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		TakesScreenshot eDriver = (TakesScreenshot)driver;
		String filePath =eDriver.getScreenshotAs(OutputType.BASE64);
		
		
		 
		
		
		 ExtentTest test =	report.createTest("createContactTest");
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("HDC".equals("HDFC")) {
			test.log(Status.PASS,"contact is created");
			
		}else {
			
			test.addScreenCaptureFromBase64String(filePath,"ErrorFile");
		}
		driver.close();
		
	}
	@Test
	public void createContactWithOrg() {
		
		
		
		 ExtentTest test =	report.createTest("createContactWithOrg");
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"contact is created");
			
		}else {
			test.log(Status.FAIL,"contact is not created");
		}
	
		
	}
	@Test
	public void createContactWithPhoneNum() {
		
		
		
		 ExtentTest test =	report.createTest("createContactWithPhoneNum");
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"contact is created");
			
		}else {
			test.log(Status.FAIL,"contact is not created");
		}
		
		
	}

}
