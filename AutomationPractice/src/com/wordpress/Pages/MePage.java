package com.wordpress.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MePage {
	WebDriver driver ;
	public MePage(WebDriver driver ){
		this.driver=driver;
	}
	
	By nextSteps=By.cssSelector(".sidebar__menu>ul>li>a[href*='next']");
	
	public WebElement getElementNextStep(){
		WebElement element = driver.findElement(nextSteps);
		return element;
	}
	
}
