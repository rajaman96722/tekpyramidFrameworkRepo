package com.tekpyramid.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactlnk;
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactButtonLink;
	
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignlnk;
	
	@FindBy(linkText = "More")
	private WebElement MoreLink;
	

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement singNOutLnk;
	
	
	public WebElement getCampaignlnk() {
		return campaignlnk;
	}

	public WebElement getMoreLink() {
		return MoreLink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactlnk() {
		return contactlnk;
	}
	public WebElement getCreateContactButtonLink() {
		return createContactButtonLink;
	}
	public void navigateToCampaignPage() {
		Actions act = new Actions(driver);
		act.moveToElement(MoreLink).perform();
		campaignlnk.click();
		
	}
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		singNOutLnk.click();
	}
	
	}


