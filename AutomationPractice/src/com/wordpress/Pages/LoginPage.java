/**
 * 
 */
package com.wordpress.Pages;

import java.util.List;

import org.openqa.selenium.*;

/**
 * @author lipika
 * 
 * 
 * this class will store all the locators of login page
 * of worpress.com
 *
 */
public class LoginPage {
	
	WebDriver driver ;
	public LoginPage(WebDriver driver ){
		this.driver=driver;
	}
	
	
	By userName = By.xpath("//input[@type='text' and @id='user_login']");
	By password = By.xpath("//input[@name='pwd' and @id='user_pass']");
	By rememberMe = By.xpath("//input[@type='checkbox' and @id='rememberme']");
	By logIn= By.xpath("//input[@type='submit' and @id='wp-submit']");

	
	
	
	
	public WebDriver typeUsername(String usrname){
		driver.findElement(userName).clear();
		driver.findElement(userName).sendKeys(usrname);
		return driver;
	}
	public WebDriver typePassword(String pwd){
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pwd);
		return driver;
	}
	public WebDriver clickLogin(){
		driver.findElement(logIn).click();
		return driver;
	}
	public WebDriver validLogin(String usrname, String pwd){
		
		driver=typeUsername(usrname);
		driver=typePassword(pwd);
		driver=clickLogin();
		return driver;
	}
	public int  numberOfLinksOnPage(){
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Total links are "+links.size());		
		return links.size();
		
	}
	
}
