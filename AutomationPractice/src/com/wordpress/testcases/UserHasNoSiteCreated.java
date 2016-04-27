package com.wordpress.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wordpress.Pages.HomePage;
import com.wordpress.Pages.LoginPage;
import com.worpress.SelectBrowser.chooseBrowser;

public class UserHasNoSiteCreated {
	@Test
	public void verifyUserSiteDoNotExist(){	
			
		//variables for URL and Browser
		String Url ="https://wordpress.com/wp-login.php?redirect_to=https%3A%2F%2Fwordpress.com%2F";
		String browserName ="firefox";
		

		WebDriver driver = null;	
		By noSiteYet = By.xpath("//div/h2[@class='empty-content__title']");
		String actualText=null;
		
		// selecting browser
		chooseBrowser browserSelect = new chooseBrowser(driver);
		driver = browserSelect.userBrowser(browserName ,Url);
		
		
		// calling login page 	
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		LoginPage login = new LoginPage(driver);
		driver =login.validLogin("chandra.lipika@gmail.com","sushant@84");
		
		//calling Home page
		HomePage homePage = new HomePage(driver);
		driver = homePage.clickCreatePost();
		
		// asserting no user site has been created
		actualText=driver.findElement(noSiteYet).getText();
		Assert.assertEquals(actualText,"You don't have any WordPress sites yet.");
		
		driver.quit();
	}
}