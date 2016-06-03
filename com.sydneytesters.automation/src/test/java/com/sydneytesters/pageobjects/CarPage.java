package com.sydneytesters.pageobjects;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import com.sydneytesters.helpclass.CustomWaits;
import com.sydneytesters.helpclass.DataProvider;
import com.sydneytesters.helpclass.CustomMethods;


public class CarPage {
	WebDriver driver;
	
	public CarPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	private By dropdownMake = By.cssSelector("#make");
	private By year = By.cssSelector("#year");
	private By age = By.cssSelector("#age");
	private By gender = By.cssSelector(".radio-inline");
	private By state = By.cssSelector("#state");
	private By email = By.cssSelector("#email");	
	private By getQuoteButton= By.cssSelector("button#getquote");
	
	DataProvider carQuoteData= new DataProvider();
	
	public CarPage waitForPageToLoad(){
		new CustomWaits(driver).waitForElementToBeVisible(getQuoteButton,5);
		return this;
	}
	
	public CarPage selectCarMake(){		
		Select selectCarMake = new Select(driver.findElement(dropdownMake));		
		selectCarMake.selectByVisibleText(carQuoteData.getCarType());	
		return this;
	}
	
	
	public CarPage enterYear(){
		driver.findElement(year).sendKeys(carQuoteData.getYear());
		return this;
	}
	
	
	public CarPage enterAge(){
		driver.findElement(age).sendKeys(carQuoteData.getAge());
		return this;
	}
	
	
	public CarPage selectGender(){
		List<WebElement> genderTypes= driver.findElements(gender);
		
		if(carQuoteData.getGender().equalsIgnoreCase("male")){
			genderTypes.get(0).click();
		}
		else{
			genderTypes.get(1).click();
		}
		return this;
	}
	
	
	public CarPage selectState(){				
		Select stateNames = new Select(driver.findElement(state));
		stateNames.selectByVisibleText(carQuoteData.getState());
		return this;
		
	}
	
		
	public CarPage enterEmail(){
		driver.findElement(email).sendKeys(carQuoteData.getEmail());
		return this;
	}
	
	
	public QuotePage clickGetQuote(){	
		
		new CustomMethods(driver).waitAndClick(driver.findElement(getQuoteButton));
		return new QuotePage(driver).waitForPageToLoad();
		
	}
	

	
		
}
