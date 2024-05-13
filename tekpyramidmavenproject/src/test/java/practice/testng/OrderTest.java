package practice.testng;

import org.testng.annotations.Test;

public class OrderTest {
	@Test(invocationCount=10)
	public void createOrderTest() {
		
		
		System.out.println("Execute OrderTest===>123");
	}
	@Test(enabled = false)
    public void billingAnOrderTest() {
		
		System.out.println("Execute billingorderTest===>123");
	}
	

}
