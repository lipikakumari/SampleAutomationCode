package com.wordpress.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.wordpress.Pages.HomePage;
import com.wordpress.Pages.LoginPage;
import com.wordpress.SelectBrowser.chooseBrowser;




public class UserHasNoSiteCreated {
	

	//variables for URL and Browser
	String Url ="https://wordpress.com/wp-login.php?redirect_to=https%3A%2F%2Fwordpress.com%2F";
	String browserName ="firefox";
	WebDriver driver = null;
	
	//variables for input parameters
/*	String validUserId="chandra.lipika.test@gmail.com";
	String validPassword="Test@1234";
*/
	
	
	@BeforeMethod
	public void selectBrowser(){
		chooseBrowser browserSelect = new chooseBrowser(driver);
		driver = browserSelect.userBrowser(browserName ,Url);
	}
	
	@AfterMethod
	public void quitBrowser(){
		driver.quit();
	}
	
	@DataProvider
	public Object[][] loginData(){
		
		Object[][] loginData = new Object[1][2];
		loginData[0][0]="chandra.lipika.test@gmail.com";
		loginData[0][1]="Test@1234";
		return loginData;
	}
	
	
	@Test (dataProvider="loginData")
	public void verifyUserSiteDoNotExist(String validUserId,String validPassword){	
	

		//Testcase variables 
		By noSiteYet = By.xpath("//div/h2[@class='empty-content__title']");
		String actualText=null;
		
		
		// calling login page 	
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		LoginPage login = new LoginPage(driver);
		driver =login.validLogin(validUserId,validPassword);
		
		//calling Home page
		HomePage homePage = new HomePage(driver);
		driver = homePage.clickCreatePost();
		
		// asserting no user site has been created
		actualText=driver.findElement(noSiteYet).getText();
		Assert.assertEquals(actualText,"You don't have any WordPress sites yet.");
		
	
	}
}
