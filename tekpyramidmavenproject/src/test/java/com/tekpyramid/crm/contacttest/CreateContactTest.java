package com.tekpyramid.crm.contacttest;

import java.io.IOException;
/**
 * @author AMAN RAJ
 * 
 * 
 */
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tekpyramid.crm.basetest.BaseClass;
import com.tekpyramid.crm.objectrepositoryutility.CreateContactPage;
import com.tekpyramid.crm.objectrepositoryutility.CreatingNewContactPage;
import com.tekpyramid.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.tekpyramid.crm.objectrepositoryutility.HomePage;
import com.tekpyramid.crm.objectrepositoryutility.OrganizationPage;

public class CreateContactTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createConTest() throws EncryptedDocumentException, IOException {

		/* read the test script data from excel sheet*/

		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandonNumber();

		// step2 : navigate to contact module
		HomePage hp = new HomePage(driver);
		hp.getContactlnk().click();
		// step3 : click on create contact button
		HomePage cp = new HomePage(driver);
		cp.getCreateContactButtonLink().click();

		// step4 : enter all the details and create new contact
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContactWithlastName(lastName);
		ccp.getSaveBtnLink().click();
		// verify Header contact info expected result
        CreateContactPage cc = new CreateContactPage(driver);
		String actHeader = cc.getHeaderMsg().getText();
		boolean status    =   actHeader.contains(lastName);
		Assert.assertEquals(status,true);
		//verify last name
		String actlastNam = cc.getLastNameMsg().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actHeader, actlastNam);
		
	}
	@Test(groups = "regressionTest")
	public void createContactWithSupportDate() throws EncryptedDocumentException, IOException {

		//read the test script data from excel sheet
		
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandonNumber();
		
		
		
		
		
		//step2 : navigate to contact module
		HomePage hp = new HomePage(driver);
		hp.getContactlnk().click();

		//step3 : click on create contact button
		HomePage cp = new HomePage(driver);
		cp.getCreateContactButtonLink().click();
		
	     
		//step4 : enter all the details and create new contact
	     String startDate=	jLib.getSystemDateYYYYDDMM();
	     String endDate=	jLib.getRequiredDateYYYYDDMM(30);
	     
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContactWithSupportdate(lastName, startDate, endDate);
		ccp.getSaveBtnLink().click();
		//verify Header contact info expected result

		 String staDate=driver.findElement(By.xpath("(//td[@class='dvtCellInfo'])[23]")).getText();
		 
		 boolean status=  staDate.contains(startDate);
	    
	     Assert.assertEquals(status,true);
	    
		 String enDate=driver.findElement(By.xpath("(//td[@class='dvtCellInfo'])[25]")).getText();
		 boolean reqDat=  enDate.contains(endDate);
		
		 Assert.assertEquals( reqDat,endDate);
	}

		
	
	@Test(groups = "regressionTest")
	public void createContactWithOrganization() throws EncryptedDocumentException, IOException {

		//read the test script data from excel sheet
	      String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandonNumber();
		  String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandonNumber();
		
	   
	   
		
		//step2 : navigate to organization module
		  HomePage hp = new HomePage(driver);
			hp.getOrgLink().click();
		//step3 : click on create organization button

        OrganizationPage cnp = new OrganizationPage(driver);
        cnp.getCreateNewOrgBtn().click();
		//step4 : enter all the details and create new organization
        CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.creatOrg(orgName);
	//	cnop.getSaveBtn().click();
		//verify Header msg expected result
		String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 if(headerInfo.contains(orgName)) {
			 System.out.println(orgName+"header verified==pass");
		 }
		 else {
			 System.out.println(orgName+"header not verified==fail");
		 }
		 
		//step 5: navigate to contact module
		

             hp.getContactlnk().click();
			//step6 : click on create contact button
            
             
			//step7 : enter all the details and create new contact
			CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
			ccp.getCreateButtonLink().click();
			ccp.createContactWithlastName(lastName);
			ccp.getSaveBtnLink().click();
			
		/*	//switch to child window
			wLib.switchTOTabOnURL(driver, "module=Accounts");
			
		   
		    
			driver.findElement(By.name("search_text")).sendKeys(orgName);
			driver.findElement(By.name("search")).click();
			driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
			
			//switch the parent window
			wLib.switchTOTabOnURL(driver, "module=Contacts");
			
		
		    driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();  */ 
			//verify header phone number info expected result
		     headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			 if(headerInfo.contains(lastName)) {
				 System.out.println(lastName+" header verified==pass");
			 }
			 else {
				 System.out.println(lastName+"header not verified==fail");
			 }
			 
		
		// verify Header orgName info Expected Result
	       String actualArgNameInfo	= driver.findElement(By.id("mouseArea_Organization Name")).getText();
	       System.out.println(actualArgNameInfo);
	       if(actualArgNameInfo.trim().equals(orgName)) {
				 System.out.println(orgName+"is created==pass");
				
			 }
			 else {
				System.out.println(orgName+"is not created==fail");
			 }

	
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

