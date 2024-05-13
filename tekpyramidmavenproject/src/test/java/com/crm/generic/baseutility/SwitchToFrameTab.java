package com.crm.generic.baseutility;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;


public class SwitchToFrameTab {
	public void switchToFrame(WebDriver driver , int index) {
		driver.switchTo().frame(index);
		
			 
	}
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
}
	

		
	



