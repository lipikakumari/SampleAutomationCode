package com.wordpress.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wordpress.Data.WordpressData;
import com.wordpress.Pages.HomePage;
import com.wordpress.Pages.LoginPage;
import com.wordpress.Pages.NewPostPage;
import com.worpress.SelectBrowser.chooseBrowser;

public class PublishMyPost {

	

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
	
	@DataProvider
	public Object[][] loginData(){
		
		Object[][] loginData = new Object[1][2];
		loginData[0][0]=wordpressData.getvalidUserId();
		loginData[0][1]=wordpressData.getvalidPassword();
		return loginData;
	}
	
	@Test (dataProvider="loginData")
	public void publishPost(String validUserId,String validPassword){	
		
		// calling login page 	
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		LoginPage login = new LoginPage(driver);
		driver =login.validLogin(validUserId,validPassword);
		
		//calling Home page
		HomePage homePage = new HomePage(driver);
		driver = homePage.clickCreatePost();
		
		
		//calling new post page
		NewPostPage newPostPage = new NewPostPage(driver);
		driver = newPostPage.typeTitle("newpost");
		//wait 20 second for page to load
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		driver = newPostPage.typeNewPostBody("this is a new post for testing");
		
		
		driver = newPostPage.clickPublishButton();
		
		//wait 20 second for page to load
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		Assert.assertTrue(newPostPage.publishSuccess(), "posted");
	
	}

}