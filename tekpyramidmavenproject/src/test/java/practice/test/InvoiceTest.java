package practice.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tekpyramid.crm.basetest.BaseClass;

public class InvoiceTest extends BaseClass{
	@Test(retryAnalyzer = com.tekpyramid.crm.listnerutility.RetryListnerImp.class)
	public void activateSim() {
		System.out.println("execute create invoice Test");
	    String actTitle =	driver.getTitle();
	    Assert.assertEquals(" ", "login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	
}
