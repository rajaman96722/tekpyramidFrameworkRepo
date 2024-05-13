package practice.testng;

import org.testng.annotations.Test;

public class ContactTest1 {
	@Test(invocationCount=10)
	public void createContactTest1() {	
		System.out.println("execute create contact with-->HDFC");	
	}
	
	@Test(dependsOnMethods="createContactTest1")
	public void modifyContactTest1() {
		System.out.println("execute modifyContactTest---HDFC->ICICI");
	}
	
	@Test(dependsOnMethods="modifyContactTest1")
	public void deleteContactTest1() {
		System.out.println("execute deleteContactTest ICICI");
	}

}
