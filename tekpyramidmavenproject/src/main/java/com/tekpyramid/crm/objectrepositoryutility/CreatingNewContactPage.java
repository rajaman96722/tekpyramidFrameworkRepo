package com.tekpyramid.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNameLink;
	
	
	@FindBy(name = "support_start_date")
	private WebElement startDateLink;
	
	@FindBy(name = "support_end_date")
	private WebElement endDateLink;
	

	@FindBy(name = "button")
	private WebElement saveBtnLink;
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createButtonLink;
	
	public WebElement getCreateButtonLink() {
		return createButtonLink;
	}


	public WebElement getSaveBtnLink() {
		return saveBtnLink;
	}


	public WebElement getLastNameLink() {
		return lastNameLink;
	}


	public WebElement getStartDateLink() {
		return startDateLink;
	}


	public WebElement getEndDateLink() {
		return endDateLink;
	}
	public void  createContactWithlastName(String lastname) {
		lastNameLink.sendKeys(lastname);
	}


	public void  createContactWithSupportdate(String lastname , String startDate , String endDate) {
		lastNameLink.sendKeys(lastname);
		startDateLink.sendKeys(startDate);
		
		endDateLink.sendKeys(endDate);
		
	}
	
	
		
	
}
