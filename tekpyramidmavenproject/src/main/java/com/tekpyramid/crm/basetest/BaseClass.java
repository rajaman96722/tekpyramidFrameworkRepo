package com.tekpyramid.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;
import com.tekpyramid.crm.objectrepositoryutility.HomePage;
import com.tekpyramid.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	// create Object
	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriver driver = null;
	public  static WebDriver sDriver = null;
	

	@BeforeSuite(groups ={"smokeTest","regressionTest"})
	public void configBS() throws SQLException {
		System.out.println("Connect to db , Report config ");
		dbLib.getDbconnection();
		
		
	}
  //  @Parameters("BROWSER")
	@BeforeClass(groups ={"smokeTest","regressionTest"})
	public void configBC(/*String browser*/) throws IOException {
		System.out.println("Launch The Browser");

		String BROWSER = // browser;
				fLib.getDataFromPropertiesFile("browser");

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();

		}
		sDriver = driver;
		UtilityClassObject.setDriver(driver);

	}

	@BeforeMethod(groups ={"smokeTest","regressionTest"})
	public void configBM() throws IOException {
		System.out.println("Login To Application");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(groups ={"smokeTest","regressionTest"})
	public void configAM() {
		System.out.println("Lougout to Application");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups ={"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("Close The Browser");
		driver.quit();

	}

	@AfterSuite(groups ={"smokeTest","regressionTest"})
	public void configAS() throws SQLException {
		System.out.println("close db , Report backup");
		dbLib.closeDbconnection();
	
	}

}
