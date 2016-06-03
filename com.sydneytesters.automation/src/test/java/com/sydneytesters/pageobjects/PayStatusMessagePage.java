package com.sydneytesters.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sydneytesters.helpclass.CustomWaits;

public class PayStatusMessagePage {
	WebDriver driver= null;
	
	public PayStatusMessagePage(WebDriver driver){
		this.driver=driver;
	}
	
	//By PayMsg = By.xpath("//div[@id='quotebox']/div/div[1]/h3/i");
	By PayMsg = By.cssSelector(".panel-title.text-center>i");

	public PayStatusMessagePage waitForPageToLoad(){
		new CustomWaits(driver).waitForElementToBeVisible(PayMsg, 5);
		return this;
	}
	
	public PayStatusMessagePage verifySuccessPayMessage(){
		Assert.assertTrue(driver.findElement(PayMsg).getText().equalsIgnoreCase("Sucessful"));
		return this;
	}
}
