package practiseDataDrivenTesting;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumTestReadDataFromRunTimeTest {

	 
		@Test
		public void seleniumTest() throws IOException {
			
			//read common data from Cmd line
			String url = System.getProperty("url");
			  String browser = System.getProperty("browser");
			// String username = System.getProperty("username");
			//  String password = System.getProperty("password");
			WebDriver driver = null;
			if(browser.equals("chrome")) {
				driver = new ChromeDriver();
			}
			else if(browser.equals("firefox")){
			    driver = new FirefoxDriver();
			}
			else if(browser.equals("edge")) {
				driver = new EdgeDriver();
			}
			else {
				driver = new ChromeDriver();
				
			}
			//step 1: login is done
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
			driver.get(url);
			
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			driver.quit();
			
		}

	

}
