package practice.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekpyramid.crm.basetest.BaseClass;

public class InvoiceTest1 extends BaseClass {
	@Test

	public void createInvoiceTest() {
	System.out.println("execute createInvoice");
	String actTitle = driver.getTitle();
	Assert.assertEquals(actTitle,"Login");
	System.out.println("Step-1");
	System.out.println("Step-2");
	System.out.println("Step-3");
	System.out.println("Step-4");

}
	@Test
	public void createInvoiceWithContactTest() {
		System.out.println("execute createInvoiceWithContact");
		
		
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
}
}