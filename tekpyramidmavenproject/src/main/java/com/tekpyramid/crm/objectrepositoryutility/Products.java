package com.tekpyramid.crm.objectrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products {
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createProductImgBtn;
     
	@FindBy(name="searchBtn")
	private WebElement ele3;

	public WebElement getCreateProductImgBtn() {
		return createProductImgBtn;
	}

	public WebElement getEle2() {
		return ele3;
	}

}
