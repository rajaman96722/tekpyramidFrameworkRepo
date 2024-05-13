package practice.test;
/**
 * Test class for contact module
 * @author AMAN RAJ
 */
import org.testng.annotations.Test;

import com.tekpyramid.crm.basetest.BaseClass;
import com.tekpyramid.crm.objectrepositoryutility.LoginPage;

public class SearchContactTest extends BaseClass{
	/**
	 * scenario : login()==>navigatecontact==>createcontact()==verify
	 */
	
	@Test
	public void searchContactTest() {
		/*step 1 : login to app*/
	   LoginPage lp = new LoginPage(driver);
	   lp.loginToapp("url", "username", "password");

	}
   
}
