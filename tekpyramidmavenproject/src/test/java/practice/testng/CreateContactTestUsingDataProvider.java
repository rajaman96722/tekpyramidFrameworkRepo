package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactTestUsingDataProvider {
	@Test(dataProvider = "getData")
	public void cretaeContact(String firstName , String lastName) {
		
		System.out.println("FirstName :"+ firstName + ", LastName:" + lastName);
		
	}
	
@DataProvider
    public Object[][] getData(){
	Object[][] objArr = new Object[3][2];
	objArr[0][0] = "deepak";
	objArr[0][1] = "hr";
	
	objArr[1][0] = "sam";
	objArr[1][1] = "sh";
	
	objArr[2][0] = "john";
	objArr[2][1] = "smith";
	
	return objArr;
	
	
}
}
