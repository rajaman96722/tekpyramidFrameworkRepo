package com.tekpyramid.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	WebDriver driver;
	public CreateContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(id = "mouseArea_Last Name")
	private WebElement lastNameMsg;
	
	public WebElement getLastNameMsg() {
		return lastNameMsg;
	}
	
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}

}
