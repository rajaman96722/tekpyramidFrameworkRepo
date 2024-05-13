package practiseTestHomePageTest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTest {
	@Test
	public void homePageTest(Method mtd) {
		Reporter.log(mtd.getName() + "Test Start");

		SoftAssert asserObj = new SoftAssert();
		Reporter.log("step 1");
		Reporter.log("step 2");
		Assert.assertEquals("Home", "Home");
		Reporter.log("step 3");
		asserObj.assertEquals("Title", "Title");
		Reporter.log("step 4");
		asserObj.assertAll();
		Reporter.log(mtd.getName() + "Test end");
	}

	@Test
	public void verifyLogoPage(Method mtd) {
		Reporter.log(mtd.getName() + "Test Start");
		SoftAssert asserObj = new SoftAssert();
		Reporter.log("step 1");
		Reporter.log("step 2");
		asserObj.assertTrue(true);
		Reporter.log("step 3");
		Reporter.log("step 4");
		asserObj.assertAll();
		Reporter.log(mtd.getName() + "Test End");

	}

}
