package com.sydneytesters.helpclass;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWaits {
	WebDriver driver;
	
	public CustomWaits(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForElementToBeVisible(By selector, int timeToWaitInSeconds)
    {
		
        WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }
	
	public void waitForElementToBeClickable(WebElement element)
    {
		WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(element));
		
    }
	

}
