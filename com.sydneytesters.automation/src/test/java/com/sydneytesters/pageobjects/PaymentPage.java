package com.sydneytesters.pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;

import com.sydneytesters.helpclass.CustomWaits;
import com.sydneytesters.helpclass.DataProvider;
import com.sydneytesters.helpclass.CustomMethods;


public class PaymentPage {
	
	WebDriver driver;
	
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
	}
	


	private By nameOnCard = By.cssSelector("#cardholdername");
	private By emailUsrname = By.cssSelector("input[id='username'][class='form-control']");
	private By password = By.cssSelector("input[id='password'][class='form-control']");
	private By cardNumber = By.cssSelector("#card-number");
	private By expirationMonth = By.cssSelector("#expiry-month");
	private By expirationYear = By.cssSelector("[name='expiry-year']");
	private By cardCVV = By.cssSelector("#cvv");	
	private By payNowButton= By.cssSelector("#pay");
	
	DataProvider cardDetailsData= new DataProvider();

	public PaymentPage waitForPageToLoad(){
		new CustomWaits(driver).waitForElementToBeVisible(payNowButton, 5);
		return this;
	}

	public PaymentPage enterNameOnCard() {
		driver.findElement(nameOnCard).sendKeys(cardDetailsData.getName());		
		return this;
	}
	
	public PaymentPage enterEmailUsrname() {
		
		driver.findElement(emailUsrname).sendKeys(cardDetailsData.getEmail());		
		return this;
	}

	public PaymentPage enterPassword() {
		driver.findElement(password).sendKeys(cardDetailsData.getPassword());
		return this;
	}

	public PaymentPage enterCardNumber() {
		driver.findElement(cardNumber).sendKeys(cardDetailsData.getCardNumber());
		return this;
	}

	public PaymentPage enterCardExpMonth() {
		Select months = new Select(driver.findElement(expirationMonth));
		months.selectByValue(cardDetailsData.getCardExpMonth());	
		return this;
	}

	public PaymentPage enterCardExpYear() {
		Select Years = new Select(driver.findElement(expirationYear));
		Years.selectByVisibleText(cardDetailsData.getCardExpYear());
		return this;
	}


	public PaymentPage enterCardCVV() {
		driver.findElement(cardCVV).sendKeys(cardDetailsData.getCvv());
		return this;
	}

	public PayStatusMessagePage clickPayNow() {
		
		new CustomMethods(driver).mouseHoverAndClick(driver.findElement(payNowButton));	
		return new PayStatusMessagePage(driver).waitForPageToLoad();
		
	}
	


}
