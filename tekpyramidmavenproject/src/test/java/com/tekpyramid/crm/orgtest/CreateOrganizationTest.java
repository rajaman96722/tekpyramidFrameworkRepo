package com.tekpyramid.crm.orgtest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;
import com.tekpyramid.crm.basetest.BaseClass;
import com.tekpyramid.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.tekpyramid.crm.objectrepositoryutility.HomePage;
import com.tekpyramid.crm.objectrepositoryutility.LoginPage;
import com.tekpyramid.crm.objectrepositoryutility.OrganizationInfoPage;
import com.tekpyramid.crm.objectrepositoryutility.OrganizationPage;
@Listeners(com.tekpyramid.crm.listnerutility.ListImpClass.class)
public class CreateOrganizationTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createOrgTest() throws EncryptedDocumentException, IOException {
         UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
		// read testScript data from excel file
		String orgName = eLib.getDataFromExcel("org", 1, 3) + jLib.getRandonNumber();

		// step2 : navigate to organization module
		 UtilityClassObject.getTest().log(Status.INFO,"naviagte to organization page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step3 : click on create organization button
		UtilityClassObject.getTest().log(Status.INFO,"naviagte to create organozation page");
		OrganizationPage cnp = new OrganizationPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// step4 : enter all the details and create new organization
		UtilityClassObject.getTest().log(Status.INFO,"create new organization");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.creatOrg(orgName);
		UtilityClassObject.getTest().log(Status.INFO, orgName+  "======>Create a new Org ");

		// verify Header msg expected result

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		if (actOrgName.contains(orgName)) {
			System.out.println(orgName + "name is verfied==pass");
		} else {
			System.out.println(orgName + "name is notverfied==fail");
		}

	}

	@Test(groups = "regressionTest")
	public void createOrganizationWithPhoneNumber() throws EncryptedDocumentException, IOException {

		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandonNumber();
		String phoneNumber = eLib.getDataFromExcel("org", 7, 3) + jLib.getRandonNumber();

		// step2 : navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		// step3 : click on create organization button
		OrganizationPage cnp = new OrganizationPage(driver);
		cnp.getCreateNewOrgBtn().click();
		// step4 : enter all the details and create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createorg(orgName, phoneNumber);

		// verify the phone info

		String actualNum = driver.findElement(By.id("dtlview_Phone")).getText();
		if (actualNum.equals(phoneNumber)) {
			System.out.println(phoneNumber + "information is verified==pass");
		} else {
			System.out.println(phoneNumber + "information is not verified==fail");
		}

	}

	@Test(groups = "regressionTest")
	public void createOrganizationWithIndustries() throws EncryptedDocumentException, IOException {

		// read the test script data from excel sheet
		String orgName = eLib.getDataFromExcel("org", 4, 2) + jLib.getRandonNumber();
		String industry = eLib.getDataFromExcel("org", 4, 3);
		String type = eLib.getDataFromExcel("org", 4, 4);

		// step2 : navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		// step3 : click on create organization button
		OrganizationPage cnp = new OrganizationPage(driver);
		cnp.getCreateNewOrgBtn().click();
		// step4 : enter all the details and create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName, industry);

		

		
		// verify the dropdown industries and type info
		
		String actualIndustries = driver.findElement(By.id("mouseArea_Industry")).getText();
		if (actualIndustries.equals(industry)) {
			System.out.println(industry + "information is verified==pass");
		} else {
			System.out.println(industry + "information is not verified==fail");
		}
		String actualType = driver.findElement(By.id("dtlview_Type")).getText();
		System.out.println(actualType);
		if (actualType.equals(type)) {
			System.out.println(type + "information is verified==pass");
		} else {
			System.out.println(type + "information is not verified==fail");
		}

	}

}
