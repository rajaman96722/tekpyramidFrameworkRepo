package practice.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenShot {
	@Test
	public void amazonTest() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://amazon.com");
		//step-1: create an object to EvenFiring WebDriver
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		//step-2: use getScreenShotAs method to get file type of screnShot
	    File source	= edriver.getScreenshotAs(OutputType.FILE);
        //store screen on local Driver
	    FileUtils.copyFile(source , new File("./screenshot/test.png"));
	}

}
