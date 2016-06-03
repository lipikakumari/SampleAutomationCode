package com.sydneytesters.pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sydneytesters.helpclass.CustomWaits;
import com.sydneytesters.helpclass.CustomMethods;

public class QuotePage {
	WebDriver driver;
	
	public QuotePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By buyInsuranceButton= By.cssSelector("#payment");
	
	public QuotePage waitForPageToLoad(){
		new CustomWaits(driver).waitForElementToBeVisible(buyInsuranceButton, 20);
		return this;
	}
	
	public PaymentPage clickBuyInsurance(){
		
		new CustomMethods(driver).mouseHoverAndClick(driver.findElement(buyInsuranceButton));	
		return new PaymentPage(driver).waitForPageToLoad();
				
	}
	
	public QuotePage verifyBuyInsuranceRendering(){
		 Assert.assertTrue(driver.findElement(buyInsuranceButton).isDisplayed());
		 return this;
	}
	
}
