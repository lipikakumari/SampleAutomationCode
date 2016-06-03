package com.sydneytesters.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HerokuappBasePage {
	WebDriver driver;
	private By getCarQuoteButton = By.cssSelector("#getcarquote");
	
	public HerokuappBasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public CarPage clickGetCarQuote() {
		
		driver.findElement(getCarQuoteButton).click();
		
		return new CarPage(driver).waitForPageToLoad();
		
	}
}
