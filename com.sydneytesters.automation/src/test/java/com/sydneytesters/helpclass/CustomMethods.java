package com.sydneytesters.helpclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CustomMethods {
	WebDriver driver;
	
	public CustomMethods(WebDriver driver) {
		this.driver = driver;
	}

	public void mouseHoverAndClick(WebElement webElement ){
		
			Actions actions = new Actions(driver);
			actions.moveToElement(webElement);	
			actions.click().build().perform();
		
	}
	
	public void waitAndClick(WebElement webElement ){
		
		if(!webElement.isEnabled())
			new CustomWaits(driver).waitForElementToBeClickable(webElement);
		webElement.click();	
	}
	
}
