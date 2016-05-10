package com.wordpress.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wordpress.Data.WordpressData;
import com.wordpress.Pages.HomePage;
import com.wordpress.Pages.LoginPage;
import com.wordpress.Pages.MePage;
import com.wordpress.SelectBrowser.chooseBrowser;

public class ScrollLoginPage {

	//Getting variables for URL and Browser from class WordpressData
	WordpressData wordpressData = new WordpressData();	
	String Url =wordpressData.getUrl();
	String browserName =wordpressData.getBrowser();
	
	//Initializing  driver
	WebDriver driver = null;

	@BeforeMethod
	public void selectBrowser(){
		chooseBrowser browserSelect = new chooseBrowser(driver);
		driver = browserSelect.userBrowser(browserName ,Url);
	}
	
	@AfterMethod
	public void quitBrowser(){
		driver.quit();
	}
	
	@Test
	public void scrollViewOnMePage(){
		
		WordpressData wordpressData= new WordpressData();
		
		LoginPage login = new LoginPage(driver);
		driver =login.validLogin(wordpressData.getvalidUserId(),wordpressData.getvalidPassword());
		
		//wait 20 second for page to load
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		
		//calling Home page
		HomePage homePage = new HomePage(driver);
		driver = homePage.clickMeImage();
		
		//wait 20 second for page to load
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		
		//calling Me page
		MePage mePage = new MePage(driver);
		WebElement nextStep = mePage.getElementNextStep();
		
		try{
			
			Thread.sleep(5000);	
			
			// Create instance of Javascript executor		 
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true);",nextStep);	
			
			Thread.sleep(5000);	
			System.out.println(nextStep.getText());
		
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	@Test
	public void scrollLoginPage(){
		try{
		Thread.sleep(5000);
		
		
		
		 ((JavascriptExecutor)driver).executeScript("scroll(0,400)");		 
		 Thread.sleep(5000);
		 
		 ((JavascriptExecutor)driver).executeScript("scroll(0,-400)");
		 Thread.sleep(5000);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
